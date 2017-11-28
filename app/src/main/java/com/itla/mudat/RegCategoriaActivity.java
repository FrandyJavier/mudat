package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.dao.CategoriasDbo;
import com.itla.mudat.entity.Categoria;
import com.itla.mudat.entity.TipoUsuario;

public class RegCategoriaActivity extends AppCompatActivity {

    EditText descripcionEdit;
    Categoria categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_categorias);

        descripcionEdit = findViewById(R.id.editTextDescripcion);
    }

    public void guardarClick(View view) {
        CategoriasDbo db = new CategoriasDbo(this);
        categoria  = new Categoria();

        if (!MainActivity.validarEntry(descripcionEdit)) {
            return;
        }

        categoria.setDescripcion(descripcionEdit.getText().toString());
        db.crear(categoria);

        Toast.makeText(this, R.string.msjGuardo, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, VisualizarCategoriasActivity.class));
    }

    public void verListadoClick(View view) {
        startActivity(new Intent(this, VisualizarCategoriasActivity.class));
    }
}
