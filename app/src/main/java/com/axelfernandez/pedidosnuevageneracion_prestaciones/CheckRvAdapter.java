package com.axelfernandez.pedidosnuevageneracion_prestaciones;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axelfernandez on 3/9/17.
 */

public class CheckRvAdapter extends RecyclerView.Adapter<CheckRvAdapter.CheckViewHolder> {
    List<Productos> prod;
    CheckRvAdapter(List<Productos> prod){
        this.prod = prod;
    }
    ArrayList<Integer> elimina = new ArrayList<>();
    ArrayList<Integer> restar = new ArrayList<>();

    public static class CheckViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView cantidad;
        TextView precio;
        ImageView deletle;


        CheckViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.item_check_prod);
            cantidad = (TextView)itemView.findViewById(R.id.item_check_cant);
            precio = (TextView)itemView.findViewById(R.id.item_check_price);
            deletle = (ImageView) itemView.findViewById(R.id.item_check_deletle);
        }
    }


    @Override
    public CheckViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.check_item, parent, false);
        CheckViewHolder pcvh = new CheckViewHolder(v);
        return pcvh;
    }

    @Override
    public void onBindViewHolder(final CheckViewHolder holder, int position) {
       Productos produc = prod.get(position);
        holder.nombre.setText(prod.get(position).getNombre());
       holder.cantidad.setText(String.valueOf(prod.get(position).getCantidad()));
        holder.precio.setText("$ "+prod.get(position).getPrecio());


        holder.deletle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeItem(holder.getAdapterPosition());

            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    private void removeItem(int position) {
        prod.remove(position);
        notifyItemRemoved(position);
        elimina.add(position);
    }
    @Override
    public int getItemCount() {
        return prod.size();
    }

public ArrayList<Integer> pasararray (){



    return elimina;
}

}
