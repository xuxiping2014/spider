package com.xinyunlian.spider.ancc.inter;

import com.xinyunlian.spider.ancc.model.GoodsModel;
import com.xinyunlian.spider.ancc.model.GoodsModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsModelMapper {
    int countByExample(GoodsModelExample example);

    int deleteByExample(GoodsModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsModel record);

    int insertSelective(GoodsModel record);

    List<GoodsModel> selectByExample(GoodsModelExample example);

    GoodsModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsModel record, @Param("example") GoodsModelExample example);

    int updateByExample(@Param("record") GoodsModel record, @Param("example") GoodsModelExample example);

    int updateByPrimaryKeySelective(GoodsModel record);

    int updateByPrimaryKey(GoodsModel record);
}