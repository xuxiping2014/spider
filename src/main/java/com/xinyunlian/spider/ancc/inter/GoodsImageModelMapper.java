package com.xinyunlian.spider.ancc.inter;

import com.xinyunlian.spider.ancc.model.GoodsImageModel;
import com.xinyunlian.spider.ancc.model.GoodsImageModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsImageModelMapper {
    int countByExample(GoodsImageModelExample example);

    int deleteByExample(GoodsImageModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsImageModel record);

    int insertSelective(GoodsImageModel record);

    List<GoodsImageModel> selectByExample(GoodsImageModelExample example);

    GoodsImageModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsImageModel record, @Param("example") GoodsImageModelExample example);

    int updateByExample(@Param("record") GoodsImageModel record, @Param("example") GoodsImageModelExample example);

    int updateByPrimaryKeySelective(GoodsImageModel record);

    int updateByPrimaryKey(GoodsImageModel record);
}