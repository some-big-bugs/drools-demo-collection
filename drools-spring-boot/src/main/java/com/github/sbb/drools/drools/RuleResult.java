package com.github.sbb.drools.drools;

import java.util.HashMap;
import java.util.Map;

public class RuleResult {

  private Map inputRecord = new HashMap<String, Object>();

  public void set(String key, Object value) {
    inputRecord.put(key, value);
  }

  public Map getResult() {
    return inputRecord;
  }

  public Map asMap() {
    return inputRecord;
  }
}
