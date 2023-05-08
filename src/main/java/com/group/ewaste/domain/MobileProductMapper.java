package com.group.ewaste.domain;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileProductMapper {

    @Select("SELECT best_price FROM mobile_product WHERE brand_name = #{brand_name} AND model_name = #{model_name} AND memory_size = #{memory_size}")
    Double getPriceByName(@Param("brand_name") String brand_name, @Param("model_name") String model_name,  @Param("memory_size") String memory_size);
}