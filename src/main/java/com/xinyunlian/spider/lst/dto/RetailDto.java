package com.xinyunlian.spider.lst.dto;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-30 19:21
 **/

import lombok.Data;

import java.util.List;

/**
 *
 * "supplierMemberId": "b2b-1046572047",
 "promotionPrice": 0.0,
 "caigouCategoryIds": "78967,78969,79734,10072",
 "supplierCompanyName": "上海博酒汇电子商务有限公司",
 "retailDetailUrl": "https:\/\/8.1688.com\/item\/560872859026.html",
 "sellout": false,
 "amountOnSale": 200,
 "tryoutOffer": false,
 "lstBrandTags": "",
 "retailPriceString": "148",
 "basePrice": 12.33,
 "newSellUnit": "1箱12瓶",
 "promotionTags": [],
 "coBrandsOffer": false,
 "tagsList": [
 {
 "uitype": "normal",
 "tagName": "阿里发货"
 }
 ],
 "gmvValue": {
 "decimals": 0,
 "integer": 0
 },
 "baseUnit": "瓶",
 "retailPrice": 148.0
 *
 *
 *
 */
@Data
public class RetailDto {

    private String supplierCompanyName;

    private String retailPrice;

    private boolean sellout;

    private String amountOnSale;

    private String newSellUnit;

    private String baseUnit;

    private List<TagsListDto> tagsList;

    private String promotionPrice;



}
