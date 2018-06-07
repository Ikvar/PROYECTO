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

public class Historial extends AppCompatActivity {

    private RecyclerView miRecicler;
    private RecyclerView.Adapter miAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        miRecicler = (RecyclerView) findViewById(R.id.listPartidas);
        miRecicler.setHasFixedSize(true);
        miRecicler.setLayoutManager(new LinearLayoutManager(this));
        miAdapter = new AdaptadorPartidas(ListaPartidas());
        miRecicler.setAdapter(miAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_add_black_24dp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), InsertarPartida.class);
                startActivity(i);
            }
        });
    }

    public List<Partidas> ListaPartidas(){
        final String SOAPACTION = "http://paquetews/recuperarPartidas";
        final String METHOD = "recuperarPartidas";
        final String NAMESPACE = "http://paquetews/";
        final String URL = "http://10.1.2.16:8084/CartasWebService/Cartas?wsdl";
        List<Partidas> Lista = new ArrayList<>();

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
            String[] partidas = resultadoFINAL.split(";");
            for(int i = 0;i<partidas.length; i++){
                String[] partida = partidas[i].split(",");
                Lista.add(new Partidas(partida[0],Integer.parseInt(partida[1]), Integer.parseInt(partida[2]), partida[3]));
            }
        }catch(Exception e){
            System.out.println(""+e.toString());
        }

        return Lista;
    }

}
