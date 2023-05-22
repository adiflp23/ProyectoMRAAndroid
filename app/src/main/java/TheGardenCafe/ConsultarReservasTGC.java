package TheGardenCafe;

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
import com.example.mesonrafaelalberti.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultarReservasTGC extends AppCompatActivity {

    List<ReservasTGC> reservasTGCList;
    RecyclerView recyclerView;
    AdaptadorReservasTGC adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_reservas_tgc);
        recyclerView = (RecyclerView)findViewById(R.id.rViewReservaTGC);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reservasTGCList = new ArrayList<>();
        mostrarReservaTGC("http://10.0.0.18/thegardencafe/mostrarReservas.php");
    }
    public void mostrarReservaTGC(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array  = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++){
                        JSONObject obj = (JSONObject) array.get(i);
                        reservasTGCList.add(new ReservasTGC (
                                obj.getString("fecha_reserva"),
                                obj.getString("mesa"),
                                obj.getString("comensales"),
                                obj.getInt("id_reservas")
                        ));
                    }
                    adaptador = new AdaptadorReservasTGC(getApplicationContext(), reservasTGCList);
                    recyclerView.setAdapter(adaptador);
                }catch (JSONException e){
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ConsultarReservasTGC.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("DNI", LoginTGC.DNI);
                return parametros;
            }
        };
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