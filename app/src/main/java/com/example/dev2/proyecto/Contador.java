package com.example.dev2.proyecto;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Contador extends AppCompatActivity {

    int player1=20;
    int player2=20;

    TextView txtplayer1, txtplayer2;
    ConstraintLayout rl1, rl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);
        txtplayer1 = (TextView) findViewById(R.id.txtPlayer1);
        txtplayer2 = (TextView) findViewById(R.id.txtPlayer2);
        rl1 = (ConstraintLayout) findViewById(R.id.player1);
        rl2 = (ConstraintLayout) findViewById(R.id.player2);
        txtplayer1.setText(""+player1);
        txtplayer2.setText(""+player2);
    }

    public void incrementar1(View view){
        player1++;
        txtplayer1.setText(""+player1);

    }

    public void incrementar2(View view){
        player2++;
        txtplayer2.setText(""+player2);
    }

    public void decrementar1(View view){
        if(player1>0) {
            player1--;
        }else{
            player1=0;
        }
        txtplayer1.setText(""+player1);
        if(player1 == 0){
            rl1.setBackgroundColor(Color.GRAY);
        }
    }

    public void decrementar2(View view){
        if(player2>0) {
            player2--;
        }else{
            player2=0;
        }
        txtplayer2.setText(""+player2);
        if(player2 == 0){
            rl2.setBackgroundColor(Color.GRAY);
        }
    }
}
