package TheGardenCafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mesonrafaelalberti.R;

public class InformacionDetallaTGC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_detalla_tgc);
    }
    public void PrimeraPantallaBDLM(View view){
        Intent PrimeraPantallaBDLM = new Intent(this, TheGardenCafe.PrimeraPantallaTGC.class);
        startActivity(PrimeraPantallaBDLM);
        finish();
    }
    public void Login(View view){
        Intent Login = new Intent(this, TheGardenCafe.LoginTGC.class);
        startActivity(Login);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
    public void onBackPressed() {
        Intent Informacion = new Intent(this, TheGardenCafe.PrimeraPantallaTGC.class);
        startActivity(Informacion);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
}