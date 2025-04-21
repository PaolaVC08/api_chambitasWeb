package com.chambitasweb.chambitasweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chambitasweb.chambitasweb.models.UserRole;
import com.chambitasweb.chambitasweb.service.UserService;
import com.chambitasweb.chambitasweb.dto.UserRequestDTO;


@RestController
@RequestMapping("/auth")
public class AuthController {

}

