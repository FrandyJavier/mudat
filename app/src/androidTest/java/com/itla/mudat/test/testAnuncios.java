package com.itla.mudat.test;

import android.test.InstrumentationTestCase;

import com.itla.mudat.dao.AnunciosDbo;
import com.itla.mudat.dao.CategoriasDbo;
import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.Categoria;
import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Usuario;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frandy Javier AP on 11/29/2017.
 */

public class testAnuncios extends InstrumentationTestCase {

    public void test_Crear() {

        Anuncio anuncio = new Anuncio();
        AnunciosDbo db = new AnunciosDbo(getInstrumentation().getTargetContext());

        Categoria categoria = new Categoria(1, "prueba");
        Usuario usuario = new Usuario(1, "prueba 1", TipoUsuario.CLIENTE, 1, "", "", "", false);

        anuncio.setCategoria(categoria);
        anuncio.setIdUsuario(usuario);
        anuncio.setId(1);
        anuncio.setFecha(Date.valueOf("11-11-2017"));
        anuncio.setCondicion("Nuevo");
        anuncio.setPrecio(Double.valueOf("100"));
        anuncio.setTitulo("prueba test");
        anuncio.setUbicacion("");
        anuncio.setDetalle("");

        assertTrue(db.crear(anuncio) > 0);
    }

    public void testListar() {
        AnunciosDbo db = new AnunciosDbo(getInstrumentation().getTargetContext());
        List<Anuncio> anuncios = new ArrayList<>();

        anuncios = db.listar();
        assertTrue(anuncios.size() > 0);
    }
}
