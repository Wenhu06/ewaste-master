package com.group.ewaste.controller;

import com.group.ewaste.domain.MailRequest;
import com.group.ewaste.service.DataService;
import com.group.ewaste.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Api("/data")
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;
    @Autowired
    private MailService mailService;

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", dataType = "file", name = "file", value = "", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "email", value = "", required = true)
    })
    @ApiOperation(value = "储存前端传过来的数据", notes = "需要上传文件和一个参数（参数名“email”，参数值为该用户的邮箱）")
    @RequestMapping("/upload")
    public void upload( @RequestParam MultipartFile file, @RequestParam String email) throws Exception {
        dataService.saveFile(file, email);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "MailRequest", name = "mailRequest", value = "", required = true)
    })
    @ApiOperation(value = "将用户储存的数据邮件发给他", notes = "参数分别为：“sendTo”：收件人，“subject”：邮件主题，“text”：文本内容", httpMethod = "POST")
    @PostMapping("/download")
    public void SendHtmlMessage(@RequestBody MailRequest mailRequest) { mailService.sendHtmlMail(mailRequest);}
}

