package com.usmp.proyectofinalandroid.fragmentosAdministrador;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.usmp.proyectofinalandroid.controladores.ActPedidosXCliente;
import com.usmp.proyectofinalandroid.controladores.ActVistaModificar;
import com.usmp.proyectofinalandroid.entidades.Cliente;
import com.usmp.proyectofinalandroid.R;
import com.usmp.proyectofinalandroid.modelos.DAOCliente;
import com.usmp.proyectofinalandroid.modelos.DAOPedido;

import java.util.ArrayList;

public class FragLisCliAdmin extends Fragment {

    ListView listaVistaClientes;
    ArrayList<String> clientesNombres;
    ArrayList<Cliente> clientesDatos;
    DAOCliente daoCliente;
    DAOPedido daoPedido;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.lyt_frag_clientes_admin, container, false);
        listaVistaClientes= view.findViewById(R.id.listViewClientes);
        this.registerForContextMenu(listaVistaClientes);
        daoCliente=new DAOCliente(this.getActivity());
        daoPedido=new DAOPedido(this.getActivity());
        daoCliente.openBD();
        daoPedido.openBD();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listarClientes();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=this.getActivity().getMenuInflater();

        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(listaVistaClientes.getAdapter().getItem(info.position).toString());
        inflater.inflate(R.menu.mc_lista_clientes,menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.mc_modificar:
                Intent intent=new Intent(this.getActivity(), ActVistaModificar.class);
                Bundle bundle=new Bundle();
                bundle.putInt("posMod",clientesDatos.get(info.position).getId());
                intent.putExtras(bundle);
                this.getActivity().startActivity(intent);
                break;
            case R.id.mc_eliminar:
                daoCliente.eliminarCliente(clientesDatos.get(info.position).getId());
                daoPedido.eliminarPedidoXCliente(clientesDatos.get(info.position).getId());
                Toast.makeText(this.getActivity(), "Cliente eliminado", Toast.LENGTH_SHORT).show();
                listarClientes();
                break;
            case R.id.mc_pedidos:
                Intent intent1=new Intent(this.getActivity(), ActPedidosXCliente.class);
                intent1.putExtra("idCli",clientesDatos.get(info.position).getId());
                this.getActivity().startActivity(intent1);
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void listarClientes(){
        clientesDatos=daoCliente.getClientes();
        clientesNombres=new ArrayList<>();
        for (Cliente c:
                clientesDatos) {
            clientesNombres.add(c.getNombre()+" "+c.getId());
        }
        ArrayAdapter adapter=new ArrayAdapter(this.getActivity(), android.R.layout.simple_list_item_1,clientesNombres);
        listaVistaClientes.setAdapter(adapter);
    }
}