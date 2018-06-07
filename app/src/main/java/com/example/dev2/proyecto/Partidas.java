package com.example.dev2.proyecto;

public class Partidas {
    private String mazo, mazo_ajeno;
    private int resultado, resultado_ajeno;

    public Partidas(){

    }

    public Partidas(String mazo, int resultado, int resultado_ajeno, String mazo_ajeno){
        this.mazo = mazo;
        this.resultado = resultado;
        this.resultado_ajeno = resultado_ajeno;
        this.mazo_ajeno = mazo_ajeno;
    }

    public String getMazo() {
        return mazo;
    }

    public void setMazo(String mazo) {
        this.mazo = mazo;
    }

    public String getMazo_ajeno() {
        return mazo_ajeno;
    }

    public void setMazo_ajeno(String mazo_ajeno) {
        this.mazo_ajeno = mazo_ajeno;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public int getResultado_ajeno() {
        return resultado_ajeno;
    }

    public void setResultado_ajeno(int resultado_ajeno) {
        this.resultado_ajeno = resultado_ajeno;
    }
}
