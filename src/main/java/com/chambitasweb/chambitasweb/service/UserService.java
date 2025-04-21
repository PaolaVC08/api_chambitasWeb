package com.chambitasweb.chambitasweb.service;

import com.chambitasweb.chambitasweb.dto.UserRequestDTO;
import com.chambitasweb.chambitasweb.models.Users;
import com.chambitasweb.chambitasweb.models.Users.Estado;
import com.chambitasweb.chambitasweb.models.Users.TipoUsuario;
import com.chambitasweb.chambitasweb.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users registrarUsuario(UserRequestDTO dto) {
        Users user = new Users();
        user.setNombre(dto.getNombre());
        user.setApellidoPaterno(dto.getApellidoPaterno());
        user.setApellidoMaterno(dto.getApellidoMaterno());
        user.setFechaNacimiento(dto.getFechaNacimiento());
        user.setCorreo(dto.getCorreo());
        user.setContraseña(dto.getContraseña()); // Aquí puedes encriptar más adelante
        user.setFotoPerfilB64(dto.getFotoPerfilB64());

        // Convertir String a Enum (con validación simple)
        if (dto.getTipoUsuario().equalsIgnoreCase("cliente")) {
            user.setTipoUsuario(TipoUsuario.CLIENTE);
        } else if (dto.getTipoUsuario().equalsIgnoreCase("profesionista")) {
            user.setTipoUsuario(TipoUsuario.PROFESIONISTA);
        } else {
            throw new IllegalArgumentException("Tipo de usuario no válido");
        }

        user.setEstado(Estado.ACTIVO); // por defecto

        return userRepository.save(user);
    }

        // Obtener todos los usuarios
        public List<Users> getAllUsers() {
            return userRepository.findAll();
        }
    
        // Obtener un usuario por ID
        public Users getUserById(Long id) {
            Optional<Users> user = userRepository.findById(id);
            return user.orElse(null); // Retorna el usuario o null si no lo encuentra
        }
    
}

