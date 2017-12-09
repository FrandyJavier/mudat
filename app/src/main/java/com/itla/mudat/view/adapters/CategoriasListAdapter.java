package com.itla.mudat.view.adapters;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.R;
import com.itla.mudat.entity.Categoria;

import java.util.List;

/**
 * Created by Frandy Javier AP on 12/2/2017.
 */

public class CategoriasListAdapter  extends BaseAdapter {
    private List<Categoria> categorias;
    private Activity context;
    private Boolean esSpinner;

    public CategoriasListAdapter(Activity context, List<Categoria> categorias,Boolean esSpinner) {
        this.context = context;
        this.categorias = categorias;
        this.esSpinner = esSpinner;
    }

    @Override
    public int getCount() {
        return categorias.size();
    }

    @Override
    public long getItemId(int position) {
        return categorias.get(position).getId();
    }

    @Override
    public Object getItem(int position) {
        return categorias.get(position);
    }

    public String getItemNombre(int position) {
        return categorias.get(position).getDescripcion();
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = View.inflate(context.getApplicationContext(), R.layout.item_categorias, null);
        }

        TextView descripcion =  view.findViewById(R.id.itemDescripcion);
        descripcion.setText(getItemNombre(position));

        if(esSpinner){
            TextView itemNombre =  view.findViewById(R.id.itemNombre);
            TextView tv_signal =  view.findViewById(R.id.itemSignal);

            itemNombre.setVisibility(View.GONE);
            tv_signal.setVisibility(View.GONE);
        }

        return view;
    }

    public int getPosition(@Nullable Categoria item) {
        return categorias.indexOf(item);
    }
}