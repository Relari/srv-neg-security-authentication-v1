package com.pe.relari.security.service.impl;

import com.pe.relari.security.model.entity.UserEntity;
import com.pe.relari.security.model.api.UserRequest;
import com.pe.relari.security.repository.UserRepository;
import com.pe.relari.security.service.UserService;
import com.pe.relari.security.util.RoleCategory;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private PasswordEncoder encoder;

    @Override
    public void addUser(UserRequest userRequest) {

        UserEntity userEntity = UserEntity.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .username("user_dev")
                .password(encoder.encode(userRequest.getPassword()))
                .role(RoleCategory.ADMIN)
                .enabled(Boolean.TRUE)
                .build();

        repository.save(userEntity);
    }



    @Override
    public void validateUser(String userName) {
//        var data = encoder.matches()

        repository.findByUsername(userName)
                .ifPresent(userEntity -> {
                    if (!userEntity.getEnabled()) {
                        throw new RuntimeException("User inactive");
                    }
                });
    }

}

