package com.group.ewaste.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("laptop")
public class LaptopData {

    private String brand;
    private String model;
    private String processorBrand;
    private String processorName;
    private String processorGnrtn;
    private String ramGb;
    private String ramType;
    private String ssd;
    private String hdd;
    private String os;
    private String osBit;
    private String graphicCardGb;
    private String weight;
    private String displaySize;
    private String warranty;
    private String touchscreen;
    private String msoffice;
    private String latestPrice;
    private String oldPrice;
    private String discount;
    private String starRating;
    private String ratings;
    private String reviews;
}