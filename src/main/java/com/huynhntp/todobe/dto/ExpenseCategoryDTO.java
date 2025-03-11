package com.huynhntp.todobe.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ExpenseCategoryDTO {
    private String id;
    private String name;
    private String description;
    private Boolean isDeleted;
}