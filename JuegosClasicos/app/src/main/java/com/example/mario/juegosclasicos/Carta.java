package com.example.mario.juegosclasicos;


import android.graphics.drawable.Drawable;

public class Carta {

    private Drawable imgCarta, reversoCarta, vistaCarta;
    private int valor, id;
    private String palo;

    public Carta(Drawable imgCarta,Drawable reversoCarta ,String palo ,int valor, int id) {
        this.imgCarta = imgCarta;
        this.reversoCarta = reversoCarta;
        this.vistaCarta = reversoCarta;
        this.valor = valor;
        this.palo = palo;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public void darVuelta(){
        this.vistaCarta = imgCarta;
    }

}
