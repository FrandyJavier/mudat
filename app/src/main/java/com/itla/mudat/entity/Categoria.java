package com.itla.mudat.entity;

/**
 * Created by Frandy Javier AP on 11/18/2017.
 */

public class Categoria {
    Integer id;
    String descripcion;

    public static final String IDCATEGORIA = "id";
    public static final String DESCRIPCION = "descripcion";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria() {  }

    public Categoria(Integer idCategoria, String descripcion) {
        this.id = idCategoria;
        this.descripcion = descripcion;
    }
}