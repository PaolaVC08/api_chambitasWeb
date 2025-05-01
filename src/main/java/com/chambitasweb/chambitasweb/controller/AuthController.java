package com.chambitasweb.chambitasweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chambitasweb.chambitasweb.dto.UserRequestDTO;
import com.chambitasweb.chambitasweb.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;  

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDTO signUpRequest) {

        try {
            // Delegar a UserService para crear el nuevo usuario
            userService.registrarUsuario(signUpRequest);

            return ResponseEntity.ok("¡Usuario registrado exitosamente!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
