package com.example.myml.API;

import com.example.myml.modelo.Articulo;
import com.google.gson.Gson;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    private static MercadoLibreAPI getAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create( new Gson() ))
                .baseUrl("https://api.mercadolibre.com/")
                .build();
        MercadoLibreAPI service = retrofit.create(MercadoLibreAPI.class);
        return service;
    }

    public static void getArticulo(String id, Callback<Articulo> callback) {
        getAPI().getArticulo(id).enqueue(callback);
    }

    public static void searchArticulos(String q, Callback <Articulo> callback) {
        getAPI().searchArticulos(q).enqueue(callback);
    }

}
