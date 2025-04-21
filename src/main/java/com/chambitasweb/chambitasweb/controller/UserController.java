package com.chambitasweb.chambitasweb.controller;

import com.chambitasweb.chambitasweb.dto.UserRequestDTO;
import com.chambitasweb.chambitasweb.models.Users;
import com.chambitasweb.chambitasweb.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*") // permite llamadas desde frontend (si lo necesitas)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        Users createdUser = userService.registrarUsuario(userRequestDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
   // Método GET para obtener todos los usuarios
   @GetMapping
   public List<Users> getAllUsers() {
       return userService.getAllUsers();
   }

   // Método GET para obtener un usuario por ID
   @GetMapping("/{id}")
   public Users getUserById(@PathVariable Long id) {
       return userService.getUserById(id);
   }

}
