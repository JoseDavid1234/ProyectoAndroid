package com.usmp.proyectofinalandroid.controladores;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.usmp.proyectofinalandroid.entidades.Cliente;
import com.usmp.proyectofinalandroid.R;
import com.usmp.proyectofinalandroid.modelos.DAOCliente;

import java.util.ArrayList;

public class ActVistaModificar extends AppCompatActivity {

    EditText edtNombre,edtApellidoPa,edtApellidoMa,edtUsuario,edtContra,edtEdad,edtFechaNac;
    Spinner sprTipo;
    RadioButton radioM,radioF;
    String tipo[]= {"TARJETA","EFECTIVO"};
    DAOCliente daoCliente=new DAOCliente(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.lyt_vista_modificar);
        daoCliente.openBD();

        Bundle bundle=this.getIntent().getExtras();

        int posMod=bundle.getInt("posMod");

        edtNombre=this.findViewById(R.id.edtNombreM);
        edtApellidoMa=this.findViewById(R.id.edtApellidoMaM);
        edtApellidoPa=this.findViewById(R.id.edtApellidoPaM);
        edtContra=this.findViewById(R.id.edtContraM);
        edtEdad=this.findViewById(R.id.edtEdadM);
        edtUsuario=this.findViewById(R.id.edtUsuarioM);
        radioF=this.findViewById(R.id.radioFemeninoM);
        radioM=this.findViewById(R.id.radioMasculinoM);
        edtFechaNac= this.findViewById(R.id.edtFechaNacimientoM);
        sprTipo= this.findViewById(R.id.spnTipoPM);

        ArrayAdapter adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tipo);
        sprTipo.setAdapter(adapter);

        Cliente clienteAnt=null;
        ArrayList<Cliente> listaCli=daoCliente.getClientes();
        for(Cliente c: listaCli){
            if(c.getId()==posMod){
                clienteAnt=c;
            }
        }

        edtNombre.setText(clienteAnt.getNombre());
        edtApellidoMa.setText(clienteAnt.getApellidoMa());
        edtApellidoPa.setText(clienteAnt.getApellidoPa());
        edtContra.setText(clienteAnt.getContra());
        edtEdad.setText(clienteAnt.getEdad()+"");
        edtUsuario.setText(clienteAnt.getUsuario());
        edtFechaNac.setText(clienteAnt.getFechaNac());
        if(radioF.isChecked()){
            radioF.setChecked(true);
        }else{
            radioM.setChecked(true);
        }
        if(clienteAnt.getTipoP().equalsIgnoreCase("TARJETA")){
            sprTipo.setSelection(0);
        }else{
            sprTipo.setSelection(1);
        }

        Button botonModificar=this.findViewById(R.id.btnModificarCliente);
        botonModificar.setOnClickListener(v->{
            Cliente cliente=new Cliente();

            cliente.setNombre(edtNombre.getText().toString());
            cliente.setApellidoMa(edtApellidoMa.getText().toString());
            cliente.setApellidoPa(edtApellidoPa.getText().toString());
            cliente.setUsuario(edtUsuario.getText().toString());
            cliente.setContra(edtContra.getText().toString());
            cliente.setEdad(Integer.parseInt(edtEdad.getText().toString()));
            cliente.setFechaNac(edtFechaNac.getText().toString());
            cliente.setTipoP(sprTipo.getSelectedItem().toString());
            if(radioF.isChecked()){
                cliente.setGenero("Femenino");
                //cliente.setCodigoImagen();
            }else{
                cliente.setGenero("Masculino");
                //cliente.setCodigoImagen();
            }

            cliente.setId(posMod);

            daoCliente.editarCliente(cliente);

            Toast.makeText(this, "¡Cliente modificado exitosamente!", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this, ActAdministrador.class);
            this.startActivity(intent);
        });

        Button botonCancelar=this.findViewById(R.id.btnCancelarM);
        botonCancelar.setOnClickListener(v->{
            Intent intent=new Intent(this,ActAdministrador.class);
            this.startActivity(intent);
        });
    }

}