package com.example.model;


import org.springframework.security.core.GrantedAuthority;

public enum LibrosRole implements GrantedAuthority {
    ROLE_ADMIN, ROLE_CLIENT;

    public String getAuthority() {
        return name();
    }

}
