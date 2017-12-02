package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.itla.mudat.dao.CategoriasDbo;
import com.itla.mudat.dao.UsuariosDbo;
import com.itla.mudat.entity.Categoria;
import com.itla.mudat.view.adapters.CategoriasListAdapter;

public class VisualizarCategoriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_categorias);

        CategoriasDbo db = new CategoriasDbo(this);

        ListView list = findViewById(R.id.listviewDatos);
        CategoriasListAdapter adapter = new CategoriasListAdapter(this, db.listar());

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Categoria usuario = ((Categoria) arg0.getItemAtPosition(position));
                Toast.makeText(VisualizarCategoriasActivity.this, "has hecho click sobre: " + usuario.getDescripcion(), Toast.LENGTH_LONG).show();

                Intent i = new Intent(VisualizarCategoriasActivity.this, RegUsuarioActivity.class);
                i.putExtra(Categoria.class.getSimpleName(), usuario);
                startActivity(i);
            }
        });
    }

    public void crearCategoriaClick(View view) {
        startActivity(new Intent(this, RegCategoriaActivity.class));
    }
}
