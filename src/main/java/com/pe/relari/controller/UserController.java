package com.pe.relari.controller;

import com.pe.relari.security.model.api.UserRequest;
import com.pe.relari.security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("${application.api.path}/users")
@AllArgsConstructor
public class UserController {

    private UserService service;

    @PostMapping
    public ResponseEntity<Void> addNewUser(
            @RequestBody @Valid UserRequest userRequest) {
        service.addUser(userRequest);
        return ResponseEntity.noContent().build();
    }

}