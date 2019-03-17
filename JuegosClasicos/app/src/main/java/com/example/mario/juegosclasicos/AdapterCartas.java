package com.example.mario.juegosclasicos;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class AdapterCartas extends RecyclerView.Adapter<AdapterCartas.ViewHolderDatos> implements View.OnClickListener {

    private ArrayList<Carta> listaCartas;

    private View.OnClickListener listener;

    public AdapterCartas(ArrayList<Carta> listaCartas) {
        this.listaCartas = listaCartas;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.carta, null, false);

        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int i) {
        viewHolderDatos.asignarDatos(listaCartas.get(i).getVistaCarta());
    }

    @Override
    public int getItemCount() {
        return listaCartas.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        private ImageView ivCarta;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            ivCarta = itemView.findViewById(R.id.imageViewCarta);
        }

        public void asignarDatos(Drawable s) {
            ivCarta.setImageDrawable(s);
        }
    }
}
