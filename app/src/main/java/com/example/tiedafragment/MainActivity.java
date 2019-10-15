package com.example.tiedafragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListaCategoriaFragment.CallBackCategoria {
    DetalleFragment detalleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        ListaCategoriaFragment lcf = (ListaCategoriaFragment) fm.findFragmentById(R.id.frg_main);
        lcf.categoriaCallback = this;
        if (isTablet(this)){
            detalleFragment=(DetalleFragment) fm.findFragmentById(R.id.frg_main_detalle);
        }
    }

    @Override
    public void CategoriaSeleccionada(int codigo) {
        if(isTablet(this)){
            detalleFragment.CargarDatos(codigo);
        }else{
            Toast.makeText(this,"cod+ "+codigo,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
            intent.putExtra("codigo",codigo);
            startActivity(intent);
        }
    }
    public static boolean isTablet (Context context){
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)>=Configuration.SCREENLAYOUT_SIZE_LARGE;
    }
}
