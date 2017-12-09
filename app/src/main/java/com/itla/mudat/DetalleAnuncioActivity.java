package com.itla.mudat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.itla.mudat.dao.CategoriasDbo;
import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.CondicionAnuncio;
import com.itla.mudat.view.adapters.CategoriasListAdapter;

public class DetalleAnuncioActivity extends AppCompatActivity {

    private EditText tituloEdit;
    private EditText ubicacionEdit;
    private EditText precioEdit;
    private EditText detalleEdit;
    private EditText condicionEdit;
    private EditText categoriaEdit;
    private EditText usuarioEdit;

    public Anuncio anuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_anuncio);
        anuncio = new Anuncio();

        asignarEdits();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            anuncio = (Anuncio) bundle.getSerializable(Anuncio.class.getSimpleName());

            tituloEdit.setText(anuncio.getTitulo());
            categoriaEdit.setText(anuncio.getCategoria().getDescripcion());
            condicionEdit.setText(anuncio.getCondicion());
            ubicacionEdit.setText(anuncio.getUbicacion());
            usuarioEdit.setText(anuncio.getIdUsuario().getNombre());
            precioEdit.setText(anuncio.getPrecio().toString());
            detalleEdit.setText(anuncio.getDetalle());
        }
    }

    private void asignarEdits() {
        tituloEdit = findViewById(R.id.editTextTitulo);
        condicionEdit = findViewById(R.id.editTextCondicion);
        categoriaEdit = findViewById(R.id.editTextCategoria);
        ubicacionEdit  = findViewById(R.id.editTextUbicacion);
        precioEdit = findViewById(R.id.editTextPrecio);
        detalleEdit = findViewById(R.id.editTextDetalle);
        usuarioEdit = findViewById(R.id.editTextUsuario);
    }
}
