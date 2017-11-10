package com.xinyunlian.spider.jd.dto;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-31 13:12
 **/
@Data
public class SeckillPromotionDto {

    private String title;

    private String description;

    private String adWords;

    private Date beginTime;

    private Date endTime;

    private String availableDesc;

    private String promotionPrice;

    private String totalNum;

    private String saleNum;

}
