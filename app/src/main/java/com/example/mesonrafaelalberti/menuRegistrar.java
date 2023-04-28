package com.example.mesonrafaelalberti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.PreparedStatement;

public class menuRegistrar extends AppCompatActivity {
    Button b1, b2;
    EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_registrar);
        b1 = (Button)findViewById(R.id.rbtn_volver);
        b2 = (Button)findViewById(R.id.rbtn_registrar);
        ed1 = (EditText) findViewById(R.id.rtxt_dni);
        ed2 = (EditText) findViewById(R.id.rtxt_usuario);
        ed3 = (EditText) findViewById(R.id.rtxt_contrasena);
        ed4 = (EditText) findViewById(R.id.rtxt_concontrasena);
        ed5 = (EditText) findViewById(R.id.rtxt_nombre);
        ed6 = (EditText) findViewById(R.id.rtxt_apellido);
        ed7 = (EditText) findViewById(R.id.rtxt_email);
        ed8 = (EditText) findViewById(R.id.rtxt_tlf);
        ed9 = (EditText) findViewById(R.id.rtxt_tipo);

    }
    public void MainActivity(View view){
        Intent MainActivity = new Intent(this, MainActivity.class);
        startActivity(MainActivity);
        finish();
    }
}