package com.example.timeorder.dto;

import java.io.Serializable;

public class Evento implements Serializable {
    private int id;
    private String fecha;
    private String nombre;
    private int hora;
    private int minutos;
    private String comentarios;

    public Evento() {
    }

    public Evento(int id, String fecha, String nombre, int hora, int minutos, String comentarios) {
        this.id = id;
        this.fecha = fecha;
        this.nombre = nombre;
        this.hora = hora;
        this.minutos = minutos;
        this.comentarios = comentarios;
    }

    public Evento(String fecha, String nombre, int hora, int minutos, String comentarios) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.hora = hora;
        this.minutos = minutos;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }


    @Override
    public String toString()
    {
        return (" ( " + this.getFecha() + " || " + this.getNombre() + " || " + this.getHora() + " : " + getMinutos() + " minutos || " + this.getComentarios()+ " ) ");
    }
}
