package com.example.mario.juegosclasicos;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;



public class ManoFragment extends Fragment {

    private ImageView ivCarta1, ivCarta2, ivCarta3, ivCarta4, ivMano;

    private ArrayList<Carta> listaCartasMano;
    private ArrayList<Carta> listaCartas;

    private Carta cartaMano;

    private SoundPool soundPool;
    private int sonidoCarta;

    private OnFragmentManoListener mListener;

    public ManoFragment() {
        // Required empty public constructor
    }

    public static ManoFragment newInstance() {
        ManoFragment fragment = new ManoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mano, container, false);

        soundPool = new SoundPool( 5, AudioManager.STREAM_MUSIC , 0);
        sonidoCarta = soundPool.load(getContext(),R.raw.sonidocarta,0);

        listaCartasMano = SolitarioActivity.listaCartasMano;
        listaCartas = SolitarioActivity.listaCartas;

        ivCarta1 = view.findViewById(R.id.imageViewCarta1);
        ivCarta2 = view.findViewById(R.id.imageViewCarta2);
        ivCarta3 = view.findViewById(R.id.imageViewCarta3);
        ivCarta4 = view.findViewById(R.id.imageViewCarta4);
        ivMano = view.findViewById(R.id.imageViewCartaMano);

        ivCarta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCarta1.setImageDrawable(listaCartasMano.get(0).getImgCarta());
                cartaMano = listaCartasMano.get(0);
                ivMano.setImageDrawable(cartaMano.getImgCarta());
                pasaDatos(cartaMano.getId());
                sonidoCarta();
                Toast.makeText(getContext(),
                        "Sacas el "+cartaMano.getValor() + " de "+ cartaMano.getPalo(), Toast.LENGTH_SHORT).show();
            }
        });

        ivCarta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCarta2.setImageDrawable(listaCartasMano.get(1).getImgCarta());
                cartaMano = listaCartasMano.get(1);
                ivMano.setImageDrawable(cartaMano.getImgCarta());
                pasaDatos(cartaMano.getId());
                sonidoCarta();
                Toast.makeText(getContext(),
                        "Sacas el "+cartaMano.getValor() + " de "+ cartaMano.getPalo(), Toast.LENGTH_SHORT).show();
            }
        });

        ivCarta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCarta3.setImageDrawable(listaCartasMano.get(2).getImgCarta());
                cartaMano = listaCartasMano.get(2);
                ivMano.setImageDrawable(cartaMano.getImgCarta());
                pasaDatos(cartaMano.getId());
                sonidoCarta();
                Toast.makeText(getContext(),
                        "Sacas el "+cartaMano.getValor() + " de "+ cartaMano.getPalo(), Toast.LENGTH_SHORT).show();
            }
        });

        ivCarta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCarta4.setImageDrawable(listaCartasMano.get(3).getImgCarta());
                cartaMano = listaCartasMano.get(3);
                ivMano.setImageDrawable(cartaMano.getImgCarta());
                pasaDatos(cartaMano.getId());
                sonidoCarta();
                Toast.makeText(getContext(),
                        "Sacas el "+cartaMano.getValor() + " de "+ cartaMano.getPalo(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentManoListener) {
            mListener = (OnFragmentManoListener) context;
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

    public interface OnFragmentManoListener {
        void OnFragmentManoListener(int idCarta);
    }

    public void buscarCarta(int idCarta){
        for (Carta cartaBusqueda: listaCartas ) {
            if(cartaBusqueda.getId() == idCarta){
                cartaMano = cartaBusqueda;
            }
        }
        ivMano.setImageDrawable(cartaMano.getImgCarta());
    }

    private void pasaDatos(int idCarta){
        if (mListener != null) {
            mListener.OnFragmentManoListener(idCarta);
        }
    }

    private void sonidoCarta(){
        soundPool.play(sonidoCarta, 1, 1, 1, 0, 1);
    }

}
