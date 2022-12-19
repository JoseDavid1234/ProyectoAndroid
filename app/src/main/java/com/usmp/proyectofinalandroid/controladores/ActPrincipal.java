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
import android.widget.Toast;

import com.usmp.proyectofinalandroid.R;
import com.usmp.proyectofinalandroid.databinding.LytPrincipalBinding;
import com.usmp.proyectofinalandroid.fragmentosPrincipal.*;

public class ActPrincipal extends AppCompatActivity {

    private LytPrincipalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=LytPrincipalBinding.inflate(this.getLayoutInflater());
        this.setContentView(binding.getRoot());
        this.reemplazarFragmento(new FragmentoInicio());

        binding.navBarBottom.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.inicio:reemplazarFragmento(new FragmentoInicio());break;
                case R.id.nosotros:reemplazarFragmento(new FragmentoNosotros());break;
                case R.id.pizzas:reemplazarFragmento(new FragmentoPizzas());break;
            }
            return true;
        });
        binding.navBarBottom.setOnItemReselectedListener(item -> {
            Toast.makeText(this.getApplicationContext(), "Ya estás en "+item.getTitle(), Toast.LENGTH_LONG).show();
        });
    }

    private void reemplazarFragmento(Fragment fragment){
        FragmentManager manager=this.getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_simple,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent=null;
        switch (item.getItemId()){
            case R.id.ms_ingresar:
                intent=new Intent(this, ActVistaIngresar.class);
                break;
            case R.id.ms_registrar:
                intent=new Intent(this, ActVistaRegistrar.class);
                break;
        }
        this.startActivity(intent);
        return true;
    }

}