package com.group.ewaste.service;

import com.group.ewaste.domain.UserBean;
import com.group.ewaste.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public UserBean LoginIn(String username, String password) {
        return userMapper.getInfo(username,password);
    }

    public void Insert(String username,String password,String cellphone,String email){
        userMapper.saveInfo(username, password, cellphone, email);
    }
}