package com.chambitasweb.chambitasweb.dto;

import com.chambitasweb.chambitasweb.models.User;
import com.chambitasweb.chambitasweb.models.User.Estado;
import com.chambitasweb.chambitasweb.models.User.TipoUsuario;

public class UserResponseDTO {
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private TipoUsuario tipoUsuario;  // Ahora es un enum
    private Estado estado;  // Ahora es un enum

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.nombre = user.getNombre();
        this.apellidoPaterno = user.getApellidoPaterno();
        this.apellidoMaterno = user.getApellidoMaterno();
        this.correo = user.getCorreo();
        this.tipoUsuario = user.getTipoUsuario();  // Sin convertir a String
        this.estado = user.getEstado();  // Sin convertir a String
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    



}

