package com.huynhntp.todobe.service;

import com.huynhntp.todobe.dto.TaskDTO;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    TaskDTO create(TaskDTO taskDTO, HttpServletRequest request) throws Exception;

    List<TaskDTO> getListTask(LocalDate localDate, HttpServletRequest request);

    TaskDTO delete(String id, HttpServletRequest request);

    TaskDTO update(String id, HttpServletRequest request);
}
