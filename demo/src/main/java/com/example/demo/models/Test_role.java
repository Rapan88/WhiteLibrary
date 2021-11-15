package com.example.demo.models;

import org.springframework.security.core.GrantedAuthority;

public enum Test_role implements GrantedAuthority {
    Starter,Elementary,Intermediate,Advanced;

    @Override
    public String getAuthority() {
        return name();
    }
}
