package com.batuhan.controller;

import com.batuhan.dto.request.LoginRequestDto;
import com.batuhan.dto.request.RegisterRequestDto;
import com.batuhan.entity.Auth;
import com.batuhan.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.batuhan.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthService authService;


    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto dto){
        if(!dto.getRepassword().equals(dto.getRepassword()))
            throw new RuntimeException("Mismatched passwords");

        return ResponseEntity.ok(authService.register(dto));
    }


    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(authService.login(dto));
    }

}
