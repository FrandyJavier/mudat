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

    public void registrarUsuarioButtonClick(View view) {
        startActivity(new Intent(this, RegUsuarioActivity.class));
    }

    public void registrarCategoriaButtonClick(View view) {
        startActivity(new Intent(this, RegCategoriaActivity.class));
    }

    public void registrarAnuncioButtonClick(View view) {
        startActivity(new Intent(this, RegAnuncioActivity.class));
    }

    public static boolean validarEntry(EditText entry){
        if(entry.getText().length() <= 0){
            entry.setError("Valor obligatorio");
            return false;
        }

        return true;
    }
}
