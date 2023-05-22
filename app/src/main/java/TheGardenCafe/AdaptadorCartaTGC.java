package TheGardenCafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.mesonrafaelalberti.R;

import java.util.List;

public class AdaptadorCartaTGC extends RecyclerView.Adapter<AdaptadorCartaTGC.ViewHolder> {
    private Context cCtx;
    private List<cartaTGC> cartaTGCList;

    public AdaptadorCartaTGC(Context mCtx, List<cartaTGC> cartaTGCList){
        this.cCtx = mCtx;
        this.cartaTGCList = cartaTGCList;

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tgcCategoria, tgcNombre, tgcPrecio;

        public ViewHolder(View itemView) {
            super(itemView);
            tgcCategoria = (TextView) itemView.findViewById(R.id.tgcCategoria);
            tgcNombre = (TextView) itemView.findViewById(R.id.tgcNombre);
            tgcPrecio = (TextView) itemView.findViewById(R.id.tgcPrecio);
        }
    }
    @Override
    public AdaptadorCartaTGC.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mostrar_carta_tgc, viewGroup, false);
        return new AdaptadorCartaTGC.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(AdaptadorCartaTGC.ViewHolder viewHolder, int position) {

        cartaTGC carta = cartaTGCList.get(position);

        viewHolder.tgcCategoria.setText(carta.getCategoria());
        viewHolder.tgcNombre.setText("Plato: "+ carta.getNombre());
        viewHolder.tgcPrecio.setText("Precio: " + String.valueOf(carta.getPrecio()) + "€");

    }
    @Override
    public int getItemCount() {
        return cartaTGCList.size();
    }


}
