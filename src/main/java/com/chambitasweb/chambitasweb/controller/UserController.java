package com.chambitasweb.chambitasweb.controller;

import com.chambitasweb.chambitasweb.dto.UserRequestDTO;
import com.chambitasweb.chambitasweb.dto.UserResponseDTO;  // Si tienes un DTO de respuesta
import com.chambitasweb.chambitasweb.models.User;
import com.chambitasweb.chambitasweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*") 
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        try {
            User createdUser = userService.registrarUsuario(userRequestDTO);
            UserResponseDTO responseDTO = new UserResponseDTO(createdUser);  

            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();  // Imprime el error completo en los logs
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método GET para obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

}
