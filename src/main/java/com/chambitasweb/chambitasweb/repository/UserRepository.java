package com.chambitasweb.chambitasweb.repository;

import com.chambitasweb.chambitasweb.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // métodos personalizados si los necesitas

    Optional<User> findByNombre(String nombre);
    Boolean existsByNombre(String nombre);
    Boolean existsByCorreo(String correo);
}
