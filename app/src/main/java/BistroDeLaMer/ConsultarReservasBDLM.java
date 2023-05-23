package BistroDeLaMer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mesonrafaelalberti.AdaptadorReservasMRA;
import com.example.mesonrafaelalberti.ConsultarReservasMRA;
import com.example.mesonrafaelalberti.Login;
import com.example.mesonrafaelalberti.R;
import com.example.mesonrafaelalberti.ReservasMRA;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultarReservasBDLM extends AppCompatActivity {

    List<ReservasBDLM> reservasBDLMList;
    RecyclerView recyclerView;
    AdaptadorReservasBDLM adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_reservas_bdlm);
        recyclerView = (RecyclerView)findViewById(R.id.rViewReservaBDLM);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reservasBDLMList = new ArrayList<>();
        mostrarReservaBDLM("http://10.0.0.18/bistrodelamer/mostrarReservas.php");
    }
    public void mostrarReservaBDLM(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array  = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++){
                        JSONObject obj = (JSONObject) array.get(i);
                        reservasBDLMList.add(new ReservasBDLM (
                                obj.getString("fecha_reserva"),
                                obj.getString("mesa"),
                                obj.getString("comensales"),
                                obj.getInt("id_reservas")
                        ));
                    }
                    adaptador = new AdaptadorReservasBDLM(getApplicationContext(), reservasBDLMList);
                    recyclerView.setAdapter(adaptador);
                }catch (JSONException e){
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ConsultarReservasBDLM.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("DNI", LoginBDLM.DNI);
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void volverAtras(View view){
        Intent volverAtras = new Intent(this, BistroDeLaMer.InformacionDetallaBDLMClon.class);
        startActivity(volverAtras);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
    public void onBackPressed() {
        Intent Informacion = new Intent(this, BistroDeLaMer.InformacionDetallaBDLMClon.class);
        startActivity(Informacion);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }


}