package com.xinyunlian.spider.jd.dto;

import lombok.Data;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-31 12:29
 **/
@Data
public class JdExcelRetEntity {
    /**
     * sku
     */
    private String skuId;
    /**
     * 品名
     */
    private String name;
    /**
     * 市场售价
     */
    private String price;
    /**
     * 京东售价
     */
    private String jdPrice;
    /**
     * 建议零售价
     */
    private String marketPrice;


    /**
     * 起售数量
     */
    private String lowPurchaseCount;
    /**
     * 销售规格
     */
    private String saleUnit;
    /**
     * 箱规
     */
    private String packageSize;
    /**
     * 备注
     */
    private String labelInfo;
    /**
     * 可售数量
     */
    //private String available;

    /**
     * 已售数目
     */
    //private String sales;

    /**
     * 是否有赠品
     */
    private String gifts;
    /**
     * 是否满赠
     */
    private String fullGifts;
    /**
     * 优惠套装
     */
    private String isSuit;

    /**
     * 促销
     */
    private String promotion;

    /**
     * 促销时间
     */
    private String promotionDate;
    /**
     * 促销信息
     */
    private String promotionDes;

    /**
     * 促销状态
     */
    private String promotionStatus;
    /**
     * 已售总数/促销总数
     */
    private String promotionNum;
    /**
     * 图片地址
     */
    private String imageUrl;




}
