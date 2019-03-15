package com.example.mario.juegosclasicos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity implements RegistroFragment.OnFragmentInteractionListener
        , LoginFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        comprobarMusica();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public void comprobarMusica(){

        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        if(preferencias.getBoolean("switch_preference_musica", false)){

            startService(new Intent(LoginActivity.this, ServicioMusica.class));
        }else{
            stopService(new Intent(LoginActivity.this, ServicioMusica.class));
        }

    }


}
