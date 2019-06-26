package com.example.myml.modelo;

import com.google.gson.annotations.SerializedName;

public class Articulo {

    public String id;
    @SerializedName("title")
    public String titulo;
    @SerializedName("thumbnail")
    public String foto;

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
}
