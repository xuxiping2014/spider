package com.xinyunlian.spider.jd.dto;

import lombok.Data;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-31 11:56
 **/
@Data
public class WareInfoDto {
    private String name;
    private String skuId;
    private String imageUrl;
    private String jdPrice;
    private String marketPrice;
    private String saleUnit;
    private List<LabelInfoDto> labelList;
    private boolean isCanBook;
    private String lowPurchaseCount;
    private String packageSize;
    private SeckillPromotionDto seckillPromotion;
    private String price;
    private String available;
    private boolean gifts;
    private boolean fullGifts;
    private boolean isSuit;

}
