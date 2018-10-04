package com.dam.mariova15.ejercicio01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    Button btnA1,
            btnA2,
            btnA3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnA1 = findViewById(R.id.buttonActivity1);
        btnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent A1 = new Intent(Principal.this, Activity1.class);
                startActivity(A1);
            }
        });


        btnA2 = findViewById(R.id.buttonActivity2);
        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent A2 = new Intent(Principal.this, Activity2.class);
                startActivity(A2);
            }
        });

        btnA3 = findViewById(R.id.buttonActivity3);
        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent A3 = new Intent(Principal.this, Activity3.class);
                startActivity(A3);
            }
        });
    }
}
