package com.example.myml.modelo;

import android.location.Address;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Articulo {

    public String id;
    @SerializedName("title")
    public String titulo;
    @SerializedName("thumbnail")
    public String foto;
    @SerializedName("price")
    public Double precio;
    @SerializedName("warranty")
    public String garantia;
    public String condition;

    public String initial_quantity;
    public String available_quantity;
    public String sold_quantity;

    public List<Picture> pictures;

    public Zona seller_address;

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

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getInitial_quantity() {
        return initial_quantity;
    }

    public void setInitial_quantity(String initial_quantity) {
        this.initial_quantity = initial_quantity;
    }

    public String getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(String available_quantity) {
        this.available_quantity = available_quantity;
    }

    public String getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(String sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public Zona getSeller_address() {
        return seller_address;
    }

    public void setSeller_address(Zona seller_address) {
        this.seller_address = seller_address;
    }
}
