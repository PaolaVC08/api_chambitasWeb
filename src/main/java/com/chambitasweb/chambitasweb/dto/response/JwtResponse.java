package com.chambitasweb.chambitasweb.dto.response;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String nombre;
    private String correo;


    public JwtResponse(String token, String type, Long id, String nombre, String correo) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }


    public String getToken() {
        return token;
    }


    public void setToken(String token) {
        this.token = token;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
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


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

    

}
