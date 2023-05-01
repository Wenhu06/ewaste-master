package com.group.ewaste.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.ewaste.domain.File;
import com.group.ewaste.domain.User;
import com.group.ewaste.domain.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    UserBean getInfo(@Param("username") String username, @Param("password") String password);


    @Insert("insert into user(username,password,cellphone,email)values(#{username},#{password},#{cellphone},#{email})")
    void saveInfo(@Param("username") String username, @Param("password") String password, @Param("cellphone") String cellphone, @Param("email") String email);
}