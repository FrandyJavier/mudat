package com.itla.mudat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Usuario;
import com.itla.mudat.dao.UsuariosDbo;

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

        nombreEdit = findViewById(R.id.editTextNombre);
        tipoEdit = findViewById(R.id.editTextTipo);
        identificacionEdit = findViewById(R.id.editTextIdentificador);
        emailEdit = findViewById(R.id.editTextEmail);
        telefonoEdit = findViewById(R.id.editTextTelefono);
        claveEdit = findViewById(R.id.editTextClave);
    }

    public void guardarClick(View view) {
        UsuariosDbo db = new UsuariosDbo(this);

        if (!MainActivity.validarEntry(nombreEdit) || !MainActivity.validarEntry(identificacionEdit) ||
                !MainActivity.validarEntry(emailEdit) || !MainActivity.validarEntry(telefonoEdit) ||
                !MainActivity.validarEntry(claveEdit)) {
            return;
        }

        usuario.setNombre(nombreEdit.getText().toString());
        usuario.setTipoUsuario(TipoUsuario.CLIENTE);
        usuario.setIdentificacion(Integer.parseInt(identificacionEdit.getText().toString()));
        usuario.setEmail(emailEdit.getText().toString());
        usuario.setTelefono(telefonoEdit.getText().toString());
        usuario.setClave(claveEdit.getText().toString());
        usuario.setEstatus(true);

        db.crear(usuario);

        Toast.makeText(this, R.string.msjGuardo, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, VisualizarUsuariosActivity.class));
    }

    public void verListadoClick(View view) {
        startActivity(new Intent(this, VisualizarUsuariosActivity.class));
    }
}
