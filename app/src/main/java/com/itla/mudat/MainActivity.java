package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.itla.mudat.dao.AnunciosDbo;
import com.itla.mudat.dao.UsuariosDbo;
import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.Usuario;
import com.itla.mudat.entity.Utils;
import com.itla.mudat.view.adapters.AnunciosListAdapter;

public class MainActivity extends AppCompatActivity {

    public static Usuario usuarioActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setElevation(0);
        buscarDatos();

        UsuariosDbo dbo = new UsuariosDbo(this);

        for (Usuario x : dbo.listar()) {
            Log.i("Usuarios Mudat", x.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.


        if(MainActivity.usuarioActual != null){
            getMenuInflater().inflate(R.menu.menu_login, menu);//Menu Resource, Menu
        }else{
            getMenuInflater().inflate(R.menu.menu_logout, menu);//Menu Resource, Menu
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_cerrarSesion:

                Utils.guardarPreferencia(this,Utils.LOGIN_ID,null);
                Utils.guardarPreferencia(this,Utils.LOGIN_NAME,null);
                MainActivity.usuarioActual = null;
                return true;
            case R.id.menu_iniciarSesion:
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void buscarDatos() {
        AnunciosDbo db = new AnunciosDbo(this);
        ListView list = findViewById(R.id.listviewDatos);
        AnunciosListAdapter adaptador = new AnunciosListAdapter(this, db.listar());
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Anuncio anuncio = ((Anuncio) arg0.getItemAtPosition(position));
                Intent i = new Intent(MainActivity.this, DetalleAnuncioActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable(Anuncio.class.getSimpleName(), anuncio);

                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        buscarDatos();
    }

    public static boolean validarEntry(EditText entry) {
        if (entry.getText().length() <= 0) {
            entry.setError("Valor obligatorio");
            return false;
        }

        return true;
    }

    public void crearAnuncioClick(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
