package com.dam.mariova15.juegosclasicos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;


    EditText etNombre,etPass,etCorreo;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        etNombre = findViewById(R.id.editTextNombre);
        etCorreo = findViewById(R.id.editTextCorreo);
        etPass = findViewById(R.id.editTextPass);
        btnRegistro = findViewById(R.id.buttonRegistro);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.buttonRegistro:
                Intent activityMain = new Intent(SignActivity.this, MainActivity.class);
                startActivity(activityMain);
                break;
        }
    }
}
