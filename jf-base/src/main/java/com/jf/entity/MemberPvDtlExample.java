package com.jf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberPvDtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitSize;

    public MemberPvDtlExample() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitSize(Integer limitSize) {
        this.limitSize=limitSize;
    }

    public Integer getLimitSize() {
        return limitSize;
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

        public Criteria andClientSourceIsNull() {
            addCriterion("client_source is null");
            return (Criteria) this;
        }

        public Criteria andClientSourceIsNotNull() {
            addCriterion("client_source is not null");
            return (Criteria) this;
        }

        public Criteria andClientSourceEqualTo(String value) {
            addCriterion("client_source =", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceNotEqualTo(String value) {
            addCriterion("client_source <>", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceGreaterThan(String value) {
            addCriterion("client_source >", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceGreaterThanOrEqualTo(String value) {
            addCriterion("client_source >=", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceLessThan(String value) {
            addCriterion("client_source <", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceLessThanOrEqualTo(String value) {
            addCriterion("client_source <=", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceLike(String value) {
            addCriterion("client_source like", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceNotLike(String value) {
            addCriterion("client_source not like", value, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceIn(List<String> values) {
            addCriterion("client_source in", values, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceNotIn(List<String> values) {
            addCriterion("client_source not in", values, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceBetween(String value1, String value2) {
            addCriterion("client_source between", value1, value2, "clientSource");
            return (Criteria) this;
        }

        public Criteria andClientSourceNotBetween(String value1, String value2) {
            addCriterion("client_source not between", value1, value2, "clientSource");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIsNull() {
            addCriterion("device_number is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIsNotNull() {
            addCriterion("device_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberEqualTo(String value) {
            addCriterion("device_number =", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotEqualTo(String value) {
            addCriterion("device_number <>", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberGreaterThan(String value) {
            addCriterion("device_number >", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("device_number >=", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLessThan(String value) {
            addCriterion("device_number <", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLessThanOrEqualTo(String value) {
            addCriterion("device_number <=", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLike(String value) {
            addCriterion("device_number like", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotLike(String value) {
            addCriterion("device_number not like", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIn(List<String> values) {
            addCriterion("device_number in", values, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotIn(List<String> values) {
            addCriterion("device_number not in", values, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberBetween(String value1, String value2) {
            addCriterion("device_number between", value1, value2, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotBetween(String value1, String value2) {
            addCriterion("device_number not between", value1, value2, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdIsNull() {
            addCriterion("member_pv_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdIsNotNull() {
            addCriterion("member_pv_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdEqualTo(String value) {
            addCriterion("member_pv_id =", value, "memberPvId");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdNotEqualTo(String value) {
            addCriterion("member_pv_id <>", value, "memberPvId");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdGreaterThan(String value) {
            addCriterion("member_pv_id >", value, "memberPvId");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdGreaterThanOrEqualTo(String value) {
            addCriterion("member_pv_id >=", value, "memberPvId");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdLessThan(String value) {
            addCriterion("member_pv_id <", value, "memberPvId");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdLessThanOrEqualTo(String value) {
            addCriterion("member_pv_id <=", value, "memberPvId");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdLike(String value) {
            addCriterion("member_pv_id like", value, "memberPvId");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdNotLike(String value) {
            addCriterion("member_pv_id not like", value, "memberPvId");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdIn(List<String> values) {
            addCriterion("member_pv_id in", values, "memberPvId");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdNotIn(List<String> values) {
            addCriterion("member_pv_id not in", values, "memberPvId");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdBetween(String value1, String value2) {
            addCriterion("member_pv_id between", value1, value2, "memberPvId");
            return (Criteria) this;
        }

        public Criteria andMemberPvIdNotBetween(String value1, String value2) {
            addCriterion("member_pv_id not between", value1, value2, "memberPvId");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeIsNull() {
            addCriterion("dtl_item_type is null");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeIsNotNull() {
            addCriterion("dtl_item_type is not null");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeEqualTo(String value) {
            addCriterion("dtl_item_type =", value, "dtlItemType");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeNotEqualTo(String value) {
            addCriterion("dtl_item_type <>", value, "dtlItemType");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeGreaterThan(String value) {
            addCriterion("dtl_item_type >", value, "dtlItemType");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dtl_item_type >=", value, "dtlItemType");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeLessThan(String value) {
            addCriterion("dtl_item_type <", value, "dtlItemType");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeLessThanOrEqualTo(String value) {
            addCriterion("dtl_item_type <=", value, "dtlItemType");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeLike(String value) {
            addCriterion("dtl_item_type like", value, "dtlItemType");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeNotLike(String value) {
            addCriterion("dtl_item_type not like", value, "dtlItemType");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeIn(List<String> values) {
            addCriterion("dtl_item_type in", values, "dtlItemType");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeNotIn(List<String> values) {
            addCriterion("dtl_item_type not in", values, "dtlItemType");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeBetween(String value1, String value2) {
            addCriterion("dtl_item_type between", value1, value2, "dtlItemType");
            return (Criteria) this;
        }

        public Criteria andDtlItemTypeNotBetween(String value1, String value2) {
            addCriterion("dtl_item_type not between", value1, value2, "dtlItemType");
            return (Criteria) this;
        }

        public Criteria andDtlItemIdIsNull() {
            addCriterion("dtl_item_id is null");
            return (Criteria) this;
        }

        public Criteria andDtlItemIdIsNotNull() {
            addCriterion("dtl_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andDtlItemIdEqualTo(Integer value) {
            addCriterion("dtl_item_id =", value, "dtlItemId");
            return (Criteria) this;
        }

        public Criteria andDtlItemIdNotEqualTo(Integer value) {
            addCriterion("dtl_item_id <>", value, "dtlItemId");
            return (Criteria) this;
        }

        public Criteria andDtlItemIdGreaterThan(Integer value) {
            addCriterion("dtl_item_id >", value, "dtlItemId");
            return (Criteria) this;
        }

        public Criteria andDtlItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dtl_item_id >=", value, "dtlItemId");
            return (Criteria) this;
        }

        public Criteria andDtlItemIdLessThan(Integer value) {
            addCriterion("dtl_item_id <", value, "dtlItemId");
            return (Criteria) this;
        }

        public Criteria andDtlItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("dtl_item_id <=", value, "dtlItemId");
            return (Criteria) this;
        }

        public Criteria andDtlItemIdIn(List<Integer> values) {
            addCriterion("dtl_item_id in", values, "dtlItemId");
            return (Criteria) this;
        }

        public Criteria andDtlItemIdNotIn(List<Integer> values) {
            addCriterion("dtl_item_id not in", values, "dtlItemId");
            return (Criteria) this;
        }

        public Criteria andDtlItemIdBetween(Integer value1, Integer value2) {
            addCriterion("dtl_item_id between", value1, value2, "dtlItemId");
            return (Criteria) this;
        }

        public Criteria andDtlItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dtl_item_id not between", value1, value2, "dtlItemId");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNull() {
            addCriterion("click_count is null");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNotNull() {
            addCriterion("click_count is not null");
            return (Criteria) this;
        }

        public Criteria andClickCountEqualTo(Integer value) {
            addCriterion("click_count =", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotEqualTo(Integer value) {
            addCriterion("click_count <>", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThan(Integer value) {
            addCriterion("click_count >", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_count >=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThan(Integer value) {
            addCriterion("click_count <", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThanOrEqualTo(Integer value) {
            addCriterion("click_count <=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountIn(List<Integer> values) {
            addCriterion("click_count in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotIn(List<Integer> values) {
            addCriterion("click_count not in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountBetween(Integer value1, Integer value2) {
            addCriterion("click_count between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotBetween(Integer value1, Integer value2) {
            addCriterion("click_count not between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Integer value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Integer value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Integer value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Integer value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Integer value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Integer> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Integer> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Integer value1, Integer value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Integer value1, Integer value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
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