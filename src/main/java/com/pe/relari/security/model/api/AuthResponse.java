package com.pe.relari.security.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String type;
    private String accessToken;
    private String dateCreated;
    private String dateExpiration;
    private Boolean isTokenExpired;

}