package com.group.ewaste.controller;

import com.group.ewaste.domain.Test;
import com.group.ewaste.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private TestService testService;
//    @RequestMapping("/test")
//    public String test(){
//        return "Test";
//    }

    @RequestMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
}
