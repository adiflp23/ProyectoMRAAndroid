package BistroDeLaMer;

import android.content.Context;
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
import com.example.mesonrafaelalberti.AdaptadorReservasMRA;
import com.example.mesonrafaelalberti.R;
import com.example.mesonrafaelalberti.ReservasMRA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdaptadorReservasBDLM extends RecyclerView.Adapter<AdaptadorReservasBDLM.ViewHolder>{
    private Context cCtx;
    private List<ReservasBDLM> reservasBDLMList;

    public AdaptadorReservasBDLM(Context mCtx, List<ReservasBDLM> reservasBDLMList){
        this.cCtx = mCtx;
        this.reservasBDLMList = reservasBDLMList;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView bdlmfechaReserva, bdlmMesa, bdlmPersonas;
        Button anularReserva;

        public ViewHolder(View itemView) {
            super(itemView);
            bdlmfechaReserva = (TextView) itemView.findViewById(R.id.bdlmFechaReserva);
            bdlmMesa = (TextView) itemView.findViewById(R.id.bdlmMesa);
            bdlmPersonas = (TextView) itemView.findViewById(R.id.bdlmPersonas);
            anularReserva = (Button) itemView.findViewById(R.id.anularReservaBDLM);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mostrar_reservas_bdlm, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AdaptadorReservasBDLM.ViewHolder viewHolder, int position) {

        ReservasBDLM reserva = reservasBDLMList.get(position);
        viewHolder.bdlmfechaReserva.setText("Fecha De La Reserva: " + reserva.getFecha_reserva());
        viewHolder.bdlmMesa.setText("Nº De La Mesa: " + reserva.getMesa());
        viewHolder.bdlmPersonas.setText("Nº De Personas: " + reserva.getComensales());

        viewHolder.anularReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = reservasBDLMList.get(position).getId();
                eliminarReserva(id);
                notifyItemRemoved(id);
            }
        });

    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return reservasBDLMList.size();
    }

    public void eliminarReserva(int id){
        String URL = "http://10.0.0.18/bistrodelamer/eliminarReserva.php";
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
