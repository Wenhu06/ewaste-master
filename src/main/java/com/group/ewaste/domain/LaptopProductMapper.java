package com.group.ewaste.domain;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopProductMapper {
    @Select("SELECT latest_price FROM laptop WHERE brand = #{brand} AND model = #{model} AND processor_name = #{processor_name} AND graphic_card_gb = #{graphic_card_gb}")
    double getPriceByName(@Param("brand") String brand, @Param("model") String model, @Param("processor_name") String processorName,
                          @Param("graphic_card_gb") String graphic_card_gb);
}
