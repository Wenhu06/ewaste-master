package com.group.ewaste.controller;

import com.group.ewaste.domain.MailRequest;
import com.group.ewaste.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api("/mail")
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "MailRequest", name = "mailRequest", value = "", required = true)
    })
    @ApiOperation(value = "根据请求参数给目标用户发邮件", notes = "参数分别为：“sendTo”：收件人，“subject”：邮件主题，“text”：文本内容", httpMethod = "POST")
    @PostMapping("/simple")
    public void SendSimpleMessage(@RequestBody MailRequest mailRequest) {
        mailService.sendSimpleMail(mailRequest);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "MailRequest", name = "mailRequest", value = "", required = true)
    })
    @ApiOperation(value = "根据请求参数给目标用户发邮件", notes = "参数分别为：“sendTo”：收件人，“subject”：邮件主题，“text”：文本内容", httpMethod = "POST")
    @PostMapping("/html")
    public void SendHtmlMessage(@RequestBody MailRequest mailRequest) { mailService.sendHtmlMailVoucher(mailRequest);}

}



