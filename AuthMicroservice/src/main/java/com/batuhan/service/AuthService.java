package com.batuhan.service;

import com.batuhan.dto.request.CreateUserRequestDto;
import com.batuhan.dto.request.LoginRequestDto;
import com.batuhan.dto.request.RegisterRequestDto;
import com.batuhan.entity.Auth;
import com.batuhan.manager.UserProfileManager;
import com.batuhan.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;

    public Auth register(RegisterRequestDto dto) {
        Auth auth = repository.save(
                Auth.builder()
                        .userName(dto.getUserName())
                        .email(dto.getEmail())
                        .password(dto.getPassword()).build());

        userProfileManager.createUser(CreateUserRequestDto
                .builder()
                .authId(auth.getId())
                .email(auth.getEmail())
                .username(auth.getUserName())
                .build());

        return auth;
    }

    public Boolean login(LoginRequestDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(), dto.getPassword());
    }
}
