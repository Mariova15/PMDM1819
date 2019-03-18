package com.example.mario.juegosclasicos;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;


public class CartasFragment extends Fragment {

    private ArrayList<Carta> listaCartasMesa;
    private ArrayList<Carta> listaCartas;
    private RecyclerView recyclerView;

    private Carta cartaMano;

    private SoundPool soundPool;
    private int sonidoCarta;

    private OnFragmentCartasMesaListener mListener;

    public CartasFragment() {
    }

    public static CartasFragment newInstance() {
        CartasFragment fragment = new CartasFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cartas, container, false);

        soundPool = new SoundPool( 5, AudioManager.STREAM_MUSIC , 0);
        sonidoCarta = soundPool.load(getContext(),R.raw.sonidocarta,0);

        listaCartas = SolitarioActivity.listaCartas;
        listaCartasMesa = SolitarioActivity.listaCartasMesa;

        recyclerView = view.findViewById(R.id.RVCartas);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 9));


        AdapterCartas adapterCartas = new AdapterCartas(listaCartasMesa);



        adapterCartas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cartaMano != null) {
                    if (cartaMano.getId() == recyclerView.getChildAdapterPosition(v)) {
                        sonidoCarta();
                        Toast.makeText(getContext(), "Colocas el " + cartaMano.getValor() + " de " + cartaMano.getPalo(), Toast.LENGTH_SHORT).show();
                        Carta cartaTemp = cartaMano;
                        listaCartasMesa.get(recyclerView.getChildAdapterPosition(v)).darVuelta();
                        cartaMano = listaCartasMesa.get(recyclerView.getChildAdapterPosition(v));
                        pasaDatos(cartaMano.getId());
                        cartaTemp.darVuelta();
                        listaCartasMesa.set(recyclerView.getChildAdapterPosition(v), cartaTemp);
                        recyclerView.getAdapter().notifyItemChanged(recyclerView.getChildAdapterPosition(v));
                    } else {
                        Toast.makeText(getContext(), "Posición equivocada", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getContext(), "Primero coge una carta de la parte izquierda", Toast.LENGTH_SHORT).show();
                }

            }
        });

        recyclerView.setAdapter(adapterCartas);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentCartasMesaListener) {
            mListener = (OnFragmentCartasMesaListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentCartasMesaListener {
        void OnFragmentCartasMesaListener(int idCarta);
    }

    public void buscarCarta(int idCarta){
        for (Carta cartaBusqueda: listaCartas ) {
            if(cartaBusqueda.getId() == idCarta){
                cartaMano = cartaBusqueda;
            }
        }
    }

    private void pasaDatos(int idCarta){
        if (mListener != null) {
            mListener.OnFragmentCartasMesaListener(idCarta);
        }
    }

    private void sonidoCarta(){
        soundPool.play(sonidoCarta, 1, 1, 1, 0, 1);
    }

}
