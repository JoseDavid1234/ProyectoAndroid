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

public class DAOPedido {
    BDPrincipal bdPrincipal;
    SQLiteDatabase database;

    public DAOPedido(Context context){
        bdPrincipal=new BDPrincipal(context);
    }

    public void openBD(){
        database=bdPrincipal.getWritableDatabase();
    }

    public void close(){
        bdPrincipal.close();
        database.close();
    }

    public void registrarPedido(Pedido pe){
        try{
            ContentValues values =new ContentValues();
            values.put("codigo",pe.getCodigo());
            values.put("idCli",pe.getIdCli());
            values.put("idImagen",pe.getIdImagen());
            values.put("precio",pe.getPrecio());
            values.put("nombre",pe.getNombre());
            values.put("ingredientes",pe.getIngredientes());
            values.put("adicional",pe.getAdicional());

            database.insert(Constantes.NOMBRETABLAPEDIDO,null,values);
        }catch (Exception e){

        }
    }

    public void editarPedido(Pedido pe){
        try{
            ContentValues values =new ContentValues();
            values.put("codigo",pe.getCodigo());
            values.put("idCli",pe.getIdCli());
            values.put("idImagen",pe.getIdImagen());
            values.put("precio",pe.getPrecio());
            values.put("nombre",pe.getNombre());
            values.put("ingredientes",pe.getIngredientes());
            values.put("adicional",pe.getAdicional());

            database.update(Constantes.NOMBRETABLAPEDIDO,values,"id="+pe.getId(),null);
        }catch (Exception e){
        }
    }

    public void eliminarPedido(int id){
        try{
            database.delete(Constantes.NOMBRETABLAPEDIDO,"id="+id,null);
        }catch (Exception e){
        }
    }

    public void eliminarPedidoXCliente(int idCli){
        try{
            database.delete(Constantes.NOMBRETABLAPEDIDO,"idCli="+idCli,null);
        }catch (Exception e){
        }
    }

    public ArrayList<Pedido> getPedidos(int idCliente){
        ArrayList<Pedido> listaPe=new ArrayList<>();
        try{
            Cursor c=database.rawQuery("select * from "+Constantes.NOMBRETABLAPEDIDO+" where idCli="+idCliente,null);
            while(c.moveToNext()){
                Pedido pedido=new Pedido();
                pedido.setId(c.getInt(0));
                pedido.setCodigo(c.getInt(1));
                pedido.setIdCli(c.getInt(2));
                pedido.setIdImagen(c.getInt(3));
                pedido.setPrecio(c.getDouble(4));
                pedido.setNombre(c.getString(5));
                pedido.setIngredientes(c.getString(6));
                pedido.setAdicional(c.getString(7));
                listaPe.add(pedido);
            }
        }catch (Exception e){
        }
        return listaPe;
    }
}
