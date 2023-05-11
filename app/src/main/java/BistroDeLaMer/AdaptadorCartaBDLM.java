package BistroDeLaMer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mesonrafaelalberti.AdaptadorCartaMRA;
import com.example.mesonrafaelalberti.R;
import com.example.mesonrafaelalberti.cartaMRA;

import java.util.List;

public class AdaptadorCartaBDLM extends RecyclerView.Adapter<AdaptadorCartaBDLM.ViewHolder> {
    private Context cCtx;
    private List<cartaBDLM> cartaBDLMList;

    public AdaptadorCartaBDLM(Context mCtx, List<cartaBDLM> cartaBDLMList){
        this.cCtx = mCtx;
        this.cartaBDLMList = cartaBDLMList;

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView bdlmCategoria, bdlmNombre, bdlmPrecio;

        public ViewHolder(View itemView) {
            super(itemView);
            bdlmCategoria = (TextView) itemView.findViewById(R.id.bdlmCategoria);
            bdlmNombre = (TextView) itemView.findViewById(R.id.bdlmNombre);
            bdlmPrecio = (TextView) itemView.findViewById(R.id.bdlmPrecio);
        }
    }
    @Override
    public AdaptadorCartaBDLM.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mostrar_carta_bdlm, viewGroup, false);
        return new AdaptadorCartaBDLM.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(AdaptadorCartaBDLM.ViewHolder viewHolder, int position) {

        cartaBDLM carta = cartaBDLMList.get(position);

        viewHolder.bdlmCategoria.setText(carta.getCategoria());
        viewHolder.bdlmNombre.setText(carta.getNombre());
        viewHolder.bdlmPrecio.setText(String.valueOf(carta.getPrecio()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cartaBDLMList.size();
    }

}
