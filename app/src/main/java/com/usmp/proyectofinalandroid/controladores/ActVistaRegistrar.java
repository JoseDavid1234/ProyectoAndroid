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

public class ActVistaRegistrar extends AppCompatActivity {

    EditText edtNombre,edtApellidoPa,edtApellidoMa,edtUsuario,edtContra,edtEdad,edtFechaNac;
    Spinner sprTipo;
    RadioButton radioM,radioF;
    String tipo[]= {"TARJETA","EFECTIVO"};
    DAOCliente daoCliente=new DAOCliente(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.lyt_vista_registrar);
        daoCliente.openBD();

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


        Button botonRegistrar=this.findViewById(R.id.btnModificarCliente);
        botonRegistrar.setOnClickListener(v->{
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
            cliente.setCodigoImagen(R.drawable.americana);
            if(Integer.parseInt(edtEdad.getText().toString())<18){
                Toast.makeText(this, "Menor de edad", Toast.LENGTH_LONG).show();
            }else{
                daoCliente.registrarCliente(cliente);
                Toast.makeText(this, "¡Cliente registrado exitosamente!", Toast.LENGTH_LONG).show();
                limpiar();
            }

        });

        Button botonRegresar=this.findViewById(R.id.btnCancelarM);
        botonRegresar.setOnClickListener(v->{
            Intent intent1=new Intent(this, ActPrincipal.class);
            this.startActivity(intent1);
        });
    }

    public void limpiar(){
        edtNombre.setText("");
        edtApellidoPa.setText("");
        edtApellidoMa.setText("");
        edtUsuario.setText("");
        edtContra.setText("");
        edtEdad.setText("");
        edtFechaNac.setText("");
        sprTipo.setSelection(0);
        radioF.setChecked(false);
        radioM.setChecked(false);
    }

}
