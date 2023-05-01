package com.group.ewaste.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("phones_data")
public class PhonesData {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String brandName;
    private String modelName;
    private String os;
    private String popularity;
    private String bestPrice;
    private String lowestPrice;
    private String highestPrice;
    private String sellersAmount;
    private String screenSize;
    private String memorySize;
    private String batterySize;
    private String releaseDate;
}
