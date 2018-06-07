package com.example.dev2.proyecto;

import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.Calendar;

public class InsertarMazo extends Activity {

    static final String SOAPACTION = "http://paquetews/guardarMazo";
    private static final String METHOD = "guardarMazo";
    private static final String NAMESPACE = "http://paquetews/";
    private static final String URL = "http://10.1.2.16:8084/CartasWebService/Cartas?wsdl";

    EditText txtnombre, txtcolor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_mazo);

        txtnombre = (EditText) findViewById(R.id.txtNombre);
        txtcolor = (EditText) findViewById(R.id.txtColor);

    }

    public void aceptar(View view){
        try{
            StrictMode.ThreadPolicy  policy  =  new  StrictMode.ThreadPolicy.Builder().permitNetwork().build();
            StrictMode.setThreadPolicy(policy);

            boolean resultadoFINAL;

            SoapObject request = new SoapObject(NAMESPACE, METHOD);
            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            sobre.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(URL);

            PropertyInfo nombreMazo = new PropertyInfo();
            nombreMazo.setName("nombre");
            nombreMazo.setValue(this.txtnombre.getText().toString());
            nombreMazo.setType(String.class);
            request.addProperty(nombreMazo);

            Calendar cal = Calendar.getInstance();
            int año = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH);
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            String fecha = dia+"/"+mes+"/"+año;

            PropertyInfo fechaMazo = new PropertyInfo();
            fechaMazo.setName("fecha");
            fechaMazo.setValue(fecha);
            fechaMazo.setType(String.class);
            request.addProperty(fechaMazo);

            PropertyInfo colorMazo = new PropertyInfo();
            colorMazo.setName("color");
            colorMazo.setValue(this.txtcolor.getText().toString());
            colorMazo.setType(String.class);
            request.addProperty(colorMazo);

            transporte.call(SOAPACTION, sobre);
            SoapPrimitive resultado = (SoapPrimitive) sobre.getResponse();
            resultadoFINAL = Boolean.parseBoolean(resultado.toString());
            if(resultadoFINAL == true){
                finish();
            }else{
                Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT);
            }
        }catch(Exception e){
            System.out.println(""+e.toString());
        }
    }

    public void cancelar(View view){
        finish();
    }
}
