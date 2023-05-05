package com.example.mesonrafaelalberti;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdaptadorHorarioMRA extends RecyclerView.Adapter<AdaptadorHorarioMRA.ViewHolder> {
    private Context mCtx;
    private List<horarioMRA>horarioMRAList;

    public AdaptadorHorarioMRA(Context mCtx, List<horarioMRA> horarioMRAList){
        this.mCtx = mCtx;
        this.horarioMRAList = horarioMRAList;

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mraDia, mraApertura, mraCierre;

        public ViewHolder(View itemView) {
            super(itemView);
            mraDia = (TextView) itemView.findViewById(R.id.mraDia);
            mraApertura = (TextView) itemView.findViewById(R.id.mraApertura);
            mraCierre = (TextView) itemView.findViewById(R.id.mraCierre);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mostrar_horario_mra, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        horarioMRA horario = horarioMRAList.get(position);

        viewHolder.mraDia.setText(horario.getDia());
        viewHolder.mraApertura.setText(horario.getApertura());
        viewHolder.mraCierre.setText(horario.getCierre());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return horarioMRAList.size();
    }
}


