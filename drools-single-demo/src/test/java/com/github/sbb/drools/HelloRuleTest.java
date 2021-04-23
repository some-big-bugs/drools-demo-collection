package com.github.sbb.drools;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class HelloRuleTest {

  @Test
  public void testHelloRule() {
    KieServices kss = KieServices.Factory.get();
    KieContainer kc = kss.getKieClasspathContainer();

    KieSession ks = kc.newKieSession();

    int i = ks.fireAllRules();

    System.out.println("总共执行次数" + i);

    ks.dispose();

  }
}
