package com.example.mario.juegosclasicos;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SolitarioActivity extends AppCompatActivity implements CartasFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solitario);
    }

    @Override
    public void onFragmentInteraction(int posCarta) {

    }
}
