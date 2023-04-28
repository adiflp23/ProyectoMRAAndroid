package Lanzar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.mesonrafaelalberti.MainActivity;
import com.example.mesonrafaelalberti.R;

public class PantallaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
    }
    public void ConsultarRestaurantes(View view){
        Intent ConsultarRestaurantes = new Intent(this, ConsultarRestaurantes.class);
        startActivity(ConsultarRestaurantes);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
}