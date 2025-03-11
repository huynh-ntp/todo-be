package com.huynhntp.todobe.mapper;

import com.huynhntp.todobe.dto.ExpenseCategoryDTO;
import com.huynhntp.todobe.entity.ExpenseCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseCategoryMapper {
    ExpenseCategoryDTO toDto(ExpenseCategory entity);
    ExpenseCategory toEntity(ExpenseCategoryDTO dto);
}