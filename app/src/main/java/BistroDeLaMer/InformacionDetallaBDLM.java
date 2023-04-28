package BistroDeLaMer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mesonrafaelalberti.R;

public class InformacionDetallaBDLM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_detalla_bdlm);
    }
    public void PrimeraPantallaBDLM(View view){
        Intent PrimeraPantallaBDLM = new Intent(this, BistroDeLaMer.PrimeraPantallaBDLM.class);
        startActivity(PrimeraPantallaBDLM);
        finish();
    }
}