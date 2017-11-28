package com.itla.mudat.entity;

/**
 * Created by Frandy Javier AP on 11/18/2017.
 */

public class Usuario {
    Integer id;
    String nombre;
    TipoUsuario tipoUsuario;
    Integer identificacion;
    String email;
    String telefono;
    String clave;
    Boolean estatus;

    public  static final String ID = "id";
    public  static final String NOMBRE = "nombre";
    public  static final String TIPO = "tipoUsuario";
    public  static final String IDENTIFICACION = "identificacion";
    public  static final String EMAIL = "email";
    public  static final String TELEFONO = "telefono";
    public  static final String CLAVE = "clave";
    public  static final String ESTATUS = "estatus";

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombre, TipoUsuario tipoUsuario, Integer identificacion, String email, String telefono, String clave, Boolean estatus) {
        this.id = idUsuario;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.identificacion = identificacion;
        this.email = email;
        this.telefono = telefono;
        this.clave = clave;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", identificacion=" + identificacion +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", clave='" + clave + '\'' +
                ", estatus=" + estatus +
                '}';
    }
}
