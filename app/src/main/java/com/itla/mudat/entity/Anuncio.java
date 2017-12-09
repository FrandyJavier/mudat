package com.itla.mudat.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Frandy Javier AP on 11/18/2017.
 */

public class Anuncio implements Serializable {

    Integer id;
    Categoria categoria;
    Usuario idUsuario;
    String fecha;
    String condicion;
    Double precio;
    String titulo;
    String ubicacion;
    String detalle;

    public static final String ID = "id";
    public static final String IDCATEGORIA = "idCategoria";
    public static final String IDUSUARIO = "idUsuario";
    public static final String FECHA = "fecha";
    public static final String CONDICION = "condicion";
    public static final String PRECIO = "precio";
    public static final String TITULO = "titulo";
    public static final String UBICACION = "ubicacion";
    public static final String DETALLE = "detalle";

    public Anuncio() {
        this.id = 0;
        this.categoria = new Categoria();
        this.idUsuario = new Usuario();
        this.fecha = "";
        this.condicion = "";
        this.precio = 0.0;
        this.titulo = "";
        this.ubicacion = "";
        this.detalle = "";
    }

    public Anuncio(Integer idAnuncio, Categoria categoria, Usuario idUsuario, String fecha, String condicion, Double precio, String titulo, String ubicacion, String detalle) {
        this.id = idAnuncio;
        this.categoria = categoria;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.condicion = condicion;
        this.precio = precio;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.detalle = detalle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }


    @Override
    public String toString() {
        return "Anuncio{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", id=" + idUsuario +
                ", fecha=" + fecha +
                ", condicion='" + condicion + '\'' +
                ", precio=" + precio +
                ", titulo='" + titulo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", detalle='" + detalle + '\'' +
                '}';
    }

}