package com.huynhntp.todobe.controller;

import com.huynhntp.todobe.dto.TaskDTO;
import com.huynhntp.todobe.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ap1/v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody() TaskDTO taskDTO, HttpServletRequest request) throws Exception {
        TaskDTO response = taskService.create(taskDTO, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
