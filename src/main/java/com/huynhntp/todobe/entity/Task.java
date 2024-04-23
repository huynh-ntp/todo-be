package com.huynhntp.todobe.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "task")
@Accessors(chain = true)
@Data
public class Task {

    @Id
    @Column(name = "id", nullable = false, length = 255)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "status", length = 255)
    private String status;

    @Column(name = "task_group_id", length = 255)
    private String taskGroupId;

}
