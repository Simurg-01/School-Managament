package com.schoolmanagement.domain.enums;

public enum UserRole {
    ROLE_ADMIN("admin"),
    ROLE_TEACHER("teacher"),
    ROLE_STUDENT("student"),
    ROLE_DEAN("dean");

    //bu sekilde kullanim degisken icindeki aciklamlari degistirme imkani sunar
    private final String name;

    UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}