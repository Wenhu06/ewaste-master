package com.group.ewaste.service;

import com.group.ewaste.domain.Email;
import com.group.ewaste.domain.UserBean;
import com.group.ewaste.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GetEmailService {

    @Autowired
    private UserMapper userMapper;

    public Email getEmail(String username){
        return userMapper.getEmail(username);
    }

}
