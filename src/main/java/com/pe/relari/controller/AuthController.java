package com.pe.relari.controller;

import com.pe.relari.security.model.api.AuthRequest;
import com.pe.relari.security.model.api.AuthResponse;
import com.pe.relari.security.model.api.TokenRequest;
import com.pe.relari.security.model.api.ValidateResponse;
import com.pe.relari.security.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping("/generate")
    public ResponseEntity<AuthResponse> generate(
            @RequestBody @Valid AuthRequest authRequest) {
        return ResponseEntity.ok(authService.generateToken(authRequest));
    }

    @PostMapping("/validate")
    public ResponseEntity<ValidateResponse> validate(
            @RequestBody @Valid TokenRequest request) {
        return ResponseEntity.ok(authService.validateToken(request.getToken()));
    }

}
