package Lanzar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.view.View;

import com.example.mesonrafaelalberti.R;

public class AyudaRestaurantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda_restaurantes);
    }
    private Transition transition;
    public void ConsultarRestaurantes(View view){
        Intent ConsultarRestaurantes = new Intent(this, ConsultarRestaurantes.class);
        startActivity(ConsultarRestaurantes);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
}