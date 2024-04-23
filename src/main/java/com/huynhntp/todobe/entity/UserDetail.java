package com.huynhntp.todobe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Entity
@Table(name = "user_detail")
@Data
@Accessors(chain = true)
public class UserDetail {

    @Id
    @Column(name = "id", nullable = false, length = 255)
    private String id;

    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "phone", length = 255)
    private String phone;

    @Column(name = "avatar_url", length = 255)
    private String avatarUrl;

}
