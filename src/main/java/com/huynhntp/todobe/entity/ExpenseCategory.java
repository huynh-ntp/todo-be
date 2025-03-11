package com.huynhntp.todobe.entity;

import com.huynhntp.todobe.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Data
@Accessors(chain = true)
public class ExpenseCategory extends BaseEntity {

    private String name;
    private String description;
    private Boolean isDeleted = false;
}