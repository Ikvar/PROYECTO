package com.example.dev2.proyecto;

public class Cartas {

    private String nombre, coste, tipo, edicion, texto;
    private int fuerza, resistencia;

    public Cartas(String nombre, String coste, String tipo, String edicion, int i, int fuerza, String s){

    }

    public Cartas(String nombre, String coste, String tipo, String edicion, String texto, int fuerza, int resistencia){
        this.nombre = nombre;
        this.coste = coste;
        this.tipo = tipo;
        this.edicion = edicion;
        this.texto = texto;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCoste() {
        return coste;
    }

    public void setCoste(String coste) {
        this.coste = coste;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }
}
