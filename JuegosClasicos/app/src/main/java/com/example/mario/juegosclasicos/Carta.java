package com.example.mario.juegosclasicos;


import android.graphics.drawable.Drawable;

public class Carta {

    private Drawable imgCarta, reversoCarta, vistaCarta;
    private int valor;
    private String palo;

    public Carta(Drawable imgCarta,Drawable reversoCarta ,String palo ,int valor) {
        this.imgCarta = imgCarta;
        this.reversoCarta = reversoCarta;
        this.vistaCarta = reversoCarta;
        this.valor = valor;
        this.palo = palo;
    }

    public Drawable getImgCarta() {
        return imgCarta;
    }

    public Drawable getReversoCarta() {
        return reversoCarta;
    }

    public int getValor() {
        return valor;
    }

    public Drawable getVistaCarta() {
        return vistaCarta;
    }

    public String getPalo() {
        return palo;
    }

    public void darVuelta(){
        this.vistaCarta = imgCarta;
    }

}
