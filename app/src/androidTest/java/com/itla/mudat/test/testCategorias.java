package com.itla.mudat.test;

import android.test.InstrumentationTestCase;

import com.itla.mudat.dao.CategoriasDbo;
import com.itla.mudat.entity.Categoria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frandy Javier AP on 11/29/2017.
 */

public class testCategorias extends InstrumentationTestCase {

    public void test_Crear() {

        Categoria categoria = new Categoria();
        CategoriasDbo db = new CategoriasDbo(getInstrumentation().getTargetContext());

        categoria.setDescripcion("Prueba");

        assertTrue(db.crear(categoria) > 0);
    }

    public void testListar() {
        CategoriasDbo db = new CategoriasDbo(getInstrumentation().getTargetContext());
        List<Categoria> categorias = new ArrayList<>();

        categorias = db.listar();
        assertTrue(categorias.size() > 0);
    }
}
