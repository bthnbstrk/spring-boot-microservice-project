package com.batuhan.controller;

import com.batuhan.entity.Auth;
import com.batuhan.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class AuthController {
    private final AuthService authService;

    /*
    @PostMapping
    public ResponseEntity<Auth> register(){}
    */
}
