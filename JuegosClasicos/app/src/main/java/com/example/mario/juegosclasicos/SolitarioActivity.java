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

    private CartasFragment cartasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solitario);
    }

    @Override
    public void onFragmentInteraction(int posCarta) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
