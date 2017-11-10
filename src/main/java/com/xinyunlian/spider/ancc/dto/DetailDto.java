package com.xinyunlian.spider.ancc.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class DetailDto {
    private Date FirmValidDate;

    private String ItemPackagingTypeCode;
    /**
     * 规格
     */
    private String ItemSpecification;

    private String ItemNetContent;

    /**
     * 公司注册日期
     */
    private Date FirmLoginDate;

    private ArrayOfKeyValueDto arrayOfKeyValue;

    private String productEx;

    /**
     * 图片路径
     */
    private List<ImageDto> Image;

    /**
     * 详细介绍地址
     */
    private String ItemDescription;


    private String alermCount;

    private String keepOnRecord;

    /**
     * 宽度
     */
    private String ItemWidth;

    /**
     * 品牌
     */
    private String BrandName;

    /**
     *
     */
    private String recallCount;

    /**
     * 高度
     */
    private String ItemHeight;

    /**
     * 重量
     */
    private String ItemGrossWeight;

    private String qualificationCount;

    /**
     * 公司状态
     */
    private String FirmStatus;

    private String ItemNetWeight;

    private String ItemPackagingMaterialCode;

    /**
     * 品名
     */
    private String ItemName;
    /**
     *
     */
    private String productFangWei;

    /**
     * 公司联系人
     */
    private String FirmContactMan;

    /**
     * 深度
     */
    private String ItemDepth;

    /**
     * 公司联系电话
     */
    private String FirmContactPhone;

    private String diffYearsMonthsDays;

    private List<Object> QS;

    /**
     * 分类编码
     */
    private String ItemClassCode;

    /**
     * 公司名
     */
    private String FirmName;

    /**
     * 公司地址
     */
    private String FirmAddress;

    private List<Object> cosmeticList;

    /**
     * 批次
     */
    private String batch;

    private Date FirmLogoutDate1;

    private String honestCount;

    /**
     * 条码
     */
    private String productCode;

    /**
     * 简短描述
     */
    private String ItemShortDescription;

    private Date FirmLogoutDate;

}
