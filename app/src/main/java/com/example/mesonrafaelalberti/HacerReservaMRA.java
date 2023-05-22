package com.example.mesonrafaelalberti;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class HacerReservaMRA extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Spinner sp1, sp2;
    TextView textView;
    Button b1, b2;
    int day, month, year, hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;
    String fecha;
    String fechaSeleccionada;
    String hora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacer_reserva_mra);
        textView = findViewById(R.id.textView4);
        b1 = findViewById(R.id.btn_Fecha);
        b2 = findViewById(R.id.btn_confirmarReserva);
        sp1 = findViewById(R.id.spinnerNumPersonas);
        sp2 = findViewById(R.id.spinnerNumMesa);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(HacerReservaMRA.this, HacerReservaMRA.this, year, month, day);
                datePickerDialog.show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hacerReserva("http://10.0.0.18/rafaelalberti/hacerReserva.php");
            }
        });
        ArrayList<String> numeros = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numeros.add(String.valueOf(i));
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numeros);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adaptador);

        ArrayList<String> numerosMesa = new ArrayList<>();

        numerosMesa.add("11");
        numerosMesa.add("22");
        numerosMesa.add("9");
        numerosMesa.add("7");
        numerosMesa.add("5");
        numerosMesa.add("1");

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numerosMesa);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adaptador2);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        myYear = year;
        myday = day;
        myMonth = month + 1;
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(HacerReservaMRA.this, HacerReservaMRA.this, hour, minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();
        fecha = myYear + "-" + myMonth + "-" + myday + " ";
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        myHour = hourOfDay;
        myMinute = minute;
        hora = myHour + ":" + myMinute;
        fechaSeleccionada = fecha + hora;
        textView.setText(fechaSeleccionada);
    }

    public void hacerReserva(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()) {
                    Toast.makeText(HacerReservaMRA.this, "Reserva Registrada Correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(HacerReservaMRA.this, "Reserva no Registrada", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HacerReservaMRA.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();

                parametros.put("DNI", Login.DNI.toString());
                parametros.put("fecha_reserva", fechaSeleccionada.toString());
                parametros.put("mesa", sp2.getSelectedItem().toString());
                parametros.put("comensales", sp1.getSelectedItem().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void onBackPressed() {
        Intent Informacion = new Intent(this, com.example.mesonrafaelalberti.InformacionDetallaMRAClon.class);
        startActivity(Informacion);
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
        finish();
    }
}