package com.example.mario.juegosclasicos;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ManoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ManoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManoFragment extends Fragment {

    private ImageView ivCarta1, ivCarta2, ivCarta3, ivCarta4, ivMano;

    private ArrayList<Carta> listaCartas;

    private OnFragmentInteractionListener mListener;

    public ManoFragment() {
        // Required empty public constructor
    }

    public static ManoFragment newInstance(String param1, String param2) {
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

        listaCartas = SolitarioActivity.listaCartasMano;
        //generarListaCartas();



        ivCarta1 = view.findViewById(R.id.imageViewCarta1);
        ivCarta2 = view.findViewById(R.id.imageViewCarta2);
        ivCarta3 = view.findViewById(R.id.imageViewCarta3);
        ivCarta4 = view.findViewById(R.id.imageViewCarta4);
        ivMano = view.findViewById(R.id.imageViewCartaMano);

        ivCarta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCarta1.setImageDrawable(listaCartas.get(0).getImgCarta());
                ivMano.setImageDrawable(listaCartas.get(0).getImgCarta());
            }
        });

        ivCarta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCarta2.setImageDrawable(listaCartas.get(1).getImgCarta());
                ivMano.setImageDrawable(ivCarta2.getDrawable());
            }
        });

        ivCarta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCarta3.setImageDrawable(listaCartas.get(2).getImgCarta());
                ivMano.setImageDrawable(ivCarta3.getDrawable());
            }
        });

        ivCarta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCarta4.setImageDrawable(listaCartas.get(3).getImgCarta());
                ivMano.setImageDrawable(ivCarta4.getDrawable());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
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
            listaCartas.add(new Carta(imgCartas.getDrawable(i)
                    , getResources().getDrawable(R.drawable.reverso_carta), palosCartas.getString(palo), valor));
            valor++;
        }

    }

}
