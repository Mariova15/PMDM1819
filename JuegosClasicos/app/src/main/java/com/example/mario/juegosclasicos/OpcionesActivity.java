package com.example.mario.juegosclasicos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OpcionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new OpcionesFragment())
                .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        comprobarMusica();
    }

    @Override
    protected void onStart() {
        super.onStart();
        comprobarMusica();
    }

    public void comprobarMusica(){

        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(OpcionesActivity.this);
        if(preferencias.getBoolean("switch_preference_musica", false)){

            startService(new Intent(OpcionesActivity.this, ServicioMusica.class));
        }else{
            stopService(new Intent(OpcionesActivity.this, ServicioMusica.class));
        }

    }

}
