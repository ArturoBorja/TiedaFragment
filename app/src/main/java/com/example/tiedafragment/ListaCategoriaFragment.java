package com.example.tiedafragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiedafragment.Entidades.Categorias;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaCategoriaFragment extends Fragment {


    public ListaCategoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.github.com").addConverterFactory(GsonConverterFactory.create()).build();
        ServicioTienda s =retrofit.create(ServicioTienda.class);
        Call<List<Categorias>> call = s.ObtenerCategoriasPorNivel(1);
        call.enqueue(new Callback<List<Categorias>>() {
            @Override
            public void onResponse(Call<List<Categorias>> call, Response<List<Categorias>> response) {

            }

            @Override
            public void onFailure(Call<List<Categorias>> call, Throwable t) {

            }
        });
        View v =inflater.inflate(R.layout.fragment_lista_categoria, container, false);
        return v;
    }

}
