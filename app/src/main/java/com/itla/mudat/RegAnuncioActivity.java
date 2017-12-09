package com.itla.mudat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.itla.mudat.dao.AnunciosDbo;
import com.itla.mudat.dao.CategoriasDbo;
import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.Categoria;
import com.itla.mudat.entity.CondicionAnuncio;
import com.itla.mudat.entity.Utils;
import com.itla.mudat.view.adapters.CategoriasListAdapter;

import java.util.Date;

public class RegAnuncioActivity extends AppCompatActivity {
    private Boolean editando = false;

    private EditText tituloEdit;
    private EditText ubicacionEdit;
    private EditText precioEdit;
    private EditText detalleEdit;
    private Spinner condicionSpinner;
    private Spinner categoriaSpinner;
    private Button borrarButton;

    private CategoriasListAdapter categoriasAdapter;
    private ArrayAdapter condicionesAdapter;

    public Anuncio anuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_anuncio);
        anuncio = new Anuncio();

        asignarEdits();
        llenarSpinners();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            editando = true;

            anuncio = (Anuncio) bundle.getSerializable(Anuncio.class.getSimpleName());
            borrarButton.setVisibility(View.VISIBLE);

            tituloEdit.setText(anuncio.getTitulo());
            categoriaSpinner.setSelection(categoriasAdapter.getPosition(anuncio.getCategoria()));
            condicionSpinner.setSelection(condicionesAdapter.getPosition(anuncio.getCondicion()));
            ubicacionEdit.setText(anuncio.getUbicacion());
            precioEdit.setText(anuncio.getPrecio().toString());
            detalleEdit.setText(anuncio.getDetalle());
        }
    }

    public void guardarClick(View view) {
        AnunciosDbo db = new AnunciosDbo(this);

        if (!MainActivity.validarEntry(tituloEdit) || !MainActivity.validarEntry(precioEdit) || !MainActivity.validarEntry(detalleEdit)) {
            return;
        }

        Categoria categoria = (Categoria) categoriasAdapter.getItem(categoriaSpinner.getSelectedItemPosition());
        CondicionAnuncio condicion = (CondicionAnuncio) condicionesAdapter.getItem(condicionSpinner.getSelectedItemPosition());

        anuncio.setTitulo(tituloEdit.getText().toString());

        anuncio.setCategoria(categoria);
        anuncio.setFecha(Utils.getFechaFormateada());
        anuncio.setCondicion(condicion.toString());
        anuncio.setUbicacion(ubicacionEdit.getText().toString());
        anuncio.setPrecio(Double.valueOf(precioEdit.getText().toString()));
        anuncio.setDetalle(detalleEdit.getText().toString());
        anuncio.setIdUsuario(MainActivity.usuarioActual);

        long paso = 0;

        if (!editando) {
            paso = db.crear(anuncio);
        } else {
            paso = db.editar(anuncio);
        }

        if (paso < 0) {
            Toast.makeText(this, R.string.msjErrorGuardar, Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, R.string.msjGuardo, Toast.LENGTH_SHORT).show();
        finish();
    }

    public void borrarButtonClick(View view) {
        AnunciosDbo db = new AnunciosDbo(this);

        if (db.eliminar(anuncio.getId()) >= 0) {
            Toast.makeText(this, R.string.msjGuardo, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void asignarEdits() {
        tituloEdit = findViewById(R.id.editTextTitulo);
        condicionSpinner = findViewById(R.id.spinnerCondicion);
        categoriaSpinner = findViewById(R.id.spinnerCategoria);
        ubicacionEdit  = findViewById(R.id.editTextUbicacion);
        precioEdit = findViewById(R.id.editTextPrecio);
        detalleEdit = findViewById(R.id.editTextDetalle);
        borrarButton = findViewById(R.id.borrarButton);
    }

    private void llenarSpinners() {
        CategoriasDbo dbo = new CategoriasDbo(this);

        condicionesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, CondicionAnuncio.values());
        condicionSpinner.setAdapter(condicionesAdapter);

        categoriasAdapter = new CategoriasListAdapter(this, dbo.listar(),true); //ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dbo.listar());
        categoriaSpinner.setAdapter(categoriasAdapter);
    }
}
