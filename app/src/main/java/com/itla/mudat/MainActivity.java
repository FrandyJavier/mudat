package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String NOMBRE = "nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void consultaUsuarioButtonClick(View view) {
        startActivity(new Intent(this, VisualizarUsuariosActivity.class));
    }

    public void consultaCategoriaButtonClick(View view) {
        startActivity(new Intent(this, VisualizarCategoriasActivity.class));
    }

    public void consultaAnuncioButtonClick(View view) {
        startActivity(new Intent(this, VisualizarAnunciosActivity.class));
    }

    public static boolean validarEntry(EditText entry){
        if(entry.getText().length() <= 0){
            entry.setError("Valor obligatorio");
            return false;
        }

        return true;
    }
}
