package com.example.dev2.proyecto;

public class Cartas {

    private String nombre;
    private String coste;
    private String tipo;
    private String edicion;
    private String texto;
    private int fuerza;
    private int resistencia;

    public Cartas(String nombre, String coste, String tipo, String texto, int fuerza, int resistencia, String edicion){
        this.nombre = nombre;
        this.coste = coste;
        this.tipo = tipo;
        this.texto = texto;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.edicion = edicion;
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
