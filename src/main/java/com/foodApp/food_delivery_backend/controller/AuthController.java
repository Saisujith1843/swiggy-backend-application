package com.foodApp.food_delivery_backend.controller;

import com.foodApp.food_delivery_backend.dto.*;
import com.foodApp.food_delivery_backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid AuthRequest request) {
        return authService.login(request);
    }
}