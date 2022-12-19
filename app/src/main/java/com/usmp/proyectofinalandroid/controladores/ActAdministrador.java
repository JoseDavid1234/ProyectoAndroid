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
import com.usmp.proyectofinalandroid.databinding.LytAdministradorBinding;
import com.usmp.proyectofinalandroid.fragmentosAdministrador.FragIniAdmin;
import com.usmp.proyectofinalandroid.fragmentosAdministrador.FragLisCliAdmin;
import com.usmp.proyectofinalandroid.fragmentosAdministrador.FragReglasAdmin;

public class ActAdministrador extends AppCompatActivity {

    private LytAdministradorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=LytAdministradorBinding.inflate(this.getLayoutInflater());
        this.setContentView(binding.getRoot());
        this.reemplazarFragmento(new FragIniAdmin());

        binding.navBarBottomAdmin.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.ms_inicio_admin:reemplazarFragmento(new FragIniAdmin());break;
                case R.id.ms_reglas_admin:reemplazarFragmento(new FragReglasAdmin());break;
                case R.id.ms_clientes_admin:reemplazarFragmento(new FragLisCliAdmin());break;
            }
            return true;
        });

        binding.navBarBottomAdmin.setOnItemReselectedListener(item -> {
            Toast.makeText(this.getApplicationContext(), "Ya estás en "+item.getTitle(), Toast.LENGTH_LONG).show();
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_simple_admin,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, ActPrincipal.class);
        this.startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    private void reemplazarFragmento(Fragment fragment){
        FragmentManager manager=this.getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.frameLayoutAdmin,fragment);
        transaction.commit();
    }
}