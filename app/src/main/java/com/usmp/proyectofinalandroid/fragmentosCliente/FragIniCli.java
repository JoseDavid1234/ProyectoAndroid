package com.usmp.proyectofinalandroid.fragmentosCliente;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.usmp.proyectofinalandroid.R;
import com.usmp.proyectofinalandroid.entidades.Cliente;
import com.usmp.proyectofinalandroid.modelos.DAOCliente;

import java.util.ArrayList;

public class FragIniCli extends Fragment {

    int idCli;
    TextView txtBienvenidos;
    DAOCliente daoCliente;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.lyt_frag_ini_cli, container, false);
        idCli=this.getActivity().getIntent().getIntExtra("idCli",0);
        txtBienvenidos=view.findViewById(R.id.txtBienvenidos);
        daoCliente=new DAOCliente(this.getActivity());
        daoCliente.openBD();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Cliente> clientes=daoCliente.getClientes();
        String nombre="";
        for (Cliente c:
             clientes) {
            if(c.getId()==idCli){
                nombre=c.getNombre();
            }
        }
        txtBienvenidos.setText("¡Bienvenido " + nombre +"!");
    }
}