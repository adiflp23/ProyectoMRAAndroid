package TheGardenCafe;

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
import com.example.mesonrafaelalberti.R;
import com.example.mesonrafaelalberti.Registrar;

import java.util.HashMap;
import java.util.Map;

import BistroDeLaMer.LoginBDLM;

public class RegistrarTGC extends AppCompatActivity {
    Button b1;
    EditText edDni, edUsuario, edContrasena, edNombre, edApellido, edEmail, edTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_tgc);
        b1 = findViewById(R.id.btn_registrarTGC);
        edDni = findViewById(R.id.edDniTGC);
        edUsuario = findViewById(R.id.edUsuarioTGC);
        edContrasena = findViewById(R.id.edContrasenaTGC);
        edNombre = findViewById(R.id.edNombreTGC);
        edApellido = findViewById(R.id.edApellidoTGC);
        edEmail = findViewById(R.id.edEmailTGC);
        edTelefono = findViewById(R.id.edTelefonoTGC);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarUsuarioMRA("http://10.0.0.18/thegardencafe/registrar.php");
            }
        });
    }
    public void LoginTGC(View view){
        Intent LoginTGC = new Intent(this, TheGardenCafe.LoginTGC.class);
        startActivity(LoginTGC);
        finish();
    }
    public void RegistrarUsuarioMRA(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                Intent intent = new Intent(getApplicationContext(), TheGardenCafe.LoginTGC.class);
                startActivity(intent);
                }else{
                    Toast.makeText(RegistrarTGC.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegistrarTGC.this, error.getMessage(), Toast.LENGTH_SHORT).show();

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

}