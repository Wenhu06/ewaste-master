package com.group.ewaste.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.ewaste.domain.AjaxResult;
import com.group.ewaste.domain.User;
import com.group.ewaste.domain.UserBean;
import com.group.ewaste.mapper.UserMapper;
import com.group.ewaste.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api
@Slf4j
@Controller
public class LoginController {

    @Resource
    UserService userService;
    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "", notes = "")
    @RequestMapping("/login")
    public String show(){
        return "page/login-2";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/page/{path}")
    public String page(@PathVariable("path")String path){
        if(path.contains(".html")){
            return "page/"+path.replace(".html","");
        }
        return "error";
    }
    @RequestMapping("/page/table/{path}")
    public String pageTable(@PathVariable("path")String path){
        if(path.contains(".html")){
            return "page/table/"+path.replace(".html","");
        }
        return "error";
    }
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "username", value = "", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "password", value = "", required = true)
    })
    @ApiOperation(value = "将用户名和密码与数据库里的值对比，验证是否正确", notes = "正确和不正确的返回值·分别为“success”和“error”", httpMethod = "POST")
    @RequestMapping(value = "/loginIn",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult login(String username, String password,@RequestParam(defaultValue = "1",required = false)String type){
        UserBean userBean = userService.LoginIn(username, password,type);
        log.info("username:{}",username);
        log.info("password:{}",password);
        if(userBean!=null){
            return AjaxResult.success("登录成功");
        }else {
            return AjaxResult.error("账号或密码错误");
        }
    }
    @ApiOperation(value = "", notes = "")
    @RequestMapping("/signup")
    public String disp(){
        return "signup";
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "username", value = "", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "password", value = "", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "cellphone", value = "", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "email", value = "", required = true)
    })
    @ApiOperation(value = "将用户提供的参数插入数据库", notes = "传数据前需要做简单的判断（用户名，密码不为空）", httpMethod = "POST")
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public AjaxResult signUp(@RequestBody User user){
        QueryWrapper<User> qw=new QueryWrapper<>();
        qw.eq("username",user.getUsername());
        if(userMapper.selectCount(qw)>0){
            return AjaxResult.error("用户名已存在");
        }
        if(userMapper.insert(user)>0){
            return AjaxResult.success("注册成功");
        }
        return AjaxResult.success("注册失败");
    }
}
