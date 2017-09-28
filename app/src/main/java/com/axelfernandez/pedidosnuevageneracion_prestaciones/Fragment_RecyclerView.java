package com.axelfernandez.pedidosnuevageneracion_prestaciones;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_RecyclerView extends Fragment {
    private ProgressDialog progressDialog;
    View v;
    Query db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Automoviles");
    int VALUE_ORDER =0;

    public Fragment_RecyclerView() {
        // Required empty public constructor
    }

    private CallBackListener callBackListener;





    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v = inflater.inflate(R.layout.fragment_fragment__recycler_view, container, false);
        View nc= inflater.inflate(R.layout.no_conexion, container,false);
        this.setHasOptionsMenu(true);


           progressDialog = new ProgressDialog(getContext());
           progressDialog.setMessage("Cargando Artículos");
           progressDialog.setCancelable(false);
           progressDialog.show();
           int posi = getArguments().getInt("pos");
           Log.e("Recibido", String.valueOf(posi));
     DBReference dbref = new DBReference();
        db =  dbref.dbgetreference(posi,VALUE_ORDER);

        final FirebaseStorage storage = FirebaseStorage.getInstance();




           FirebaseRecyclerAdapter<Productos, ProductViewHolder> fvadapter = new FirebaseRecyclerAdapter<Productos, ProductViewHolder>(
                   Productos.class,
                   R.layout.item_cardproducto,
                   ProductViewHolder.class,
                   db

           ) {

               @Override
               protected void populateViewHolder(final ProductViewHolder viewHolder, final Productos model, int position) {

                   Glide.with(getContext()).using(new FirebaseImageLoader()).load(storage.getReferenceFromUrl(model.getFoto())).into(viewHolder.foto);
                   viewHolder.name.setText(model.getNombre());
                   viewHolder.price.setText("$" + model.getPrecio());

                   progressDialog.dismiss();
                   viewHolder.b.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           callBackListener.onCallBack(model.nombre, String.valueOf(model.precio), viewHolder.numberPicker.getValue());


                           viewHolder.b.setEnabled(false);

                           viewHolder.b.setImageResource(R.drawable.ic_check_black_24dp);
                           Snackbar.make(v, "Se ha agregado correctamente " + viewHolder.name.getText() + ". La cantidad de " + viewHolder.numberPicker.getValue() + " Unidades", Snackbar.LENGTH_LONG)
                                   .setAction("Action", null).show();
                       }
                   });


               }
           };


           RecyclerView rv = (RecyclerView) v.findViewById(R.id.rv);
           rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
           rv.setAdapter(fvadapter);

            return v;}



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getActivity() is fully created in onActivityCreated and instanceOf differentiate it between different Activities
        if (getActivity() instanceof CallBackListener)
            callBackListener = (CallBackListener) getActivity();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
         inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menufragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();

        if (id==R.id.action_ordenar_name){
         if(VALUE_ORDER==0|| VALUE_ORDER==2){

            VALUE_ORDER=1;
           FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.detach(this).attach(this).commit();
            return true;
        }
        }
        if(id==R.id.action_menor_precio){
            if (VALUE_ORDER==0 || VALUE_ORDER==1){
                VALUE_ORDER=2;
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(this).attach(this).commit();
                return true;

            }
        }
        if(id==R.id.action_ultimos_agregados){
            if (VALUE_ORDER==2 || VALUE_ORDER==1){
                VALUE_ORDER=0;
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(this).attach(this).commit();
                return true;

            }

        }
    return false;
    }
}
