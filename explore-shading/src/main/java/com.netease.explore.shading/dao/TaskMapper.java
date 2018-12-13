package com.netease.explore.shading.dao;

import com.netease.explore.shading.domain.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper {
    int insert(@Param("task") Task task);

    int insertSelective(@Param("task") Task task);

    int insertList(@Param("tasks") List<Task> tasks);

    int updateByPrimaryKeySelective(@Param("task") Task task);

    Task findById(@Param("id")Long id);


}
