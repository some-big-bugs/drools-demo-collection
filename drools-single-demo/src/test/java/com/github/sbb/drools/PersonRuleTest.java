package com.github.sbb.drools;

import com.github.sbb.drools.entity.Person;
import com.github.sbb.drools.entity.School;
import java.util.Arrays;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonRuleTest {

  private static final Logger logger = LoggerFactory.getLogger(PersonRuleTest.class);

  KieContainer kc;

  @Before
  public void init() {
    KieServices kss = KieServices.Factory.get();
    kc = kss.getKieClasspathContainer();
  }

  @Test
  public void testHelloRuleless() {

    StatelessKieSession ks = kc.newStatelessKieSession("person");

    School school = new School();
    school.setClassName("babaddddddd");

    Person person = new Person();
    person.setClassName("babad");
    person.setAge(30);

    Command cmd = CommandFactory.newInsertElements(Arrays.asList(school, person));

    Object execute = ks.execute(cmd);
    logger.info("总共执行次数 {}", execute);
  }

  @Test
  public void testHelloRule() {

    KieSession ks = kc.newKieSession("person");

    School school = new School();
    school.setClassName("babaddddddd");

    Person person = new Person();
    person.setClassName("babad");
    person.setAge(30);

    ks.insert(school);
    ks.insert(person);

    int i = ks.fireAllRules(new RuleNameEqualsAgendaFilter("规则名称"));

    logger.info("总共执行次数 {}", i);
    ks.dispose();
  }
}
