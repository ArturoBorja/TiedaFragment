package com.example.tiedafragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiedafragment.Adaptadores.AdaptadorCategoria;
import com.example.tiedafragment.Adaptadores.CategoriaHolder;
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
public class ListaCategoriaFragment extends Fragment implements CategoriaHolder.CategoriaCallback {
    RecyclerView recyclerView;
    CallBackCategoria categoriaCallback;

    public ListaCategoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://viveyupi.com/api/").addConverterFactory(GsonConverterFactory.create()).build();
        ServicioTienda s =retrofit.create(ServicioTienda.class);
        Call<List<Categorias>> call = s.ObtenerCategoriasPorNivel(1);
        View v =inflater.inflate(R.layout.fragment_lista_categoria, container, false);
        recyclerView = v.findViewById(R.id.rv_fragment_lista);
        call.enqueue(new Callback<List<Categorias>>() {
            @Override
            public void onResponse(Call<List<Categorias>> call, Response<List<Categorias>> response) {
                AdaptadorCategoria adaptadorCategoria =new AdaptadorCategoria(getContext(),ListaCategoriaFragment.this,response.body());
                recyclerView.setAdapter(adaptadorCategoria);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
            }

            @Override
            public void onFailure(Call<List<Categorias>> call, Throwable t) {

            }
        });

        return v;
    }

    @Override
    public void CategoriaSeleccionar(int id) {
        categoriaCallback.CategoriaSeleccionada(id);
    }
    public interface CallBackCategoria{
        void CategoriaSeleccionada(int codigo);
    }

}
