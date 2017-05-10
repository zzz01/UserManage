package com.hust.manage.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected int pageStart;

	protected int pageLimit;

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

	public UserExample() {
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_name like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_name not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserPasswordIsNull() {
			addCriterion("user_password is null");
			return (Criteria) this;
		}

		public Criteria andUserPasswordIsNotNull() {
			addCriterion("user_password is not null");
			return (Criteria) this;
		}

		public Criteria andUserPasswordEqualTo(String value) {
			addCriterion("user_password =", value, "userPassword");
			return (Criteria) this;
		}

		public Criteria andUserPasswordNotEqualTo(String value) {
			addCriterion("user_password <>", value, "userPassword");
			return (Criteria) this;
		}

		public Criteria andUserPasswordGreaterThan(String value) {
			addCriterion("user_password >", value, "userPassword");
			return (Criteria) this;
		}

		public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("user_password >=", value, "userPassword");
			return (Criteria) this;
		}

		public Criteria andUserPasswordLessThan(String value) {
			addCriterion("user_password <", value, "userPassword");
			return (Criteria) this;
		}

		public Criteria andUserPasswordLessThanOrEqualTo(String value) {
			addCriterion("user_password <=", value, "userPassword");
			return (Criteria) this;
		}

		public Criteria andUserPasswordLike(String value) {
			addCriterion("user_password like", value, "userPassword");
			return (Criteria) this;
		}

		public Criteria andUserPasswordNotLike(String value) {
			addCriterion("user_password not like", value, "userPassword");
			return (Criteria) this;
		}

		public Criteria andUserPasswordIn(List<String> values) {
			addCriterion("user_password in", values, "userPassword");
			return (Criteria) this;
		}

		public Criteria andUserPasswordNotIn(List<String> values) {
			addCriterion("user_password not in", values, "userPassword");
			return (Criteria) this;
		}

		public Criteria andUserPasswordBetween(String value1, String value2) {
			addCriterion("user_password between", value1, value2, "userPassword");
			return (Criteria) this;
		}

		public Criteria andUserPasswordNotBetween(String value1, String value2) {
			addCriterion("user_password not between", value1, value2, "userPassword");
			return (Criteria) this;
		}

		public Criteria andUserTelIsNull() {
			addCriterion("user_tel is null");
			return (Criteria) this;
		}

		public Criteria andUserTelIsNotNull() {
			addCriterion("user_tel is not null");
			return (Criteria) this;
		}

		public Criteria andUserTelEqualTo(String value) {
			addCriterion("user_tel =", value, "userTel");
			return (Criteria) this;
		}

		public Criteria andUserTelNotEqualTo(String value) {
			addCriterion("user_tel <>", value, "userTel");
			return (Criteria) this;
		}

		public Criteria andUserTelGreaterThan(String value) {
			addCriterion("user_tel >", value, "userTel");
			return (Criteria) this;
		}

		public Criteria andUserTelGreaterThanOrEqualTo(String value) {
			addCriterion("user_tel >=", value, "userTel");
			return (Criteria) this;
		}

		public Criteria andUserTelLessThan(String value) {
			addCriterion("user_tel <", value, "userTel");
			return (Criteria) this;
		}

		public Criteria andUserTelLessThanOrEqualTo(String value) {
			addCriterion("user_tel <=", value, "userTel");
			return (Criteria) this;
		}

		public Criteria andUserTelLike(String value) {
			addCriterion("user_tel like", value, "userTel");
			return (Criteria) this;
		}

		public Criteria andUserTelNotLike(String value) {
			addCriterion("user_tel not like", value, "userTel");
			return (Criteria) this;
		}

		public Criteria andUserTelIn(List<String> values) {
			addCriterion("user_tel in", values, "userTel");
			return (Criteria) this;
		}

		public Criteria andUserTelNotIn(List<String> values) {
			addCriterion("user_tel not in", values, "userTel");
			return (Criteria) this;
		}

		public Criteria andUserTelBetween(String value1, String value2) {
			addCriterion("user_tel between", value1, value2, "userTel");
			return (Criteria) this;
		}

		public Criteria andUserTelNotBetween(String value1, String value2) {
			addCriterion("user_tel not between", value1, value2, "userTel");
			return (Criteria) this;
		}

		public Criteria andUserTruenameIsNull() {
			addCriterion("user_truename is null");
			return (Criteria) this;
		}

		public Criteria andUserTruenameIsNotNull() {
			addCriterion("user_truename is not null");
			return (Criteria) this;
		}

		public Criteria andUserTruenameEqualTo(String value) {
			addCriterion("user_truename =", value, "userTruename");
			return (Criteria) this;
		}

		public Criteria andUserTruenameNotEqualTo(String value) {
			addCriterion("user_truename <>", value, "userTruename");
			return (Criteria) this;
		}

		public Criteria andUserTruenameGreaterThan(String value) {
			addCriterion("user_truename >", value, "userTruename");
			return (Criteria) this;
		}

		public Criteria andUserTruenameGreaterThanOrEqualTo(String value) {
			addCriterion("user_truename >=", value, "userTruename");
			return (Criteria) this;
		}

		public Criteria andUserTruenameLessThan(String value) {
			addCriterion("user_truename <", value, "userTruename");
			return (Criteria) this;
		}

		public Criteria andUserTruenameLessThanOrEqualTo(String value) {
			addCriterion("user_truename <=", value, "userTruename");
			return (Criteria) this;
		}

		public Criteria andUserTruenameLike(String value) {
			addCriterion("user_truename like", value, "userTruename");
			return (Criteria) this;
		}

		public Criteria andUserTruenameNotLike(String value) {
			addCriterion("user_truename not like", value, "userTruename");
			return (Criteria) this;
		}

		public Criteria andUserTruenameIn(List<String> values) {
			addCriterion("user_truename in", values, "userTruename");
			return (Criteria) this;
		}

		public Criteria andUserTruenameNotIn(List<String> values) {
			addCriterion("user_truename not in", values, "userTruename");
			return (Criteria) this;
		}

		public Criteria andUserTruenameBetween(String value1, String value2) {
			addCriterion("user_truename between", value1, value2, "userTruename");
			return (Criteria) this;
		}

		public Criteria andUserTruenameNotBetween(String value1, String value2) {
			addCriterion("user_truename not between", value1, value2, "userTruename");
			return (Criteria) this;
		}

		public Criteria andUserAddressIsNull() {
			addCriterion("user_address is null");
			return (Criteria) this;
		}

		public Criteria andUserAddressIsNotNull() {
			addCriterion("user_address is not null");
			return (Criteria) this;
		}

		public Criteria andUserAddressEqualTo(String value) {
			addCriterion("user_address =", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressNotEqualTo(String value) {
			addCriterion("user_address <>", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressGreaterThan(String value) {
			addCriterion("user_address >", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressGreaterThanOrEqualTo(String value) {
			addCriterion("user_address >=", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressLessThan(String value) {
			addCriterion("user_address <", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressLessThanOrEqualTo(String value) {
			addCriterion("user_address <=", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressLike(String value) {
			addCriterion("user_address like", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressNotLike(String value) {
			addCriterion("user_address not like", value, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressIn(List<String> values) {
			addCriterion("user_address in", values, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressNotIn(List<String> values) {
			addCriterion("user_address not in", values, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressBetween(String value1, String value2) {
			addCriterion("user_address between", value1, value2, "userAddress");
			return (Criteria) this;
		}

		public Criteria andUserAddressNotBetween(String value1, String value2) {
			addCriterion("user_address not between", value1, value2, "userAddress");
			return (Criteria) this;
		}

		public Criteria andCreatedateIsNull() {
			addCriterion("createdate is null");
			return (Criteria) this;
		}

		public Criteria andCreatedateIsNotNull() {
			addCriterion("createdate is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedateEqualTo(Date value) {
			addCriterionForJDBCDate("createdate =", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateNotEqualTo(Date value) {
			addCriterionForJDBCDate("createdate <>", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateGreaterThan(Date value) {
			addCriterionForJDBCDate("createdate >", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("createdate >=", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateLessThan(Date value) {
			addCriterionForJDBCDate("createdate <", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("createdate <=", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateIn(List<Date> values) {
			addCriterionForJDBCDate("createdate in", values, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateNotIn(List<Date> values) {
			addCriterionForJDBCDate("createdate not in", values, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("createdate between", value1, value2, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("createdate not between", value1, value2, "createdate");
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