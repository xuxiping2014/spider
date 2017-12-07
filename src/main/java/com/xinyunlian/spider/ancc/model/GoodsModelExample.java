package com.xinyunlian.spider.ancc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsModelExample() {
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

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationIsNull() {
            addCriterion("item_specification is null");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationIsNotNull() {
            addCriterion("item_specification is not null");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationEqualTo(String value) {
            addCriterion("item_specification =", value, "itemSpecification");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationNotEqualTo(String value) {
            addCriterion("item_specification <>", value, "itemSpecification");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationGreaterThan(String value) {
            addCriterion("item_specification >", value, "itemSpecification");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("item_specification >=", value, "itemSpecification");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationLessThan(String value) {
            addCriterion("item_specification <", value, "itemSpecification");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationLessThanOrEqualTo(String value) {
            addCriterion("item_specification <=", value, "itemSpecification");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationLike(String value) {
            addCriterion("item_specification like", value, "itemSpecification");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationNotLike(String value) {
            addCriterion("item_specification not like", value, "itemSpecification");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationIn(List<String> values) {
            addCriterion("item_specification in", values, "itemSpecification");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationNotIn(List<String> values) {
            addCriterion("item_specification not in", values, "itemSpecification");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationBetween(String value1, String value2) {
            addCriterion("item_specification between", value1, value2, "itemSpecification");
            return (Criteria) this;
        }

        public Criteria andItemSpecificationNotBetween(String value1, String value2) {
            addCriterion("item_specification not between", value1, value2, "itemSpecification");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeIsNull() {
            addCriterion("item_packaging_typecode is null");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeIsNotNull() {
            addCriterion("item_packaging_typecode is not null");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeEqualTo(String value) {
            addCriterion("item_packaging_typecode =", value, "itemPackagingTypecode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeNotEqualTo(String value) {
            addCriterion("item_packaging_typecode <>", value, "itemPackagingTypecode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeGreaterThan(String value) {
            addCriterion("item_packaging_typecode >", value, "itemPackagingTypecode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_packaging_typecode >=", value, "itemPackagingTypecode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeLessThan(String value) {
            addCriterion("item_packaging_typecode <", value, "itemPackagingTypecode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeLessThanOrEqualTo(String value) {
            addCriterion("item_packaging_typecode <=", value, "itemPackagingTypecode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeLike(String value) {
            addCriterion("item_packaging_typecode like", value, "itemPackagingTypecode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeNotLike(String value) {
            addCriterion("item_packaging_typecode not like", value, "itemPackagingTypecode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeIn(List<String> values) {
            addCriterion("item_packaging_typecode in", values, "itemPackagingTypecode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeNotIn(List<String> values) {
            addCriterion("item_packaging_typecode not in", values, "itemPackagingTypecode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeBetween(String value1, String value2) {
            addCriterion("item_packaging_typecode between", value1, value2, "itemPackagingTypecode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingTypecodeNotBetween(String value1, String value2) {
            addCriterion("item_packaging_typecode not between", value1, value2, "itemPackagingTypecode");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentIsNull() {
            addCriterion("item_netcontent is null");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentIsNotNull() {
            addCriterion("item_netcontent is not null");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentEqualTo(String value) {
            addCriterion("item_netcontent =", value, "itemNetcontent");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentNotEqualTo(String value) {
            addCriterion("item_netcontent <>", value, "itemNetcontent");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentGreaterThan(String value) {
            addCriterion("item_netcontent >", value, "itemNetcontent");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentGreaterThanOrEqualTo(String value) {
            addCriterion("item_netcontent >=", value, "itemNetcontent");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentLessThan(String value) {
            addCriterion("item_netcontent <", value, "itemNetcontent");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentLessThanOrEqualTo(String value) {
            addCriterion("item_netcontent <=", value, "itemNetcontent");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentLike(String value) {
            addCriterion("item_netcontent like", value, "itemNetcontent");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentNotLike(String value) {
            addCriterion("item_netcontent not like", value, "itemNetcontent");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentIn(List<String> values) {
            addCriterion("item_netcontent in", values, "itemNetcontent");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentNotIn(List<String> values) {
            addCriterion("item_netcontent not in", values, "itemNetcontent");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentBetween(String value1, String value2) {
            addCriterion("item_netcontent between", value1, value2, "itemNetcontent");
            return (Criteria) this;
        }

        public Criteria andItemNetcontentNotBetween(String value1, String value2) {
            addCriterion("item_netcontent not between", value1, value2, "itemNetcontent");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionIsNull() {
            addCriterion("item_description is null");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionIsNotNull() {
            addCriterion("item_description is not null");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionEqualTo(String value) {
            addCriterion("item_description =", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotEqualTo(String value) {
            addCriterion("item_description <>", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionGreaterThan(String value) {
            addCriterion("item_description >", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("item_description >=", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionLessThan(String value) {
            addCriterion("item_description <", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionLessThanOrEqualTo(String value) {
            addCriterion("item_description <=", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionLike(String value) {
            addCriterion("item_description like", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotLike(String value) {
            addCriterion("item_description not like", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionIn(List<String> values) {
            addCriterion("item_description in", values, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotIn(List<String> values) {
            addCriterion("item_description not in", values, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionBetween(String value1, String value2) {
            addCriterion("item_description between", value1, value2, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotBetween(String value1, String value2) {
            addCriterion("item_description not between", value1, value2, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemWidthIsNull() {
            addCriterion("item_width is null");
            return (Criteria) this;
        }

        public Criteria andItemWidthIsNotNull() {
            addCriterion("item_width is not null");
            return (Criteria) this;
        }

        public Criteria andItemWidthEqualTo(String value) {
            addCriterion("item_width =", value, "itemWidth");
            return (Criteria) this;
        }

        public Criteria andItemWidthNotEqualTo(String value) {
            addCriterion("item_width <>", value, "itemWidth");
            return (Criteria) this;
        }

        public Criteria andItemWidthGreaterThan(String value) {
            addCriterion("item_width >", value, "itemWidth");
            return (Criteria) this;
        }

        public Criteria andItemWidthGreaterThanOrEqualTo(String value) {
            addCriterion("item_width >=", value, "itemWidth");
            return (Criteria) this;
        }

        public Criteria andItemWidthLessThan(String value) {
            addCriterion("item_width <", value, "itemWidth");
            return (Criteria) this;
        }

        public Criteria andItemWidthLessThanOrEqualTo(String value) {
            addCriterion("item_width <=", value, "itemWidth");
            return (Criteria) this;
        }

        public Criteria andItemWidthLike(String value) {
            addCriterion("item_width like", value, "itemWidth");
            return (Criteria) this;
        }

        public Criteria andItemWidthNotLike(String value) {
            addCriterion("item_width not like", value, "itemWidth");
            return (Criteria) this;
        }

        public Criteria andItemWidthIn(List<String> values) {
            addCriterion("item_width in", values, "itemWidth");
            return (Criteria) this;
        }

        public Criteria andItemWidthNotIn(List<String> values) {
            addCriterion("item_width not in", values, "itemWidth");
            return (Criteria) this;
        }

        public Criteria andItemWidthBetween(String value1, String value2) {
            addCriterion("item_width between", value1, value2, "itemWidth");
            return (Criteria) this;
        }

        public Criteria andItemWidthNotBetween(String value1, String value2) {
            addCriterion("item_width not between", value1, value2, "itemWidth");
            return (Criteria) this;
        }

        public Criteria andItemHeightIsNull() {
            addCriterion("item_height is null");
            return (Criteria) this;
        }

        public Criteria andItemHeightIsNotNull() {
            addCriterion("item_height is not null");
            return (Criteria) this;
        }

        public Criteria andItemHeightEqualTo(String value) {
            addCriterion("item_height =", value, "itemHeight");
            return (Criteria) this;
        }

        public Criteria andItemHeightNotEqualTo(String value) {
            addCriterion("item_height <>", value, "itemHeight");
            return (Criteria) this;
        }

        public Criteria andItemHeightGreaterThan(String value) {
            addCriterion("item_height >", value, "itemHeight");
            return (Criteria) this;
        }

        public Criteria andItemHeightGreaterThanOrEqualTo(String value) {
            addCriterion("item_height >=", value, "itemHeight");
            return (Criteria) this;
        }

        public Criteria andItemHeightLessThan(String value) {
            addCriterion("item_height <", value, "itemHeight");
            return (Criteria) this;
        }

        public Criteria andItemHeightLessThanOrEqualTo(String value) {
            addCriterion("item_height <=", value, "itemHeight");
            return (Criteria) this;
        }

        public Criteria andItemHeightLike(String value) {
            addCriterion("item_height like", value, "itemHeight");
            return (Criteria) this;
        }

        public Criteria andItemHeightNotLike(String value) {
            addCriterion("item_height not like", value, "itemHeight");
            return (Criteria) this;
        }

        public Criteria andItemHeightIn(List<String> values) {
            addCriterion("item_height in", values, "itemHeight");
            return (Criteria) this;
        }

        public Criteria andItemHeightNotIn(List<String> values) {
            addCriterion("item_height not in", values, "itemHeight");
            return (Criteria) this;
        }

        public Criteria andItemHeightBetween(String value1, String value2) {
            addCriterion("item_height between", value1, value2, "itemHeight");
            return (Criteria) this;
        }

        public Criteria andItemHeightNotBetween(String value1, String value2) {
            addCriterion("item_height not between", value1, value2, "itemHeight");
            return (Criteria) this;
        }

        public Criteria andItemDepthIsNull() {
            addCriterion("item_depth is null");
            return (Criteria) this;
        }

        public Criteria andItemDepthIsNotNull() {
            addCriterion("item_depth is not null");
            return (Criteria) this;
        }

        public Criteria andItemDepthEqualTo(String value) {
            addCriterion("item_depth =", value, "itemDepth");
            return (Criteria) this;
        }

        public Criteria andItemDepthNotEqualTo(String value) {
            addCriterion("item_depth <>", value, "itemDepth");
            return (Criteria) this;
        }

        public Criteria andItemDepthGreaterThan(String value) {
            addCriterion("item_depth >", value, "itemDepth");
            return (Criteria) this;
        }

        public Criteria andItemDepthGreaterThanOrEqualTo(String value) {
            addCriterion("item_depth >=", value, "itemDepth");
            return (Criteria) this;
        }

        public Criteria andItemDepthLessThan(String value) {
            addCriterion("item_depth <", value, "itemDepth");
            return (Criteria) this;
        }

        public Criteria andItemDepthLessThanOrEqualTo(String value) {
            addCriterion("item_depth <=", value, "itemDepth");
            return (Criteria) this;
        }

        public Criteria andItemDepthLike(String value) {
            addCriterion("item_depth like", value, "itemDepth");
            return (Criteria) this;
        }

        public Criteria andItemDepthNotLike(String value) {
            addCriterion("item_depth not like", value, "itemDepth");
            return (Criteria) this;
        }

        public Criteria andItemDepthIn(List<String> values) {
            addCriterion("item_depth in", values, "itemDepth");
            return (Criteria) this;
        }

        public Criteria andItemDepthNotIn(List<String> values) {
            addCriterion("item_depth not in", values, "itemDepth");
            return (Criteria) this;
        }

        public Criteria andItemDepthBetween(String value1, String value2) {
            addCriterion("item_depth between", value1, value2, "itemDepth");
            return (Criteria) this;
        }

        public Criteria andItemDepthNotBetween(String value1, String value2) {
            addCriterion("item_depth not between", value1, value2, "itemDepth");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightIsNull() {
            addCriterion("item_grossweight is null");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightIsNotNull() {
            addCriterion("item_grossweight is not null");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightEqualTo(String value) {
            addCriterion("item_grossweight =", value, "itemGrossweight");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightNotEqualTo(String value) {
            addCriterion("item_grossweight <>", value, "itemGrossweight");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightGreaterThan(String value) {
            addCriterion("item_grossweight >", value, "itemGrossweight");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightGreaterThanOrEqualTo(String value) {
            addCriterion("item_grossweight >=", value, "itemGrossweight");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightLessThan(String value) {
            addCriterion("item_grossweight <", value, "itemGrossweight");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightLessThanOrEqualTo(String value) {
            addCriterion("item_grossweight <=", value, "itemGrossweight");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightLike(String value) {
            addCriterion("item_grossweight like", value, "itemGrossweight");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightNotLike(String value) {
            addCriterion("item_grossweight not like", value, "itemGrossweight");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightIn(List<String> values) {
            addCriterion("item_grossweight in", values, "itemGrossweight");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightNotIn(List<String> values) {
            addCriterion("item_grossweight not in", values, "itemGrossweight");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightBetween(String value1, String value2) {
            addCriterion("item_grossweight between", value1, value2, "itemGrossweight");
            return (Criteria) this;
        }

        public Criteria andItemGrossweightNotBetween(String value1, String value2) {
            addCriterion("item_grossweight not between", value1, value2, "itemGrossweight");
            return (Criteria) this;
        }

        public Criteria andItemNetweightIsNull() {
            addCriterion("item_netweight is null");
            return (Criteria) this;
        }

        public Criteria andItemNetweightIsNotNull() {
            addCriterion("item_netweight is not null");
            return (Criteria) this;
        }

        public Criteria andItemNetweightEqualTo(String value) {
            addCriterion("item_netweight =", value, "itemNetweight");
            return (Criteria) this;
        }

        public Criteria andItemNetweightNotEqualTo(String value) {
            addCriterion("item_netweight <>", value, "itemNetweight");
            return (Criteria) this;
        }

        public Criteria andItemNetweightGreaterThan(String value) {
            addCriterion("item_netweight >", value, "itemNetweight");
            return (Criteria) this;
        }

        public Criteria andItemNetweightGreaterThanOrEqualTo(String value) {
            addCriterion("item_netweight >=", value, "itemNetweight");
            return (Criteria) this;
        }

        public Criteria andItemNetweightLessThan(String value) {
            addCriterion("item_netweight <", value, "itemNetweight");
            return (Criteria) this;
        }

        public Criteria andItemNetweightLessThanOrEqualTo(String value) {
            addCriterion("item_netweight <=", value, "itemNetweight");
            return (Criteria) this;
        }

        public Criteria andItemNetweightLike(String value) {
            addCriterion("item_netweight like", value, "itemNetweight");
            return (Criteria) this;
        }

        public Criteria andItemNetweightNotLike(String value) {
            addCriterion("item_netweight not like", value, "itemNetweight");
            return (Criteria) this;
        }

        public Criteria andItemNetweightIn(List<String> values) {
            addCriterion("item_netweight in", values, "itemNetweight");
            return (Criteria) this;
        }

        public Criteria andItemNetweightNotIn(List<String> values) {
            addCriterion("item_netweight not in", values, "itemNetweight");
            return (Criteria) this;
        }

        public Criteria andItemNetweightBetween(String value1, String value2) {
            addCriterion("item_netweight between", value1, value2, "itemNetweight");
            return (Criteria) this;
        }

        public Criteria andItemNetweightNotBetween(String value1, String value2) {
            addCriterion("item_netweight not between", value1, value2, "itemNetweight");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeIsNull() {
            addCriterion("item_classcode is null");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeIsNotNull() {
            addCriterion("item_classcode is not null");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeEqualTo(String value) {
            addCriterion("item_classcode =", value, "itemClasscode");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeNotEqualTo(String value) {
            addCriterion("item_classcode <>", value, "itemClasscode");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeGreaterThan(String value) {
            addCriterion("item_classcode >", value, "itemClasscode");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_classcode >=", value, "itemClasscode");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeLessThan(String value) {
            addCriterion("item_classcode <", value, "itemClasscode");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeLessThanOrEqualTo(String value) {
            addCriterion("item_classcode <=", value, "itemClasscode");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeLike(String value) {
            addCriterion("item_classcode like", value, "itemClasscode");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeNotLike(String value) {
            addCriterion("item_classcode not like", value, "itemClasscode");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeIn(List<String> values) {
            addCriterion("item_classcode in", values, "itemClasscode");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeNotIn(List<String> values) {
            addCriterion("item_classcode not in", values, "itemClasscode");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeBetween(String value1, String value2) {
            addCriterion("item_classcode between", value1, value2, "itemClasscode");
            return (Criteria) this;
        }

        public Criteria andItemClasscodeNotBetween(String value1, String value2) {
            addCriterion("item_classcode not between", value1, value2, "itemClasscode");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionIsNull() {
            addCriterion("item_shortdescription is null");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionIsNotNull() {
            addCriterion("item_shortdescription is not null");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionEqualTo(String value) {
            addCriterion("item_shortdescription =", value, "itemShortdescription");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionNotEqualTo(String value) {
            addCriterion("item_shortdescription <>", value, "itemShortdescription");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionGreaterThan(String value) {
            addCriterion("item_shortdescription >", value, "itemShortdescription");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("item_shortdescription >=", value, "itemShortdescription");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionLessThan(String value) {
            addCriterion("item_shortdescription <", value, "itemShortdescription");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionLessThanOrEqualTo(String value) {
            addCriterion("item_shortdescription <=", value, "itemShortdescription");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionLike(String value) {
            addCriterion("item_shortdescription like", value, "itemShortdescription");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionNotLike(String value) {
            addCriterion("item_shortdescription not like", value, "itemShortdescription");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionIn(List<String> values) {
            addCriterion("item_shortdescription in", values, "itemShortdescription");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionNotIn(List<String> values) {
            addCriterion("item_shortdescription not in", values, "itemShortdescription");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionBetween(String value1, String value2) {
            addCriterion("item_shortdescription between", value1, value2, "itemShortdescription");
            return (Criteria) this;
        }

        public Criteria andItemShortdescriptionNotBetween(String value1, String value2) {
            addCriterion("item_shortdescription not between", value1, value2, "itemShortdescription");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeIsNull() {
            addCriterion("item_packagingmaterial_code is null");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeIsNotNull() {
            addCriterion("item_packagingmaterial_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeEqualTo(String value) {
            addCriterion("item_packagingmaterial_code =", value, "itemPackagingmaterialCode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeNotEqualTo(String value) {
            addCriterion("item_packagingmaterial_code <>", value, "itemPackagingmaterialCode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeGreaterThan(String value) {
            addCriterion("item_packagingmaterial_code >", value, "itemPackagingmaterialCode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_packagingmaterial_code >=", value, "itemPackagingmaterialCode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeLessThan(String value) {
            addCriterion("item_packagingmaterial_code <", value, "itemPackagingmaterialCode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeLessThanOrEqualTo(String value) {
            addCriterion("item_packagingmaterial_code <=", value, "itemPackagingmaterialCode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeLike(String value) {
            addCriterion("item_packagingmaterial_code like", value, "itemPackagingmaterialCode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeNotLike(String value) {
            addCriterion("item_packagingmaterial_code not like", value, "itemPackagingmaterialCode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeIn(List<String> values) {
            addCriterion("item_packagingmaterial_code in", values, "itemPackagingmaterialCode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeNotIn(List<String> values) {
            addCriterion("item_packagingmaterial_code not in", values, "itemPackagingmaterialCode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeBetween(String value1, String value2) {
            addCriterion("item_packagingmaterial_code between", value1, value2, "itemPackagingmaterialCode");
            return (Criteria) this;
        }

        public Criteria andItemPackagingmaterialCodeNotBetween(String value1, String value2) {
            addCriterion("item_packagingmaterial_code not between", value1, value2, "itemPackagingmaterialCode");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFirmNameIsNull() {
            addCriterion("firm_name is null");
            return (Criteria) this;
        }

        public Criteria andFirmNameIsNotNull() {
            addCriterion("firm_name is not null");
            return (Criteria) this;
        }

        public Criteria andFirmNameEqualTo(String value) {
            addCriterion("firm_name =", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameNotEqualTo(String value) {
            addCriterion("firm_name <>", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameGreaterThan(String value) {
            addCriterion("firm_name >", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameGreaterThanOrEqualTo(String value) {
            addCriterion("firm_name >=", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameLessThan(String value) {
            addCriterion("firm_name <", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameLessThanOrEqualTo(String value) {
            addCriterion("firm_name <=", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameLike(String value) {
            addCriterion("firm_name like", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameNotLike(String value) {
            addCriterion("firm_name not like", value, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameIn(List<String> values) {
            addCriterion("firm_name in", values, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameNotIn(List<String> values) {
            addCriterion("firm_name not in", values, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameBetween(String value1, String value2) {
            addCriterion("firm_name between", value1, value2, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmNameNotBetween(String value1, String value2) {
            addCriterion("firm_name not between", value1, value2, "firmName");
            return (Criteria) this;
        }

        public Criteria andFirmAddressIsNull() {
            addCriterion("firm_address is null");
            return (Criteria) this;
        }

        public Criteria andFirmAddressIsNotNull() {
            addCriterion("firm_address is not null");
            return (Criteria) this;
        }

        public Criteria andFirmAddressEqualTo(String value) {
            addCriterion("firm_address =", value, "firmAddress");
            return (Criteria) this;
        }

        public Criteria andFirmAddressNotEqualTo(String value) {
            addCriterion("firm_address <>", value, "firmAddress");
            return (Criteria) this;
        }

        public Criteria andFirmAddressGreaterThan(String value) {
            addCriterion("firm_address >", value, "firmAddress");
            return (Criteria) this;
        }

        public Criteria andFirmAddressGreaterThanOrEqualTo(String value) {
            addCriterion("firm_address >=", value, "firmAddress");
            return (Criteria) this;
        }

        public Criteria andFirmAddressLessThan(String value) {
            addCriterion("firm_address <", value, "firmAddress");
            return (Criteria) this;
        }

        public Criteria andFirmAddressLessThanOrEqualTo(String value) {
            addCriterion("firm_address <=", value, "firmAddress");
            return (Criteria) this;
        }

        public Criteria andFirmAddressLike(String value) {
            addCriterion("firm_address like", value, "firmAddress");
            return (Criteria) this;
        }

        public Criteria andFirmAddressNotLike(String value) {
            addCriterion("firm_address not like", value, "firmAddress");
            return (Criteria) this;
        }

        public Criteria andFirmAddressIn(List<String> values) {
            addCriterion("firm_address in", values, "firmAddress");
            return (Criteria) this;
        }

        public Criteria andFirmAddressNotIn(List<String> values) {
            addCriterion("firm_address not in", values, "firmAddress");
            return (Criteria) this;
        }

        public Criteria andFirmAddressBetween(String value1, String value2) {
            addCriterion("firm_address between", value1, value2, "firmAddress");
            return (Criteria) this;
        }

        public Criteria andFirmAddressNotBetween(String value1, String value2) {
            addCriterion("firm_address not between", value1, value2, "firmAddress");
            return (Criteria) this;
        }

        public Criteria andFirmStatusIsNull() {
            addCriterion("firm_status is null");
            return (Criteria) this;
        }

        public Criteria andFirmStatusIsNotNull() {
            addCriterion("firm_status is not null");
            return (Criteria) this;
        }

        public Criteria andFirmStatusEqualTo(String value) {
            addCriterion("firm_status =", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusNotEqualTo(String value) {
            addCriterion("firm_status <>", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusGreaterThan(String value) {
            addCriterion("firm_status >", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusGreaterThanOrEqualTo(String value) {
            addCriterion("firm_status >=", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusLessThan(String value) {
            addCriterion("firm_status <", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusLessThanOrEqualTo(String value) {
            addCriterion("firm_status <=", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusLike(String value) {
            addCriterion("firm_status like", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusNotLike(String value) {
            addCriterion("firm_status not like", value, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusIn(List<String> values) {
            addCriterion("firm_status in", values, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusNotIn(List<String> values) {
            addCriterion("firm_status not in", values, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusBetween(String value1, String value2) {
            addCriterion("firm_status between", value1, value2, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmStatusNotBetween(String value1, String value2) {
            addCriterion("firm_status not between", value1, value2, "firmStatus");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanIsNull() {
            addCriterion("firm_contactman is null");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanIsNotNull() {
            addCriterion("firm_contactman is not null");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanEqualTo(String value) {
            addCriterion("firm_contactman =", value, "firmContactman");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanNotEqualTo(String value) {
            addCriterion("firm_contactman <>", value, "firmContactman");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanGreaterThan(String value) {
            addCriterion("firm_contactman >", value, "firmContactman");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanGreaterThanOrEqualTo(String value) {
            addCriterion("firm_contactman >=", value, "firmContactman");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanLessThan(String value) {
            addCriterion("firm_contactman <", value, "firmContactman");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanLessThanOrEqualTo(String value) {
            addCriterion("firm_contactman <=", value, "firmContactman");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanLike(String value) {
            addCriterion("firm_contactman like", value, "firmContactman");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanNotLike(String value) {
            addCriterion("firm_contactman not like", value, "firmContactman");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanIn(List<String> values) {
            addCriterion("firm_contactman in", values, "firmContactman");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanNotIn(List<String> values) {
            addCriterion("firm_contactman not in", values, "firmContactman");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanBetween(String value1, String value2) {
            addCriterion("firm_contactman between", value1, value2, "firmContactman");
            return (Criteria) this;
        }

        public Criteria andFirmContactmanNotBetween(String value1, String value2) {
            addCriterion("firm_contactman not between", value1, value2, "firmContactman");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneIsNull() {
            addCriterion("firm_contactphone is null");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneIsNotNull() {
            addCriterion("firm_contactphone is not null");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneEqualTo(String value) {
            addCriterion("firm_contactphone =", value, "firmContactphone");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneNotEqualTo(String value) {
            addCriterion("firm_contactphone <>", value, "firmContactphone");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneGreaterThan(String value) {
            addCriterion("firm_contactphone >", value, "firmContactphone");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneGreaterThanOrEqualTo(String value) {
            addCriterion("firm_contactphone >=", value, "firmContactphone");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneLessThan(String value) {
            addCriterion("firm_contactphone <", value, "firmContactphone");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneLessThanOrEqualTo(String value) {
            addCriterion("firm_contactphone <=", value, "firmContactphone");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneLike(String value) {
            addCriterion("firm_contactphone like", value, "firmContactphone");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneNotLike(String value) {
            addCriterion("firm_contactphone not like", value, "firmContactphone");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneIn(List<String> values) {
            addCriterion("firm_contactphone in", values, "firmContactphone");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneNotIn(List<String> values) {
            addCriterion("firm_contactphone not in", values, "firmContactphone");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneBetween(String value1, String value2) {
            addCriterion("firm_contactphone between", value1, value2, "firmContactphone");
            return (Criteria) this;
        }

        public Criteria andFirmContactphoneNotBetween(String value1, String value2) {
            addCriterion("firm_contactphone not between", value1, value2, "firmContactphone");
            return (Criteria) this;
        }

        public Criteria andFirmLoginDateIsNull() {
            addCriterion("firm_login_date is null");
            return (Criteria) this;
        }

        public Criteria andFirmLoginDateIsNotNull() {
            addCriterion("firm_login_date is not null");
            return (Criteria) this;
        }

        public Criteria andFirmLoginDateEqualTo(Date value) {
            addCriterion("firm_login_date =", value, "firmLoginDate");
            return (Criteria) this;
        }

        public Criteria andFirmLoginDateNotEqualTo(Date value) {
            addCriterion("firm_login_date <>", value, "firmLoginDate");
            return (Criteria) this;
        }

        public Criteria andFirmLoginDateGreaterThan(Date value) {
            addCriterion("firm_login_date >", value, "firmLoginDate");
            return (Criteria) this;
        }

        public Criteria andFirmLoginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("firm_login_date >=", value, "firmLoginDate");
            return (Criteria) this;
        }

        public Criteria andFirmLoginDateLessThan(Date value) {
            addCriterion("firm_login_date <", value, "firmLoginDate");
            return (Criteria) this;
        }

        public Criteria andFirmLoginDateLessThanOrEqualTo(Date value) {
            addCriterion("firm_login_date <=", value, "firmLoginDate");
            return (Criteria) this;
        }

        public Criteria andFirmLoginDateIn(List<Date> values) {
            addCriterion("firm_login_date in", values, "firmLoginDate");
            return (Criteria) this;
        }

        public Criteria andFirmLoginDateNotIn(List<Date> values) {
            addCriterion("firm_login_date not in", values, "firmLoginDate");
            return (Criteria) this;
        }

        public Criteria andFirmLoginDateBetween(Date value1, Date value2) {
            addCriterion("firm_login_date between", value1, value2, "firmLoginDate");
            return (Criteria) this;
        }

        public Criteria andFirmLoginDateNotBetween(Date value1, Date value2) {
            addCriterion("firm_login_date not between", value1, value2, "firmLoginDate");
            return (Criteria) this;
        }

        public Criteria andFirmValidDateIsNull() {
            addCriterion("firm_valid_date is null");
            return (Criteria) this;
        }

        public Criteria andFirmValidDateIsNotNull() {
            addCriterion("firm_valid_date is not null");
            return (Criteria) this;
        }

        public Criteria andFirmValidDateEqualTo(Date value) {
            addCriterion("firm_valid_date =", value, "firmValidDate");
            return (Criteria) this;
        }

        public Criteria andFirmValidDateNotEqualTo(Date value) {
            addCriterion("firm_valid_date <>", value, "firmValidDate");
            return (Criteria) this;
        }

        public Criteria andFirmValidDateGreaterThan(Date value) {
            addCriterion("firm_valid_date >", value, "firmValidDate");
            return (Criteria) this;
        }

        public Criteria andFirmValidDateGreaterThanOrEqualTo(Date value) {
            addCriterion("firm_valid_date >=", value, "firmValidDate");
            return (Criteria) this;
        }

        public Criteria andFirmValidDateLessThan(Date value) {
            addCriterion("firm_valid_date <", value, "firmValidDate");
            return (Criteria) this;
        }

        public Criteria andFirmValidDateLessThanOrEqualTo(Date value) {
            addCriterion("firm_valid_date <=", value, "firmValidDate");
            return (Criteria) this;
        }

        public Criteria andFirmValidDateIn(List<Date> values) {
            addCriterion("firm_valid_date in", values, "firmValidDate");
            return (Criteria) this;
        }

        public Criteria andFirmValidDateNotIn(List<Date> values) {
            addCriterion("firm_valid_date not in", values, "firmValidDate");
            return (Criteria) this;
        }

        public Criteria andFirmValidDateBetween(Date value1, Date value2) {
            addCriterion("firm_valid_date between", value1, value2, "firmValidDate");
            return (Criteria) this;
        }

        public Criteria andFirmValidDateNotBetween(Date value1, Date value2) {
            addCriterion("firm_valid_date not between", value1, value2, "firmValidDate");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDateIsNull() {
            addCriterion("firm_logout_date is null");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDateIsNotNull() {
            addCriterion("firm_logout_date is not null");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDateEqualTo(Date value) {
            addCriterion("firm_logout_date =", value, "firmLogoutDate");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDateNotEqualTo(Date value) {
            addCriterion("firm_logout_date <>", value, "firmLogoutDate");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDateGreaterThan(Date value) {
            addCriterion("firm_logout_date >", value, "firmLogoutDate");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDateGreaterThanOrEqualTo(Date value) {
            addCriterion("firm_logout_date >=", value, "firmLogoutDate");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDateLessThan(Date value) {
            addCriterion("firm_logout_date <", value, "firmLogoutDate");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDateLessThanOrEqualTo(Date value) {
            addCriterion("firm_logout_date <=", value, "firmLogoutDate");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDateIn(List<Date> values) {
            addCriterion("firm_logout_date in", values, "firmLogoutDate");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDateNotIn(List<Date> values) {
            addCriterion("firm_logout_date not in", values, "firmLogoutDate");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDateBetween(Date value1, Date value2) {
            addCriterion("firm_logout_date between", value1, value2, "firmLogoutDate");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDateNotBetween(Date value1, Date value2) {
            addCriterion("firm_logout_date not between", value1, value2, "firmLogoutDate");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDate1IsNull() {
            addCriterion("firm_logout_date1 is null");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDate1IsNotNull() {
            addCriterion("firm_logout_date1 is not null");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDate1EqualTo(Date value) {
            addCriterion("firm_logout_date1 =", value, "firmLogoutDate1");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDate1NotEqualTo(Date value) {
            addCriterion("firm_logout_date1 <>", value, "firmLogoutDate1");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDate1GreaterThan(Date value) {
            addCriterion("firm_logout_date1 >", value, "firmLogoutDate1");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDate1GreaterThanOrEqualTo(Date value) {
            addCriterion("firm_logout_date1 >=", value, "firmLogoutDate1");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDate1LessThan(Date value) {
            addCriterion("firm_logout_date1 <", value, "firmLogoutDate1");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDate1LessThanOrEqualTo(Date value) {
            addCriterion("firm_logout_date1 <=", value, "firmLogoutDate1");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDate1In(List<Date> values) {
            addCriterion("firm_logout_date1 in", values, "firmLogoutDate1");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDate1NotIn(List<Date> values) {
            addCriterion("firm_logout_date1 not in", values, "firmLogoutDate1");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDate1Between(Date value1, Date value2) {
            addCriterion("firm_logout_date1 between", value1, value2, "firmLogoutDate1");
            return (Criteria) this;
        }

        public Criteria andFirmLogoutDate1NotBetween(Date value1, Date value2) {
            addCriterion("firm_logout_date1 not between", value1, value2, "firmLogoutDate1");
            return (Criteria) this;
        }

        public Criteria andQualificationCountIsNull() {
            addCriterion("qualification_count is null");
            return (Criteria) this;
        }

        public Criteria andQualificationCountIsNotNull() {
            addCriterion("qualification_count is not null");
            return (Criteria) this;
        }

        public Criteria andQualificationCountEqualTo(String value) {
            addCriterion("qualification_count =", value, "qualificationCount");
            return (Criteria) this;
        }

        public Criteria andQualificationCountNotEqualTo(String value) {
            addCriterion("qualification_count <>", value, "qualificationCount");
            return (Criteria) this;
        }

        public Criteria andQualificationCountGreaterThan(String value) {
            addCriterion("qualification_count >", value, "qualificationCount");
            return (Criteria) this;
        }

        public Criteria andQualificationCountGreaterThanOrEqualTo(String value) {
            addCriterion("qualification_count >=", value, "qualificationCount");
            return (Criteria) this;
        }

        public Criteria andQualificationCountLessThan(String value) {
            addCriterion("qualification_count <", value, "qualificationCount");
            return (Criteria) this;
        }

        public Criteria andQualificationCountLessThanOrEqualTo(String value) {
            addCriterion("qualification_count <=", value, "qualificationCount");
            return (Criteria) this;
        }

        public Criteria andQualificationCountLike(String value) {
            addCriterion("qualification_count like", value, "qualificationCount");
            return (Criteria) this;
        }

        public Criteria andQualificationCountNotLike(String value) {
            addCriterion("qualification_count not like", value, "qualificationCount");
            return (Criteria) this;
        }

        public Criteria andQualificationCountIn(List<String> values) {
            addCriterion("qualification_count in", values, "qualificationCount");
            return (Criteria) this;
        }

        public Criteria andQualificationCountNotIn(List<String> values) {
            addCriterion("qualification_count not in", values, "qualificationCount");
            return (Criteria) this;
        }

        public Criteria andQualificationCountBetween(String value1, String value2) {
            addCriterion("qualification_count between", value1, value2, "qualificationCount");
            return (Criteria) this;
        }

        public Criteria andQualificationCountNotBetween(String value1, String value2) {
            addCriterion("qualification_count not between", value1, value2, "qualificationCount");
            return (Criteria) this;
        }

        public Criteria andProductExIsNull() {
            addCriterion("product_ex is null");
            return (Criteria) this;
        }

        public Criteria andProductExIsNotNull() {
            addCriterion("product_ex is not null");
            return (Criteria) this;
        }

        public Criteria andProductExEqualTo(String value) {
            addCriterion("product_ex =", value, "productEx");
            return (Criteria) this;
        }

        public Criteria andProductExNotEqualTo(String value) {
            addCriterion("product_ex <>", value, "productEx");
            return (Criteria) this;
        }

        public Criteria andProductExGreaterThan(String value) {
            addCriterion("product_ex >", value, "productEx");
            return (Criteria) this;
        }

        public Criteria andProductExGreaterThanOrEqualTo(String value) {
            addCriterion("product_ex >=", value, "productEx");
            return (Criteria) this;
        }

        public Criteria andProductExLessThan(String value) {
            addCriterion("product_ex <", value, "productEx");
            return (Criteria) this;
        }

        public Criteria andProductExLessThanOrEqualTo(String value) {
            addCriterion("product_ex <=", value, "productEx");
            return (Criteria) this;
        }

        public Criteria andProductExLike(String value) {
            addCriterion("product_ex like", value, "productEx");
            return (Criteria) this;
        }

        public Criteria andProductExNotLike(String value) {
            addCriterion("product_ex not like", value, "productEx");
            return (Criteria) this;
        }

        public Criteria andProductExIn(List<String> values) {
            addCriterion("product_ex in", values, "productEx");
            return (Criteria) this;
        }

        public Criteria andProductExNotIn(List<String> values) {
            addCriterion("product_ex not in", values, "productEx");
            return (Criteria) this;
        }

        public Criteria andProductExBetween(String value1, String value2) {
            addCriterion("product_ex between", value1, value2, "productEx");
            return (Criteria) this;
        }

        public Criteria andProductExNotBetween(String value1, String value2) {
            addCriterion("product_ex not between", value1, value2, "productEx");
            return (Criteria) this;
        }

        public Criteria andAlermCountIsNull() {
            addCriterion("alerm_count is null");
            return (Criteria) this;
        }

        public Criteria andAlermCountIsNotNull() {
            addCriterion("alerm_count is not null");
            return (Criteria) this;
        }

        public Criteria andAlermCountEqualTo(String value) {
            addCriterion("alerm_count =", value, "alermCount");
            return (Criteria) this;
        }

        public Criteria andAlermCountNotEqualTo(String value) {
            addCriterion("alerm_count <>", value, "alermCount");
            return (Criteria) this;
        }

        public Criteria andAlermCountGreaterThan(String value) {
            addCriterion("alerm_count >", value, "alermCount");
            return (Criteria) this;
        }

        public Criteria andAlermCountGreaterThanOrEqualTo(String value) {
            addCriterion("alerm_count >=", value, "alermCount");
            return (Criteria) this;
        }

        public Criteria andAlermCountLessThan(String value) {
            addCriterion("alerm_count <", value, "alermCount");
            return (Criteria) this;
        }

        public Criteria andAlermCountLessThanOrEqualTo(String value) {
            addCriterion("alerm_count <=", value, "alermCount");
            return (Criteria) this;
        }

        public Criteria andAlermCountLike(String value) {
            addCriterion("alerm_count like", value, "alermCount");
            return (Criteria) this;
        }

        public Criteria andAlermCountNotLike(String value) {
            addCriterion("alerm_count not like", value, "alermCount");
            return (Criteria) this;
        }

        public Criteria andAlermCountIn(List<String> values) {
            addCriterion("alerm_count in", values, "alermCount");
            return (Criteria) this;
        }

        public Criteria andAlermCountNotIn(List<String> values) {
            addCriterion("alerm_count not in", values, "alermCount");
            return (Criteria) this;
        }

        public Criteria andAlermCountBetween(String value1, String value2) {
            addCriterion("alerm_count between", value1, value2, "alermCount");
            return (Criteria) this;
        }

        public Criteria andAlermCountNotBetween(String value1, String value2) {
            addCriterion("alerm_count not between", value1, value2, "alermCount");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordIsNull() {
            addCriterion("keepon_record is null");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordIsNotNull() {
            addCriterion("keepon_record is not null");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordEqualTo(String value) {
            addCriterion("keepon_record =", value, "keeponRecord");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordNotEqualTo(String value) {
            addCriterion("keepon_record <>", value, "keeponRecord");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordGreaterThan(String value) {
            addCriterion("keepon_record >", value, "keeponRecord");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordGreaterThanOrEqualTo(String value) {
            addCriterion("keepon_record >=", value, "keeponRecord");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordLessThan(String value) {
            addCriterion("keepon_record <", value, "keeponRecord");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordLessThanOrEqualTo(String value) {
            addCriterion("keepon_record <=", value, "keeponRecord");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordLike(String value) {
            addCriterion("keepon_record like", value, "keeponRecord");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordNotLike(String value) {
            addCriterion("keepon_record not like", value, "keeponRecord");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordIn(List<String> values) {
            addCriterion("keepon_record in", values, "keeponRecord");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordNotIn(List<String> values) {
            addCriterion("keepon_record not in", values, "keeponRecord");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordBetween(String value1, String value2) {
            addCriterion("keepon_record between", value1, value2, "keeponRecord");
            return (Criteria) this;
        }

        public Criteria andKeeponRecordNotBetween(String value1, String value2) {
            addCriterion("keepon_record not between", value1, value2, "keeponRecord");
            return (Criteria) this;
        }

        public Criteria andRecallCountIsNull() {
            addCriterion("recall_count is null");
            return (Criteria) this;
        }

        public Criteria andRecallCountIsNotNull() {
            addCriterion("recall_count is not null");
            return (Criteria) this;
        }

        public Criteria andRecallCountEqualTo(String value) {
            addCriterion("recall_count =", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountNotEqualTo(String value) {
            addCriterion("recall_count <>", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountGreaterThan(String value) {
            addCriterion("recall_count >", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountGreaterThanOrEqualTo(String value) {
            addCriterion("recall_count >=", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountLessThan(String value) {
            addCriterion("recall_count <", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountLessThanOrEqualTo(String value) {
            addCriterion("recall_count <=", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountLike(String value) {
            addCriterion("recall_count like", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountNotLike(String value) {
            addCriterion("recall_count not like", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountIn(List<String> values) {
            addCriterion("recall_count in", values, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountNotIn(List<String> values) {
            addCriterion("recall_count not in", values, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountBetween(String value1, String value2) {
            addCriterion("recall_count between", value1, value2, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountNotBetween(String value1, String value2) {
            addCriterion("recall_count not between", value1, value2, "recallCount");
            return (Criteria) this;
        }

        public Criteria andProductfangweiIsNull() {
            addCriterion("productFangWei is null");
            return (Criteria) this;
        }

        public Criteria andProductfangweiIsNotNull() {
            addCriterion("productFangWei is not null");
            return (Criteria) this;
        }

        public Criteria andProductfangweiEqualTo(String value) {
            addCriterion("productFangWei =", value, "productfangwei");
            return (Criteria) this;
        }

        public Criteria andProductfangweiNotEqualTo(String value) {
            addCriterion("productFangWei <>", value, "productfangwei");
            return (Criteria) this;
        }

        public Criteria andProductfangweiGreaterThan(String value) {
            addCriterion("productFangWei >", value, "productfangwei");
            return (Criteria) this;
        }

        public Criteria andProductfangweiGreaterThanOrEqualTo(String value) {
            addCriterion("productFangWei >=", value, "productfangwei");
            return (Criteria) this;
        }

        public Criteria andProductfangweiLessThan(String value) {
            addCriterion("productFangWei <", value, "productfangwei");
            return (Criteria) this;
        }

        public Criteria andProductfangweiLessThanOrEqualTo(String value) {
            addCriterion("productFangWei <=", value, "productfangwei");
            return (Criteria) this;
        }

        public Criteria andProductfangweiLike(String value) {
            addCriterion("productFangWei like", value, "productfangwei");
            return (Criteria) this;
        }

        public Criteria andProductfangweiNotLike(String value) {
            addCriterion("productFangWei not like", value, "productfangwei");
            return (Criteria) this;
        }

        public Criteria andProductfangweiIn(List<String> values) {
            addCriterion("productFangWei in", values, "productfangwei");
            return (Criteria) this;
        }

        public Criteria andProductfangweiNotIn(List<String> values) {
            addCriterion("productFangWei not in", values, "productfangwei");
            return (Criteria) this;
        }

        public Criteria andProductfangweiBetween(String value1, String value2) {
            addCriterion("productFangWei between", value1, value2, "productfangwei");
            return (Criteria) this;
        }

        public Criteria andProductfangweiNotBetween(String value1, String value2) {
            addCriterion("productFangWei not between", value1, value2, "productfangwei");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysIsNull() {
            addCriterion("diffYearsMonthsDays is null");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysIsNotNull() {
            addCriterion("diffYearsMonthsDays is not null");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysEqualTo(String value) {
            addCriterion("diffYearsMonthsDays =", value, "diffyearsmonthsdays");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysNotEqualTo(String value) {
            addCriterion("diffYearsMonthsDays <>", value, "diffyearsmonthsdays");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysGreaterThan(String value) {
            addCriterion("diffYearsMonthsDays >", value, "diffyearsmonthsdays");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysGreaterThanOrEqualTo(String value) {
            addCriterion("diffYearsMonthsDays >=", value, "diffyearsmonthsdays");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysLessThan(String value) {
            addCriterion("diffYearsMonthsDays <", value, "diffyearsmonthsdays");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysLessThanOrEqualTo(String value) {
            addCriterion("diffYearsMonthsDays <=", value, "diffyearsmonthsdays");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysLike(String value) {
            addCriterion("diffYearsMonthsDays like", value, "diffyearsmonthsdays");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysNotLike(String value) {
            addCriterion("diffYearsMonthsDays not like", value, "diffyearsmonthsdays");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysIn(List<String> values) {
            addCriterion("diffYearsMonthsDays in", values, "diffyearsmonthsdays");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysNotIn(List<String> values) {
            addCriterion("diffYearsMonthsDays not in", values, "diffyearsmonthsdays");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysBetween(String value1, String value2) {
            addCriterion("diffYearsMonthsDays between", value1, value2, "diffyearsmonthsdays");
            return (Criteria) this;
        }

        public Criteria andDiffyearsmonthsdaysNotBetween(String value1, String value2) {
            addCriterion("diffYearsMonthsDays not between", value1, value2, "diffyearsmonthsdays");
            return (Criteria) this;
        }

        public Criteria andQsIsNull() {
            addCriterion("qs is null");
            return (Criteria) this;
        }

        public Criteria andQsIsNotNull() {
            addCriterion("qs is not null");
            return (Criteria) this;
        }

        public Criteria andQsEqualTo(String value) {
            addCriterion("qs =", value, "qs");
            return (Criteria) this;
        }

        public Criteria andQsNotEqualTo(String value) {
            addCriterion("qs <>", value, "qs");
            return (Criteria) this;
        }

        public Criteria andQsGreaterThan(String value) {
            addCriterion("qs >", value, "qs");
            return (Criteria) this;
        }

        public Criteria andQsGreaterThanOrEqualTo(String value) {
            addCriterion("qs >=", value, "qs");
            return (Criteria) this;
        }

        public Criteria andQsLessThan(String value) {
            addCriterion("qs <", value, "qs");
            return (Criteria) this;
        }

        public Criteria andQsLessThanOrEqualTo(String value) {
            addCriterion("qs <=", value, "qs");
            return (Criteria) this;
        }

        public Criteria andQsLike(String value) {
            addCriterion("qs like", value, "qs");
            return (Criteria) this;
        }

        public Criteria andQsNotLike(String value) {
            addCriterion("qs not like", value, "qs");
            return (Criteria) this;
        }

        public Criteria andQsIn(List<String> values) {
            addCriterion("qs in", values, "qs");
            return (Criteria) this;
        }

        public Criteria andQsNotIn(List<String> values) {
            addCriterion("qs not in", values, "qs");
            return (Criteria) this;
        }

        public Criteria andQsBetween(String value1, String value2) {
            addCriterion("qs between", value1, value2, "qs");
            return (Criteria) this;
        }

        public Criteria andQsNotBetween(String value1, String value2) {
            addCriterion("qs not between", value1, value2, "qs");
            return (Criteria) this;
        }

        public Criteria andBatchIsNull() {
            addCriterion("batch is null");
            return (Criteria) this;
        }

        public Criteria andBatchIsNotNull() {
            addCriterion("batch is not null");
            return (Criteria) this;
        }

        public Criteria andBatchEqualTo(String value) {
            addCriterion("batch =", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotEqualTo(String value) {
            addCriterion("batch <>", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThan(String value) {
            addCriterion("batch >", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThanOrEqualTo(String value) {
            addCriterion("batch >=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThan(String value) {
            addCriterion("batch <", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThanOrEqualTo(String value) {
            addCriterion("batch <=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLike(String value) {
            addCriterion("batch like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotLike(String value) {
            addCriterion("batch not like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchIn(List<String> values) {
            addCriterion("batch in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotIn(List<String> values) {
            addCriterion("batch not in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchBetween(String value1, String value2) {
            addCriterion("batch between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotBetween(String value1, String value2) {
            addCriterion("batch not between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andHonestCountIsNull() {
            addCriterion("honest_count is null");
            return (Criteria) this;
        }

        public Criteria andHonestCountIsNotNull() {
            addCriterion("honest_count is not null");
            return (Criteria) this;
        }

        public Criteria andHonestCountEqualTo(String value) {
            addCriterion("honest_count =", value, "honestCount");
            return (Criteria) this;
        }

        public Criteria andHonestCountNotEqualTo(String value) {
            addCriterion("honest_count <>", value, "honestCount");
            return (Criteria) this;
        }

        public Criteria andHonestCountGreaterThan(String value) {
            addCriterion("honest_count >", value, "honestCount");
            return (Criteria) this;
        }

        public Criteria andHonestCountGreaterThanOrEqualTo(String value) {
            addCriterion("honest_count >=", value, "honestCount");
            return (Criteria) this;
        }

        public Criteria andHonestCountLessThan(String value) {
            addCriterion("honest_count <", value, "honestCount");
            return (Criteria) this;
        }

        public Criteria andHonestCountLessThanOrEqualTo(String value) {
            addCriterion("honest_count <=", value, "honestCount");
            return (Criteria) this;
        }

        public Criteria andHonestCountLike(String value) {
            addCriterion("honest_count like", value, "honestCount");
            return (Criteria) this;
        }

        public Criteria andHonestCountNotLike(String value) {
            addCriterion("honest_count not like", value, "honestCount");
            return (Criteria) this;
        }

        public Criteria andHonestCountIn(List<String> values) {
            addCriterion("honest_count in", values, "honestCount");
            return (Criteria) this;
        }

        public Criteria andHonestCountNotIn(List<String> values) {
            addCriterion("honest_count not in", values, "honestCount");
            return (Criteria) this;
        }

        public Criteria andHonestCountBetween(String value1, String value2) {
            addCriterion("honest_count between", value1, value2, "honestCount");
            return (Criteria) this;
        }

        public Criteria andHonestCountNotBetween(String value1, String value2) {
            addCriterion("honest_count not between", value1, value2, "honestCount");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(String value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(String value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(String value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(String value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(String value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLike(String value) {
            addCriterion("shop_id like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotLike(String value) {
            addCriterion("shop_id not like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<String> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<String> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(String value1, String value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(String value1, String value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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