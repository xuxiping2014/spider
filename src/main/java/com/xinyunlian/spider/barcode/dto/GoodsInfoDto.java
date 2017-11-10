package com.xinyunlian.spider.barcode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInfoDto {

    /**
     * barcode
     */
    private String barcode;

    /**
     * 品名
     */
    private String name;

    /**
     * 规格
     */
    private String spec;


    /**
     * 1=非烟  0=烟
     */
    private String isTobacco;

    /**
     * 售价
     */
    private String price;

    /**
     * 商标
     */
    private String brand;
    /**
     * 厂家
     */
    private String factory;

    /**
     * 异常信息
     */
    private String error;
    /**
     * 异常编码
     */
    private String errorCode;

}
