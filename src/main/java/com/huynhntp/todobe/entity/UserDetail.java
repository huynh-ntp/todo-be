package com.huynhntp.todobe.entity;

import com.huynhntp.todobe.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "user_detail")
@Data
@Accessors(chain = true)
public class UserDetail extends BaseEntity implements Serializable {

    @Column(name = "account_id", length = 255)
    private String accountId;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "phone", length = 255)
    private String phone;

    @Column(name = "avatar_url", length = 255)
    private String avatarUrl;

}
