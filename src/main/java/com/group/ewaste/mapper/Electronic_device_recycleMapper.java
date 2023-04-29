package com.group.ewaste.mapper;

import com.group.ewaste.domain.Electronic_device_recycle;
import com.group.ewaste.domain.Electronic_device_recycleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Electronic_device_recycleMapper {
    long countByExample(Electronic_device_recycleExample example);

    int deleteByExample(Electronic_device_recycleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Electronic_device_recycle record);

    int insertSelective(Electronic_device_recycle record);

    List<Electronic_device_recycle> selectByExample(Electronic_device_recycleExample example);

    Electronic_device_recycle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Electronic_device_recycle record, @Param("example") Electronic_device_recycleExample example);

    int updateByExample(@Param("record") Electronic_device_recycle record, @Param("example") Electronic_device_recycleExample example);

    int updateByPrimaryKeySelective(Electronic_device_recycle record);

    int updateByPrimaryKey(Electronic_device_recycle record);
}