package com.itla.mudat;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Utils;

public class PanelRegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_registro);

        if(MainActivity.usuarioActual == null){
            finish();
        }

        if(MainActivity.usuarioActual.getTipoUsuario() == TipoUsuario.CLIENTE){
            Toast.makeText(this,"No posee permiso de visualizar el panel",Toast.LENGTH_LONG).show();
            finish();
        }
    }

    public void verUsuarioClick(View view) {

        if(MainActivity.usuarioActual.getTipoUsuario() != TipoUsuario.ADMINISTRADOR)
        {
            Toast.makeText(this,"No posee permiso para realizar esta operacion",Toast.LENGTH_LONG).show();
            return;
        }

        startActivity(new Intent(this, VisualizarUsuariosActivity.class));
    }

    public void verCategoriaClick(View view) {
        startActivity(new Intent(this, VisualizarCategoriasActivity.class));
    }

    public void verAnuncioClick(View view) {
        startActivity(new Intent(this, VisualizarAnunciosActivity.class));
    }

    public void salirbuttonClick(View view) {
        Utils.guardarPreferencia(this,Utils.LOGIN_ID,null);
        Utils.guardarPreferencia(this,Utils.LOGIN_NAME,null);
        MainActivity.usuarioActual = null;
        finish();
    }
}
