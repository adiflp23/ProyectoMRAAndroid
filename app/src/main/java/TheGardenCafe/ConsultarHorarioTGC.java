package TheGardenCafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mesonrafaelalberti.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import BistroDeLaMer.AdaptadorHorarioBDLM;
import BistroDeLaMer.ConsultarHorarioBDLM;
import BistroDeLaMer.horarioBDLM;

public class ConsultarHorarioTGC extends AppCompatActivity {
    List<horarioTGC> horarioTGCList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_horario_tgc);
        recyclerView = (RecyclerView)findViewById(R.id.rViewListaTGC);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        horarioTGCList = new ArrayList<>();
        mostrarHorarioTGC("http://10.0.0.18/thegardencafe/mostrarHorario.php");
    }
    public void mostrarHorarioTGC(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array  = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++){
                        JSONObject obj = (JSONObject) array.get(i);
                        horarioTGCList.add(new horarioTGC(
                                obj.getString("dia"),
                                obj.getString("apertura"),
                                obj.getString("cierre")
                        ));
                    }
                    AdaptadorHorarioTGC adaptador = new AdaptadorHorarioTGC(getApplicationContext(), horarioTGCList);
                    recyclerView.setAdapter(adaptador);
                }catch (JSONException e){

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ConsultarHorarioTGC.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void volverAtras(View view){
        Intent volverAtras = new Intent(this, TheGardenCafe.InformacionDetallaTGCClon.class);
        startActivity(volverAtras);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }

}