package com.hust.manage.model;

import java.util.ArrayList;
import java.util.List;

public class PowerExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	private int pageStart;

	private int pageLimit;

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public PowerExample() {
		oredCriteria = new ArrayList<Criteria>();
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
			criteria = new ArrayList<Criterion>();
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

		public Criteria andPowerNameIsNull() {
			addCriterion("power_name is null");
			return (Criteria) this;
		}

		public Criteria andPowerNameIsNotNull() {
			addCriterion("power_name is not null");
			return (Criteria) this;
		}

		public Criteria andPowerNameEqualTo(String value) {
			addCriterion("power_name =", value, "powerName");
			return (Criteria) this;
		}

		public Criteria andPowerNameNotEqualTo(String value) {
			addCriterion("power_name <>", value, "powerName");
			return (Criteria) this;
		}

		public Criteria andPowerNameGreaterThan(String value) {
			addCriterion("power_name >", value, "powerName");
			return (Criteria) this;
		}

		public Criteria andPowerNameGreaterThanOrEqualTo(String value) {
			addCriterion("power_name >=", value, "powerName");
			return (Criteria) this;
		}

		public Criteria andPowerNameLessThan(String value) {
			addCriterion("power_name <", value, "powerName");
			return (Criteria) this;
		}

		public Criteria andPowerNameLessThanOrEqualTo(String value) {
			addCriterion("power_name <=", value, "powerName");
			return (Criteria) this;
		}

		public Criteria andPowerNameLike(String value) {
			addCriterion("power_name like", value, "powerName");
			return (Criteria) this;
		}

		public Criteria andPowerNameNotLike(String value) {
			addCriterion("power_name not like", value, "powerName");
			return (Criteria) this;
		}

		public Criteria andPowerNameIn(List<String> values) {
			addCriterion("power_name in", values, "powerName");
			return (Criteria) this;
		}

		public Criteria andPowerNameNotIn(List<String> values) {
			addCriterion("power_name not in", values, "powerName");
			return (Criteria) this;
		}

		public Criteria andPowerNameBetween(String value1, String value2) {
			addCriterion("power_name between", value1, value2, "powerName");
			return (Criteria) this;
		}

		public Criteria andPowerNameNotBetween(String value1, String value2) {
			addCriterion("power_name not between", value1, value2, "powerName");
			return (Criteria) this;
		}

		public Criteria andPowerUrlIsNull() {
			addCriterion("power_url is null");
			return (Criteria) this;
		}

		public Criteria andPowerUrlIsNotNull() {
			addCriterion("power_url is not null");
			return (Criteria) this;
		}

		public Criteria andPowerUrlEqualTo(String value) {
			addCriterion("power_url =", value, "powerUrl");
			return (Criteria) this;
		}

		public Criteria andPowerUrlNotEqualTo(String value) {
			addCriterion("power_url <>", value, "powerUrl");
			return (Criteria) this;
		}

		public Criteria andPowerUrlGreaterThan(String value) {
			addCriterion("power_url >", value, "powerUrl");
			return (Criteria) this;
		}

		public Criteria andPowerUrlGreaterThanOrEqualTo(String value) {
			addCriterion("power_url >=", value, "powerUrl");
			return (Criteria) this;
		}

		public Criteria andPowerUrlLessThan(String value) {
			addCriterion("power_url <", value, "powerUrl");
			return (Criteria) this;
		}

		public Criteria andPowerUrlLessThanOrEqualTo(String value) {
			addCriterion("power_url <=", value, "powerUrl");
			return (Criteria) this;
		}

		public Criteria andPowerUrlLike(String value) {
			addCriterion("power_url like", value, "powerUrl");
			return (Criteria) this;
		}

		public Criteria andPowerUrlNotLike(String value) {
			addCriterion("power_url not like", value, "powerUrl");
			return (Criteria) this;
		}

		public Criteria andPowerUrlIn(List<String> values) {
			addCriterion("power_url in", values, "powerUrl");
			return (Criteria) this;
		}

		public Criteria andPowerUrlNotIn(List<String> values) {
			addCriterion("power_url not in", values, "powerUrl");
			return (Criteria) this;
		}

		public Criteria andPowerUrlBetween(String value1, String value2) {
			addCriterion("power_url between", value1, value2, "powerUrl");
			return (Criteria) this;
		}

		public Criteria andPowerUrlNotBetween(String value1, String value2) {
			addCriterion("power_url not between", value1, value2, "powerUrl");
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