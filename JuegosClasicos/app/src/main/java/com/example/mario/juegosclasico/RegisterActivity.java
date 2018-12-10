package com.example.mario.juegosclasico;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements RegisterFragment.RegistroListener {

    private RegisterFragment fragmentRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fragmentRegistro = (RegisterFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_register);
        fragmentRegistro.setMiEscuchadorClick(new RegisterFragment.RegistroListener() {
            @Override
            public void botonesRegistro(int boton) {
                if (fragmentRegistro.getEtEmail().getText().toString().isEmpty() || fragmentRegistro.getEtPassword().getText().toString().isEmpty() || fragmentRegistro.getEtUsuario().getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(RegisterActivity.this);
                    SharedPreferences.Editor editorPreferencias = preferencias.edit();
                    editorPreferencias.putString("username", fragmentRegistro.getEtUsuario().getText().toString());
                    editorPreferencias.putString("userpasswd", fragmentRegistro.getEtPassword().getText().toString());
                    editorPreferencias.putString("usermail", fragmentRegistro.getEtEmail().getText().toString());
                    editorPreferencias.commit();
                    Toast.makeText(RegisterActivity.this, "Uusuario registrado", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }



    @Override
    public void botonesRegistro(int boton) {

    }
}
