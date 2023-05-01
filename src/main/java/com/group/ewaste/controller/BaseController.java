package com.group.ewaste.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group.ewaste.domain.PageInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseController {
    public static QueryWrapper makeQueryMaps(Object vo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        Map<String,Object> map = objectToMap(vo);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String fieldName = humpToLine(entry.getKey());
            Object paramVal = entry.getValue();
            queryWrapper.like(paramVal != null && StringUtils.isNotBlank(String.valueOf(paramVal)),fieldName,paramVal);
        }
        return queryWrapper;
    }
    public static Page setOrderPage(PageInfo pageInfo){
        if(pageInfo.getPage() == null){
            pageInfo.setPage(1L);
        }
        if(pageInfo.getLimit() == null){
            pageInfo.setLimit(10L);
        }
        Page page = new Page();
//        page.setOrders(orders);
        page.setSize(pageInfo.getLimit());
        page.setCurrent(pageInfo.getPage());
        return page;
    }
    public static Map<String,Object> objectToMap(Object json) {
        Map<String,Object> map = JSONObject.parseObject(JSON.toJSONString(json));
        return map;
    }
    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}