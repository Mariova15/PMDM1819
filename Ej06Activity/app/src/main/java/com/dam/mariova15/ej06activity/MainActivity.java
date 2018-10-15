package com.dam.mariova15.ej06activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int estado = 0;

    EditText etNombre;
    Button btnAceptar;
    Button btnLimpiar;
    Button btnMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.EditTextNombre);
        btnAceptar = findViewById(R.id.ButtonAceptar);
        btnLimpiar = findViewById(R.id.ButtonLimpiar);
        btnMostrar = findViewById(R.id.ButtonMostrar);

        if (savedInstanceState != null) {
            int temp = savedInstanceState.getInt("ESTADO");
            if (temp ==1){
                etNombre.setVisibility(View.GONE);
            } else{
                etNombre.setVisibility(View.VISIBLE);
            }
        }

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String saludoGenerico = "Hola ";
                Toast.makeText(MainActivity.this, saludoGenerico + etNombre.getText(), Toast.LENGTH_LONG).show();
            }
        });


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNombre.setText("");
            }
        });

    }

    public void ocultar(View v) {
        etNombre.setVisibility(View.GONE);
        estado = 1;
    }

    public void mostrar(View view) {
        etNombre.setVisibility(View.VISIBLE);
        estado = 2;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ESTADO", estado);
    }
}