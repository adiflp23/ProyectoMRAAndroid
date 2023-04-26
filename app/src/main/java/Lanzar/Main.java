package Lanzar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mesonrafaelalberti.MainActivity;
import com.example.mesonrafaelalberti.R;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void ConsultarRestaurantes(View view){
        Intent ConsultarRestaurantes = new Intent(this, ConsultarRestaurantes.class);
        startActivity(ConsultarRestaurantes);
        finish();
    }
}