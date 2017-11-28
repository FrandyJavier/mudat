package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.Usuario;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frandy Javier AP on 11/27/2017.
 */

public class AnunciosDbo {

    DbConnection connection;
    Context context;

    public AnunciosDbo(Context context) {
        connection = new DbConnection(context);
        this.context = context;
    }

    public Anuncio buscar(int id) {
        Anuncio anuncio = new Anuncio();

        if ((double) id > 0) {
            anuncio = this.listar().get(id);
        }

        return anuncio;
    }

    public long crear(Anuncio anuncio) {
        SQLiteDatabase db = connection.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Anuncio.IDCATEGORIA, anuncio.getCategoria().getId());
        values.put(Anuncio.IDUSUARIO, anuncio.getIdUsuario().toString());
        values.put(Anuncio.FECHA, anuncio.getFecha().toString());
        values.put(Anuncio.CONDICION, anuncio.getCondicion());
        values.put(Anuncio.PRECIO, anuncio.getPrecio());
        values.put(Anuncio.TITULO, anuncio.getTitulo());
        values.put(Anuncio.UBICACION, anuncio.getUbicacion());
        values.put(Anuncio.DETALLE, anuncio.getDetalle());

        long retorno = db.insert(Anuncio.class.getSimpleName(), Anuncio.ID, values);

        db.close();
        return retorno;
    }

    public List<Anuncio> listar() {
        List<Anuncio> anuncios = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();

        String[] columnas = new String[]{Anuncio.ID, Anuncio.IDCATEGORIA, Anuncio.IDUSUARIO, Anuncio.FECHA, Anuncio.CONDICION, Anuncio.PRECIO, Anuncio.TITULO, Anuncio.UBICACION, Anuncio.DETALLE};

        Cursor cursor = db.query(Anuncio.class.getSimpleName(), columnas, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Anuncio anuncio = new Anuncio();
            CategoriasDbo categoria = new CategoriasDbo(context);
            UsuariosDbo usuario = new UsuariosDbo(context);

            anuncio.setCategoria(categoria.buscar(cursor.getInt(cursor.getColumnIndex(Anuncio.IDCATEGORIA))));
            anuncio.setIdUsuario(usuario.buscar(cursor.getInt(cursor.getColumnIndex(Anuncio.IDUSUARIO))));

            anuncio.setId(cursor.getInt(cursor.getColumnIndex(Anuncio.ID)));
            anuncio.setFecha(Date.valueOf(cursor.getString(cursor.getColumnIndex(Anuncio.FECHA))));
            anuncio.setCondicion(cursor.getString(cursor.getColumnIndex(Anuncio.CONDICION)));
            anuncio.setPrecio(cursor.getDouble(cursor.getColumnIndex(Anuncio.PRECIO)));
            anuncio.setTitulo(cursor.getString(cursor.getColumnIndex(Anuncio.TITULO)));
            anuncio.setUbicacion(cursor.getString(cursor.getColumnIndex(Anuncio.UBICACION)));
            anuncio.setDetalle(cursor.getString(cursor.getColumnIndex(Anuncio.DETALLE)));

            cursor.moveToNext();
            anuncios.add(anuncio);
        }

        cursor.close();
        db.close();
        return anuncios;
    }
}