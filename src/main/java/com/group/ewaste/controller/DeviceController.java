package com.group.ewaste.controller;


import com.group.ewaste.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api("/device")
@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "Map<String, String>", name = "deviceInfo", value = "获取name，storage，condition，repair。name可选\"256G\"\"128G\"\"512G\"\"1T\"。condition可选\"New and Unopened\"\"Almost New\"\"Minor Bumps and Scratches\"\"Slightly Bumped and Scratched\"\"Obvious Bump and Scratches\"\"Deformed Body or Broken Screen\"。repair可选\"No Maintenance\"\"Battery Replacement Only\"\"Only the Screen has Repair\"\"Only the Motherboard has Repair\"\"Two or More Places with Maintenance\"\"No Third Party Maintenance\"  ", required = true)
    })
    @ApiOperation(value = "用户选择回收的设备情况", notes = "name storage condition repair等用户均以下拉框输入。", httpMethod = "POST")
    @RequestMapping(value = "/calculatePrice",method = RequestMethod.POST)
    public double calculatePrice(@RequestBody Map<String, String> deviceInfo) {
        String name = deviceInfo.get("name");
        String storage = deviceInfo.get("storage");
        String condition = deviceInfo.get("condition");
        String repair = deviceInfo.get("repair");

        double price = deviceService.calculatePrice(name, storage, condition, repair);
        return price;
    }
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "Map<String, String>", name = "BrandInfo", value = "获取未知的设备品牌和用户邮箱——brand,email", required = true)
    })
    @ApiOperation(value = "用户输入未知的设备", notes = "用户输入未知设备的brand 和用户的email", httpMethod = "POST")
    @PostMapping("/newBrand")
    public void insertNewBrand(@RequestBody Map<String, String> BrandInfo) {
        String brand = BrandInfo.get("brand");
        String email = BrandInfo.get("email");
        deviceService.insertNewProduct(brand, email);
    }
}
