package com.huynhntp.todobe.entity;

import com.huynhntp.todobe.entity.base.BaseEntity;
import com.huynhntp.todobe.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity
@Accessors(chain = true)
@Table(name = "account")
@Data
public class Account extends BaseEntity implements Serializable {

    @Column(name = "username", unique = true, length = 255)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "role", length = 255)
    @Enumerated(EnumType.STRING)
    private Role role;

}
