package com.group.ewaste.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group.ewaste.domain.AjaxResult;
import com.group.ewaste.domain.PageInfo;
import com.group.ewaste.domain.FeedBack;
import com.group.ewaste.mapper.FeedBackMapper;
import com.group.ewaste.mapper.FeedBackMapper;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/feedback")
@RestController
public class FeedBackController extends BaseController {
    @Autowired
    private FeedBackMapper feedbackMapper;
    @ApiOperation(value = "反馈分页查询")
    @GetMapping("/page")
    public AjaxResult page(PageInfo pageInfo,FeedBack feedBack){
        Page page = setOrderPage(pageInfo);
        QueryWrapper queryWrapper = makeQueryMaps(feedBack);
        return AjaxResult.success(feedbackMapper.selectPage(page,queryWrapper));
    }
    @ApiOperation(value = "反馈添加")
    @PostMapping("/add")
    public AjaxResult add( FeedBack feedBack) {
        feedBack.setCreateTime(new Date());
        int insert = feedbackMapper.insert(feedBack);
        if(insert>0){
            return AjaxResult.success("添加成功");
        }
        return AjaxResult.error("添加失败");
    }
    @ApiOperation(value = "反馈删除")
    @PostMapping("/delete")
    public AjaxResult delete(Long id, String ids) {
        if (id != null) feedbackMapper.deleteById(id);
        if (StringUtils.isNotBlank(ids)) {
            List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
            if (listIds != null && !listIds.isEmpty()) {
                feedbackMapper.deleteBatchIds(listIds);
            }
        }
        return AjaxResult.success("删除成功");
    }
    @ApiOperation(value = "反馈编辑")
    @PostMapping("/update")
    public AjaxResult update( FeedBack feedBack) {
        int i = feedbackMapper.updateById(feedBack);
        if(i>0){
            return  AjaxResult.success("修改成功");
        }
        return AjaxResult.error("修改失败");
    }
}
