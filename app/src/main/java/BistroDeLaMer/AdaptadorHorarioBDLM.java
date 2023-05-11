package BistroDeLaMer;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.view.LayoutInflater;

import com.example.mesonrafaelalberti.R;

public class AdaptadorHorarioBDLM extends RecyclerView.Adapter<AdaptadorHorarioBDLM.ViewHolder> {
    private Context bCtx;
    private List<horarioBDLM>horarioBDLMList;

    public AdaptadorHorarioBDLM(Context bCtx, List<horarioBDLM> horarioBDLMList){
        this.bCtx = bCtx;
        this.horarioBDLMList = horarioBDLMList;
    }

    public static class  ViewHolder extends  RecyclerView.ViewHolder {
        TextView bdlmDia, bdlmApertura, bdlmCierre;

        public ViewHolder(View itemView){
            super(itemView);
            bdlmDia = (TextView) itemView.findViewById(R.id.bdlmDia);
            bdlmApertura = (TextView) itemView.findViewById(R.id.bdlmApertura);
            bdlmCierre = (TextView) itemView.findViewById(R.id.bdlmCierre);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mostrar_horario_bdlm, viewGroup, false);

        return new ViewHolder(view);
    }


    public void onBindViewHolder(ViewHolder viewHolder, int position){

        horarioBDLM horario = horarioBDLMList.get(position);
        viewHolder.bdlmDia.setText(horario.getDia());
        viewHolder.bdlmApertura.setText(horario.getApertura());
        viewHolder.bdlmCierre.setText(horario.getCierre());

    }
    @Override
    public  int getItemCount(){
        return horarioBDLMList.size();
    }

}
