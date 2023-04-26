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
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            registrarUsuarios();
            }
        });


    }
    public void registrarUsuarios() {
        try {
            PreparedStatement ps;
            conexionMYSQL con = new conexionMYSQL();

            con.ConectarBasedeDatos();
            String DNI = ed1.getText().toString();
            String usuario = ed2.getText().toString();
            String contrasena = String.valueOf(ed3.getText());
            String concontrasena = String.valueOf(ed4.getText());
            String nombre = ed5.getText().toString();
            String apellido = ed6.getText().toString();
            String email = ed7.getText().toString();
            int telefono = Integer.parseInt(String.valueOf(ed8.getText()));
            String codigo = ed9.getText().toString();
            String ADM = "colega";

            String sql;

            sql = "insert into usuarios(DNI, usuario, contrasena, nombre, apellido, email, telefono, tipo_usuario) values(?,?,?,?,?,?,?,?)";
            try {
                ps = con.conexion.prepareStatement(sql);

                ps.setString(1, DNI);

                ps.setString(2, usuario);

                ps.setString(3, contrasena);

                ps.setString(4, nombre);

                ps.setString(5, apellido);

                ps.setString(6, email);

                ps.setInt(7, telefono);

                if (codigo.equals(ADM)) {
                    ps.setInt(8, 1);
                } else {
                    ps.setInt(8, 0);
                }

                if (contrasena.equals(concontrasena)) {

                    try {
                        ps.executeUpdate();
                        Toast.makeText(getApplicationContext(),"usuario insertado correctamente", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                }

            } catch (Exception e) {
            }

        } catch (Exception e) {
        }
    }
    public void MainActivity(View view){
        Intent MainActivity = new Intent(this, MainActivity.class);
        startActivity(MainActivity);
        finish();
    }
}