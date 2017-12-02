package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Usuario;
import com.itla.mudat.dao.UsuariosDbo;
import com.itla.mudat.view.adapters.UsuariosListAdapter;

import java.util.List;

public class VisualizarUsuariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_usuarios);

        UsuariosDbo db = new UsuariosDbo(this);

        ListView list = findViewById(R.id.listviewDatos);
        UsuariosListAdapter adapter = new UsuariosListAdapter(this, db.listar());

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Usuario usuario = ((Usuario) arg0.getItemAtPosition(position));
                Toast.makeText(VisualizarUsuariosActivity.this, "has hecho click sobre: " + usuario.getNombre(), Toast.LENGTH_LONG).show();

                Intent i = new Intent(VisualizarUsuariosActivity.this, RegUsuarioActivity.class);
                i.putExtra(Usuario.class.getSimpleName(), usuario);
                startActivity(i);
            }
        });
    }

    public void crearUsuarioClick(View view) {
        startActivity(new Intent(this, RegUsuarioActivity.class));
    }
}
