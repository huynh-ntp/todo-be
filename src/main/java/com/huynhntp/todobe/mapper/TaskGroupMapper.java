package com.huynhntp.todobe.mapper;

import com.huynhntp.todobe.dto.TaskGroupDTO;
import com.huynhntp.todobe.entity.TaskGroup;
import org.mapstruct.Mapper;

@Mapper
public interface TaskGroupMapper {

    TaskGroup toEntity(TaskGroupDTO taskGroupDTO);

    TaskGroupDTO toDto(TaskGroup taskGroup);

}
