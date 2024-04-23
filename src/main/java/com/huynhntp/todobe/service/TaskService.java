package com.huynhntp.todobe.service;

import com.huynhntp.todobe.dto.TaskDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface TaskService {
    TaskDTO create(TaskDTO taskDTO, HttpServletRequest request) throws Exception;
}
