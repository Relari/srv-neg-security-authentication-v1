package com.pe.relari.security.service;

import com.pe.relari.security.model.api.UserRequest;

public interface UserService {

    void addUser(UserRequest userRequest);
    void validateUser(String username);
}
