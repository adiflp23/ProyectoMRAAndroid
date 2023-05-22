package BistroDeLaMer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mesonrafaelalberti.InformacionDetallaMRAClon;
import com.example.mesonrafaelalberti.Login;
import com.example.mesonrafaelalberti.R;

import java.util.HashMap;
import java.util.Map;

public class LoginBDLM extends AppCompatActivity {
    Button b1;
    EditText edusuario, edcontrasena;
    public static String DNI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_bdlm);
        b1 = findViewById(R.id.btn_loginBDLM);
        edusuario = findViewById(R.id.usuarioLoginBDLM);
        edcontrasena = findViewById(R.id.contrasenaLoginBDLM);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUsuarioBDLM("http://10.0.0.18/bistrodelamer/login.php");
            }
        });
    }
    public void Registrar(View view){
        Intent Registrar = new Intent(this, BistroDeLaMer.RegistrarBDLM.class);
        startActivity(Registrar);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent Informacion = new Intent(this, BistroDeLaMer.InformacionDetallaBDLM.class);
        startActivity(Informacion);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }

    public void loginUsuarioBDLM(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    DNI = TextUtils.substring(response, 8, 17);
                    Intent intent = new Intent(getApplicationContext(), BistroDeLaMer.InformacionDetallaBDLMClon.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                }else{
                    Toast.makeText(LoginBDLM.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginBDLM.this, error.getMessage(), Toast.LENGTH_SHORT).show();

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