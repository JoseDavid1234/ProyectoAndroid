package com.usmp.proyectofinalandroid.modelos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.usmp.proyectofinalandroid.entidades.Cliente;
import com.usmp.proyectofinalandroid.entidades.Pedido;
import com.usmp.proyectofinalandroid.util.BDPrincipal;
import com.usmp.proyectofinalandroid.util.Constantes;

import java.util.ArrayList;

public class DAOCliente {

    BDPrincipal bdPrincipal;
    SQLiteDatabase database;

    public DAOCliente(Context context){
        bdPrincipal=new BDPrincipal(context);
    }

    public void openBD(){
        database=bdPrincipal.getWritableDatabase();
    }

    public void close(){
        bdPrincipal.close();
        database.close();
    }

    public void registrarCliente(Cliente cli){
        try{
            ContentValues values =new ContentValues();

            values.put("codigoImagen",cli.getCodigoImagen());
            values.put("edad",cli.getEdad());
            values.put("apellidoMa",cli.getApellidoMa());
            values.put("apellidoPa",cli.getApellidoPa());
            values.put("usuario",cli.getUsuario());
            values.put("contra",cli.getContra());
            values.put("genero",cli.getGenero());
            values.put("fechaNac",cli.getFechaNac());
            values.put("tipoP",cli.getTipoP());
            values.put("nombre",cli.getNombre());

            database.insert(Constantes.NOMBRETABLACLIENTE,null,values);
        }catch (Exception e){

        }
    }

    public void editarCliente(Cliente cli){
        try{
            ContentValues values =new ContentValues();

            values.put("codigoImagen",cli.getCodigoImagen());
            values.put("edad",cli.getEdad());
            values.put("apellidoMa",cli.getApellidoMa());
            values.put("apellidoPa",cli.getApellidoPa());
            values.put("usuario",cli.getUsuario());
            values.put("contra",cli.getContra());
            values.put("genero",cli.getGenero());
            values.put("fechaNac",cli.getFechaNac());
            values.put("tipoP",cli.getTipoP());
            values.put("nombre",cli.getNombre());

            database.update(Constantes.NOMBRETABLACLIENTE,values,"id="+cli.getId(),null);
        }catch (Exception e){
        }
    }

    public void eliminarCliente(int id){
        try{
            database.delete(Constantes.NOMBRETABLACLIENTE,"id="+id,null);
        }catch (Exception e){
        }
    }

    public ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> listaCli=new ArrayList<>();
        try{
            Cursor c=database.rawQuery("select * from "+Constantes.NOMBRETABLACLIENTE,null);
            while(c.moveToNext()){

                Cliente cliente=new Cliente();
                cliente.setId(c.getInt(0));
                cliente.setEdad(c.getInt(1));
                cliente.setCodigoImagen(c.getInt(2));
                cliente.setNombre(c.getString(3));
                cliente.setApellidoMa(c.getString(4));
                cliente.setApellidoPa(c.getString(5));
                cliente.setUsuario(c.getString(6));
                cliente.setGenero(c.getString(7));
                cliente.setFechaNac(c.getString(8));
                cliente.setTipoP(c.getString(9));
                cliente.setContra(c.getString(10));
                listaCli.add(cliente);
            }
        }catch (Exception e){
        }
        return listaCli;
    }


}
