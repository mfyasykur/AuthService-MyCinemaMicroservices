package edu.binar.challenge.MyCinemaMicroservices.AuthService.service;

import edu.binar.challenge.MyCinemaMicroservices.AuthService.entity.AuthRequest;
import edu.binar.challenge.MyCinemaMicroservices.AuthService.entity.AuthResponse;
import edu.binar.challenge.MyCinemaMicroservices.AuthService.entity.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private final RestTemplate restTemplate;

    private final JwtUtil jwt;

    @Autowired
    public AuthService(RestTemplate restTemplate, JwtUtil jwt) {
        this.restTemplate = restTemplate;
        this.jwt = jwt;
    }

    public AuthResponse register(AuthRequest authRequest) {

        authRequest.setPassword(BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt()));

        UserDto userDto = restTemplate.postForObject("http://user-service/users", authRequest, UserDto.class);
        Assert.notNull(userDto, "Failed to register user. Please try again later");

        String accessToken = jwt.generate(userDto, "ACCESS");
        String refreshToken = jwt.generate(userDto, "REFRESH");

        return new AuthResponse(accessToken, refreshToken);
    }
}
