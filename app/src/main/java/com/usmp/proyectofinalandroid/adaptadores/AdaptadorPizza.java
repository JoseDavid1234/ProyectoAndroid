package com.usmp.proyectofinalandroid.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.usmp.proyectofinalandroid.entidades.Pizza;
import com.usmp.proyectofinalandroid.R;

import java.util.ArrayList;

public class AdaptadorPizza extends BaseAdapter {
    Activity activity;
    ArrayList<Pizza> listaPizza;

    public AdaptadorPizza(Activity activity,ArrayList<Pizza> listaPizza){
        this.activity= activity;
        this.listaPizza= listaPizza;
    }

    @Override
    public int getCount() {
        return listaPizza.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPizza.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v;
        TextView txtCodigo, txtNom, txtIngre, txtAdicional, txtPrecio;
        ImageView imgPizza;
        if (position%2==0){
            LayoutInflater inflater= (LayoutInflater)activity.getLayoutInflater();
            v=inflater.inflate(R.layout.lyt_item_pizza_iz,null);
            txtCodigo=v.findViewById(R.id.txtCodigoD);
            txtNom=v.findViewById(R.id.txtNomD);
            txtIngre=v.findViewById(R.id.txtIngreD);
            txtAdicional=v.findViewById(R.id.txtAdD);
            txtPrecio=v.findViewById(R.id.txtPreD);
            imgPizza=v.findViewById(R.id.imgPizzaD);
        }else{
            LayoutInflater inflater= (LayoutInflater)activity.getLayoutInflater();
            v=inflater.inflate(R.layout.lyt_item_pizza_der,null);
            txtCodigo=v.findViewById(R.id.txtCodigoD);
            txtNom=v.findViewById(R.id.txtNomD);
            txtIngre=v.findViewById(R.id.txtIngreD);
            txtAdicional=v.findViewById(R.id.txtAdD);
            txtPrecio=v.findViewById(R.id.txtPreD);
            imgPizza=v.findViewById(R.id.imgPizzaD);
        }

        Pizza p=listaPizza.get(position);
        txtCodigo.setText("Código: "+p.getCodigo());
        txtNom.setText("Pizza: "+p.getNombre());
        txtIngre.setText("Ingredientes: "+p.getIngredientes());
        txtAdicional.setText("Adicionales: "+p.getAdicional());
        txtPrecio.setText("S/."+p.getPrecio());
        imgPizza.setImageResource(p.getIdImagen());
        return v;
    }
}
