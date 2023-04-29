package com.group.ewaste.service;

import com.group.ewaste.domain.Product;
import com.group.ewaste.domain.ProductExample;
import com.group.ewaste.mapper.ProductMapper;
import com.group.ewaste.mapper.ProductMapperImpl;
import com.group.ewaste.mapper.UnknownProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UnknownProductMapper unknownProductMapper;

    public double calculatePrice(String name, String storage, String condition, String repair) {
        String productName = name;
        double defaultPrice =productMapper.getPriceByName(productName);
        // calculate the price by storage
        if ("256G".equals(storage)) {
            defaultPrice *= 1.1;
        } else if ("128G".equals(storage)) {
            defaultPrice *= 1.0;
        } else if ("512G".equals(storage)) {
            defaultPrice *= 1.3;
        } else if ("1T".equals(storage)) {
            defaultPrice *= 1.5;
        }

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
        return defaultPrice;
    }

    public void insertNewProduct(String brand, String email){
        unknownProductMapper.insertUnknownDevice(brand,email);
    }
}
