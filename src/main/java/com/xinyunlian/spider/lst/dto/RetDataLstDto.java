package com.xinyunlian.spider.lst.dto;

import lombok.Data;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-30 19:14
 **/
@Data
public class RetDataLstDto {
    private int pageCount;

    private int totalCount;

    private List<RetDataDto> offerList;
}
