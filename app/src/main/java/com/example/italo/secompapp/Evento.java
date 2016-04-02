package com.example.italo.secompapp;

import android.provider.ContactsContract;
import android.text.format.DateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Italo on 20/03/2016.
 */
public class Evento {
    private String nome;
    private String palestrante;
    private String eventoID;
    private Date data;
    public static ArrayList<Evento> listaEventos=new ArrayList<>();

    public Evento(String nome,String palestrante,String eventoID,Date data){
        this.nome=nome;
        this.palestrante=palestrante;
        this.eventoID=eventoID;
        this.data=data;
    }

    public Evento(String nome,String ID,Date data){
        this.nome=nome;
        this.eventoID=ID;
        this.data=data;
    }

    public String getNome(){
        return nome;
    }

    public String getPalestrante(){
        return palestrante;
    }

    public String getEventoID(){
        return eventoID;
    }

    public Date getData(){
        return data;
    }

    public int getDayOfWeek(){
        GregorianCalendar calendar=new GregorianCalendar();
        calendar.setTime(getData());
        return calendar.get(GregorianCalendar.DAY_OF_WEEK);
    }

    public static ArrayList<Evento> getEventsInADayOfWeek(int dayOfWeek){
        ArrayList<Evento> listaAux=new ArrayList<>();
        for(int i=0;i<listaEventos.size();i++){
            if(dayOfWeek==listaEventos.get(i).getDayOfWeek())
                listaAux.add(listaEventos.get(i));
        }
        return listaAux;
    }


}
