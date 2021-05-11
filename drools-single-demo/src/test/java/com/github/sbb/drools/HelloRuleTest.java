package com.github.sbb.drools;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloRuleTest {

  private static final Logger logger = LoggerFactory.getLogger(HelloRuleTest.class);

  KieContainer kc;

  @Before
  public void init() {
    KieServices kss = KieServices.Factory.get();
    kc = kss.getKieClasspathContainer();
  }


  @Test
  public void testHelloRule() {

    KieSession ks = kc.newKieSession();
    int i = ks.fireAllRules();
    logger.info("总共执行次数 {}", i);
    ks.dispose();

  }
}
