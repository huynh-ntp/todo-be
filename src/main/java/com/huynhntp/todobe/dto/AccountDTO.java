package com.huynhntp.todobe.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class AccountDTO implements Serializable {
    private String id;
    private String username;
    private String password;
    private Boolean isActive;
    private String role;
}
