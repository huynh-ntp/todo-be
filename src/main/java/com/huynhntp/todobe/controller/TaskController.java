package com.huynhntp.todobe.controller;

import com.huynhntp.todobe.dto.TaskDTO;
import com.huynhntp.todobe.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/task")
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody() TaskDTO taskDTO, HttpServletRequest request) throws Exception {
        TaskDTO response = taskService.create(taskDTO, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getTaskList(@RequestParam("date") String date, HttpServletRequest request) {
        List<TaskDTO> response = taskService.getListTask(date != null ? LocalDate.parse(date) : LocalDate.now(), request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam("id") String id, HttpServletRequest request) {
        TaskDTO response = taskService.delete(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam("id") String id, HttpServletRequest request) {
        TaskDTO response = taskService.update(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
