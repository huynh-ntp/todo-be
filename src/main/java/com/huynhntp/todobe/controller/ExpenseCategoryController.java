package com.huynhntp.todobe.controller;

import com.huynhntp.todobe.dto.ExpenseCategoryDTO;
import com.huynhntp.todobe.service.ExpenseCategoryService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth/expense-category")
public class ExpenseCategoryController {

    private ExpenseCategoryService expenseCategoryService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ExpenseCategoryDTO expenseCategoryDTO, HttpServletRequest request) {
        ExpenseCategoryDTO response = expenseCategoryService.create(expenseCategoryDTO, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll(HttpServletRequest request) {
        List<ExpenseCategoryDTO> response = expenseCategoryService.getAll(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id, HttpServletRequest request) {
        ExpenseCategoryDTO response = expenseCategoryService.getById(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody ExpenseCategoryDTO expenseCategoryDTO, HttpServletRequest request) {
        ExpenseCategoryDTO response = expenseCategoryService.update(id, expenseCategoryDTO, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id, HttpServletRequest request) {
        ExpenseCategoryDTO response = expenseCategoryService.delete(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}