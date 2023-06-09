package com.group.ewaste.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group.ewaste.domain.AjaxResult;
import com.group.ewaste.domain.PageInfo;
import com.group.ewaste.domain.PhonesData;
import com.group.ewaste.mapper.PhonesDataMapper;
import com.group.ewaste.mapper.UnknownProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    @Autowired
    private UnknownProductMapper unknownProductMapper;
    @Autowired
    private PhonesDataMapper phonesDataMapper;

    public double calculatePrice(String model_name, double best_price, String condition, String repair,String memory_size) {
        double defaultPrice = best_price*0.11;
//      defaultPrice =mobileMapper.getPriceByName(model_name,memory_size);
//      calculate the price by detail of device
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
        } else if ("Deformed Body or Broken Screen".equals(condition)) {
            defaultPrice *= 0.5;
        }

        // calculate the price by maintenance
        if ("No Maintenance".equals(repair)) {
        } else if ("Battery Replacement Only".equals(repair)) {
            defaultPrice *= 0.9;
        } else if ("Only the Screen has Repair".equals(repair)) {
            defaultPrice *= 0.8;
        } else if ("Only the Motherboard has Repair".equals(repair)) {
            defaultPrice *= 0.7;
        } else if ("Two or More Places with Maintenance".equals(repair)) {
            defaultPrice *= 0.6;
        } else if ("No Third Party Maintenance".equals(repair)) {
            defaultPrice *= 0.9;
        }
        return Math.round(defaultPrice * 100.0) / 100.0;
    }

    public void insertNewProduct(String brand, String email){
        unknownProductMapper.insertUnknownDevice(brand,email);
    }

    public PageInfo selectPage(PageInfo pageInfo, PhonesData phonesData) {
        Page<PhonesData> page = new Page<>(pageInfo.getPage(), pageInfo.getLimit());
        QueryWrapper<PhonesData> queryWrapper = new QueryWrapper<>(phonesData);
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
        IPage<PhonesData> iPage = phonesDataMapper.selectPage(page, queryWrapper);
        pageInfo.setRows(iPage.getRecords());
        pageInfo.setTotal(iPage.getTotal());
        return pageInfo;
    }

}
