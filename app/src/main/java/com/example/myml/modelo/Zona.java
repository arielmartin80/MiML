package com.example.myml.modelo;

public class Zona {

    public Mapa city;
    public Mapa state;
    public Mapa country;
    public String latitude;
    public String longitude;

    public Mapa getCity() {
        return city;
    }

    public void setCity(Mapa city) {
        this.city = city;
    }

    public Mapa getState() {
        return state;
    }

    public void setState(Mapa state) {
        this.state = state;
    }

    public Mapa getCountry() {
        return country;
    }

    public void setCountry(Mapa country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getZona(){
        String zona = getCity().getName()+", "+getState().getName();
        return zona;
    }
}
