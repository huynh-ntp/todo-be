package com.huynhntp.todobe.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class UserDetailDTO {
    private String id;
    private String username;
    private LocalDate dob;
    private String phone;
    private String avatarUrl;
}
