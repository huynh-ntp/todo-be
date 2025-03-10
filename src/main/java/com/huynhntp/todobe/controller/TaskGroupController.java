package com.huynhntp.todobe.controller;

import com.huynhntp.todobe.service.TaskGroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/auth/taskGroup")
public class TaskGroupController {

    private TaskGroupService taskGroupService;

}
