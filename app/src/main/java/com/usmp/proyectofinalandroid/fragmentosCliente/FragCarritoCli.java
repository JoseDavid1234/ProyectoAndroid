package com.usmp.proyectofinalandroid.fragmentosCliente;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.usmp.proyectofinalandroid.R;
import com.usmp.proyectofinalandroid.adaptadores.AdaptadorPedido;
import com.usmp.proyectofinalandroid.adaptadores.AdaptadorPizza;
import com.usmp.proyectofinalandroid.dialogos.DialogoAlerta;
import com.usmp.proyectofinalandroid.entidades.Pedido;
import com.usmp.proyectofinalandroid.entidades.Pizza;
import com.usmp.proyectofinalandroid.modelos.DAOPedido;

import java.util.ArrayList;

public class FragCarritoCli extends Fragment {


    ListView listaVista;
    int idCli;
    ArrayList<Pedido> listaPedidos;
    DAOPedido daoPedido;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater,container,savedInstanceState);
        daoPedido=new DAOPedido(this.getActivity());
        daoPedido.openBD();
        View vistaNueva=inflater.inflate(R.layout.lyt_frag_carrito_cli,container,false);
        idCli=this.getActivity().getIntent().getIntExtra("idCli",0);

        listaVista = vistaNueva.findViewById(R.id.listaCarritoCli);

        return vistaNueva;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listaPedidos= daoPedido.getPedidos(idCli);

        listaVista.setAdapter(new AdaptadorPedido(this.getActivity(),listaPedidos));
        listaVista.setOnItemClickListener((parent, view1, position, id) -> {

            int idPed=listaPedidos.get(position).getId();

            FragmentManager fm=this.getActivity().getSupportFragmentManager();
            DialogoAlerta dialogo=new DialogoAlerta(idPed);
            dialogo.show(fm,"tagDialogo");

        });

    }
}