package com.huynhntp.todobe.entity;

import com.huynhntp.todobe.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @Column(name = "id", nullable = false, length = 255)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "status", length = 255)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "task_group_id", length = 255)
    private String taskGroupId;
}
