package com.huynhntp.todobe.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@Accessors(chain = true)
public class TaskDTO implements Serializable {
    private String id;
    private String description;
    private String status;
    private String taskGroupId;
}
