package com.pe.relari;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SecurityAuthenticationApplicationTest {

    @Test
    void generateKeys() {

        List<String> keys = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
            keys.add(Base64.getEncoder().encodeToString(key.getEncoded()));
        }
        System.out.println(keys);

        assertNotNull(keys);
    }

}