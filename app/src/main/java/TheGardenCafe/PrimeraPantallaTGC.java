package TheGardenCafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mesonrafaelalberti.R;

public class PrimeraPantallaTGC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla_tgc);
    }
    public void ConsultarRestaurantes(View view){
        Intent Consultar = new Intent(this, Lanzar.ConsultarRestaurantes.class);
        startActivity(Consultar);
        finish();
    }
    public void InformacionDetalla(View view){
        Intent IDetalla = new Intent(this, TheGardenCafe.InformacionDetallaTGC.class);
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