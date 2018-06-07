package com.example.dev2.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

public class Mazos extends AppCompatActivity {
    private RecyclerView miRecicler;
    private RecyclerView.Adapter miAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mazos);
        miRecicler = (RecyclerView) findViewById(R.id.listMazos);
        miRecicler.setHasFixedSize(true);
        miRecicler.setLayoutManager(new LinearLayoutManager(this));
        miAdapter = new AdaptadorMazos(DatosMazos());
        miRecicler.setAdapter(miAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_add_black_24dp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), InsertarMazo.class);
                startActivity(i);
            }
        });
    }

    public List<Barajas> DatosMazos(){
        final String SOAPACTION = "http://paquetews/recuperarMazos";
        final String METHOD = "recuperarMazos";
        final String NAMESPACE = "http://paquetews/";
        final String URL = "http://10.1.2.16:8084/CartasWebService/Cartas?wsdl";
        List<Barajas> Lista = new ArrayList<>();
        try{
            StrictMode.ThreadPolicy  policy  =  new  StrictMode.ThreadPolicy.Builder().permitNetwork().build();
            StrictMode.setThreadPolicy(policy);

            String resultadoFINAL;

            SoapObject request = new SoapObject(NAMESPACE, METHOD);
            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            sobre.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(URL);

            transporte.call(SOAPACTION, sobre);
            SoapPrimitive resultado = (SoapPrimitive) sobre.getResponse();
            resultadoFINAL = resultado.toString();
            String[] mazos = resultadoFINAL.split(";");
            for(int i = 0;i<mazos.length; i++){
                String[] mazo = mazos[i].split(",");
                Lista.add(new Barajas(Integer.parseInt(mazo[0]),mazo[1], mazo[2], mazo[3]));
            }
        }catch(Exception e){
            System.out.println(""+e.toString());
        }
        return Lista;
    }

}
