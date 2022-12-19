package com.usmp.proyectofinalandroid.fragmentosAdministrador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.usmp.proyectofinalandroid.R;
import com.usmp.proyectofinalandroid.controladores.ActPedidosXCliente;
import com.usmp.proyectofinalandroid.entidades.Pedido;
import com.usmp.proyectofinalandroid.modelos.DAOPedido;

import java.util.ArrayList;

public class FragmentoLista extends Fragment {
    ArrayList<Pedido> listaPedidos;
    ListView listaVistaPersona;
    int idCli;
    DAOPedido daoPedido;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.lyt_lista_ped_x_cli,null);
        idCli=this.getActivity().getIntent().getIntExtra("idCli",0);
        daoPedido=new DAOPedido(this.getActivity());
        daoPedido.openBD();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        listaVistaPersona = v.findViewById(R.id.lvPedidosXCliente);
        listaPedidos=daoPedido.getPedidos(idCli);

        ArrayList<String> nombres=new ArrayList<>();
        for(Pedido p:listaPedidos){
            nombres.add(p.getNombre());
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1,nombres);
        listaVistaPersona.setAdapter(adapter);
        listaVistaPersona.setOnItemClickListener((parent, view, position, id) -> {
            ActPedidosXCliente act= (ActPedidosXCliente) this.getActivity();
            act.seleccionarPedido(listaPedidos.get(position));
        });
    }
}
