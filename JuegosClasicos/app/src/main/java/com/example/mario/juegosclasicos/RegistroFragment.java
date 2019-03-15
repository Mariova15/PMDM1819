package com.example.mario.juegosclasicos;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistroFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistroFragment extends Fragment {

    private EditText etNombreRegistro, etEmailRegistro, etPassRegistro;
    private Button btnRegistrar;

    private OnFragmentInteractionListener mListener;

    public RegistroFragment() {
        // Required empty public constructor
    }

    public static RegistroFragment newInstance() {
        RegistroFragment fragment = new RegistroFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registro, container, false);

        etNombreRegistro = view.findViewById(R.id.editTextNombreRegistro);
        etEmailRegistro = view.findViewById(R.id.editTextEmailRegistro);
        etPassRegistro = view.findViewById(R.id.editTextPassRegistro);
        btnRegistrar = view.findViewById(R.id.buttonRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData(etNombreRegistro.getText().toString(),etEmailRegistro.getText().toString(),etPassRegistro.getText().toString());
                loadData();
                //Toast.makeText(getContext(), "Usuario registrado", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void saveData(String nombreRegistro, String email, String password) {
        SharedPreferences sharedPreferences =  getContext().getSharedPreferences("datos-usuario", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("nombre", nombreRegistro);
        editor.putString("email", email);
        editor.putString("password", password);

        editor.apply();

    }

    public void loadData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("datos-usuario", MODE_PRIVATE);
        String nombre = sharedPreferences.getString("nombre", "");
        String email = sharedPreferences.getString("email", "");
        String password = sharedPreferences.getString("password", "");

        Toast.makeText(getContext(), nombre + " "+ email + " " + password, Toast.LENGTH_SHORT).show();
    }


}
