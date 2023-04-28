package Lanzar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mesonrafaelalberti.R;

public class CerrarAplicacion extends AppCompatActivity {
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerrar_aplicacion);
        b1 = (Button) findViewById(R.id.mbtn_cerrarAplicacion);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    finishAffinity();
            }
        });
    }
    public void ConsultarRestaurantes(View view){
        Intent ConsultarRestaurantes = new Intent(this, ConsultarRestaurantes.class);
        startActivity(ConsultarRestaurantes);
        finish();
    }

}