package BistroDeLaMer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mesonrafaelalberti.R;

public class InformacionDetallaBDLMClon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_detalla_bdlmclon);
    }
    public void mostrarHorario(View view){
        Intent mostrarHorario = new Intent(this, BistroDeLaMer.ConsultarHorarioBDLM.class);
        startActivity(mostrarHorario);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
    public void mostrarCarta(View view){
        Intent mostrarCarta = new Intent(this, BistroDeLaMer.ConsultarCartaBDLM.class);
        startActivity(mostrarCarta);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
    public void hacerReserva(View view){
        Intent hacerReserva = new Intent(this, BistroDeLaMer.HacerReservaBDLM.class);
        startActivity(hacerReserva);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
    public void consultarReserva(View view){
        Intent consultarReserva = new Intent(this, BistroDeLaMer.ConsultarReservasBDLM.class);
        startActivity(consultarReserva);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
    public void onBackPressed() {
        Intent Informacion = new Intent(this, BistroDeLaMer.InformacionDetallaBDLM.class);
        startActivity(Informacion);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }

}