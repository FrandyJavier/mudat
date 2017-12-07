package com.itla.mudat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.itla.mudat.entity.TipoUsuario;
import com.itla.mudat.entity.Usuario;
import com.itla.mudat.dao.UsuariosDbo;

public class RegUsuarioActivity extends AppCompatActivity {

    private EditText nombreEdit;
    private Spinner tipoUsuarioSpinner;
    private EditText identificacionEdit;
    private EditText emailEdit;
    private EditText telefonoEdit;
    private EditText claveEdit;

    public Usuario usuario;
    private ArrayAdapter tipoUsuarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_usuario);
        usuario = new Usuario();

        nombreEdit = findViewById(R.id.editTextNombre);
        identificacionEdit = findViewById(R.id.editTextIdentificador);
        emailEdit = findViewById(R.id.editTextEmail);
        telefonoEdit = findViewById(R.id.editTextTelefono);
        claveEdit = findViewById(R.id.editTextClave);


        tipoUsuarioAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TipoUsuario.values());

        tipoUsuarioSpinner = findViewById(R.id.tipoUsuarioSpinner);
        tipoUsuarioSpinner.setAdapter(tipoUsuarioAdapter);

        Bundle bundle = getIntent().getExtras();
        Button borrarButton = findViewById(R.id.borrarButton);

        if (bundle != null) {
            usuario = (Usuario) bundle.getSerializable(Usuario.class.getSimpleName());
            borrarButton.setVisibility(View.VISIBLE);

            nombreEdit.setText(usuario.getNombre());
            tipoUsuarioSpinner.setSelection(tipoUsuarioAdapter.getPosition(usuario.getTipoUsuario()));
            identificacionEdit.setText(usuario.getIdentificacion());
            emailEdit.setText(usuario.getEmail());
            telefonoEdit.setText(usuario.getEmail());
            claveEdit.setText(usuario.getClave());
        }
    }

    public void guardarClick(View view) {
        UsuariosDbo db = new UsuariosDbo(this);

        if (!MainActivity.validarEntry(nombreEdit) || !MainActivity.validarEntry(identificacionEdit) ||
                !MainActivity.validarEntry(emailEdit) || !MainActivity.validarEntry(telefonoEdit) ||
                !MainActivity.validarEntry(claveEdit)) {
            return;
        }

        usuario.setNombre(nombreEdit.getText().toString());
        usuario.setTipoUsuario(TipoUsuario.valueOf(tipoUsuarioSpinner.getSelectedItem().toString()));
        usuario.setIdentificacion(identificacionEdit.getText().toString());
        usuario.setEmail(emailEdit.getText().toString());
        usuario.setTelefono(telefonoEdit.getText().toString());
        usuario.setClave(claveEdit.getText().toString());
        usuario.setEstatus(true);

        long paso = 0;

        if(usuario.getId() <= 0){
           paso =  db.crear(usuario);
        }else{
            paso = db.editar(usuario);
        }

        if (paso < 0){
            Toast.makeText(this, R.string.msjErrorGuardar, Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, R.string.msjGuardo, Toast.LENGTH_SHORT).show();
        finish();
    }

    public void borrarButtonClick(View view) {
        UsuariosDbo db = new UsuariosDbo(this);

        if(db.eliminar(usuario.getId()) >= 0){
            Toast.makeText(this, R.string.msjGuardo, Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
