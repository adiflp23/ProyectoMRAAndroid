package com.example.mesonrafaelalberti;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mysql.cj.xdevapi.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BistroDeLaMer.RegistrarBDLM;

public class ConsultarHorarioMRA extends AppCompatActivity {

    List<horarioMRA>horarioMRAList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_horario_mra);
        recyclerView = (RecyclerView)findViewById(R.id.rViewListaMRA);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        horarioMRAList = new ArrayList<>();
        mostrarHorarioMRA("http://10.0.0.43/rafaelalberti/mostrarHorario.php");
    }


    public void mostrarHorarioMRA(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array  = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++){
                        JSONObject obj = (JSONObject) array.get(i);
                        horarioMRAList.add(new horarioMRA (
                                obj.getString("dia"),
                                obj.getString("apertura"),
                                obj.getString("cierre")
                                ));
                    }
                    AdaptadorHorarioMRA adaptador = new AdaptadorHorarioMRA(getApplicationContext(), horarioMRAList);
                    recyclerView.setAdapter(adaptador);
                }catch (JSONException e){

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ConsultarHorarioMRA.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}