package com.chambitasweb.chambitasweb.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//import com.anderluuna.spring.security.postgresql.principiostest.models.User;
import com.chambitasweb.chambitasweb.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImplService implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String nombre;

  private String correo;

  @JsonIgnore
  private String contraseña;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImplService(Long id, String nombre, String correo, String contraseña,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.nombre = nombre;
    this.correo = correo;
    this.authorities = authorities;
  }

  public static UserDetailsImplService build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
       // .map(role -> new SimpleGrantedAuthority(role.getNombreRol().name()))
        .collect(Collectors.toList());

    return new UserDetailsImplService(user.getId(),
        user.getNombre(),
        user.getCorreo(),
        user.getContraseña(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
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
