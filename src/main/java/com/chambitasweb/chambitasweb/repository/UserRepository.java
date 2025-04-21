package com.chambitasweb.chambitasweb.repository;

import com.chambitasweb.chambitasweb.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    // métodos personalizados si los necesitas
}
