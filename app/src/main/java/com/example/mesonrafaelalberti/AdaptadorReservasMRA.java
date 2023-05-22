package com.example.mesonrafaelalberti;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdaptadorReservasMRA extends RecyclerView.Adapter<AdaptadorReservasMRA.ViewHolder> {

    private Context cCtx;
    private List<ReservasMRA> reservasMRAList;

    public AdaptadorReservasMRA(Context mCtx, List<ReservasMRA> reservasMRAList){
        this.cCtx = mCtx;
        this.reservasMRAList = reservasMRAList;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mrafechaReserva, mraMesa, mraPersonas;
        Button anularReserva;

        public ViewHolder(View itemView) {
            super(itemView);
            mrafechaReserva = (TextView) itemView.findViewById(R.id.mraFechaReserva);
            mraMesa = (TextView) itemView.findViewById(R.id.mraMesa);
            mraPersonas = (TextView) itemView.findViewById(R.id.mraPersonas);
            anularReserva = (Button) itemView.findViewById(R.id.anularReservaMRA);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mostrar_reservas_mra, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        ReservasMRA reserva = reservasMRAList.get(position);
        viewHolder.mrafechaReserva.setText("Fecha De La Reserva: " + reserva.getFecha_reserva());
        viewHolder.mraMesa.setText("Nº De La Mesa: " + reserva.getMesa());
        viewHolder.mraPersonas.setText("Nº De Personas: " + reserva.getComensales());

        viewHolder.anularReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = reservasMRAList.get(position).getId();
                eliminarReserva(id);
                notifyItemRemoved(id);
            }
        });

    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return reservasMRAList.size();
    }

    public void eliminarReserva(int id){
        String URL = "http://10.0.0.18/rafaelalberti/eliminarReserva.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Toast.makeText(cCtx, "Reserva Anulada Correctamente", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(cCtx, "Reserva No Anulada", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(cCtx, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("id_reservas", String.valueOf(id));
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(cCtx);
        requestQueue.add(stringRequest);


    }

}
