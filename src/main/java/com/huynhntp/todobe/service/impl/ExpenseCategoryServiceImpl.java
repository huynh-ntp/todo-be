package com.huynhntp.todobe.service.impl;

import com.huynhntp.todobe.dto.ExpenseCategoryDTO;
import com.huynhntp.todobe.entity.ExpenseCategory;
import com.huynhntp.todobe.mapper.ExpenseCategoryMapper;
import com.huynhntp.todobe.repository.ExpenseCategoryRepository;
import com.huynhntp.todobe.service.ExpenseCategoryService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final ExpenseCategoryMapper expenseCategoryMapper;

    @Override
    public ExpenseCategoryDTO create(ExpenseCategoryDTO expenseCategoryDTO, HttpServletRequest request) {
        ExpenseCategory expenseCategory = expenseCategoryMapper.toEntity(expenseCategoryDTO);
        return expenseCategoryMapper.toDto(expenseCategoryRepository.save(expenseCategory));
    }

    @Override
    public List<ExpenseCategoryDTO> getAll(HttpServletRequest request) {
        return expenseCategoryRepository.findAll().stream()
                .filter(category -> !category.getIsDeleted())
                .map(expenseCategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseCategoryDTO getById(String id, HttpServletRequest request) {
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense category not found"));
        if (expenseCategory.getIsDeleted()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense category not found");
        }
        return expenseCategoryMapper.toDto(expenseCategory);
    }

    @Override
    public ExpenseCategoryDTO update(String id, ExpenseCategoryDTO expenseCategoryDTO, HttpServletRequest request) {
        ExpenseCategory existingCategory = expenseCategoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense category not found"));
        if (existingCategory.getIsDeleted()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense category not found");
        }

        existingCategory
                .setName(expenseCategoryDTO.getName())
                .setDescription(expenseCategoryDTO.getDescription());

        return expenseCategoryMapper.toDto(expenseCategoryRepository.save(existingCategory));
    }

    @Override
    public ExpenseCategoryDTO delete(String id, HttpServletRequest request) {
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense category not found"));
        if (expenseCategory.getIsDeleted()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense category not found");
        }

        expenseCategory.setIsDeleted(true);

        return expenseCategoryMapper.toDto(expenseCategoryRepository.save(expenseCategory));
    }
}