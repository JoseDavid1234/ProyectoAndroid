package com.usmp.proyectofinalandroid.controladores;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.usmp.proyectofinalandroid.R;
import com.usmp.proyectofinalandroid.entidades.Pedido;
import com.usmp.proyectofinalandroid.fragmentosAdministrador.FragmentoDetalle;
import com.usmp.proyectofinalandroid.fragmentosAdministrador.FragmentoLista;


public class ActPedidosXCliente extends AppCompatActivity {
    FragmentoLista fragLista;
    FragmentoDetalle fragDetalle;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_pedidos_x_cliente);
        asignarReferencias();
        btnRegresar.setOnClickListener(v -> {
            Intent intent=new Intent(this,ActAdministrador.class);
            this.startActivity(intent);
        });

    }

    private void asignarReferencias() {
        fragLista= (FragmentoLista) this.getSupportFragmentManager().findFragmentById(R.id.fragLista);
        fragDetalle= (FragmentoDetalle) this.getSupportFragmentManager().findFragmentById(R.id.fragDetalle);
        btnRegresar=this.findViewById(R.id.btnRegresarPed);
    }

    public void seleccionarPedido(Pedido pedido) {
        fragDetalle.mostrarDatos(pedido);
    }
}
