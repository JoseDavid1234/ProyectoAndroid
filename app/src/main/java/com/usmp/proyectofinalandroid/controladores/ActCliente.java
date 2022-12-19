package com.usmp.proyectofinalandroid.controladores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.usmp.proyectofinalandroid.R;
import com.usmp.proyectofinalandroid.fragmentosCliente.FragCarritoCli;
import com.usmp.proyectofinalandroid.fragmentosCliente.FragIniCli;
import com.usmp.proyectofinalandroid.fragmentosCliente.FragListPizzas;
import com.usmp.proyectofinalandroid.fragmentosCliente.FragPagoCli;

public class ActCliente extends AppCompatActivity {

    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_cliente);
        this.reemplazarFragmento(new FragIniCli());
        bnv=this.findViewById(R.id.navBarBottomCliente);
        bnv.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.ms_inicio_cliente:
                    reemplazarFragmento(new FragIniCli());
                    break;
                case R.id.ms_lista_pizzas:
                    reemplazarFragmento(new FragListPizzas());
                    break;
                case R.id.ms_carrito_cliente:
                    reemplazarFragmento(new FragCarritoCli());
                    break;
                case R.id.ms_pago_cliente:
                    reemplazarFragmento(new FragPagoCli());
                    break;
            }
            return true;
        });
    }

    private void reemplazarFragmento(Fragment fragment){
        FragmentManager fm=this.getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frameLayoutCliente,fragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_simple_cliente,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, ActPrincipal.class);
        this.startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}