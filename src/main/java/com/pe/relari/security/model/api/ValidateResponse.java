package com.pe.relari.security.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidateResponse {

    private String dateExpiration;
    private Boolean isTokenExpired;

}