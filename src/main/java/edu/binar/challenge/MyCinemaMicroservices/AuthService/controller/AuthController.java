package edu.binar.challenge.MyCinemaMicroservices.AuthService.controller;

import edu.binar.challenge.MyCinemaMicroservices.AuthService.entity.AuthRequest;
import edu.binar.challenge.MyCinemaMicroservices.AuthService.entity.AuthResponse;
import edu.binar.challenge.MyCinemaMicroservices.AuthService.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/mycinema-v1/auth")
public class AuthController {

    @Autowired
    private final AuthService authService;

    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest authRequest) {

        return ResponseEntity.ok(authService.register(authRequest));
    }
}
