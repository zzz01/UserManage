package com.hust.manage.dao;

import com.hust.manage.model.RolePower;
import com.hust.manage.model.RolePowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePowerMapper {
    int countByExample(RolePowerExample example);

    int deleteByExample(RolePowerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePower record);

    int insertSelective(RolePower record);

    List<RolePower> selectByExample(RolePowerExample example);

    RolePower selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePower record, @Param("example") RolePowerExample example);

    int updateByExample(@Param("record") RolePower record, @Param("example") RolePowerExample example);

    int updateByPrimaryKeySelective(RolePower record);

    int updateByPrimaryKey(RolePower record);
}