package com.group.ewaste.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group.ewaste.domain.AjaxResult;
import com.group.ewaste.domain.PageInfo;
import com.group.ewaste.domain.User;
import com.group.ewaste.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/user")
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserMapper userMapper;
    @ApiOperation(value = "用户分页查询")
    @GetMapping("/page")
    public AjaxResult page(PageInfo pageInfo,User user){
        Page page = setOrderPage(pageInfo);
        QueryWrapper queryWrapper = makeQueryMaps(user);
        return AjaxResult.success(userMapper.selectPage(page,queryWrapper));
    }
    @ApiOperation(value = "用户添加")
    @PostMapping("/add")
    public AjaxResult add(User user) {
        if(userMapper.selectCount(new QueryWrapper<User>().eq("username",user.getUsername()))>0){
            return AjaxResult.error("用户名已存在");
        }
        int insert = userMapper.insert(user);
        if(insert>0){
            return AjaxResult.success("添加成功");
        }
        return AjaxResult.error("添加失败");
    }
    @ApiOperation(value = "用户删除")
    @PostMapping("/delete")
    public AjaxResult delete(Long id, String ids) {
        if (id != null) userMapper.deleteById(id);
        if (StringUtils.isNotBlank(ids)) {
            List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
            if (listIds != null && !listIds.isEmpty()) {
                userMapper.deleteBatchIds(listIds);
            }
        }
        return AjaxResult.success("删除成功");
    }
    @ApiOperation(value = "用户编辑")
    @PostMapping("/update")
    public AjaxResult update( User user) {
        int i = userMapper.updateById(user);
        if(i>0){
            return  AjaxResult.success("修改成功");
        }
        return AjaxResult.error("修改失败");
    }
    @ApiOperation(value = "用户修改密码")
    @PostMapping("/changePwd")
    public AjaxResult changePwd(User user) {
        User user1 = userMapper.selectOne(new QueryWrapper<User>().eq("username",user.getUsername()));
        if(!user1.getPassword().equals(user.getOldpassword())){
            return  AjaxResult.error("原始密码错误");
        }
        user1.setPassword(user.getPassword());
        return update(user1);
    }
}
