package com.dam.mariova15.juegosclasicos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView tvNombre,tvPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvNombre = findViewById(R.id.textViewNombre);
        tvPass = findViewById(R.id.textViewPass);
        btnLogin = findViewById(R.id.buttonRegistro);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.buttonLogin:

                break;
        }
    }

}
