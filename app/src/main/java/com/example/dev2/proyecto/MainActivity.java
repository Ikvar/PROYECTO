package com.example.dev2.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buscador(View view){
        Intent i = new Intent(this, Buscador.class);
        startActivity(i);
    }

    public void contador(View view){
        Intent i = new Intent(this, Contador.class);
        startActivity(i);
    }

    public void mazos(View view){
        Intent i = new Intent(this, Mazos.class);
        startActivity(i);
    }

    public void historial(View view){
        Intent i = new Intent(this, Historial.class);
        startActivity(i);
    }
}
