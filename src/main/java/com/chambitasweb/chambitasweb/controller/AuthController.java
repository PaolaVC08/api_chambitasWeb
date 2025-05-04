package com.chambitasweb.chambitasweb.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chambitasweb.chambitasweb.dto.LoginRequest;
import com.chambitasweb.chambitasweb.dto.UserRequestDTO;
import com.chambitasweb.chambitasweb.dto.response.JwtResponse;
import com.chambitasweb.chambitasweb.service.UserDetailsImplService;
import com.chambitasweb.chambitasweb.service.UserService;
import com.chambitasweb.chambitasweb.security.jwt.JwtUtils;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;  // Inyección de AuthenticationManager

    @Autowired
    private JwtUtils jwtUtils;  // Inyección de JwtUtils

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDTO signUpRequest) {
        try {
            userService.registrarUsuario(signUpRequest);
            return ResponseEntity.ok("¡Usuario registrado exitosamente!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        // Realiza la autenticación
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getNombre(), loginRequest.getContraseña()));

        // Guarda la autenticación en el SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Genera el token JWT
        String jwt = jwtUtils.generateJwtToken(authentication);

        // Obtiene los detalles del usuario autenticado
        UserDetailsImplService userDetails = (UserDetailsImplService) authentication.getPrincipal();

        // Retorna el JWT y los detalles del usuario
        return ResponseEntity.ok(new JwtResponse(
            jwt,
            "Bearer", // Puedes usar "Bearer" literal o desde el DTO
            userDetails.getId(),
            userDetails.getUsername(), // Devuelve el nombre
            userDetails.getCorreo()
        ));
    }
}
