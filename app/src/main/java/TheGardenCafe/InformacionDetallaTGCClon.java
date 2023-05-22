package TheGardenCafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mesonrafaelalberti.R;

public class InformacionDetallaTGCClon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_detalla_tgcclon);
    }
    public void mostrarHorario(View view){
        Intent mostrarHorario = new Intent(this, TheGardenCafe.ConsultarHorarioTGC.class);
        startActivity(mostrarHorario);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
    public void mostrarCarta(View view){
        Intent mostrarCarta = new Intent(this, TheGardenCafe.ConsultarCartaTGC.class);
        startActivity(mostrarCarta);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
    public void hacerReserva(View view){
        Intent hacerReserva = new Intent(this, TheGardenCafe.HacerReservaTGC.class);
        startActivity(hacerReserva);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
    public void consultarReserva(View view){
        Intent consultarReserva = new Intent(this, TheGardenCafe.ConsultarReservasTGC.class);
        startActivity(consultarReserva);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }

}