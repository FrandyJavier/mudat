package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.entity.Categoria;
import com.itla.mudat.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frandy Javier AP on 11/27/2017.
 */

public class CategoriasDbo {
    DbConnection connection;

    public CategoriasDbo(Context context) {
        connection = new DbConnection(context);
    }

    public Categoria buscar(int id) {
        Categoria categoria = new Categoria();
        List<Categoria> listado = this.listar();

        int index;
        if ((double) id > 0) {
            for (int x = 0; x < listado.size(); x++) {
                index = x;
                if (listado.get(index).getId() == id) {
                    categoria = listado.get(index);
                    break;
                }
            }
        }

        return categoria;
    }

    public long crear(Categoria categoria) {
        SQLiteDatabase db = connection.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Categoria.DESCRIPCION, categoria.getDescripcion());

        long retorno = db.insert(Categoria.class.getSimpleName(), Categoria.IDCATEGORIA, values);

        db.close();
        return retorno;
    }

    public long editar(Categoria categoria) {
        SQLiteDatabase db = connection.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Categoria.DESCRIPCION, categoria.getDescripcion());

        long retorno = db.update(Categoria.class.getSimpleName(), values, Categoria.IDCATEGORIA + "= ?", new String[]{categoria.getId().toString()});

        db.close();
        return retorno;
    }

    public long eliminar(int id) {
        SQLiteDatabase db = connection.getWritableDatabase();
        long retorno = db.delete(Usuario.class.getSimpleName(), Categoria.IDCATEGORIA + "= ?", new String[]{String.valueOf(id)});
        db.close();
        return retorno;
    }

    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();

        String[] columnas = new String[]{Categoria.IDCATEGORIA, Categoria.DESCRIPCION};

        Cursor cursor = db.query(Categoria.class.getSimpleName(), columnas, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Categoria categoria = new Categoria();

            categoria.setId(cursor.getInt(cursor.getColumnIndex(Categoria.IDCATEGORIA)));
            categoria.setDescripcion(cursor.getString(cursor.getColumnIndex(Categoria.DESCRIPCION)));

            cursor.moveToNext();
            categorias.add(categoria);
        }

        cursor.close();
        db.close();
        return categorias;
    }
}