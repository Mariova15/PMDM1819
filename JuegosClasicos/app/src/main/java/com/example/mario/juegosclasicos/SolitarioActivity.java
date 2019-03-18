package com.example.mario.juegosclasicos;

import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.app.FragmentManager;

import java.util.ArrayList;
import java.util.Collections;

public class SolitarioActivity extends AppCompatActivity implements CartasFragment.OnFragmentCartasMesaListener, ManoFragment.OnFragmentManoListener {

    public static ArrayList<Carta> listaCartas = new ArrayList<>();
    public static ArrayList<Carta> listaCartasMesa = new ArrayList<>();
    public static ArrayList<Carta> listaCartasMano = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solitario);
        generarListaCartas();
    }

    @Override
    public void OnFragmentCartasMesaListener(int idCarta) {

        ManoFragment manoFragment = (ManoFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentMano);
        manoFragment.buscarCarta(idCarta);

    }

    @Override
    public void OnFragmentManoListener(int idCarta) {
        CartasFragment cartasFragment = (CartasFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentCartas);
        cartasFragment.buscarCarta(idCarta);

    }

    private void generarListaCartas() {
        TypedArray imgCartas = getResources().obtainTypedArray(R.array.img_carta);
        TypedArray palosCartas = getResources().obtainTypedArray(R.array.nombre_palos);
        int valor = 1;
        int palo = 0;
        int id = 0;
        for (int i = 0; i < imgCartas.length(); i++) {
            if (valor == 10) {
                valor = 1;
                palo++;
            }
            listaCartas.add(new Carta(imgCartas.getDrawable(i)
                    , getResources().getDrawable(R.drawable.reverso_carta), palosCartas.getString(palo), valor, id));
            valor++;
            id++;
        }
        listaCartas.get(36).setPalo("oros");
        listaCartas.get(36).setValor(10);
        listaCartas.get(37).setPalo("copas");
        listaCartas.get(37).setValor(10);
        listaCartas.get(38).setPalo("espadas");
        listaCartas.get(38).setValor(10);
        listaCartas.get(39).setPalo("bastos");
        listaCartas.get(39).setValor(10);

        generarListaCartasMano();
    }

    private void generarListaCartasMano(){
        for (Carta cartaAnnadir : listaCartas ) {
            listaCartasMesa.add(cartaAnnadir);
        }
        Collections.shuffle(listaCartasMesa);
        for (int i = 0; i < 4; i++) {
            listaCartasMano.add(listaCartasMesa.get(i));
        }
        for (Carta cartaBorrar : listaCartasMano) {
            listaCartasMesa.remove(cartaBorrar);
        }

    }

}
