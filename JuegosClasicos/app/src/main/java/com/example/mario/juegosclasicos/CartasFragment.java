package com.example.mario.juegosclasicos;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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

    private ArrayList<Carta> listaCartas;
    private RecyclerView recyclerView;

    private OnFragmentInteractionListener mListener;

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

        listaCartas = new ArrayList<>();

        recyclerView = view.findViewById(R.id.RVCartas);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 9));

        generarListaCartas();

        AdapterCartas adapterCartas = new AdapterCartas(listaCartas);

        adapterCartas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaCartas.get(recyclerView.getChildAdapterPosition(v)).darVuelta();
                recyclerView.getAdapter().notifyItemChanged(recyclerView.getChildAdapterPosition(v));
                Toast.makeText(getContext(), listaCartas.get(
                        recyclerView.getChildAdapterPosition(v)).getPalo()+ " " + listaCartas.get(
                        recyclerView.getChildAdapterPosition(v)).getValor(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapterCartas);

        return view;
    }

    private void generarListaCartas() {

        TypedArray imgCartas = getResources().obtainTypedArray(R.array.img_carta);
        TypedArray palosCartas = getResources().obtainTypedArray(R.array.nombre_palos);
        int valor = 0;
        int palo = 0;
        for (int i = 0; i < imgCartas.length(); i++) {
            if(valor == 10){
                valor = 0;
                palo++;
            }
            listaCartas.add(new Carta(imgCartas.getDrawable(i)
                    , getResources().getDrawable(R.drawable.reverso_carta), palosCartas.getString(palo) ,valor));
            valor++;
        }

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
        void onFragmentInteraction(int posCarta);
    }
}
