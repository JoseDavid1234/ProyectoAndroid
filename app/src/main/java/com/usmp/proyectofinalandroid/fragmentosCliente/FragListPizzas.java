package com.usmp.proyectofinalandroid.fragmentosCliente;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.usmp.proyectofinalandroid.R;
import com.usmp.proyectofinalandroid.adaptadores.AdaptadorPedido;
import com.usmp.proyectofinalandroid.adaptadores.AdaptadorPizza;
import com.usmp.proyectofinalandroid.entidades.Pedido;
import com.usmp.proyectofinalandroid.entidades.Pizza;
import com.usmp.proyectofinalandroid.modelos.DAOPedido;

import java.util.ArrayList;

public class FragListPizzas extends Fragment {

    ListView listaVista;
    int idCli;
    ArrayList<Pizza> listaPizzas;
    DAOPedido daoPedido;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater,container,savedInstanceState);
        daoPedido=new DAOPedido(this.getActivity());
        daoPedido.openBD();
        View vistaNueva=inflater.inflate(R.layout.lyt_frag_list_ped,container,false);

        listaPizzas=new ArrayList<>();

        //llenar lista de pizzas
        Pizza pizza1=new Pizza();
        pizza1.setIdImagen(R.drawable.americana);
        pizza1.setAdicional("Oregano");
        pizza1.setCodigo(1);
        pizza1.setIngredientes("Queso y Jamón");
        pizza1.setPrecio(20.5);
        pizza1.setNombre("Americana");
        Pizza pizza2=new Pizza();
        pizza2.setIdImagen(R.drawable.hawaiana);
        pizza2.setAdicional("Oregano");
        pizza2.setCodigo(2);
        pizza2.setIngredientes("Piña, Queso y Jamón");
        pizza2.setPrecio(22.5);
        pizza2.setNombre("Hawaiana");
        Pizza pizza3=new Pizza();
        pizza3.setIdImagen(R.drawable.meatlover);
        pizza3.setAdicional("Aji Panca");
        pizza3.setCodigo(3);
        pizza3.setIngredientes("Chorizo y Queso");
        pizza3.setPrecio(25.5);
        pizza3.setNombre("Meat Lover");
        Pizza pizza4=new Pizza();
        pizza4.setIdImagen(R.drawable.pepperoni);
        pizza4.setAdicional("Orégano");
        pizza4.setCodigo(4);
        pizza4.setIngredientes("Pepperoni y queso");
        pizza4.setPrecio(27.5);
        pizza4.setNombre("Pepperoni");

        listaPizzas.add(pizza1);
        listaPizzas.add(pizza2);
        listaPizzas.add(pizza3);
        listaPizzas.add(pizza4);


        listaVista = vistaNueva.findViewById(R.id.listaPizzasCli);
        listaVista.setAdapter(new AdaptadorPizza(this.getActivity(),listaPizzas));
        idCli=this.getActivity().getIntent().getIntExtra("idCli",0);
        return vistaNueva;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listaVista.setOnItemClickListener((parent, view1, position, id) -> {
            Pizza pizza=listaPizzas.get(position);
            Pedido pedido=new Pedido();
            pedido.setAdicional(pizza.getAdicional());
            pedido.setIngredientes(pizza.getIngredientes());
            pedido.setPrecio(pizza.getPrecio());
            pedido.setNombre(pizza.getNombre());
            pedido.setCodigo(pizza.getCodigo());
            pedido.setIdImagen(pizza.getIdImagen());
            pedido.setIdCli(idCli);

            daoPedido.registrarPedido(pedido);

            Toast.makeText(this.getActivity(), "El producto se añadió a su carrito", Toast.LENGTH_SHORT).show();
        });

    }
}