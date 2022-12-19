package com.usmp.proyectofinalandroid.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.usmp.proyectofinalandroid.modelos.DAOPedido;

public class DialogoAlerta extends DialogFragment {

    int idPed;
    DAOPedido daoPedido;

    public DialogoAlerta(int idPed){
        this.idPed=idPed;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        daoPedido=new DAOPedido(this.getActivity());
        daoPedido.openBD();
        AlertDialog.Builder builder=new AlertDialog.Builder(this.getActivity());
        builder.setMessage("¿Está seguro de que quiere eliminar el pedido?").setTitle("Confimar").setPositiveButton("SI",(dialog, which) -> {
            daoPedido.eliminarPedido(idPed);
            Toast.makeText(this.getActivity(), "Pedido eliminado", Toast.LENGTH_SHORT).show();
            dialog.cancel();
        }).setNegativeButton("NO",(dialog, which) -> {
            dialog.cancel();
        });
        return builder.create();
    }
}