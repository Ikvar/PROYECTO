package com.example.dev2.proyecto;

public class Barajas {

    private int id;
    private String nombre, fecha_alta, color;

    public Barajas(){

    }

    public Barajas(int id, String nombre, String fecha_alta, String color){
        this.id = id;
        this.nombre = nombre;
        this.fecha_alta = fecha_alta;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
