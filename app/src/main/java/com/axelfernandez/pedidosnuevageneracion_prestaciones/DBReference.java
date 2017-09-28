package com.axelfernandez.pedidosnuevageneracion_prestaciones;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * Created by axelfernandez on 26/9/17.
 */

public class DBReference {


    public Query dbgetreference(int posi, int VALUE_ORDER){
        Query db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Automoviles");
        if (posi==1 && VALUE_ORDER==0){db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Automoviles");}
        else if (posi==2 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Motos");}
        else if (posi==3 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Bicicletas");}
        else if (posi==4 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Televisores");}
        else if (posi==5 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Celulares");}
        else if (posi==6 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Carcasa_Celulares");}
        else if (posi==7 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Electrodomesticos");}
        else if (posi==8 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Muebles_Hogar");}
        else if (posi==9 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Articulos_Hogar");}
        else if (posi==10 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Tazas_Diseños");}
        else if (posi==11 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Llaveros_Diseños");}
        else if (posi==12 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Ropa_Deportiva");}
        else if (posi==13 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Ropa_Formal");}
        else if (posi==14 && VALUE_ORDER==0){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Articulos_Varios");}

        if (posi==1 && VALUE_ORDER==1){db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Automoviles").orderByChild("nombre");}
        else if (posi==2 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Motos").orderByChild("nombre");}
        else if (posi==3 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Bicicletas").orderByChild("nombre");}
        else if (posi==4 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Televisores").orderByChild("nombre");}
        else if (posi==5 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Celulares").orderByChild("nombre");}
        else if (posi==6 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Carcasa_Celulares").orderByChild("nombre");}
        else if (posi==7 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Electrodomesticos").orderByChild("nombre");}
        else if (posi==8 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Muebles_Hogar").orderByChild("nombre");}
        else if (posi==9 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Articulos_Hogar").orderByChild("nombre");}
        else if (posi==10 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Tazas_Diseños").orderByChild("nombre");}
        else if (posi==11 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Llaveros_Diseños").orderByChild("nombre");}
        else if (posi==12 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Ropa_Deportiva").orderByChild("nombre");}
        else if (posi==13 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Ropa_Formal").orderByChild("nombre");}
        else if (posi==14 && VALUE_ORDER==1){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Articulos_Varios").orderByChild("nombre");}


        if (posi==1 && VALUE_ORDER==2){db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Automoviles").orderByChild("precio");}
        else if (posi==2 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Motos").orderByChild("precio");}
        else if (posi==3 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Bicicletas").orderByChild("precio");}
        else if (posi==4 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Televisores").orderByChild("precio");}
        else if (posi==5 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Celulares").orderByChild("precio");}
        else if (posi==6 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Carcasa_Celulares").orderByChild("precio");}
        else if (posi==7 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Electrodomesticos").orderByChild("precio");}
        else if (posi==8 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Muebles_Hogar").orderByChild("precio");}
        else if (posi==9 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Articulos_Hogar").orderByChild("precio");}
        else if (posi==10 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Tazas_Diseños").orderByChild("precio");}
        else if (posi==11 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Llaveros_Diseños").orderByChild("precio");}
        else if (posi==12 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Ropa_Deportiva").orderByChild("precio");}
        else if (posi==13 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Ropa_Formal").orderByChild("precio");}
        else if (posi==14 && VALUE_ORDER==2){ db = FirebaseDatabase.getInstance().getReference().child("Rubro").child("Articulos_Varios").orderByChild("precio");}
return db;
    }

    public String desc (int posi){
        String desc= null;


        if (posi==1 ){desc = "Automoviles";}
        else if (posi==2 ){ desc = "Motos";}
        else if (posi==3 ){ desc = "Bicicletas";}
        else if (posi==4){ desc = "Televisores";}
        else if (posi==5){ desc = "Celulares";}
        else if (posi==6){ desc = "Carcasa Para Celulares";}
        else if (posi==7){ desc = "Electrodomesticos";}
        else if (posi==8){ desc = "Muebles Para el Hogar";}
        else if (posi==9 ){ desc = "Articulos Para el Hogar";}
        else if (posi==10){ desc = "Tazas Con Diseños";}
        else if (posi==11){ desc = "Llaveros Con diseños";}
        else if (posi==12){ desc = "Ropa Informal";}
        else if (posi==13){ desc = "Ropa Formal";}
        else if (posi==14){ desc = "Articulos Varios";}
     return desc;
    }
}
