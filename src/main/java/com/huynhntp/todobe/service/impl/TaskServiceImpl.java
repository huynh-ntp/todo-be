package com.huynhntp.todobe.service.impl;

import com.huynhntp.todobe.dto.TaskDTO;
import com.huynhntp.todobe.entity.Task;
import com.huynhntp.todobe.entity.TaskGroup;
import com.huynhntp.todobe.mapper.TaskMapper;
import com.huynhntp.todobe.repository.TaskGroupRepository;
import com.huynhntp.todobe.repository.TaskRepository;
import com.huynhntp.todobe.service.TaskGroupService;
import com.huynhntp.todobe.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    //Repositories
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskGroupRepository taskGroupRepository;

    //Mappers
    @Autowired
    private TaskMapper taskMapper;

    //Services
    @Autowired
    private TaskGroupService taskGroupService;


    @Override
    public TaskDTO create(TaskDTO taskDTO, HttpServletRequest request) throws Exception {
        TaskGroup taskGroup = taskGroupRepository.findById(taskDTO.getTaskGroupId()).orElse(null);
        if (taskGroup == null) {
            throw new Exception();
        }
        Task task = taskMapper.toEntity(taskDTO);
        return taskMapper.toDto(taskRepository.save(task));
    }
}
