package com.example.tiedafragment.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tiedafragment.Entidades.Categorias;
import com.example.tiedafragment.R;

import java.util.List;

public class AdaptadorCategoria extends RecyclerView.Adapter<CategoriaHolder> {
    Context context;
    CategoriaHolder.CategoriaCallback callback;
    List<Categorias> datos;

    public AdaptadorCategoria(Context context, CategoriaHolder.CategoriaCallback callback, List<Categorias> datos) {
        this.context = context;
        this.callback = callback;
        this.datos = datos;
    }

    @NonNull
    @Override
    public CategoriaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_categoria,parent,false);
        return new CategoriaHolder(v,callback);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaHolder holder, int position) {
        Glide.with(context).load(datos.get(position).getImagen_cuadrada()).into(holder.ibtn_categoria);
        holder.id =datos.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
