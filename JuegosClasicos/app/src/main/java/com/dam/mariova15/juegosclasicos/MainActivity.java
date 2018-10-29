package com.dam.mariova15.juegosclasicos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;

    Button btnLogin, btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.buttonLogin);
        btnRegistro = findViewById(R.id.buttonRegistro);

    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.buttonLogin:
                Intent activityLogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(activityLogin);
                break;
            case R.id.buttonRegistro:
                Intent activityRegistro = new Intent(MainActivity.this, SignActivity.class);
                startActivity(activityRegistro);
                break;
        }
    }
}

