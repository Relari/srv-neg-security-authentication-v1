package com.pe.relari.controller;

import com.pe.relari.security.model.api.UserRequest;
import com.pe.relari.security.model.api.UserResponse;
import com.pe.relari.security.service.JwtService;
import com.pe.relari.security.service.UserService;
import com.pe.relari.security.util.Utility;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("${application.api.path}/users")
@AllArgsConstructor
public class UserController {

    private UserService service;
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity<Void> addNewUser(
            @RequestBody @Valid UserRequest userRequest) {
        service.addUser(userRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}/validate")
    public ResponseEntity<UserResponse> extractUser(
            @RequestHeader(name = "Authorization") String token) {

        String value = Utility.getTokenFromHeader(token);

        if (value == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.ok(
                new UserResponse(
                        jwtService.extractUsername(value)
                )
        );
    }

}