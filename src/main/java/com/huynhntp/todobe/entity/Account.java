package com.huynhntp.todobe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Accessors(chain = true)
@Table(name = "account")
@Data
public class Account {

    @Id
    @Column(name = "id", nullable = false, length = 255)
    private String id;

    @Column(name = "username", unique = true, length = 255)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "isactive")
    private Boolean isActive;

    @Column(name = "role", length = 255)
    private String role;

}
