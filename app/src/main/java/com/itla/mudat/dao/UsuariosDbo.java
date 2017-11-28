package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frandy Javier AP on 11/25/2017.
 */

public class UsuariosDbo {
    DbConnection connection;

    public UsuariosDbo(Context context) {
        connection = new DbConnection(context);
    }


    public Usuario buscar(int id) {
        Usuario usuario = new Usuario();

        if ((double) id > 0) {
            usuario = this.listar().get(id);
        }

        return usuario;
    }

    public long crear(Usuario usuario) {
        SQLiteDatabase db = connection.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Usuario.NOMBRE, usuario.getNombre());
        values.put(Usuario.TIPO, usuario.getTipoUsuario().toString());
        values.put(Usuario.IDENTIFICACION, usuario.getIdentificacion());
        values.put(Usuario.EMAIL, usuario.getEmail());
        values.put(Usuario.TELEFONO, usuario.getTelefono());
        values.put(Usuario.CLAVE, usuario.getClave());
        values.put(Usuario.ESTATUS, usuario.getEstatus());

        long retorno = db.insert(Usuario.class.getSimpleName(), Usuario.ID, values);
        db.close();
        return  retorno;
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase db = connection.getReadableDatabase();

        String[] columnas = new String[]{Usuario.ID,Usuario.NOMBRE,Usuario.NOMBRE, Usuario.TIPO, Usuario.IDENTIFICACION, Usuario.EMAIL, Usuario.TELEFONO, Usuario.CLAVE, Usuario.ESTATUS};

        Cursor cursor = db.query(Usuario.class.getSimpleName(), columnas, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Usuario usuario = new Usuario();

            usuario.setId(cursor.getInt(cursor.getColumnIndex(Usuario.ID)));
            usuario.setNombre(cursor.getString(cursor.getColumnIndex(Usuario.NOMBRE)));
            usuario.setTipoUsuario(TipoUsuario.valueOf(cursor.getString(cursor.getColumnIndex(Usuario.TIPO))));
            usuario.setIdentificacion(cursor.getInt(cursor.getColumnIndex(Usuario.IDENTIFICACION)));
            usuario.setEmail(cursor.getString(cursor.getColumnIndex(Usuario.EMAIL)));
            usuario.setTelefono(cursor.getString(cursor.getColumnIndex(Usuario.TELEFONO)));
            usuario.setClave(cursor.getString(cursor.getColumnIndex(Usuario.CLAVE)));
            usuario.setEstatus(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(Usuario.ESTATUS))));

            cursor.moveToNext();
            usuarios.add(usuario);
        }

        cursor.close();
        db.close();
        return usuarios;
    }
}
