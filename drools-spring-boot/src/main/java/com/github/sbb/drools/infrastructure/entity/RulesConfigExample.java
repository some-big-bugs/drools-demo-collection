package com.github.sbb.drools.infrastructure.entity;

import java.util.ArrayList;
import java.util.List;

public class RulesConfigExample {

  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public RulesConfigExample() {
    oredCriteria = new ArrayList<>();
  }

  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  public String getOrderByClause() {
    return orderByClause;
  }

  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  public boolean isDistinct() {
    return distinct;
  }

  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  public Criteria createCriteria() {
    Criteria criteria = createCriteriaInternal();
    if (oredCriteria.size() == 0) {
      oredCriteria.add(criteria);
    }
    return criteria;
  }

  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  protected abstract static class GeneratedCriteria {

    protected List<Criterion> criteria;

    protected GeneratedCriteria() {
      super();
      criteria = new ArrayList<>();
    }

    public boolean isValid() {
      return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
      return criteria;
    }

    public List<Criterion> getCriteria() {
      return criteria;
    }

    protected void addCriterion(String condition) {
      if (condition == null) {
        throw new RuntimeException("Value for condition cannot be null");
      }
      criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
      if (value == null) {
        throw new RuntimeException("Value for " + property + " cannot be null");
      }
      criteria.add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
      if (value1 == null || value2 == null) {
        throw new RuntimeException("Between values for " + property + " cannot be null");
      }
      criteria.add(new Criterion(condition, value1, value2));
    }

    public Criteria andIdIsNull() {
      addCriterion("id is null");
      return (Criteria) this;
    }

    public Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return (Criteria) this;
    }

    public Criteria andIdEqualTo(Integer value) {
      addCriterion("id =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(Integer value) {
      addCriterion("id <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(Integer value) {
      addCriterion("id >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("id >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(Integer value) {
      addCriterion("id <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(Integer value) {
      addCriterion("id <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<Integer> values) {
      addCriterion("id in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<Integer> values) {
      addCriterion("id not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(Integer value1, Integer value2) {
      addCriterion("id between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(Integer value1, Integer value2) {
      addCriterion("id not between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andSceneIsNull() {
      addCriterion("scene is null");
      return (Criteria) this;
    }

    public Criteria andSceneIsNotNull() {
      addCriterion("scene is not null");
      return (Criteria) this;
    }

    public Criteria andSceneEqualTo(String value) {
      addCriterion("scene =", value, "scene");
      return (Criteria) this;
    }

    public Criteria andSceneNotEqualTo(String value) {
      addCriterion("scene <>", value, "scene");
      return (Criteria) this;
    }

    public Criteria andSceneGreaterThan(String value) {
      addCriterion("scene >", value, "scene");
      return (Criteria) this;
    }

    public Criteria andSceneGreaterThanOrEqualTo(String value) {
      addCriterion("scene >=", value, "scene");
      return (Criteria) this;
    }

    public Criteria andSceneLessThan(String value) {
      addCriterion("scene <", value, "scene");
      return (Criteria) this;
    }

    public Criteria andSceneLessThanOrEqualTo(String value) {
      addCriterion("scene <=", value, "scene");
      return (Criteria) this;
    }

    public Criteria andSceneLike(String value) {
      addCriterion("scene like", value, "scene");
      return (Criteria) this;
    }

    public Criteria andSceneNotLike(String value) {
      addCriterion("scene not like", value, "scene");
      return (Criteria) this;
    }

    public Criteria andSceneIn(List<String> values) {
      addCriterion("scene in", values, "scene");
      return (Criteria) this;
    }

    public Criteria andSceneNotIn(List<String> values) {
      addCriterion("scene not in", values, "scene");
      return (Criteria) this;
    }

    public Criteria andSceneBetween(String value1, String value2) {
      addCriterion("scene between", value1, value2, "scene");
      return (Criteria) this;
    }

    public Criteria andSceneNotBetween(String value1, String value2) {
      addCriterion("scene not between", value1, value2, "scene");
      return (Criteria) this;
    }

    public Criteria andRuleIsNull() {
      addCriterion("rule is null");
      return (Criteria) this;
    }

    public Criteria andRuleIsNotNull() {
      addCriterion("rule is not null");
      return (Criteria) this;
    }

    public Criteria andRuleEqualTo(String value) {
      addCriterion("rule =", value, "rule");
      return (Criteria) this;
    }

    public Criteria andRuleNotEqualTo(String value) {
      addCriterion("rule <>", value, "rule");
      return (Criteria) this;
    }

    public Criteria andRuleGreaterThan(String value) {
      addCriterion("rule >", value, "rule");
      return (Criteria) this;
    }

    public Criteria andRuleGreaterThanOrEqualTo(String value) {
      addCriterion("rule >=", value, "rule");
      return (Criteria) this;
    }

    public Criteria andRuleLessThan(String value) {
      addCriterion("rule <", value, "rule");
      return (Criteria) this;
    }

    public Criteria andRuleLessThanOrEqualTo(String value) {
      addCriterion("rule <=", value, "rule");
      return (Criteria) this;
    }

    public Criteria andRuleLike(String value) {
      addCriterion("rule like", value, "rule");
      return (Criteria) this;
    }

    public Criteria andRuleNotLike(String value) {
      addCriterion("rule not like", value, "rule");
      return (Criteria) this;
    }

    public Criteria andRuleIn(List<String> values) {
      addCriterion("rule in", values, "rule");
      return (Criteria) this;
    }

    public Criteria andRuleNotIn(List<String> values) {
      addCriterion("rule not in", values, "rule");
      return (Criteria) this;
    }

    public Criteria andRuleBetween(String value1, String value2) {
      addCriterion("rule between", value1, value2, "rule");
      return (Criteria) this;
    }

    public Criteria andRuleNotBetween(String value1, String value2) {
      addCriterion("rule not between", value1, value2, "rule");
      return (Criteria) this;
    }
  }

  public static class Criteria extends GeneratedCriteria {

    protected Criteria() {
      super();
    }
  }

  public static class Criterion {

    private String condition;

    private Object value;

    private Object secondValue;

    private boolean noValue;

    private boolean singleValue;

    private boolean betweenValue;

    private boolean listValue;

    private String typeHandler;

    public String getCondition() {
      return condition;
    }

    public Object getValue() {
      return value;
    }

    public Object getSecondValue() {
      return secondValue;
    }

    public boolean isNoValue() {
      return noValue;
    }

    public boolean isSingleValue() {
      return singleValue;
    }

    public boolean isBetweenValue() {
      return betweenValue;
    }

    public boolean isListValue() {
      return listValue;
    }

    public String getTypeHandler() {
      return typeHandler;
    }

    protected Criterion(String condition) {
      super();
      this.condition = condition;
      this.typeHandler = null;
      this.noValue = true;
    }

    protected Criterion(String condition, Object value, String typeHandler) {
      super();
      this.condition = condition;
      this.value = value;
      this.typeHandler = typeHandler;
      if (value instanceof List<?>) {
        this.listValue = true;
      } else {
        this.singleValue = true;
      }
    }

    protected Criterion(String condition, Object value) {
      this(condition, value, null);
    }

    protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
      super();
      this.condition = condition;
      this.value = value;
      this.secondValue = secondValue;
      this.typeHandler = typeHandler;
      this.betweenValue = true;
    }

    protected Criterion(String condition, Object value, Object secondValue) {
      this(condition, value, secondValue, null);
    }
  }
}