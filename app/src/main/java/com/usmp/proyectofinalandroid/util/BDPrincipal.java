package com.usmp.proyectofinalandroid.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDPrincipal extends SQLiteOpenHelper {


    public BDPrincipal(@Nullable Context context) {
        super(context, Constantes.NOMBREBD, null, Constantes.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Constantes.NOMBRETABLACLIENTE+"(" +
                "id integer primary key autoincrement," +
                "edad integer not null," +
                "codigoImagen integer not null," +
                "nombre text not null," +
                "apellidoMa text not null," +
                "apellidoPa text not null," +
                "usuario text not null," +
                "genero text not null," +
                "fechaNac text not null," +
                "tipoP text not null," +
                "contra text not null)");
        db.execSQL("create table "+Constantes.NOMBRETABLAPEDIDO+"(" +
                "id integer primary key autoincrement," +
                "codigo integer not null," +
                "idCli integer not null," +
                "idImagen integer not null," +
                "precio real not null," +
                "nombre text not null," +
                "ingredientes text not null," +
                "adicional text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
