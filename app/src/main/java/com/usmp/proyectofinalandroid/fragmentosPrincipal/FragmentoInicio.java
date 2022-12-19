package com.usmp.proyectofinalandroid.fragmentosPrincipal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.usmp.proyectofinalandroid.controladores.ActVistaIngresar;
import com.usmp.proyectofinalandroid.controladores.ActVistaRegistrar;
import com.usmp.proyectofinalandroid.entidades.Cliente;
import com.usmp.proyectofinalandroid.R;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;

public class FragmentoInicio extends Fragment {

    public FragmentoInicio() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.lyt_fragmento_inicio, container, false);

        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button vistaRegistrar=view.findViewById(R.id.btnVistaRegistrar);
        vistaRegistrar.setOnClickListener(v->{
            Intent intent=new Intent(this.getActivity(), ActVistaRegistrar.class);
            this.getActivity().startActivity(intent);
        });

        Button vistaIngresar=view.findViewById(R.id.btnIngresarVista);
        vistaIngresar.setOnClickListener(v->{
            Intent intent=new Intent(this.getActivity(), ActVistaIngresar.class);
            this.getActivity().startActivity(intent);
        });

        ArrayList lista=new ArrayList<CarouselItem>();
        lista.add(new CarouselItem(R.drawable.carrusel1));
        lista.add(new CarouselItem(R.drawable.carrusel2));
        lista.add(new CarouselItem(R.drawable.carrusel3));

        ImageCarousel imgCarousel=view.findViewById(R.id.carousel);
        imgCarousel.addData(lista);
        imgCarousel.setAutoPlay(true);
        imgCarousel.setAutoPlayDelay(5000);
        imgCarousel.setBottomShadowHeight(30);
        imgCarousel.setTopShadowHeight(30);

        asignarUris(view);
        super.onViewCreated(view, savedInstanceState);
    }

    private void asignarUris(View view) {
        view.findViewById(R.id.ic_fb).setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ottopizzas.oficial"));
            startActivity(intent);
        });
        view.findViewById(R.id.ic_ins).setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ottopizzas.oficial/"));
            startActivity(intent);
        });
        view.findViewById(R.id.ic_snap).setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.snapchat.com/"));
            startActivity(intent);
        });
        view.findViewById(R.id.ic_tiktok).setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tiktok.com/"));
            startActivity(intent);
        });
        view.findViewById(R.id.ic_twitch).setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitch.tv/"));
            startActivity(intent);
        });
        view.findViewById(R.id.ic_twitter).setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"));
            startActivity(intent);
        });
    }
}