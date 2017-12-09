package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.itla.mudat.dao.AnunciosDbo;
import com.itla.mudat.dao.UsuariosDbo;
import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.Categoria;
import com.itla.mudat.entity.Usuario;
import com.itla.mudat.view.adapters.AnunciosListAdapter;

import java.util.List;

public class VisualizarAnunciosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_anuncios);
        buscarDatos();
    }

    private void buscarDatos() {
        AnunciosDbo db = new AnunciosDbo(this);
        ListView list = findViewById(R.id.listviewDatos);
        AnunciosListAdapter adaptador =  new AnunciosListAdapter(this,db.listar());
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Anuncio anuncio = ((Anuncio) arg0.getItemAtPosition(position));
                Intent i = new Intent(VisualizarAnunciosActivity.this, RegAnuncioActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable(Anuncio.class.getSimpleName(), anuncio);

                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        buscarDatos();
    }

    public void crearAnuncioClick(View view) {
        startActivity(new Intent(this, RegAnuncioActivity.class));
    }
}
