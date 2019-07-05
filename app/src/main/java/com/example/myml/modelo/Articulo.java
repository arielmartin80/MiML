package com.example.myml.modelo;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Articulo {

    public String id;
    @SerializedName("title")
    public String titulo;
    @SerializedName("thumbnail")
    public String foto;
    @SerializedName("price")
    public Double precio;
    public List<Sale_term> sale_terms;
    public List<Picture> pictures;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Sale_term> getSale_terms() {
        return sale_terms;
    }

    public void setSale_terms(List<Sale_term> sale_terms) {
        this.sale_terms = sale_terms;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public String getDiasGarantia(){
        String dato = getSale_terms().get(0).value_name;
        return dato;
    }
}
