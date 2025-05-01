package com.chambitasweb.chambitasweb.service;

import com.chambitasweb.chambitasweb.dto.UserRequestDTO;
import com.chambitasweb.chambitasweb.models.User;
import com.chambitasweb.chambitasweb.models.User.Estado;
import com.chambitasweb.chambitasweb.models.User.TipoUsuario;
import com.chambitasweb.chambitasweb.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;  // Para encriptar contraseñas

    public User registrarUsuario(UserRequestDTO dto) {
        // Validar si el nombre de usuario o correo ya existen
        if (userRepository.existsByNombre(dto.getNombre())) {
            throw new IllegalArgumentException("¡El nombre de usuario ya está en uso!");
        }

        if (userRepository.existsByCorreo(dto.getCorreo())) {
            throw new IllegalArgumentException("¡El correo electrónico ya está registrado!");
        }

        // Crear el nuevo usuario
        User user = new User();
        user.setNombre(dto.getNombre());
        user.setApellidoPaterno(dto.getApellidoPaterno());
        user.setApellidoMaterno(dto.getApellidoMaterno());
        user.setFechaNacimiento(dto.getFechaNacimiento());
        user.setCorreo(dto.getCorreo());
        user.setContraseña(encoder.encode(dto.getContraseña()));  // Encriptamos la contraseña
       // user.setTipoUsuario(TipoUsuario.valueOf(dto.getTipoUsuario().toUpperCase()));  // Convertir String a Enum
        user.setTipoUsuario(dto.getTipoUsuario());  // No es necesario usar valueOf si ya es un enum



        user.setEstado(Estado.ACTIVO);  // Por defecto, lo dejamos como ACTIVO

        return userRepository.save(user);
    }

    // Método para obtener todos los usuarios
    public List<User> getAllUser() {
        return userRepository.findAll();  // Esto devuelve todos los usuarios de la base de datos
    }


}
