package com.example.tiedafragment;
import com.example.tiedafragment.Entidades.Categorias;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServicioTienda {
    @GET("/api/categorias/nivel/{nivel}/")
    Call<List<Categorias>> ObtenerCategoriasPorNivel(@Path("nivel")int nivel);
    @GET("/api/categorias/padre/{padre}/")
    Call<List<Categorias>> ObtenerCategoriasPorPadre(@Path("padre")int nivel);

}
