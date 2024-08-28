package com.pe.relari.security.service;

import com.pe.relari.security.model.api.AuthRequest;
import com.pe.relari.security.model.api.AuthResponse;
import com.pe.relari.security.model.api.ValidateResponse;

public interface AuthService {
    AuthResponse generateToken(AuthRequest authRequest);
    ValidateResponse validateToken(String token);
}
