package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.dao.CategoriasDbo;
import com.itla.mudat.entity.Categoria;
import com.itla.mudat.entity.TipoUsuario;

public class RegCategoriaActivity extends AppCompatActivity {

    EditText descripcionEdit;
    Categoria categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_categorias);
        Button borrarButton = findViewById(R.id.borrarButton);
        descripcionEdit = findViewById(R.id.editTextDescripcion);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            categoria = (Categoria) bundle.getSerializable(Categoria.class.getSimpleName());
            borrarButton.setVisibility(View.VISIBLE);
            descripcionEdit.setText(categoria.getDescripcion());
        }
    }

    public void guardarClick(View view) {
        CategoriasDbo db = new CategoriasDbo(this);
        categoria  = new Categoria();

        if (!MainActivity.validarEntry(descripcionEdit)) {
            return;
        }

        categoria.setDescripcion(descripcionEdit.getText().toString());

        long paso = 0;

        if(categoria.getId() <= 0){
            paso =  db.crear(categoria);
        }else{
            paso = db.editar(categoria);
        }

        if (paso < 0){
            Toast.makeText(this, R.string.msjErrorGuardar, Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, R.string.msjGuardo, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, VisualizarCategoriasActivity.class));
    }

    public void verListadoClick(View view) {
        startActivity(new Intent(this, VisualizarCategoriasActivity.class));
    }

    public void borrarButtonClick(View view) {
        CategoriasDbo db = new CategoriasDbo(this);

        if(db.eliminar(categoria.getId()) >= 0){
            Toast.makeText(this, R.string.msjGuardo, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, VisualizarUsuariosActivity.class));
        }
    }
}
