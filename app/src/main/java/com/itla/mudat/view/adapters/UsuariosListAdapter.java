package com.itla.mudat.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.entity.Usuario;

import java.util.List;

/**
 * Created by Frandy Javier AP on 12/2/2017.
 */

public class UsuariosListAdapter extends BaseAdapter {
    private List<Usuario> usuarios;
    private Activity context;

    public UsuariosListAdapter(Activity context, List<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public long getItemId(int position) {
        return usuarios.get(position).getId();
    }

    @Override
    public Object getItem(int position) {
        return usuarios.get(position);
    }

    public String getItemNombre(int position) {
        return usuarios.get(position).getNombre();
    }

    public String getItemIdentificacion(int position) {
        return usuarios.get(position).getIdentificacion().toString();
    }

    public String getItemMail(int position) {
        return usuarios.get(position).getEmail();
    }

    public String getItemTelefono(int position) {
        return usuarios.get(position).getTelefono();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = View.inflate(context.getApplicationContext(), R.layout.item_usuarios, null);
        }

        TextView identificacion = view.findViewById(R.id.itemIdentifiacion);
        TextView nombre =  view.findViewById(R.id.itemNombre);
        TextView email =  view.findViewById(R.id.itemEmail);
        TextView telefono =  view.findViewById(R.id.itemTelefono);

        identificacion.setText("Identificacion: " +  getItemIdentificacion(position));
        nombre.setText("Nombre: " + getItemNombre(position));
        email.setText("Email: " + getItemMail(position));
        telefono.setText("Telefono: " + getItemTelefono(position));

        return view;
    }
}