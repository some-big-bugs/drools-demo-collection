package com.github.sbb.drools.drools;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KieSessionHelper {

  @Autowired
  private RuleLoader ruleLoader;

  /**
   * 获取KieSession
   *
   * @param sceneId 场景ID
   * @return KieSession
   */
  public KieSession getKieSessionBySceneId(String scene) {
    return ruleLoader.getKieContainerBySceneId(scene).getKieBase().newKieSession();
  }

}
