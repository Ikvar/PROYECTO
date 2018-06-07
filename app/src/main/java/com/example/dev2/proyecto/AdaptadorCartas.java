package com.example.dev2.proyecto;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorCartas extends RecyclerView.Adapter<AdaptadorCartas.ViewHolder>{

    private List<Cartas> listaCartas;

    public AdaptadorCartas(List<Cartas> ListaCarta){
        this.listaCartas = ListaCarta;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_resultados, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        String nombre = listaCartas.get(position).getNombre();
        holder.txtnombre.setText(nombre);
        String coste = listaCartas.get(position).getCoste();
        holder.txtcoste.setText(coste);
        String tipo = listaCartas.get(position).getTipo();
        holder.txttipo.setText(tipo);
        String edicion = listaCartas.get(position).getEdicion();
        holder.txtedicion.setText(edicion);
        String texto = listaCartas.get(position).getTexto();
        int fuerza = listaCartas.get(position).getFuerza();
        holder.txtfuerza.setText(String.valueOf(fuerza));
        int resistencia = listaCartas.get(position).getResistencia();
        holder.txtresistencia.setText(String.valueOf(resistencia));
    }

    @Override
    public int getItemCount(){
        return listaCartas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtnombre, txtcoste, txttipo, txtedicion, txttexto, txtfuerza, txtresistencia;

        public ViewHolder(View v){
            super(v);
            txtnombre = (TextView) v.findViewById(R.id.txtNombre);
            txtcoste = (TextView) v.findViewById(R.id.txtCoste);
            txttipo = (TextView) v.findViewById(R.id.txtTipo);
            txtedicion = (TextView) v.findViewById(R.id.txtEdicion);
            txttexto = (TextView) v.findViewById(R.id.txtTexto);
            txtfuerza = (TextView) v.findViewById(R.id.txtFuerza);
            txtresistencia = (TextView) v.findViewById(R.id.txtResistencia);
        }
    }
}
