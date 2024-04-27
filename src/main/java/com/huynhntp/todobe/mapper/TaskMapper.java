package com.huynhntp.todobe.mapper;

import com.huynhntp.todobe.dto.TaskDTO;
import com.huynhntp.todobe.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task toEntity(TaskDTO taskDTO);

    TaskDTO toDto(Task task);

}
