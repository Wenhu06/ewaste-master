package com.group.ewaste.domain;

import java.util.ArrayList;
import java.util.List;

public class Device_dataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Device_dataExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeviceRecycleIdIsNull() {
            addCriterion("device_recycle_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceRecycleIdIsNotNull() {
            addCriterion("device_recycle_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceRecycleIdEqualTo(Long value) {
            addCriterion("device_recycle_id =", value, "deviceRecycleId");
            return (Criteria) this;
        }

        public Criteria andDeviceRecycleIdNotEqualTo(Long value) {
            addCriterion("device_recycle_id <>", value, "deviceRecycleId");
            return (Criteria) this;
        }

        public Criteria andDeviceRecycleIdGreaterThan(Long value) {
            addCriterion("device_recycle_id >", value, "deviceRecycleId");
            return (Criteria) this;
        }

        public Criteria andDeviceRecycleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("device_recycle_id >=", value, "deviceRecycleId");
            return (Criteria) this;
        }

        public Criteria andDeviceRecycleIdLessThan(Long value) {
            addCriterion("device_recycle_id <", value, "deviceRecycleId");
            return (Criteria) this;
        }

        public Criteria andDeviceRecycleIdLessThanOrEqualTo(Long value) {
            addCriterion("device_recycle_id <=", value, "deviceRecycleId");
            return (Criteria) this;
        }

        public Criteria andDeviceRecycleIdIn(List<Long> values) {
            addCriterion("device_recycle_id in", values, "deviceRecycleId");
            return (Criteria) this;
        }

        public Criteria andDeviceRecycleIdNotIn(List<Long> values) {
            addCriterion("device_recycle_id not in", values, "deviceRecycleId");
            return (Criteria) this;
        }

        public Criteria andDeviceRecycleIdBetween(Long value1, Long value2) {
            addCriterion("device_recycle_id between", value1, value2, "deviceRecycleId");
            return (Criteria) this;
        }

        public Criteria andDeviceRecycleIdNotBetween(Long value1, Long value2) {
            addCriterion("device_recycle_id not between", value1, value2, "deviceRecycleId");
            return (Criteria) this;
        }

        public Criteria andOssUrlIsNull() {
            addCriterion("oss_url is null");
            return (Criteria) this;
        }

        public Criteria andOssUrlIsNotNull() {
            addCriterion("oss_url is not null");
            return (Criteria) this;
        }

        public Criteria andOssUrlEqualTo(String value) {
            addCriterion("oss_url =", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlNotEqualTo(String value) {
            addCriterion("oss_url <>", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlGreaterThan(String value) {
            addCriterion("oss_url >", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlGreaterThanOrEqualTo(String value) {
            addCriterion("oss_url >=", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlLessThan(String value) {
            addCriterion("oss_url <", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlLessThanOrEqualTo(String value) {
            addCriterion("oss_url <=", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlLike(String value) {
            addCriterion("oss_url like", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlNotLike(String value) {
            addCriterion("oss_url not like", value, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlIn(List<String> values) {
            addCriterion("oss_url in", values, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlNotIn(List<String> values) {
            addCriterion("oss_url not in", values, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlBetween(String value1, String value2) {
            addCriterion("oss_url between", value1, value2, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andOssUrlNotBetween(String value1, String value2) {
            addCriterion("oss_url not between", value1, value2, "ossUrl");
            return (Criteria) this;
        }

        public Criteria andAccessIsNull() {
            addCriterion("`access` is null");
            return (Criteria) this;
        }

        public Criteria andAccessIsNotNull() {
            addCriterion("`access` is not null");
            return (Criteria) this;
        }

        public Criteria andAccessEqualTo(Integer value) {
            addCriterion("`access` =", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessNotEqualTo(Integer value) {
            addCriterion("`access` <>", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessGreaterThan(Integer value) {
            addCriterion("`access` >", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("`access` >=", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessLessThan(Integer value) {
            addCriterion("`access` <", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessLessThanOrEqualTo(Integer value) {
            addCriterion("`access` <=", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessIn(List<Integer> values) {
            addCriterion("`access` in", values, "access");
            return (Criteria) this;
        }

        public Criteria andAccessNotIn(List<Integer> values) {
            addCriterion("`access` not in", values, "access");
            return (Criteria) this;
        }

        public Criteria andAccessBetween(Integer value1, Integer value2) {
            addCriterion("`access` between", value1, value2, "access");
            return (Criteria) this;
        }

        public Criteria andAccessNotBetween(Integer value1, Integer value2) {
            addCriterion("`access` not between", value1, value2, "access");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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