package TheGardenCafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mesonrafaelalberti.R;
import java.util.List;

public class AdaptadorHorarioTGC extends RecyclerView.Adapter<AdaptadorHorarioTGC.ViewHolder> {
    private Context tCtx;
    private List<horarioTGC> horarioTGCList;

    public AdaptadorHorarioTGC(Context bCtx, List<horarioTGC> horarioBDLMList){
        this.tCtx = bCtx;
        this.horarioTGCList = horarioBDLMList;
    }

    public static class  ViewHolder extends  RecyclerView.ViewHolder {
        TextView tgcDia, tgcApertura, tgcCierre;

        public ViewHolder(View itemView){
            super(itemView);
            tgcDia = (TextView) itemView.findViewById(R.id.tgcDia);
            tgcApertura = (TextView) itemView.findViewById(R.id.tgcApertura);
            tgcCierre = (TextView) itemView.findViewById(R.id.tgcCierre);

        }
    }

    @Override
    public AdaptadorHorarioTGC.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mostrar_horario_tgc, viewGroup, false);

        return new AdaptadorHorarioTGC.ViewHolder(view);
    }


    public void onBindViewHolder(AdaptadorHorarioTGC.ViewHolder viewHolder, int position){

        horarioTGC horario = horarioTGCList.get(position);
        viewHolder.tgcDia.setText(horario.getDia());
        viewHolder.tgcApertura.setText(horario.getApertura());
        viewHolder.tgcCierre.setText(horario.getCierre());

    }
    @Override
    public  int getItemCount(){
        return horarioTGCList.size();
    }

}

