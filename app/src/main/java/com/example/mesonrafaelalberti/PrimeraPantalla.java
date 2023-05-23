package com.example.mesonrafaelalberti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrimeraPantalla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla);
    }
    public void ConsultarRestaurantes(View view){
        Intent Consultar = new Intent(this, Lanzar.ConsultarRestaurantes.class);
        startActivity(Consultar);
        finish();
    }
    public void InformacionDetalla(View view){
        Intent IDetalla = new Intent(this, com.example.mesonrafaelalberti.InformacionDetallaMRA.class);
        startActivity(IDetalla);
        finish();
    }
    public void onBackPressed() {
        Intent Informacion = new Intent(this, Lanzar.ConsultarRestaurantes.class);
        startActivity(Informacion);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
}