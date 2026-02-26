package com.foodApp.food_delivery_backend.service;

import com.foodApp.food_delivery_backend.dto.AuthRequest;
import com.foodApp.food_delivery_backend.dto.SignupRequest;
import com.foodApp.food_delivery_backend.model.User;
import com.foodApp.food_delivery_backend.repository.UserRepository;
import com.foodApp.food_delivery_backend.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String signup(SignupRequest signupRequest) {

        if(userRepository.findByUsername(signupRequest.getUsername()).isPresent()){
            return "User already exists";
        }

        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole(signupRequest.getRole());
        userRepository.save(user);

        return "User registered successfully";

    }

    public String login(AuthRequest authRequest) {

        User user = userRepository.findByUsername(authRequest.getUsername())
                .orElseThrow(()-> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("password does not match");
        }

        return jwtUtil.generateToken(user.getUsername(), user.getRole());

    }

}
