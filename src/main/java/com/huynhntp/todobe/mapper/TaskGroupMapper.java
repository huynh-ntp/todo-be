package com.huynhntp.todobe.mapper;

import com.huynhntp.todobe.dto.TaskGroupDTO;
import com.huynhntp.todobe.entity.TaskGroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskGroupMapper {

    TaskGroup toEntity(TaskGroupDTO taskGroupDTO);

    TaskGroupDTO toDto(TaskGroup taskGroup);

}
