package com.huynhntp.todobe.service.impl;

import com.huynhntp.todobe.dto.TaskGroupDTO;
import com.huynhntp.todobe.entity.TaskGroup;
import com.huynhntp.todobe.mapper.TaskGroupMapper;
import com.huynhntp.todobe.repository.TaskGroupRepository;
import com.huynhntp.todobe.service.TaskGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class TaskGroupServiceImpl implements TaskGroupService {
    @Autowired
    private TaskGroupRepository taskGroupRepository;

    @Autowired
    private TaskGroupMapper taskGroupMapper;


    @Override
    public TaskGroupDTO createNew() {
        TaskGroup taskGroup = new TaskGroup();
        LocalDate now = LocalDate.now();
        taskGroup.setDate(now)
                .setDescription(String.format("Công việc ngày %s", DateTimeFormatter.ofPattern("dd-MM-yyyy").format(now)));
        return taskGroupMapper.toDto(taskGroupRepository.save(taskGroup));
    }
}
