package com.xinyunlian.spider.lst.dto;

import lombok.Data;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-30 19:16
 **/

@Data
public class RetDataDto {

    private String id;

    private TradeQuantityDto tradeQuantity;

    private RetailDto retailVO;

    private InformationDto information;
}
