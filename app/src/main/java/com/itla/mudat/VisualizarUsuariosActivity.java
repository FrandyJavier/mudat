package com.itla.mudat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.itla.mudat.entity.Usuario;
import com.itla.mudat.dao.UsuariosDbo;

import java.util.List;

public class VisualizarUsuariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_usuarios);
        UsuariosDbo db = new UsuariosDbo(this);

        List<Usuario> datos = db.listar();
        ListView list = findViewById(R.id.listviewDatos);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        for (int x= 0; x <= datos.size() -1 ; x++){
            adaptador.add(datos.get(x).getNombre());
        }

        list.setAdapter(adaptador);
    }
}
