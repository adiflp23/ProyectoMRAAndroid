package com.example.mesonrafaelalberti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorCartaMRA extends RecyclerView.Adapter<AdaptadorCartaMRA.ViewHolder> {
    private Context cCtx;
    private List<cartaMRA> cartaMRAList;

    public AdaptadorCartaMRA(Context mCtx, List<cartaMRA> cartaMRAList){
        this.cCtx = mCtx;
        this.cartaMRAList = cartaMRAList;

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mraCategoria, mraNombre, mraPrecio;

        public ViewHolder(View itemView) {
            super(itemView);
            mraCategoria = (TextView) itemView.findViewById(R.id.mraCategoria);
            mraNombre = (TextView) itemView.findViewById(R.id.mraNombre);
            mraPrecio = (TextView) itemView.findViewById(R.id.mraPrecio);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mostrar_carta_mra, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        cartaMRA carta = cartaMRAList.get(position);

        viewHolder.mraCategoria.setText(carta.getCategoria());
        viewHolder.mraNombre.setText(carta.getNombre());
        viewHolder.mraPrecio.setText(String.valueOf(carta.getPrecio()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cartaMRAList.size();
    }
}
