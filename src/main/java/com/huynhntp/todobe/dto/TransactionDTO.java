package com.huynhntp.todobe.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class TransactionDTO implements Serializable {
    private String id;
    private BigDecimal amount;
    private LocalDateTime date;
    private String description;
    private String categoryId;
    private String accountId;
    private Boolean isDeleted;
}