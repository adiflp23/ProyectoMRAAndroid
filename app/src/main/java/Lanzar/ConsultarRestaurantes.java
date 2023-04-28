package Lanzar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.mesonrafaelalberti.R;
import com.example.mesonrafaelalberti.menuRegistrar;

import BistroDeLaMer.PrimeraPantallaBDLM;

public class ConsultarRestaurantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_restaurantes);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuAyuda:
                Intent intent2 = new Intent(this, AyudaRestaurantes.class);
                startActivity(intent2);
                return true;
            case R.id.menuCerrar:
                Intent intent = new Intent(this, CerrarAplicacion.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void PrimeraPantallaBDLM(View view){
        Intent PrimeraPantallaBDLM = new Intent(this, BistroDeLaMer.PrimeraPantallaBDLM.class);
        startActivity(PrimeraPantallaBDLM);
        finish();
    }
}