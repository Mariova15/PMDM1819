package com.example.mario.juegosclasicos;


import android.graphics.drawable.Drawable;

public class Carta {

    private Drawable imgCarta;
    private String nombre;

    public Carta(Drawable imgCarta, String nombre) {
        this.imgCarta = imgCarta;
        this.nombre = nombre;
    }

    public Drawable getImgCarta() {
        return imgCarta;
    }

    public String getNombre() {
        return nombre;
    }

}
