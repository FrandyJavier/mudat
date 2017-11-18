package com.itla.mudat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.itla.mudat.Entity.Usuario;

public class RegUsuarioActivity extends AppCompatActivity {

    private EditText nombreEdit;
    private EditText tipoEdit;
    private EditText identificacionEdit;
    private EditText emailEdit;
    private EditText telefonoEdit;
    private EditText claveEdit;

    public Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_usuario);
        usuario = new Usuario();

        nombreEdit = (EditText) findViewById(R.id.editTextNombre);
        tipoEdit = (EditText) findViewById(R.id.editTextTipo);
        identificacionEdit = (EditText) findViewById(R.id.editTextIdentificador);
        emailEdit = (EditText) findViewById(R.id.editTextEmail);
        telefonoEdit = (EditText) findViewById(R.id.editTextTelefono);
        claveEdit = (EditText) findViewById(R.id.editTextClave);
    }

    public void guardarUsuarioClick(View view) {
        if(!validarEntry(nombreEdit) || !validarEntry(identificacionEdit) ||
                !validarEntry(emailEdit) || !validarEntry(telefonoEdit) ||
                !validarEntry(claveEdit)){
            return;
        }

        usuario.setNombre(nombreEdit.getText().toString());
        usuario.setIdentificacion(Integer.parseInt(identificacionEdit.getText().toString()));
        usuario.setEmail(emailEdit.getText().toString());
        usuario.setTelefono(telefonoEdit.getText().toString());
        usuario.setClave(claveEdit.getText().toString());
    }

    public static boolean validarEntry(EditText entry){
        if(entry.getText().length() <= 0){
            entry.setError("Valor obligatorio");
            return false;
        }

        return true;
    }
}
