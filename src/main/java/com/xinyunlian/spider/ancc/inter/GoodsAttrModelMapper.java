package com.xinyunlian.spider.ancc.inter;

import com.xinyunlian.spider.ancc.model.GoodsAttrModel;
import com.xinyunlian.spider.ancc.model.GoodsAttrModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsAttrModelMapper {
    int countByExample(GoodsAttrModelExample example);

    int deleteByExample(GoodsAttrModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsAttrModel record);

    int insertSelective(GoodsAttrModel record);

    List<GoodsAttrModel> selectByExample(GoodsAttrModelExample example);

    GoodsAttrModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsAttrModel record, @Param("example") GoodsAttrModelExample example);

    int updateByExample(@Param("record") GoodsAttrModel record, @Param("example") GoodsAttrModelExample example);

    int updateByPrimaryKeySelective(GoodsAttrModel record);

    int updateByPrimaryKey(GoodsAttrModel record);
}