package com.axelfernandez.pedidosnuevageneracion_prestaciones;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Checkout_Activity extends AppCompatActivity {
ArrayList<Integer> arrayidex=new ArrayList<>();
    AlertDialog alert;
    int resta=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Resumen de Compra");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Button btncomprar = (Button) findViewById(R.id.buttoncomprar);
        final EditText nombre = (EditText) findViewById(R.id.check_nombre);
        final EditText apellido = (EditText) findViewById(R.id.check_apellido);
        final EditText dni = (EditText) findViewById(R.id.check_dni);
        final EditText email = (EditText) findViewById(R.id.check_email);
        RecyclerView rv = (RecyclerView)findViewById(R.id.checkrv);
        final TextView totalt = (TextView)findViewById(R.id.item_check_total);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        List<Productos> lista = (List<Productos>) getIntent().getSerializableExtra("miLista");
        int total =0;

for (int i= 0 ; i<lista.size();i++){
  int sPrecio=  lista.get(i).getPrecio();
    int cantidad=lista.get(i).cantidad;
    int subtotal= Integer.valueOf(sPrecio);
    total= total + subtotal;

}
    totalt.setText("Total: $"+String.valueOf(total));
       final CheckRvAdapter adapter = new CheckRvAdapter(lista);
        arrayidex = adapter.pasararray();
        rv.setAdapter(adapter);



btncomprar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String  snombre = String.valueOf(nombre.getText());
        String sapellido= String.valueOf(apellido.getText());
        String sdni =  String.valueOf(dni.getText());
        String semail = String.valueOf(email.getText());
        if(snombre.isEmpty()){nombre.setError("Completa con tu nombre");}
        if(sapellido.isEmpty()){apellido.setError("Escribe tu Apellido");}
        if(sdni.isEmpty()){dni.setError("No olvides el DNI");}
        if(semail.isEmpty()){email.setError("Faltó tu email");}
        if (snombre.isEmpty() == false && sapellido.isEmpty() == false && sdni.isEmpty() == false && semail.isEmpty() == false) {


        String asunto = "Pedido CompraApp de "+ nombre.getText() +" " + apellido.getText();
       String texemail= "Datos del chofer: \n " +"Nombre y Apellido: " + nombre.getText() +" " +apellido.getText() +"\n"
                +"DNI: "+dni.getText() + "\n"+
                "E-mail: "+ email.getText() + "\n" +"\n El pedido contiene lo siguiente \n"+  "\n";
        for (int i = 0;i<adapter.prod.size();i++){
            texemail = texemail + "Producto N "+i+ "\n"
                   +"Nombre:" + adapter.prod.get(i).getNombre() +" \n"
                    + "Cantidad: "+ adapter.prod.get(i).getCantidad()+" \n"
                    + "Precio: " +adapter.prod.get(i).getPrecio() + "\n" + "\n";



        }

        texemail= texemail + "\n" + totalt.getText();

        final String ntextemail = texemail;
        final String nasunto = asunto;
        final AlertDialog.Builder builder = new AlertDialog.Builder(Checkout_Activity.this);
        builder.setMessage("Por favor, elija la Aplicacion Gmail para enviar este pedido")
                .setTitle("Atención")
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                sendEmail(ntextemail,nasunto);

                            }
                        });
       alert = builder.create();
        alert.show();}

    }


});

    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("array", arrayidex);
        startActivity(i);
        super.onBackPressed();  // Invoca al método
    }
    protected void sendEmail( String cuerpo, String asunto) {
        String[] TO = {"pedidosprestaciones@gmail.com"}; //aquí pon tu correo
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
// Esto podrás modificarlo si quieres, el asunto y el cuerpo del mensaje
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, cuerpo);

        try {
            startActivity(Intent.createChooser(emailIntent, "Escoge Gmail y envia el correo..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(),
                    "No tienes clientes de email instalados.", Toast.LENGTH_SHORT).show();
        }
    }
}

