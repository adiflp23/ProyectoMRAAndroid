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

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    Button b1;
    EditText edusuario, edcontrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = findViewById(R.id.btn_loginMRA);
        edusuario = findViewById(R.id.usuarioLoginMRA);
        edcontrasena = findViewById(R.id.contrasenaLoginMRA);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUsuarioMRA("http://10.0.0.43/rafaelalberti/login.php");
            }
        });
    }

    public void RegistrarMRA(View view){
        Intent Registrar = new Intent(this, com.example.mesonrafaelalberti.Registrar.class);
        startActivity(Registrar);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent Informacion = new Intent(this, com.example.mesonrafaelalberti.InformacionDetallaMRA.class);
        startActivity(Informacion);
        finish();
    }

    public void loginUsuarioMRA(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Intent intent = new Intent(getApplicationContext(), InformacionDetallaMRAClon.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                }else{
                    Toast.makeText(Login.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, error.getMessage(), Toast.LENGTH_SHORT).show();

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