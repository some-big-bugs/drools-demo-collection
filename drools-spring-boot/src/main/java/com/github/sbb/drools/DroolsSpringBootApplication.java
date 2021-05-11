package com.github.sbb.drools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.sbb.drools.infrastructure")
public class DroolsSpringBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(DroolsSpringBootApplication.class, args);
  }

}
