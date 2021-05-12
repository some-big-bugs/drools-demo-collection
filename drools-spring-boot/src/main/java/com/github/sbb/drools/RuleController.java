package com.github.sbb.drools;

import com.github.sbb.drools.drools.DefaultContext;
import com.github.sbb.drools.drools.KieSessionHelper;
import com.github.sbb.drools.drools.RuleLoader;
import com.github.sbb.drools.drools.RuleResult;
import java.util.Map;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("rule")
@RestController
public class RuleController {

  @Autowired
  private RuleLoader ruleLoader;

  @Autowired
  private KieSessionHelper kieSessionHelper;

  /**
   * 重新加载所有规则
   */
  @GetMapping("reload")
  public String reload() {
    System.out.println("reload all");
    ruleLoader.reloadAll();
    return "success";
  }
//
//  /**
//   * 重新加载给定场景下的规则
//   *
//   * @param sceneId 场景ID
//   */
//  @GetMapping("reload/{sceneId}")
//  public String reload(@PathVariable("sceneId") String sceneId) {
//    System.out.println("reload scene:" + sceneId);
//    ruleLoader.reload(sceneId);
//    return "success";
//  }

  /**
   * 触发给定场景规则
   *
   * @param sceneId 场景ID
   */
  @PostMapping("fire/{sceneId}")
  public RuleResult fire(@PathVariable("sceneId") String sceneId, @RequestBody Map<String, Object> params) {
    System.out.println("fire scene:" + sceneId);
    KieSession kieSession = kieSessionHelper.getKieSessionBySceneId(sceneId);
    RuleResult ruleResult = new RuleResult();
    try {

      DefaultContext defaultContext = new DefaultContext(params);

      kieSession.insert(defaultContext);
      kieSession.insert(ruleResult);
      kieSession.fireAllRules();
    } finally {
      kieSession.dispose();
    }

    return ruleResult;
  }

}
