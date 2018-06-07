package com.example.dev2.proyecto;

import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class InsertarPartida extends Activity {

    static final String SOAPACTION = "http://paquetews/insertarPartida";
    private static final String METHOD = "insertarPartida";
    private static final String NAMESPACE = "http://paquetews/";
    private static final String URL = "http://10.1.2.16:8084/CartasWebService/Cartas?wsdl";

    EditText txtmazo, txtmazoajeno, txtresultado, txtresultadoajeno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_partida);

        this.txtmazo = (EditText)findViewById(R.id.txtMazo);
        this.txtmazoajeno = (EditText)findViewById(R.id.txtMazoAjeno);
        this.txtresultado = (EditText)findViewById(R.id.txtResultado);
        this.txtresultadoajeno = (EditText)findViewById(R.id.txtResultadoAjeno);
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
            nombreMazo.setName("mazo");
            nombreMazo.setValue(this.txtmazo.getText().toString());
            nombreMazo.setType(String.class);
            request.addProperty(nombreMazo);

            PropertyInfo resultadoMazo = new PropertyInfo();
            resultadoMazo.setName("resultado");
            resultadoMazo.setValue(this.txtresultado.getText().toString());
            resultadoMazo.setType(Integer.class);
            request.addProperty(resultadoMazo);

            PropertyInfo resultadoAjeno = new PropertyInfo();
            resultadoAjeno.setName("resultado_ajeno");
            resultadoAjeno.setValue(this.txtresultadoajeno.getText().toString());
            resultadoAjeno.setType(Integer.class);
            request.addProperty(resultadoAjeno);

            PropertyInfo mazoAjeno = new PropertyInfo();
            mazoAjeno.setName("mazo_ajeno");
            mazoAjeno.setValue(this.txtmazoajeno.getText().toString());
            mazoAjeno.setType(String.class);
            request.addProperty(mazoAjeno);

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
