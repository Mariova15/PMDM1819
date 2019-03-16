package com.example.mario.juegosclasicos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    private Button btnJugar, btnOpciones, btnCreditos, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnOpciones = findViewById(R.id.buttonOpciones);

        btnOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, OpcionesActivity.class);
                startActivity(intent);
            }
        });

        btnSalir = findViewById(R.id.buttonSalir);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(PrincipalActivity.this);

                String temp;

                if(preferencias.getBoolean("switch_preference_musica", false)){
                    temp = "algo";
                }else{
                    temp = "nada";
                }

                Toast.makeText(PrincipalActivity.this, temp, Toast.LENGTH_SHORT).show();
            }
        });

        btnJugar = findViewById(R.id.buttonJugar);

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, SolitarioActivity.class);
                startActivity(intent);
            }
        });
    }
}
