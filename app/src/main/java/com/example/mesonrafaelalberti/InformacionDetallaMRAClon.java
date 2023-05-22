package com.example.mesonrafaelalberti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InformacionDetallaMRAClon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_detalla_mraclon);
    }
    public void mostrarHorario(View view){
        Intent mostrarHorario = new Intent(this, com.example.mesonrafaelalberti.ConsultarHorarioMRA.class);
        startActivity(mostrarHorario);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
    public void mostrarCarta(View view){
        Intent mostrarCarta = new Intent(this, com.example.mesonrafaelalberti.ConsultarCartaMRA.class);
        startActivity(mostrarCarta);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
    public void hacerReserva(View view){
        Intent hacerReserva = new Intent(this, com.example.mesonrafaelalberti.HacerReservaMRA.class);
        startActivity(hacerReserva);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
    public void consultarReserva(View view){
        Intent consultarReserva = new Intent(this, com.example.mesonrafaelalberti.ConsultarReservasMRA.class);
        startActivity(consultarReserva);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
}