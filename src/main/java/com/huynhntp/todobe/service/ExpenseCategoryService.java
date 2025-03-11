package com.huynhntp.todobe.service;

import com.huynhntp.todobe.dto.ExpenseCategoryDTO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface ExpenseCategoryService {
    ExpenseCategoryDTO create(ExpenseCategoryDTO expenseCategoryDTO, HttpServletRequest request);
    
    List<ExpenseCategoryDTO> getAll(HttpServletRequest request);
    
    ExpenseCategoryDTO getById(String id, HttpServletRequest request);
    
    ExpenseCategoryDTO update(String id, ExpenseCategoryDTO expenseCategoryDTO, HttpServletRequest request);
    
    ExpenseCategoryDTO delete(String id, HttpServletRequest request);
}