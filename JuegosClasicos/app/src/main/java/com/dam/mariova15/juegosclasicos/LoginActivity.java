package com.dam.mariova15.juegosclasicos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;

    EditText etNombre,etPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNombre = findViewById(R.id.editTextNombre);
        etPass = findViewById(R.id.editTextPass);
        etPass = findViewById(R.id.editTextPass);
        btnLogin = findViewById(R.id.buttonRegistro);



    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.buttonLogin:
                Intent activityMain = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(activityMain);
                break;
        }
    }

}
