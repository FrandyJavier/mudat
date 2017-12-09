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

        buscarDatos();
    }

    @Override
    protected void onResume(){
        super.onResume();
        buscarDatos();
    }

    private void buscarDatos() {
        CategoriasDbo db = new CategoriasDbo(this);

        ListView list = findViewById(R.id.listviewDatos);
        CategoriasListAdapter adapter = new CategoriasListAdapter(this, db.listar(),false);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Categoria categoria = ((Categoria) arg0.getItemAtPosition(position));
                Intent i = new Intent(VisualizarCategoriasActivity.this, RegCategoriaActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable(Categoria.class.getSimpleName(), categoria);

                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    public void crearCategoriaClick(View view) {
        startActivity(new Intent(this, RegCategoriaActivity.class));
    }
}
