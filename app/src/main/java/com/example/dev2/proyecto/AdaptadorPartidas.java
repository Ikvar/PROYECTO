package com.example.dev2.proyecto;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorPartidas extends RecyclerView.Adapter<AdaptadorPartidas.ViewHolder>{

    private List<Partidas> listaPartidas;

    public AdaptadorPartidas(List<Partidas> ListaPartida){
        this.listaPartidas = ListaPartida;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_partidas, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        String mazo = listaPartidas.get(position).getMazo();
        holder.txtmazo.setText(mazo);
        int resultado = listaPartidas.get(position).getResultado();
        holder.txtresultado.setText(String.valueOf(resultado));
        int resultado_ajeno = listaPartidas.get(position).getResultado_ajeno();
        holder.txtresultadoajeno.setText(String.valueOf(resultado_ajeno));
        String mazo_ajeno = listaPartidas.get(position).getMazo_ajeno();
        holder.txtmazoajeno.setText(mazo_ajeno);
    }

    @Override
    public int getItemCount(){
        return listaPartidas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtmazo, txtresultado, txtresultadoajeno, txtmazoajeno;

        public ViewHolder(View v){
            super(v);
            txtmazo = (TextView) v.findViewById(R.id.txtMazo);
            txtresultado = (TextView) v.findViewById(R.id.txtResultado);
            txtresultadoajeno = (TextView) v.findViewById(R.id.txtResultadoAjeno);
            txtmazoajeno = (TextView) v.findViewById(R.id.txtMazoAjeno);
        }
    }
}
