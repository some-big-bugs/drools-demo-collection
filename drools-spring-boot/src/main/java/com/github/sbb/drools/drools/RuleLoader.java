package com.github.sbb.drools.drools;

import com.github.sbb.drools.infrastructure.entity.RulesConfig;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 规则加载器
 *
 * @author loujinhe
 * @date 2019/4/14 00:06
 */
@Component
public class RuleLoader implements ApplicationRunner {

  /**
   * key:kcontainerName,value:KieContainer，每个场景对应一个KieContainer
   */
  private final ConcurrentMap<String, KieContainer> kieContainerMap = new ConcurrentHashMap<>();

  @Autowired
  private RulesConfigService rulesConfigService;

  @Override
  public void run(ApplicationArguments args) {
    reloadAll();
  }

  /**
   * 构造kcontainerName
   *
   * @param sceneId 场景ID
   * @return kcontainerName
   */
  private String buildKcontainerName(String sceneId) {
    return "kcontainer_" + sceneId;
  }

  /**
   * 构造kbaseName
   *
   * @param sceneId 场景ID
   * @return kbaseName
   */
  private String buildKbaseName(String sceneId) {
    return "kbase_" + sceneId;
  }

  /**
   * 构造ksessionName
   *
   * @param sceneId 场景ID
   * @return ksessionName
   */
  private String buildKsessionName(String sceneId) {
    return "ksession_" + sceneId;
  }

  KieContainer getKieContainerBySceneId(String scene) {
    return kieContainerMap.get(buildKcontainerName(scene));
  }

  /**
   * 重新加载所有规则
   */
  public void reloadAll() {
    Map<String, List<RulesConfig>> sceneId2RuleInfoListMap = rulesConfigService.getRuleInfoListMap();
    for (Map.Entry<String, List<RulesConfig>> entry : sceneId2RuleInfoListMap.entrySet()) {
      String sceneId = entry.getKey();
      reload(sceneId, entry.getValue());
    }
    System.out.println("reload all success");
  }

  /**
   * 重新加载给定场景下的规则
   *
   * @param sceneId 场景ID
   */
  public void reload(String sceneId) {
    List<RulesConfig> ruleInfos = rulesConfigService.getRuleInfoListBySceneId(sceneId);
    reload(sceneId, ruleInfos);
    System.out.println("reload success");
  }

  /**
   * 重新加载给定场景给定规则列表，对应一个kmodule
   *
   * @param sceneId   场景ID
   * @param ruleInfos 规则列表
   */
  private void reload(String sceneId, List<RulesConfig> ruleInfos) {
    KieServices kieServices = KieServices.get();
    KieModuleModel kieModuleModel = kieServices.newKieModuleModel();
    KieBaseModel kieBaseModel = kieModuleModel.newKieBaseModel(buildKbaseName(sceneId));
    kieBaseModel.setDefault(true);
    kieBaseModel.addPackage(sceneId);
    kieBaseModel.newKieSessionModel(buildKsessionName(sceneId));

    KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
    for (RulesConfig ruleInfo : ruleInfos) {
      String fullPath = MessageFormat
          .format("src/main/resources/rules/scene_{0}/rule_{1}.drl", String.valueOf(sceneId), String.valueOf(ruleInfo.getId()));
      kieFileSystem.write(fullPath, ruleInfo.getRule());
    }
    kieFileSystem.writeKModuleXML(kieModuleModel.toXML());

    KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
    Results results = kieBuilder.getResults();
    if (results.hasMessages(Message.Level.ERROR)) {
      System.out.println(results.getMessages());
      throw new IllegalStateException("rule error");
    }

    KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
    kieContainerMap.put(buildKcontainerName(sceneId), kieContainer);
  }
}

