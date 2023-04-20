package com.example.mesonrafaelalberti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.mesonrafaelalberti.conexionMYSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    EditText usuario, contrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =  findViewById(R.id.lbtn_iniciarSesion);
        usuario = findViewById(R.id.ltxt_usuario);
        contrasena = findViewById(R.id.ltxt_contrasena);
    }

    public void enLoginButtonClick(View view){
        ResultSet rs=null;
        conexionMYSQL con = new conexionMYSQL();
        con.ConectarBasedeDatos();
        try {
            String SQL = "SELECT tipo_usuario FROM usuarios WHERE usuario = ? AND contrasena = ?";
            PreparedStatement pstmt = con.conexion.prepareStatement(SQL);
            pstmt.setString(1, usuario.getText().toString());
            pstmt.setString(2, contrasena.getText().toString());
            rs = pstmt.executeQuery();
            int tipo=0;
            while (rs.next())
            {
                tipo = rs.getInt("tipo_usuario");
            }

            if(tipo == 1){
                startActivity(new Intent(getApplicationContext(), menuAdmin.class));
            } else if(tipo == 0){
                startActivity(new Intent(getApplicationContext(), menuEstandar.class));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void menuRegistrar(View view){
        Intent menuRegistrar = new Intent(this, menuRegistrar.class);
        startActivity(menuRegistrar);
        finish();
    }
}