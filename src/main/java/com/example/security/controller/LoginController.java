package com.example.security.controller;


import com.example.security.model.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest) {
        Authentication authenticationReq =
                UsernamePasswordAuthenticationToken.authenticated(
                        loginRequest.username(), loginRequest.password(), null
                );
        Authentication authenticationRes =
                this.authenticationManager.authenticate(authenticationReq);

        return ResponseEntity.ok().build();
    }
}

