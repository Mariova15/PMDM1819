package com.example.mario.juegosclasico;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.preference.PreferenceFragment;



public class OpcionesFragment extends PreferenceFragment  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }


}
