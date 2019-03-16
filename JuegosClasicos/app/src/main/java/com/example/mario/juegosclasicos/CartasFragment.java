package com.example.mario.juegosclasicos;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),9));

        generarListaCartas();

        AdapterCartas adapterCartas = new AdapterCartas(listaCartas);

        recyclerView.setAdapter(adapterCartas);

        return view;
    }

    private void generarListaCartas() {
        Field[] drawablesFields = com.example.mario.juegosclasicos.R.drawable.class.getFields();
        //ArrayList<Drawable> drawables = new ArrayList<>();

        for (Field field : drawablesFields) {
            try {
                //drawables.add(getResources().getDrawable(field.getInt(null)));
                listaCartas.add(new Carta(getResources().getDrawable(field.getInt(null)), field.getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        void onFragmentInteraction(Uri uri);
    }
}
