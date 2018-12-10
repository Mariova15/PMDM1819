package com.example.mario.juegosclasico;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btJugar, btOpciones, btCreditos, btSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comprobarMusica();

        btSalir = findViewById(R.id.btSalir);

        btSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btOpciones = findViewById(R.id.btOpciones);

        btOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, OpcionesActivity.class);
                startActivity(i);
            }
        });



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

        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        if(preferencias.getBoolean("prefk_musica", true)){

            startService(new Intent(MainActivity.this, ServicioMusica.class));
        }else{
            stopService(new Intent(MainActivity.this, ServicioMusica.class));
        }

    }


}
