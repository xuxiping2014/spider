package com.xinyunlian.spider.jd.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-31 11:55
 **/
@Data
public class RetDataLstDto {
    private String currentTime;
    private int pageCount;
    private int page;
    private int pageSize;
    private List<WareInfoDto> wareInfoList;
}
