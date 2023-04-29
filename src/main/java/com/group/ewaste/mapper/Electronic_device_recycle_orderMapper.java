package com.group.ewaste.mapper;

import com.group.ewaste.domain.Electronic_device_recycle_order;
import com.group.ewaste.domain.Electronic_device_recycle_orderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Electronic_device_recycle_orderMapper {
    long countByExample(Electronic_device_recycle_orderExample example);

    int deleteByExample(Electronic_device_recycle_orderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Electronic_device_recycle_order record);

    int insertSelective(Electronic_device_recycle_order record);

    List<Electronic_device_recycle_order> selectByExample(Electronic_device_recycle_orderExample example);

    Electronic_device_recycle_order selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Electronic_device_recycle_order record, @Param("example") Electronic_device_recycle_orderExample example);

    int updateByExample(@Param("record") Electronic_device_recycle_order record, @Param("example") Electronic_device_recycle_orderExample example);

    int updateByPrimaryKeySelective(Electronic_device_recycle_order record);

    int updateByPrimaryKey(Electronic_device_recycle_order record);
}