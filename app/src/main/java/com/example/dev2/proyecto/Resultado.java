package com.example.dev2.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Resultado extends AppCompatActivity {

    private RecyclerView miRecicler;
    private RecyclerView.Adapter miAdapter;
    String resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle bundle=getIntent().getExtras();
        resultado = bundle.getString("resultado");

        miRecicler = (RecyclerView) findViewById(R.id.listResultados);
        miRecicler.setHasFixedSize(true);
        miRecicler.setLayoutManager(new LinearLayoutManager(this));
        miAdapter = new AdaptadorCartas(DatosCartas());
        miRecicler.setAdapter(miAdapter);
    }

    public List<Cartas> DatosCartas(){
        List<Cartas> Lista = new ArrayList<>();
        String[] cartas = resultado.split(";");
        for(int i = 0;i<cartas.length; i++){
            String[] carta = cartas[i].split(",");
            Lista.add(new Cartas(carta[0], carta[1], carta[2], carta[3], Integer.parseInt(carta[4]), Integer.parseInt(carta[5]), carta[6]));
        }
        return Lista;
    }
}
