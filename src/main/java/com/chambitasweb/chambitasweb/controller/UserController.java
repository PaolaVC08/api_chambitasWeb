package com.chambitasweb.chambitasweb.controller;

import com.chambitasweb.chambitasweb.dto.UserRequestDTO;
import com.chambitasweb.chambitasweb.models.User;
import com.chambitasweb.chambitasweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // permite llamadas desde frontend (si lo necesitas)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User registrarUsuario(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.registrarUsuario(userRequestDTO);
    }
}
