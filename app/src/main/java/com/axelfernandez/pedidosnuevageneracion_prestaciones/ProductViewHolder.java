package com.axelfernandez.pedidosnuevageneracion_prestaciones;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.shawnlin.numberpicker.NumberPicker;

/**
 * Created by axelfernandez on 2/9/17.
 */

public  class ProductViewHolder extends RecyclerView.ViewHolder {
    CardView cv;
    TextView price;
    TextView name;
    ImageView foto;
    ImageButton b;
    NumberPicker numberPicker;
    TextView cantidad;

    ProductViewHolder(final View itemView) {
        super(itemView);
        cv = (CardView)itemView.findViewById(R.id.cv);
        price = (TextView)itemView.findViewById(R.id.item_prod_price);
        name = (TextView)itemView.findViewById(R.id.item_prod_desc);
        foto = (ImageView)itemView.findViewById(R.id.item_prod_image);
        numberPicker = (NumberPicker) itemView.findViewById(R.id.np__numberpicker_input2);
        b = (ImageButton)itemView.findViewById(R.id.imageButton);
        cantidad = (TextView) itemView.findViewById(R.id.item_prod_cant);
    }

    }