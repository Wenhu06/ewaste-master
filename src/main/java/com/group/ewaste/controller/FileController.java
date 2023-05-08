package com.group.ewaste.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group.ewaste.domain.AjaxResult;
import com.group.ewaste.domain.PageInfo;
import com.group.ewaste.domain.File;
import com.group.ewaste.domain.User;
import com.group.ewaste.mapper.FileMapper;
import com.group.ewaste.mapper.FileMapper;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/file")
@RestController
public class FileController extends BaseController {
    @Autowired
    private FileMapper fileMapper;
    @ApiOperation(value = "文件查询")
    @GetMapping("/page")
    public AjaxResult page(PageInfo pageInfo,File file){
        Page page = setOrderPage(pageInfo);
        QueryWrapper queryWrapper = makeQueryMaps(file);
        if(file.getCreateBy()!=null){
            queryWrapper.eq("create_by",file.getCreateBy());
        }
        return AjaxResult.success(fileMapper.selectPage(page,queryWrapper));
    }
}
