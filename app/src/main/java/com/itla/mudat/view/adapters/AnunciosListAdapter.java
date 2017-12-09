package com.itla.mudat.view.adapters;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.entity.Anuncio;
import com.itla.mudat.entity.Categoria;

import java.util.List;

/**
 * Created by Frandy Javier AP on 12/8/2017.
 */

public class AnunciosListAdapter extends BaseAdapter {
    private List<Anuncio> listado;
    private Activity context;

    public AnunciosListAdapter(Activity context, List<Anuncio> anuncios) {
        this.context = context;
        this.listado = anuncios;
    }

    @Override
    public int getCount() {
        return listado.size();
    }

    @Override
    public long getItemId(int position) {
        return listado.get(position).getId();
    }

    @Override
    public Object getItem(int position) {
        return listado.get(position);
    }

    public String getItemFecha(int position) {
        return listado.get(position).getFecha();
    }

    public String getItemTitulo(int position) {
        return listado.get(position).getTitulo();
    }

    public String getItemCategoria(int position) {
        return listado.get(position).getCategoria().getDescripcion();
    }

    public String getItemPrecio(int position) {
        return listado.get(position).getPrecio().toString();
    }

    public String getItemCondicion(int position) {
        return listado.get(position).getCondicion();
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = View.inflate(context.getApplicationContext(), R.layout.item_anuncios, null);
        }

        TextView fecha = view.findViewById(R.id.itemFecha);
        TextView titulo = view.findViewById(R.id.itemTitulo);
        TextView categoria = view.findViewById(R.id.itemCategoria);
        TextView precio = view.findViewById(R.id.itemPrecio);
        TextView condicion = view.findViewById(R.id.itemCondicion);

        fecha.setText(getItemFecha(position));
        titulo.setText(getItemTitulo(position));
        categoria.setText(getItemCategoria(position));
        precio.setText("Precio: $" + getItemPrecio(position));
        condicion.setText(getItemCondicion(position));

        return view;
    }

    public int getPosition(@Nullable Categoria item) {
        return listado.indexOf(item);
    }
}