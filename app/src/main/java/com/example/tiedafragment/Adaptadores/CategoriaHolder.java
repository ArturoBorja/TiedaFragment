package com.example.tiedafragment.Adaptadores;

import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiedafragment.R;

public class CategoriaHolder extends RecyclerView.ViewHolder {
    public ImageButton ibtn_categoria;
    public int id;
    public CategoriaCallback callback;
    public CategoriaHolder(@NonNull View itemView, CategoriaCallback c) {
        super(itemView);
        this.callback=c;
        ibtn_categoria = itemView.findViewById(R.id.img_item_categoria);
        ibtn_categoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.CategoriaSeleccionar(id);
            }
        });
    }
    public interface CategoriaCallback{
        void CategoriaSeleccionar(int id);
    }
}
