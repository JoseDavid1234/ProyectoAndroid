package com.usmp.proyectofinalandroid.fragmentosAdministrador;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.usmp.proyectofinalandroid.R;

public class FragIniAdmin extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lyt_frag_inicio_admin, container, false);
    }
}