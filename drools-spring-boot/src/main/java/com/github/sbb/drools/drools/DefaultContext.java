package com.github.sbb.drools.drools;

import java.util.HashMap;
import java.util.Map;

public class DefaultContext {

  private Map<String, Object> inputRecord;

  public DefaultContext() {
    this.inputRecord = new HashMap<>();
  }

  public void set(String key, Object value) {
    this.inputRecord.put(key, value);
  }

  public DefaultContext(Map<String, Object> inputRecord) {
    this.inputRecord = inputRecord;
  }

  public String getString(String key) {
    return (String) inputRecord.get(key);
  }
}
