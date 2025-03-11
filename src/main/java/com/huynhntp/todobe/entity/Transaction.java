package com.huynhntp.todobe.entity;

import com.huynhntp.todobe.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
@Accessors(chain = true)
public class Transaction extends BaseEntity implements Serializable {

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ExpenseCategory category;

    @Column(name = "account_id", length = 255)
    private String accountId;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
}