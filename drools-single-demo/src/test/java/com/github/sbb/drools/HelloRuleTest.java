package com.github.sbb.drools;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloRuleTest {

  private static final Logger logger = LoggerFactory.getLogger(HelloRuleTest.class);


  @Test
  public void testHelloRule() {
    KieServices kss = KieServices.Factory.get();
    KieContainer kc = kss.getKieClasspathContainer();
    KieSession ks = kc.newKieSession();
    int i = ks.fireAllRules();
    logger.info("总共执行次数 {}", i);
    ks.dispose();

  }
}
