package com.itla.mudat.test;

import android.content.Context;
import android.test.InstrumentationTestCase;

import com.itla.mudat.dao.UsuariosDbo;
import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frandy Javier AP on 11/28/2017.
 */

public class testUsuarios extends InstrumentationTestCase {

    public void test_Crear() {

        Usuario usuario = new Usuario();
        UsuariosDbo db = new UsuariosDbo(getInstrumentation().getTargetContext());

        usuario.setNombre("Prueba");
        usuario.setTipoUsuario(TipoUsuario.CLIENTE);
        usuario.setIdentificacion(1);
        usuario.setEmail("prueba@gmail.com");
        usuario.setTelefono("809-000-0000");
        usuario.setClave("123");
        usuario.setEstatus(true);

        assertTrue(db.crear(usuario) > 0);
    }

    public void testListar() {
        UsuariosDbo db = new UsuariosDbo(getInstrumentation().getTargetContext());
        List<Usuario> usuarios = new ArrayList<>();

        usuarios = db.listar();
        assertTrue(usuarios.size() > 0);
    }
}
