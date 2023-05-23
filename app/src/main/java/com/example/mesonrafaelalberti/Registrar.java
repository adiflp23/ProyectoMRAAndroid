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

import BistroDeLaMer.RegistrarBDLM;

public class Registrar extends AppCompatActivity {
    Button b1;
    EditText edDni, edUsuario, edContrasena, edNombre, edApellido, edEmail, edTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        b1 = findViewById(R.id.btn_registrarMRA);
        edDni = findViewById(R.id.edDniMRA);
        edUsuario = findViewById(R.id.edUsuarioMRA);
        edContrasena = findViewById(R.id.edContrasenaMRA);
        edNombre = findViewById(R.id.edNombreMRA);
        edApellido = findViewById(R.id.edApellidoMRA);
        edEmail = findViewById(R.id.edEmailMRA);
        edTelefono = findViewById(R.id.edTelefonoMRA);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarUsuarioMRA("http://10.0.0.18/rafaelalberti/registrar.php");
            }
        });

    }
    public void LoginMRA(View view){
        Intent LoginMRA = new Intent(this, com.example.mesonrafaelalberti.Login.class);
        startActivity(LoginMRA);
        finish();
    }
    public void RegistrarUsuarioMRA(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                Toast.makeText(Registrar.this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), com.example.mesonrafaelalberti.Login.class);
                startActivity(intent);
                }else{
                    Toast.makeText(Registrar.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Registrar.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("DNI", edDni.getText().toString());
                parametros.put("usuario", edUsuario.getText().toString());
                parametros.put("contrasena", edContrasena.getText().toString());
                parametros.put("nombre", edNombre.getText().toString());
                parametros.put("apellido", edApellido.getText().toString());
                parametros.put("email", edEmail.getText().toString());
                parametros.put("telefono", edTelefono.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void onBackPressed() {
        Intent Informacion = new Intent(this, com.example.mesonrafaelalberti.Login.class);
        startActivity(Informacion);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
}