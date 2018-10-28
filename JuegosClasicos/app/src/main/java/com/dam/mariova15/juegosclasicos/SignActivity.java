package com.dam.mariova15.juegosclasicos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignActivity extends AppCompatActivity {

    TextView tvNombre,tvPass;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        tvNombre = findViewById(R.id.textViewNombre);
        tvPass = findViewById(R.id.textViewPass);
        btnRegistro = findViewById(R.id.buttonRegistro);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.buttonRegistro:

                break;
        }
    }
}
