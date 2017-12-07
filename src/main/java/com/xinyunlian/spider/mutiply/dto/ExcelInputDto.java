package com.xinyunlian.spider.mutiply.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelInputDto {
    /**
     * barcode
     */
    private String barcode;
    /**
     * 1=非烟  0=烟
     */
    private String isTobacco;

    /**
     * 售价
     */
    private String price;
}
