package com.usmp.proyectofinalandroid.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.usmp.proyectofinalandroid.R;
import com.usmp.proyectofinalandroid.entidades.Pedido;

import java.util.ArrayList;

public class AdaptadorPedido extends BaseAdapter {

    Activity activity;
    ArrayList<Pedido> listaPedido;

    public AdaptadorPedido(Activity activity,ArrayList<Pedido> listaPedido){
        this.activity= activity;
        this.listaPedido= listaPedido;
    }

    @Override
    public int getCount() {
        return listaPedido.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPedido.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v=convertView;
        TextView txtCodigo, txtNom, txtIngre, txtAd, txtPre;
        ImageView imgCelular;
        if (v==null){
            LayoutInflater inflater= (LayoutInflater)activity.getLayoutInflater();
            v=inflater.inflate(R.layout.lyt_item_pedido,null);
        }
        txtCodigo=v.findViewById(R.id.txtCodigoD);
        txtNom=v.findViewById(R.id.txtNomD);
        txtIngre=v.findViewById(R.id.txtIngreD);
        txtAd=v.findViewById(R.id.txtAdD);
        txtPre=v.findViewById(R.id.txtPreD);
        imgCelular=v.findViewById(R.id.imgPizzaD);
        Pedido p=listaPedido.get(position);
        txtCodigo.setText("Código: "+p.getCodigo());
        txtNom.setText("Pizza: "+p.getNombre());
        txtIngre.setText("Ingredientes: "+p.getIngredientes());
        txtAd.setText("Adicionales: "+p.getAdicional());
        txtPre.setText("S/."+p.getPrecio());
        imgCelular.setImageResource(p.getIdImagen());
        return v;
    }
}
