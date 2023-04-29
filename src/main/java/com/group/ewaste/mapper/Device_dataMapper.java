package com.group.ewaste.mapper;

import com.group.ewaste.domain.Device_data;
import com.group.ewaste.domain.Device_dataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Device_dataMapper {
    long countByExample(Device_dataExample example);

    int deleteByExample(Device_dataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Device_data record);

    int insertSelective(Device_data record);

    List<Device_data> selectByExample(Device_dataExample example);

    Device_data selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Device_data record, @Param("example") Device_dataExample example);

    int updateByExample(@Param("record") Device_data record, @Param("example") Device_dataExample example);

    int updateByPrimaryKeySelective(Device_data record);

    int updateByPrimaryKey(Device_data record);
}