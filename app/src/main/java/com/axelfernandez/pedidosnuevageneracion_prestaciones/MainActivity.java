package com.axelfernandez.pedidosnuevageneracion_prestaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.andremion.counterfab.CounterFab;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.axelfernandez.pedidosnuevageneracion_prestaciones.R.id.fab;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CallBackListener {
    CounterFab counterFab;
    List<Productos> milista =new ArrayList<>();
    List<Integer> array = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final CounterFab counterFab = (CounterFab) findViewById(fab);
        array = getIntent().getIntegerArrayListExtra("array");
        if (array!=null){
            elim(array);
        }
        counterFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Checkout_Activity.class);
                intent.putExtra("miLista", (Serializable) milista);
                startActivity(intent);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setFragment(0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    //@SuppressWarnins("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        int id = item.getItemId();

          if (id == R.id.nav_car) {
              setFragment(1);
              drawer.closeDrawer(GravityCompat.START);
              return true;

          } else if (id == R.id.nav_moto) {
              setFragment(2);
              drawer.closeDrawer(GravityCompat.START);
              return true;
        }
          else if (id == R.id.nav_bike) {
              setFragment(3);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
          else if (id == R.id.nav_television) {
              setFragment(4);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
          else if (id == R.id.nav_cellphone) {
              setFragment(5);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
          else if (id == R.id.nav_cellphonecase) {
              setFragment(6);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
          else if (id == R.id.nav_electrodomestic) {
              setFragment(7);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
          else if (id == R.id.nav_homefurniture) {
              setFragment(8);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
          else if (id == R.id.nav_articuleshome) {
              setFragment(9);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
          else if (id == R.id.nav_designcup) {
              setFragment(10);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
          else if (id == R.id.nav_desingkeys) {
              setFragment(11);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
          else if (id == R.id.nav_sportwear) {
              setFragment(12);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
          else if (id == R.id.nav_formalwear) {
              setFragment(13);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
          else if (id == R.id.nav_otherarticules) {
              setFragment(14);
              drawer.closeDrawer(GravityCompat.START);
              return true;
          }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setFragment(int position) {
        Bundle bundle = new Bundle();

        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        Fragment_RecyclerView recyclerviewfragmen = new Fragment_RecyclerView();
        switch (position) {
            case 0:
                bundle.putInt("pos",0);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                WelcomeFragment welcomefragment = new WelcomeFragment();
                fragmentTransaction.replace(R.id.fragment, welcomefragment);
                welcomefragment.setArguments(bundle);
                fragmentTransaction.commit();
                break;
            case 1:
                bundle.putInt("pos",1);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Automoviles");
                break;
            case 2:
                bundle.putInt("pos",2);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Motos");
                break;
            case 3:
                bundle.putInt("pos",3);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Bicicletas");

                break;
            case 4:
                bundle.putInt("pos",4);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Televisores");

                break;
            case 5:
                bundle.putInt("pos",5);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Celulares");

                break;
            case 6:
                bundle.putInt("pos",6);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Carcasas para Celulares");

                break;
            case 7:
                bundle.putInt("pos",7);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Electrodomesticos");

                break;
            case 8:
                bundle.putInt("pos",8);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Muebles para el Hogar");

                break;
            case 9:
                bundle.putInt("pos",9);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Articulos Para el Hogar");

                break;
            case 10:
                bundle.putInt("pos",10);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Tazas con Diseños");
                break;
            case 11:
                bundle.putInt("pos",11);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Llaveros con Diseños");

                break;
            case 12:
                bundle.putInt("pos",12);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Ropa Deportiva");

                break;
            case 13:
                bundle.putInt("pos",13);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Ropa Formal");

                break;
            case 14:
                bundle.putInt("pos",14);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, recyclerviewfragmen);
                recyclerviewfragmen.setArguments(bundle);
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Articulos Varios");

                break;

        }
    }



    @Override
    public void onCallBack(String name, String precio, int cantidad) {
        CounterFab counterFab = (CounterFab) findViewById(fab);
        Productos check = new Productos();

        Log.e("name", name);
        Log.e("Price", precio);
        Log.e("cant", String.valueOf(cantidad));
        int iprecio = Integer.valueOf(precio.replace(".",""));
        iprecio= iprecio*cantidad;
        check.setNombre(name);
        check.setPrecio(iprecio);
        check.setCantidad(cantidad);

        milista.add(check);


        counterFab.increase();
    }

    public void elim (List<Integer> elimi){

       for(int i =0; i>elimi.size();i++) {
           milista.remove(elimi.indexOf(i));
           counterFab.decrease();
       }

    }
}
