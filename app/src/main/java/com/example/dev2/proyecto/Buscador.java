package com.example.dev2.proyecto;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class Buscador extends AppCompatActivity {

    EditText txtnombre, txtcompcoste, txtcoste, txttipo, txttexto, txtcompfuerza, txtfuerza, txtcompresist, txtresistencia, txtedicion;
    CheckBox chblanco, chnegro, chrojo, chazul, chverde, chincoloro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);
        this.txtnombre = (EditText)findViewById(R.id.txtNombre);
        this.txtcompcoste = (EditText)findViewById(R.id.txtCompCMC);
        this.txtcoste = (EditText)findViewById(R.id.txtCoste);
        this.txttipo = (EditText)findViewById(R.id.txtTipo);
        this.txttexto = (EditText)findViewById(R.id.txtTexto);
        this.txtcompfuerza = (EditText)findViewById(R.id.txtCompFuerza);
        this.txtfuerza = (EditText)findViewById(R.id.txtFuerza);
        this.txtcompresist = (EditText)findViewById(R.id.txtCompResist);
        this.txtresistencia = (EditText)findViewById(R.id.txtResist);
        this.txtedicion = (EditText)findViewById(R.id.txtEdicion);

        this.chblanco = (CheckBox) findViewById(R.id.chBlanco);
        this.chnegro = (CheckBox) findViewById(R.id.chNegro);
        this.chrojo = (CheckBox) findViewById(R.id.chRojo);
        this.chazul = (CheckBox) findViewById(R.id.chAzul);
        this.chverde = (CheckBox) findViewById(R.id.chVerde);
        this.chincoloro = (CheckBox) findViewById(R.id.chIncoloro);

    }

    public void buscar(View view){
        final String SOAPACTION = "http://paquetews/consultaCartas";
        final String METHOD = "consultaCartas";
        final String NAMESPACE = "http://paquetews/";
        final String URL = "http://10.1.2.16:8084/CartasWebService/Cartas?wsdl";

        String resultadoFinal = "";

        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
            StrictMode.setThreadPolicy(policy);


            String color = "";

            SoapObject request = new SoapObject(NAMESPACE, METHOD);
            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            sobre.setOutputSoapObject(request);
            HttpTransportSE transporte = new HttpTransportSE(URL);

            if (this.txtnombre.getText().toString().equals("")) {
                PropertyInfo nombre = new PropertyInfo();
                nombre.setName("nombre");
                nombre.setValue("NaN");
                nombre.setType(String.class);
                request.addProperty(nombre);

            } else {


                PropertyInfo nombre = new PropertyInfo();
                nombre.setName("nombre");
                nombre.setValue(this.txtnombre.getText().toString());
                nombre.setType(String.class);
                request.addProperty(nombre);
            }

            if (this.txtcompcoste.getText().toString().equals("")) {
                PropertyInfo compCoste = new PropertyInfo();
                compCoste.setName("compCoste");
                compCoste.setValue("NaN");
                compCoste.setType(String.class);
                request.addProperty(compCoste);

            } else {


                PropertyInfo compCoste = new PropertyInfo();
                compCoste.setName("compCoste");
                compCoste.setValue(txtcompcoste.getText().toString());
                compCoste.setType(String.class);
                request.addProperty(compCoste);
            }

            if (this.txtcoste.getText().toString().equals("")) {
                PropertyInfo coste = new PropertyInfo();
                coste.setName("coste");
                coste.setValue("NaN");
                coste.setType(String.class);
                request.addProperty(coste);

            } else {


                PropertyInfo coste = new PropertyInfo();
                coste.setName("coste");
                coste.setValue(txtcoste.getText().toString());
                coste.setType(String.class);
                request.addProperty(coste);
            }

            if (this.txttipo.getText().toString().equals("")) {
                PropertyInfo tipo = new PropertyInfo();
                tipo.setName("tipo");
                tipo.setValue("NaN");
                tipo.setType(String.class);
                request.addProperty(tipo);

            } else {


                PropertyInfo tipo = new PropertyInfo();
                tipo.setName("tipo");
                tipo.setValue(txttipo.getText().toString());
                tipo.setType(String.class);
                request.addProperty(tipo);
            }

            if (this.txttexto.getText().toString().equals("")) {
                PropertyInfo tipo = new PropertyInfo();
                tipo.setName("texto");
                tipo.setValue("NaN");
                tipo.setType(String.class);
                request.addProperty(tipo);

            } else {


                PropertyInfo tipo = new PropertyInfo();
                tipo.setName("texto");
                tipo.setValue(txttexto.getText().toString());
                tipo.setType(String.class);
                request.addProperty(tipo);
            }

            if (this.txtcompfuerza.getText().toString().equals("")) {
                PropertyInfo compFuerza = new PropertyInfo();
                compFuerza.setName("compFuerza");
                compFuerza.setValue("NaN");
                compFuerza.setType(String.class);
                request.addProperty(compFuerza);

            } else {


                PropertyInfo compFuerza = new PropertyInfo();
                compFuerza.setName("compFuerza");
                compFuerza.setValue(txtcompfuerza.getText().toString());
                compFuerza.setType(String.class);
                request.addProperty(compFuerza);
            }

            if (this.txtfuerza.getText().toString().equals("")) {
                PropertyInfo fuerza = new PropertyInfo();
                fuerza.setName("fuerza");
                fuerza.setValue("NaN");
                fuerza.setType(String.class);
                request.addProperty(fuerza);

            } else {


                PropertyInfo fuerza = new PropertyInfo();
                fuerza.setName("fuerza");
                fuerza.setValue(txtfuerza.getText().toString());
                fuerza.setType(String.class);
                request.addProperty(fuerza);
            }

            if (this.txtcompresist.getText().toString().equals("")) {
                PropertyInfo compResist = new PropertyInfo();
                compResist.setName("compResist");
                compResist.setValue("NaN");
                compResist.setType(String.class);
                request.addProperty(compResist);

            } else {


                PropertyInfo compResist = new PropertyInfo();
                compResist.setName("compResist");
                compResist.setValue(txtcompresist.getText().toString());
                compResist.setType(String.class);
                request.addProperty(compResist);
            }

            if (this.txtresistencia.getText().toString().equals("")) {
                PropertyInfo resist = new PropertyInfo();
                resist.setName("resistencia");
                resist.setValue("NaN");
                resist.setType(String.class);
                request.addProperty(resist);

            } else {


                PropertyInfo resist = new PropertyInfo();
                resist.setName("resistencia");
                resist.setValue(txtresistencia.getText().toString());
                resist.setType(String.class);
                request.addProperty(resist);
            }

            if (this.txtedicion.getText().toString().equals("")) {
                PropertyInfo edicion = new PropertyInfo();
                edicion.setName("edicion");
                edicion.setValue("NaN");
                edicion.setType(String.class);
                request.addProperty(edicion);

            } else {


                PropertyInfo edicion = new PropertyInfo();
                edicion.setName("edicion");
                edicion.setValue(txtedicion.getText().toString());
                edicion.setType(String.class);
                request.addProperty(edicion);
            }

            if (chblanco.isChecked()) {
                color += "W";
            }

            if (chnegro.isChecked()) {
                color += "B";
            }

            if (chrojo.isChecked()) {
                color += "R";
            }

            if (chazul.isChecked()) {
                color += "U";
            }

            if (chverde.isChecked()) {
                color += "G";
            }

            if (chincoloro.isChecked()) {
                color += "C";
            }
            if(color.equals("")) {
                PropertyInfo colorCarta = new PropertyInfo();
                colorCarta.setName("color");
                colorCarta.setValue("NaN");
                colorCarta.setType(String.class);
                request.addProperty(colorCarta);
            }else{
                PropertyInfo colorCarta = new PropertyInfo();
                colorCarta.setName("color");
                colorCarta.setValue(color);
                colorCarta.setType(String.class);
                request.addProperty(colorCarta);
            }

            transporte.call(SOAPACTION, sobre);
            SoapPrimitive resultado = (SoapPrimitive) sobre.getResponse();
            resultadoFinal = resultado.toString();


        }catch (Exception e){
            System.out.println("Error: "+e.toString());
        }

        Intent i = new Intent(this, Resultado.class);
        i.putExtra("resultado", resultadoFinal);
        startActivity(i);
    }
}
