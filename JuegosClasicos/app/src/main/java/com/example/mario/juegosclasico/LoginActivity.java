package com.example.mario.juegosclasico;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginFragment.LoginListener {

    private LoginFragment fragmentLogin;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        boolean nuevoUsuario = false;

        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        if (preferencias.getString("usermail", "").isEmpty()) {
            nuevoUsuario = true;
        }else{
            nuevoUsuario = false;
        }


        if (nuevoUsuario) {
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
            startActivity(i);
        }

        fragmentLogin = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_login);

        fragmentLogin.setMiEscuchadorClick(new LoginFragment.LoginListener() {
            @Override
            public void botonesLogin(int boton) {
                boolean usuarioRegistrado;
                if (boton == R.id.btLoginLogin) {
                    if (fragmentLogin.getEtEmail().getText().toString().isEmpty() || fragmentLogin.getEtPassword().getText().toString().isEmpty()) {
                        Toast.makeText(LoginActivity.this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
                    } else {
                        email = fragmentLogin.getEtEmail().getText().toString();
                        password = fragmentLogin.getEtPassword().getText().toString();

                        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                        String correo = preferencias.getString("usermail", "");
                        String passwd = preferencias.getString("userpasswd", "");
                        if (correo.equals("") || passwd.equals("")) {
                            usuarioRegistrado = false;
                        } else if (correo.equals(email) && passwd.equals(password)) {
                            usuarioRegistrado = true;
                        } else {
                            usuarioRegistrado = false;
                        }

                        if (usuarioRegistrado) {
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(LoginActivity.this, "Usuario no registrado.", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else if (boton == R.id.btRegistroLogin) {
                    Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                    PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                    startActivity(i);
                }
            }
        });

    }

    @Override
    public void botonesLogin(int boton) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(LoginActivity.this, ServicioMusica.class));
    }
}
