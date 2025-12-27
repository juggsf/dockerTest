package com.example.dockerdemo.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final String DEMO_TOKEN = "demo-token";
    private static final UserInfo DEMO_USER = new UserInfo("u1001", "demo", "demo@example.com");

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing request body");
        }

        String username = request.getUsername();
        String password = request.getPassword();
        if ("demo".equals(username) && "password".equals(password)) {
            return new LoginResponse(DEMO_TOKEN, DEMO_USER);
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
    }

    @GetMapping("/user")
    public UserInfo currentUser(@RequestHeader(value = "Authorization", required = false) String authorization) {
        String expected = "Bearer " + DEMO_TOKEN;
        if (authorization == null || !expected.equals(authorization)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token");
        }

        return DEMO_USER;
    }
}
