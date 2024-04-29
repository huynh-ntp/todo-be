package com.huynhntp.todobe.service.impl;

import com.huynhntp.todobe.dto.TaskDTO;
import com.huynhntp.todobe.dto.TaskGroupDTO;
import com.huynhntp.todobe.entity.Task;
import com.huynhntp.todobe.entity.TaskGroup;
import com.huynhntp.todobe.enums.TaskStatus;
import com.huynhntp.todobe.mapper.TaskMapper;
import com.huynhntp.todobe.repository.TaskGroupRepository;
import com.huynhntp.todobe.repository.TaskRepository;
import com.huynhntp.todobe.service.TaskGroupService;
import com.huynhntp.todobe.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    //Repositories
    private TaskRepository taskRepository;
    private TaskGroupRepository taskGroupRepository;

    //Mappers
    private TaskMapper taskMapper;

    //Services
    private TaskGroupService taskGroupService;


    @Override
    public TaskDTO create(TaskDTO taskDTO, HttpServletRequest request) throws Exception {
        TaskGroup taskGroup = taskGroupRepository.findByDate(LocalDate.now());
        String taskGroupId;
        if (taskGroup == null) {
            TaskGroupDTO taskGroupDTO = taskGroupService.createNew();
            taskGroupId = taskGroupDTO.getId();
        } else {
            taskGroupId = taskGroup.getId();
        }
        Task task = taskMapper.toEntity(taskDTO)
                .setTaskGroupId(taskGroupId)
                .setStatus(TaskStatus.NEW);
        return taskMapper.toDto(taskRepository.save(task));
    }

    @Override
    public List<TaskDTO> getListTask(LocalDate localDate, HttpServletRequest request) {
        TaskGroup taskGroup = taskGroupRepository.findByDate(localDate);
        if (taskGroup == null) {
            taskGroupService.createNew();
            return new ArrayList<>();
        }
        return taskRepository.findByTaskGroupId(taskGroup.getId())
                .stream().map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO delete(String id, HttpServletRequest request) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found entity");
        }
        taskRepository.delete(task);
        return taskMapper.toDto(task.setStatus(TaskStatus.REMOVED));
    }

    @Override
    public TaskDTO update(String id, HttpServletRequest request) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found entity");
        }
        task.setStatus(TaskStatus.FINISHED);
        return taskMapper.toDto(taskRepository.save(task));
    }
}
