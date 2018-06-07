package com.example.dev2.proyecto;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdaptadorMazos extends RecyclerView.Adapter<AdaptadorMazos.ViewHolder>{

    private List<Barajas> listaBarajas;

    public AdaptadorMazos(List<Barajas> ListaBaraja){
        this.listaBarajas = ListaBaraja;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_mazos, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        int id = listaBarajas.get(position).getId();
        holder.txtid.setText(String.valueOf(id));
        String nombre = listaBarajas.get(position).getNombre();
        holder.txtnombre.setText(nombre);
        String fecha = listaBarajas.get(position).getFecha_alta();
        holder.txtfecha.setText(fecha);
        String color = listaBarajas.get(position).getColor();
        holder.lycolormazo.setBackgroundColor(Color.parseColor(color));
    }

    @Override
    public int getItemCount(){
        return listaBarajas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtid, txtnombre, txtfecha;
        private LinearLayout lycolormazo;

        public ViewHolder(View v){
            super(v);
            txtid = (TextView) v.findViewById(R.id.txtId);
            txtfecha = (TextView) v.findViewById(R.id.txtFecha);
            txtnombre = (TextView) v.findViewById(R.id.txtNombre);
            lycolormazo = (LinearLayout) v.findViewById(R.id.lyColorMazo);
        }
    }
}
