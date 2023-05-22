package BistroDeLaMer;

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

public class ConsultarCartaBDLM extends AppCompatActivity {
    List<cartaBDLM> cartaBDLMList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_carta_bdlm);
        recyclerView = (RecyclerView)findViewById(R.id.rViewCartaMRA);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartaBDLMList = new ArrayList<>();
        mostrarCartaBDLM("http://10.0.0.18/bistrodelamer/mostrarCarta.php");
    }
    public void mostrarCartaBDLM(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array  = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++){
                        JSONObject obj = (JSONObject) array.get(i);
                        cartaBDLMList.add(new cartaBDLM(
                                obj.getString("categoria"),
                                obj.getString("nombre"),
                                (float) obj.getDouble("precio")
                        ));
                    }
                    AdaptadorCartaBDLM adaptador = new AdaptadorCartaBDLM(getApplicationContext(), cartaBDLMList);
                    recyclerView.setAdapter(adaptador);
                }catch (JSONException e){

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ConsultarCartaBDLM.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void volverAtras(View view){
        Intent volverAtras = new Intent(this, BistroDeLaMer.InformacionDetallaBDLMClon.class);
        startActivity(volverAtras);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }

}