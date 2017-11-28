package com.itla.mudat.test;

import com.itla.mudat.entity.Usuario;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frandy Javier AP on 11/28/2017.
 */

public class testUsuarios extends TestCase {
    public void test_Crear() {
        assertTrue(1 > 2);
    }

    public void testListar() {
        List<Usuario> usuarios = new ArrayList<>();

        assertTrue(usuarios.size() > 0);
    }
}
