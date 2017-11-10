package com.xinyunlian.spider.lst.dto;

import lombok.Data;

import java.util.HashMap;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-30 19:36
 **/
@Data
public class TradeQuantityDto {
    private String quantityBegin;

    private String unit;

    private String sellUnit;

    private HashMap<String,String> gmvValue;
}
