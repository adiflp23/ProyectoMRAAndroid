package com.example.mesonrafaelalberti;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mesonrafaelalberti.conexionMYSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    EditText edusuario, edcontrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =  findViewById(R.id.lbtn_iniciarSesion);
        edusuario = findViewById(R.id.ltxt_usuario);
        edcontrasena = findViewById(R.id.ltxt_contrasena);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUsuario("http://10.0.0.43/rafaelalberti/login.php");
            }
        });
    }

    public void menuRegistrar(View view){
        Intent menuRegistrar = new Intent(this, menuRegistrar.class);
        startActivity(menuRegistrar);
        finish();
    }
    public void loginUsuario(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Intent intent = new Intent(getApplicationContext(), menuEstandar.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("usuario", edusuario.getText().toString());
                parametros.put("contrasena", edcontrasena.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}