package com.group.ewaste.mapper;

import com.group.ewaste.domain.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface UnknownProductMapper {
    @Insert("insert into unknow_device(brand,email)values(#{brand},#{email})")
    void insertUnknownDevice(@Param("brand") String brand, @Param("email") String password);
}
