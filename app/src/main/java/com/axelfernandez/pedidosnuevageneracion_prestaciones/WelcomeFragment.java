package com.axelfernandez.pedidosnuevageneracion_prestaciones;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    private ProgressDialog progressDialog;
    Query db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Automoviles");
    int VALUE_ORDER =0;
    private CallBackListener callBackListener;
RecyclerView rv;
    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_welcome, container, false);


        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Cargando Artículos");
        progressDialog.setCancelable(false);
        progressDialog.show();
        int posi = (int) (Math.random()*13+1);
        DBReference dbref = new DBReference();
        db =  dbref.dbgetreference(posi,VALUE_ORDER);
        TextView tv = (TextView)v.findViewById(R.id.welcome_rubro);
        tv.setText("Mirá estos productos en el Rubro de: "+dbref.desc(posi));
        final FirebaseStorage storage = FirebaseStorage.getInstance();




        final FirebaseRecyclerAdapter<Productos, ProductViewHolder> fvadapter = new FirebaseRecyclerAdapter<Productos, ProductViewHolder>(
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
                viewHolder.numberPicker.setVisibility(View.INVISIBLE);
                viewHolder.b.setVisibility(View.INVISIBLE);
                viewHolder.cantidad.setText("");
                progressDialog.dismiss();



            }
        };


        rv = (RecyclerView) v.findViewById(R.id.welcome_rv);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(fvadapter);
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastItem = layoutManager.findLastCompletelyVisibleItemPosition();
                if(lastItem == layoutManager.getItemCount()-1){
                    mHandler.removeCallbacks(SCROLLING_RUNNABLE);
                    Handler postHandler = new Handler();
                    postHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            rv.setAdapter(null);
                            rv.setAdapter(fvadapter);
                            mHandler.postDelayed(SCROLLING_RUNNABLE, 2000);
                        }
                    }, 2000);
                }
            }
        });
        mHandler.postDelayed(SCROLLING_RUNNABLE, 2000);
        return v;}



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getActivity() is fully created in onActivityCreated and instanceOf differentiate it between different Activities
        if (getActivity() instanceof CallBackListener)
            callBackListener = (CallBackListener) getActivity();
    }
    final int duration = 10;
    final int pixelsToMove = 30;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable SCROLLING_RUNNABLE = new Runnable() {

        @Override
        public void run() {
            rv.smoothScrollBy(pixelsToMove, 0);
            mHandler.postDelayed(this, duration);
        }
    };


    }


