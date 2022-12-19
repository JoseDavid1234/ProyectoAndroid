package com.usmp.proyectofinalandroid.fragmentosAdministrador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.usmp.proyectofinalandroid.R;
import com.usmp.proyectofinalandroid.entidades.Pedido;

public class FragmentoDetalle extends Fragment {
    TextView txtNom,txtIn,txtAdi,txtPre,txtCod;
    ImageView imgFoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.lyt_detalle_ped_x_cli,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtNom=view.findViewById(R.id.txtNom);
        txtIn=view.findViewById(R.id.txtIngredientes);
        txtAdi=view.findViewById(R.id.txtAdicional);
        txtPre=view.findViewById(R.id.txtPrecio);
        txtCod=view.findViewById(R.id.txtCodigo);
        imgFoto=view.findViewById(R.id.imgFoto);
    }

    public void mostrarDatos(Pedido pedido){
        txtNom.setText(pedido.getNombre());
        txtIn.setText(pedido.getIngredientes());
        txtAdi.setText(pedido.getAdicional());
        txtPre.setText(pedido.getPrecio()+"");
        txtCod.setText(pedido.getCodigo()+"");
        imgFoto.setImageResource(pedido.getIdImagen());
    }

}
