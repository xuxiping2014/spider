package com.xinyunlian.spider.lst.dto;

import lombok.Data;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-30 20:38
 **/
@Data
public class LstExcelRetEntity {
    /**
     * 商品编号
     */
    private String id;
    /**
     * 品名
     */
    private String name;
    /**
     * 库存
     */
    private String stock;
    /**
     * 价格
     */
    private String price;
    /**
     * 销售规格
     */
    private String saleUnit;
    /**
     * 销售单位
     */
    private String unit;
    /**
     * 基础单位
     */
    private String baseUnit;
    /**
     * 最小起订量
     */
    private String minSaleNum;
    /**
     *  备注属性
     */
    private String tag;
    /**
     * 促销
     */
    private String promotion;
    /**
     * 促销价格
     */
    private String promotionPrice;
    /**
     * 成交金额
     */
    private String dealMoney;
    /**
     * 售罄
     */
    private String sellOut;
}
