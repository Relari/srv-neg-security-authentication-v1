package com.pe.relari.security.service.impl;

import com.pe.relari.security.model.api.AuthRequest;
import com.pe.relari.security.model.api.AuthResponse;
import com.pe.relari.security.model.api.ValidateResponse;
import com.pe.relari.security.service.JwtService;
import com.pe.relari.security.service.AuthService;
import com.pe.relari.security.util.Utility;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Override
    public AuthResponse generateToken(AuthRequest authRequest) {

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword())
        );

        if (authenticate.isAuthenticated()) {
            String token = jwtService.generateToken(authRequest.getUsername());
            return AuthResponse.builder()
                    .accessToken(token)
                    .type(Utility.TYPE_AUTHENTICATION)
                    .dateCreated(Utility.formatDate(new Date()))
                    .dateExpiration(Utility.formatDate(jwtService.extractExpiration(token)))
                    .isTokenExpired(jwtService.isTokenExpired(token))
                    .build();
        }

        return null;
    }

    @Override
    public ValidateResponse validateToken(String token) {
        var data = jwtService.validateToken(token);
        return new ValidateResponse(
                data.getBody().getSubject(),
                Utility.formatDate(data.getBody().getExpiration()),
                Utility.validateDateExpiration(data.getBody().getExpiration())
        );
    }

}
