package com.example.myml.API;

import com.example.myml.modelo.Articulo;
import com.example.myml.modelo.ResultadoBusqueda;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MercadoLibreAPI {

    @GET("items/{itemId}")
    Call<Articulo> getArticulo(@Path("itemId") String id);

    @GET("sites/MLA/search")
    Call <ResultadoBusqueda> searchArticulos(@Query("q") String query);

}
