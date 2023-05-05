package com.example.mesonrafaelalberti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InformacionDetallaMRA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_detalla_mra);
    }
    public void PrimeraPantallaBDLM(View view){
        Intent PrimeraPantallaBDLM = new Intent(this, com.example.mesonrafaelalberti.PrimeraPantalla.class);
        startActivity(PrimeraPantallaBDLM);
        finish();
    }
    public void Login(View view){
        Intent Login = new Intent(this, com.example.mesonrafaelalberti.Login.class);
        startActivity(Login);
        finish();
    }

}