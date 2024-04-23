package com.huynhntp.todobe.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AccountDTO {
    private String id;
    private String username;
    private String password;
    private Boolean isActive;
    private String role;
}
