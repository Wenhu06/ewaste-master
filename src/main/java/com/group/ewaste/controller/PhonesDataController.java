package com.group.ewaste.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group.ewaste.domain.AjaxResult;
import com.group.ewaste.domain.PageInfo;
import com.group.ewaste.domain.PhonesData;
import com.group.ewaste.mapper.PhonesDataMapper;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/phonesData")
@RestController
public class PhonesDataController extends BaseController {
    @Autowired
    private PhonesDataMapper phonesDataMapper;
    @ApiOperation(value = "设备分页查询")
    @GetMapping("/page")
    public AjaxResult page(PageInfo pageInfo,PhonesData phonesData){
        Page page = setOrderPage(pageInfo);
        QueryWrapper queryWrapper = makeQueryMaps(phonesData);
        return AjaxResult.success(phonesDataMapper.selectPage(page,queryWrapper));
    }
    @ApiOperation(value = "设备添加")
    @PostMapping("/add")
    public AjaxResult add( PhonesData phonesData) {
        int insert = phonesDataMapper.insert(phonesData);
        if(insert>0){
            return AjaxResult.success("添加成功");
        }
        return AjaxResult.error("添加失败");
    }
    @ApiOperation(value = "设备删除")
    @PostMapping("/delete")
    public AjaxResult delete(Long id, String ids) {
        if (id != null) phonesDataMapper.deleteById(id);
        if (StringUtils.isNotBlank(ids)) {
            List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
            if (listIds != null && !listIds.isEmpty()) {
                phonesDataMapper.deleteBatchIds(listIds);
            }
        }
        return AjaxResult.success("删除成功");
    }
    @ApiOperation(value = "设备编辑")
    @PostMapping("/update")
    public AjaxResult update( PhonesData phonesData) {
        int i = phonesDataMapper.updateById(phonesData);
        if(i>0){
            return  AjaxResult.success("修改成功");
        }
        return AjaxResult.error("修改失败");
    }
}
