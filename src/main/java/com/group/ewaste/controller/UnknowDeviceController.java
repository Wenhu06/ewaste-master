package com.group.ewaste.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group.ewaste.domain.AjaxResult;
import com.group.ewaste.domain.PageInfo;
import com.group.ewaste.domain.UnknownDevice;
import com.group.ewaste.mapper.UnknowDeviceMapper;
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

@RequestMapping("/unknownDevice")
@RestController
public class UnknowDeviceController extends BaseController {
    @Autowired
    private UnknowDeviceMapper unknowDeviceMapper;
    @ApiOperation(value = "unknowDevice分页查询")
    @GetMapping("/page")
    public AjaxResult page(PageInfo pageInfo,UnknownDevice unknownDevice){
        Page page = setOrderPage(pageInfo);
        QueryWrapper queryWrapper = makeQueryMaps(unknownDevice);
        return AjaxResult.success(unknowDeviceMapper.selectPage(page,queryWrapper));
    }
    @ApiOperation(value = "unknowDevice添加")
    @PostMapping("/add")
    public AjaxResult add(UnknownDevice unknownDevice) {
        if(unknowDeviceMapper.selectCount(new QueryWrapper<UnknownDevice>().eq("brand",unknownDevice.getBrand()))>0){
            return AjaxResult.error("unknowDevice名已存在");
        }
        int insert = unknowDeviceMapper.insert(unknownDevice);
        if(insert>0){
            return AjaxResult.success("添加成功");
        }
        return AjaxResult.error("添加失败");
    }
    @ApiOperation(value = "unknowDevice删除")
    @PostMapping("/delete")
    public AjaxResult delete(Long id, String ids) {
        if (id != null) unknowDeviceMapper.deleteById(id);
        if (StringUtils.isNotBlank(ids)) {
            List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
            if (listIds != null && !listIds.isEmpty()) {
                unknowDeviceMapper.deleteBatchIds(listIds);
            }
        }
        return AjaxResult.success("删除成功");
    }
    @ApiOperation(value = "unknowDevice编辑")
    @PostMapping("/update")
    public AjaxResult update( UnknownDevice unknownDevice) {
        int i = unknowDeviceMapper.updateById(unknownDevice);
        if(i>0){
            return  AjaxResult.success("修改成功");
        }
        return AjaxResult.error("修改失败");
    }
}
