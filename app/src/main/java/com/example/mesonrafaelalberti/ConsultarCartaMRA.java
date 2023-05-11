package com.example.mesonrafaelalberti;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsultarCartaMRA extends AppCompatActivity {

    List<cartaMRA> cartaMRAList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_carta_mra);
        recyclerView = (RecyclerView)findViewById(R.id.rViewCartaMRA);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartaMRAList = new ArrayList<>();
        mostrarCartaMRA("http://10.0.0.43/rafaelalberti/mostrarCarta.php");
    }
    public void mostrarCartaMRA(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array  = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++){
                        JSONObject obj = (JSONObject) array.get(i);
                        cartaMRAList.add(new cartaMRA (
                                obj.getString("categoria"),
                                obj.getString("nombre"),
                                (float) obj.getDouble("precio")
                        ));
                    }
                    AdaptadorCartaMRA adaptador = new AdaptadorCartaMRA(getApplicationContext(), cartaMRAList);
                    recyclerView.setAdapter(adaptador);
                }catch (JSONException e){

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ConsultarCartaMRA.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void volverAtras(View view){
        Intent volverAtras = new Intent(this, com.example.mesonrafaelalberti.InformacionDetallaMRAClon.class);
        startActivity(volverAtras);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }

}