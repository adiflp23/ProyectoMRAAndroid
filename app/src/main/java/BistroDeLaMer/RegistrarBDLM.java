package BistroDeLaMer;

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

import java.util.HashMap;
import java.util.Map;

public class RegistrarBDLM extends AppCompatActivity {

    Button b1;
    EditText edDni, edUsuario, edContrasena, edNombre, edApellido, edEmail, edTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_bdlm);
        b1 = findViewById(R.id.btn_registrarBDLM);
        edDni = findViewById(R.id.edDniBDLM);
        edUsuario = findViewById(R.id.edUsuarioBDLM);
        edContrasena = findViewById(R.id.edContrasenaBDLM);
        edNombre = findViewById(R.id.edNombreBDLM);
        edApellido = findViewById(R.id.edApellidoBDLM);
        edEmail = findViewById(R.id.edEmailBDLM);
        edTelefono = findViewById(R.id.edTelefonoTGC);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarUsuarioBDLM("http://10.0.0.18/bistrodelamer/registrar.php");
            }
        });

    }
    public void LoginBDLM(View view){
        Intent LoginBDLM = new Intent(this, BistroDeLaMer.LoginBDLM.class);
        startActivity(LoginBDLM);
        finish();
    }

    public void RegistrarUsuarioBDLM(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    Toast.makeText(RegistrarBDLM.this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), BistroDeLaMer.LoginBDLM.class);
                    startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegistrarBDLM.this, error.getMessage(), Toast.LENGTH_SHORT).show();

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