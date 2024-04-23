package com.huynhntp.todobe.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class TaskGroupDTO {
    private String id;
    private String description;
    private LocalDate date;
    private String accountId;
}
