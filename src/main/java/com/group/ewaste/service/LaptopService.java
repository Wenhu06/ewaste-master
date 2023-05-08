package com.group.ewaste.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group.ewaste.domain.LaptopData;
import com.group.ewaste.domain.PageInfo;
import com.group.ewaste.mapper.LaptopDataMapper;
import com.group.ewaste.mapper.UnknownProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private UnknownProductMapper unknownProductMapper;
    @Autowired
    private LaptopDataMapper laptopDataMapper;
    public double calculatePrice(String brand, String model, String processorName, double latestPrice,String graphic_card_gb, String condition,String repair) {
        double defaultPrice = latestPrice * 0.005;
//        defaultPrice =laptopProductMapper.getPriceByName(brand,model,processorName,graphic_card_gb);

        // calculate the price by detail of device
        if ("New and Unopened".equals(condition)) {
            // no change of now one
        } else if ("Almost New".equals(condition)) {
            defaultPrice *= 0.9;
        } else if ("Minor Bumps and Scratches".equals(condition)) {
            defaultPrice *= 0.8;
        } else if ("Slightly Bumped and Scratched".equals(condition)) {
            defaultPrice *= 0.7;
        } else if ("Obvious Bump and Scratches".equals(condition)) {
            defaultPrice *= 0.6;
        }

        // calculate the price by maintenance
        if ("No Maintenance".equals(repair)) {
        } else if ("With maintenance".equals(repair)) {
            defaultPrice *= 0.8;
        } else if ("No Third Party Maintenance".equals(repair)) {
            defaultPrice *= 0.9;
        }
        return Math.round(defaultPrice * 100.0) / 100.0;
    }

    public void insertNewProduct(String brand, String email){
        unknownProductMapper.insertUnknownDevice(brand,email);
    }

    public PageInfo selectPage(PageInfo pageInfo, LaptopData laptopData) {
        Page<LaptopData> page = new Page<>(pageInfo.getPage(), pageInfo.getLimit());
        QueryWrapper<LaptopData> queryWrapper = new QueryWrapper<>(laptopData);
        if (pageInfo.getSort_order() != null && !pageInfo.getSort_order().isEmpty()) {
            String[] sortArr = pageInfo.getSort_order().toArray(new String[0]);
            if (sortArr.length > 1) {
                if ("asc".equalsIgnoreCase(sortArr[1])) {
                    queryWrapper.orderByAsc(sortArr[0]);
                } else if ("desc".equalsIgnoreCase(sortArr[1])) {
                    queryWrapper.orderByDesc(sortArr[0]);
                }
            } else if (sortArr.length > 0) {
                queryWrapper.orderByAsc(sortArr[0]);
            }
        }
        IPage<LaptopData> iPage = laptopDataMapper.selectPage(page, queryWrapper);
        pageInfo.setRows(iPage.getRecords());
        pageInfo.setTotal(iPage.getTotal());
        return pageInfo;
    }
}
