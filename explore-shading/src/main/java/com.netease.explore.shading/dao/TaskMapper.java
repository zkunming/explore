package com.netease.explore.shading.dao;

import com.netease.explore.shading.domain.Task;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskMapper {
    int insert(@Param("task") Task task);

    int insertSelective(@Param("task") Task task);

    int insertList(@Param("tasks") List<Task> tasks);

    int updateByPrimaryKeySelective(@Param("task") Task task);

    Task findById(@Param("id")Long id);
}

