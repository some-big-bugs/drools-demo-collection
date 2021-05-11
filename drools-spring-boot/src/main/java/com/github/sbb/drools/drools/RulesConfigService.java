package com.github.sbb.drools.drools;

import com.github.sbb.drools.infrastructure.entity.RulesConfig;
import com.github.sbb.drools.infrastructure.mapper.RulesConfigMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RulesConfigService {

  @Autowired
  private RulesConfigMapper rulesConfigMapper;

  /**
   * 获取给定场景下的规则信息列表
   *
   * @param sceneId 场景ID
   * @return 规则列表
   */
  public List<RulesConfig> getRuleInfoListBySceneId(String sceneId) {
    Map<String, List<RulesConfig>> sceneId2RuleInfoListMap = getRuleInfoListMap();
    return sceneId2RuleInfoListMap.get(sceneId);
  }

  /**
   * 获取场景与规则信息列表的Map
   *
   * @return 场景规则信息列表Map，Map(sceneId : List < RuleInfo >)
   */
  public Map<String, List<RulesConfig>> getRuleInfoListMap() {
    Map<String, List<RulesConfig>> sceneId2RuleInfoListMap = new HashMap<>();
    List<RulesConfig> allRuleInfos = generateRuleInfoList();
    for (RulesConfig ruleInfo : allRuleInfos) {
      List<RulesConfig> ruleInfos = sceneId2RuleInfoListMap.computeIfAbsent(ruleInfo.getScene(), k -> new ArrayList<>());
      ruleInfos.add(ruleInfo);
    }
    return sceneId2RuleInfoListMap;
  }

  private List<RulesConfig> generateRuleInfoList() {
    return rulesConfigMapper.selectByExample(null);
  }

}
