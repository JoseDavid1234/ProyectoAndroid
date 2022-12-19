package com.usmp.proyectofinalandroid.controladores;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.usmp.proyectofinalandroid.entidades.Cliente;
import com.usmp.proyectofinalandroid.R;
import com.usmp.proyectofinalandroid.modelos.DAOCliente;

import java.util.ArrayList;

public class ActVistaIngresar extends AppCompatActivity {

    ArrayList<Cliente> listaClientes;
    EditText edtUsuario,edtContra;
    DAOCliente daoCliente;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.lyt_vista_ingresar);
        daoCliente=new DAOCliente(this);
        daoCliente.openBD();
        listaClientes=daoCliente.getClientes();

        edtContra=this.findViewById(R.id.edtContra1);
        edtUsuario=this.findViewById(R.id.edtUsuario1);

        Button botonIngresar=this.findViewById(R.id.btnIngresar);
        botonIngresar.setOnClickListener(v->{

            String usuario=edtUsuario.getText().toString();
            String contra=edtContra.getText().toString();

            boolean flag=false;
            int idCli=0;
            for(Cliente c:listaClientes){
                if(c.getUsuario().equals(usuario) && c.getContra().equals(contra)){
                    flag=true;
                    idCli=c.getId();
                    break;
                }
            }

            if(flag){
                Toast.makeText(this, "¡Cliente validado!", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(this,ActCliente.class);
                intent.putExtra("idCli",idCli);
                this.startActivity(intent);
            }else{
                if(usuario.equalsIgnoreCase("admin")&&contra.equalsIgnoreCase("123")){
                    Intent intent = new Intent(this, ActAdministrador.class);
                    this.startActivity(intent);
                }else{
                    Toast.makeText(this, "Cliente no válido", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button botonRegresar=this.findViewById(R.id.btnRegresar);
        botonRegresar.setOnClickListener(v->{
            Intent intent=new Intent(this, ActPrincipal.class);
            this.startActivity(intent);
        });
    }

}