package com.huynhntp.todobe.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class TaskDTO {
    private String id;
    private String description;
    private String status;
    private String taskGroupId;
}
