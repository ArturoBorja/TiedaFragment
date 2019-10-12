package com.example.tiedafragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListaCategoriaFragment.CallBackCategoria {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        ListaCategoriaFragment lcf = (ListaCategoriaFragment) fm.findFragmentById(R.id.frg_main);
        lcf.categoriaCallback = this;
    }

    @Override
    public void CategoriaSeleccionada(int codigo) {
        Toast.makeText(this,"cod+ "+codigo,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
        intent.putExtra("codigo",codigo);
        startActivity(intent);
    }
}
