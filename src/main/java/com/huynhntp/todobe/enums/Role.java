package com.huynhntp.todobe.enums;

import java.util.stream.Stream;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public static Role of(String role) {
        return Stream.of(Role.values())
                .filter(x -> x.getRole().equals(role))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
