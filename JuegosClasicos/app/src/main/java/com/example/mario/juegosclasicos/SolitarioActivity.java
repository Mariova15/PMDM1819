package com.example.mario.juegosclasicos;

import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.app.FragmentManager;

import java.util.ArrayList;

public class SolitarioActivity extends AppCompatActivity implements CartasFragment.OnFragmentInteractionListener, ManoFragment.OnFragmentInteractionListener {

    public static ArrayList<Carta> listaCartasMesa = new ArrayList<>();
    public static ArrayList<Carta> listaCartasMano = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solitario);
        generarListaCartas();
    }

    @Override
    public void onFragmentInteraction(int posCarta) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void generarListaCartas() {
        TypedArray imgCartas = getResources().obtainTypedArray(R.array.img_carta);
        TypedArray palosCartas = getResources().obtainTypedArray(R.array.nombre_palos);
        int valor = 0;
        int palo = 0;
        for (int i = 0; i < imgCartas.length(); i++) {
            if (valor == 10) {
                valor = 0;
                palo++;
            }
            listaCartasMesa.add(new Carta(imgCartas.getDrawable(i)
                    , getResources().getDrawable(R.drawable.reverso_carta), palosCartas.getString(palo), valor));
            valor++;
        }
        generarListaCartasMano();
    }

    private void generarListaCartasMano(){
        for (int i = 0; i < 4; i++) {
            listaCartasMano.add(listaCartasMesa.get(i));
        }
        for (Carta cartaBorrar : listaCartasMano) {
            listaCartasMesa.remove(cartaBorrar);
        }

    }

}
