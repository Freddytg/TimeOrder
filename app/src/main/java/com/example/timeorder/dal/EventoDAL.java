package com.example.timeorder.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.timeorder.dto.Evento;
import com.example.timeorder.helpers.DatabaseHelper;

import java.util.ArrayList;

public class EventoDAL {
    private DatabaseHelper dbHelper;
    private Evento evento;

    public EventoDAL(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.evento = new Evento();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }

    public EventoDAL(Context context, Evento evento) {
        this.dbHelper = new DatabaseHelper(context);
        this.evento = evento;
    }

    public boolean insertar(String fecha, String nombre, int hora, int minutos, String comentarios)
    {
        this.evento.setFecha(fecha);
        this.evento.setNombre(nombre);
        this.evento.setHora(hora);
        this.evento.setMinutos(minutos);
        this.evento.setComentarios(comentarios);

        return this.tryInsert();
    }

    private boolean tryInsert() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put("fecha", this.evento.getFecha());
        c.put("nombre", this.evento.getNombre());
        c.put("hora", this.evento.getHora());
        c.put("minutos", this.evento.getMinutos());
        c.put("comentarios", this.evento.getComentarios());

        try {
            db.insert("evento", null, c);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public ArrayList<Evento> seleccionar() {
        ArrayList<Evento> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor consulta = db.rawQuery("SELECT * FROM evento", null);

        if(consulta.moveToFirst()) {
            do {
                int id = consulta.getInt(0);
                String fecha = consulta.getString(1);
                String nombre = consulta.getString(2);
                int hora = consulta.getInt(3);
                int minutos = consulta.getInt(4);
                String comentarios = consulta.getString(5);

                Evento evento = new Evento(id,fecha,nombre,hora,minutos,comentarios);
                lista.add(evento);


            } while(consulta.moveToNext());

        }


        return lista;
    }

    public boolean actualizar(int id, Evento evento)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put("fecha", this.evento.getFecha());
        c.put("nombre", this.evento.getNombre());
        c.put("hora", this.evento.getHora());
        c.put("minutos", this.evento.getMinutos());
        c.put("comentarios", this.evento.getComentarios());
        try {
            int filasAfectadas;
            filasAfectadas = db.update(
                    "evento",
                    c,
                    "id = ?",
                    new String[] { String.valueOf(id) }
            );
            return (filasAfectadas > 0);
        } catch (Exception e) {

        }

        return false;
    }

    public boolean actualizar(Evento evento)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put("fecha", this.evento.getFecha());
        c.put("nombre", this.evento.getNombre());
        c.put("hora", this.evento.getHora());
        c.put("minutos", this.evento.getMinutos());
        c.put("comentarios", this.evento.getComentarios());
        try {
            int filasAfectadas;
            filasAfectadas = db.update(
                    "evento",
                    c,
                    "id = ?",
                    new String[] { String.valueOf(evento.getId()) }
            );
            return (filasAfectadas > 0);
        } catch (Exception e) {

        }

        return false;
    }

    public boolean eliminar(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        int filasAfectadas;

        try {
            filasAfectadas = db.delete("evento","id = ?",
                    new String[] { String.valueOf(id) });
        } catch (Exception e) {
            return false;
        }

        return (filasAfectadas == 1);

    }

    public Evento getEvento() {
        return this.evento;
    }

}
