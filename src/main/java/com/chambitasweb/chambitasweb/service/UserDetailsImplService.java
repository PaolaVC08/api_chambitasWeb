package com.chambitasweb.chambitasweb.service;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.chambitasweb.chambitasweb.models.User;

public class UserDetailsImplService implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String correo;

    @JsonIgnore
    private String contraseña;

    // Ya no necesitas authorities si no vas a manejar roles
    // private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImplService(Long id, String nombre, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        // Elimina authorities ya que no los estás manejando
    }

    public static UserDetailsImplService build(User user) {
        return new UserDetailsImplService(
            user.getId(),
            user.getNombre(),
            user.getCorreo(),
            user.getContraseña()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // Devuelve null ya que no vas a manejar roles
    }

    public Long getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String getUsername() {
        return nombre;
    }

    @Override
    public String getPassword() {
        return contraseña;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImplService user = (UserDetailsImplService) o;
        return Objects.equals(id, user.id);
    }
}
