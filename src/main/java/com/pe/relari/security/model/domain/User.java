package com.pe.relari.security.model.domain;

import com.pe.relari.security.util.RoleCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Integer id;
    private String name;
    private String username;
    private String password;
    private RoleCategory role;
    private String email;
    private Boolean enabled;

}
