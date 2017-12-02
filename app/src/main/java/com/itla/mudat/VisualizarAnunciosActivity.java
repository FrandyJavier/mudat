package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.itla.mudat.dao.AnunciosDbo;
import com.itla.mudat.dao.UsuariosDbo;
import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.Usuario;

import java.util.List;

public class VisualizarAnunciosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_anuncios);
        AnunciosDbo db = new AnunciosDbo(this);

        List<Anuncio> datos = db.listar();
        ListView list = findViewById(R.id.listviewDatos);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        for (int x= 0; x <= datos.size() -1 ; x++){
            adaptador.add(datos.get(x).getTitulo());
        }

        list.setAdapter(adaptador);
    }

    public void crearAnuncioClick(View view) {
        startActivity(new Intent(this, RegAnuncioActivity.class));
    }
}
