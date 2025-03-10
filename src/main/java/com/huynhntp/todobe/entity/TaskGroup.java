package com.huynhntp.todobe.entity;

import com.huynhntp.todobe.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "task_group")
@Accessors(chain = true)
@Data
public class TaskGroup extends BaseEntity implements Serializable {

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "account_id", length = 255)
    private String accountId;

}
