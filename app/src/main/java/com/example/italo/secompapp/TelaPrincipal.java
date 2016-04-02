package com.example.italo.secompapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TelaPrincipal extends AppCompatActivity implements View.OnClickListener{
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carregaListaEvento();
        setContentView(R.layout.activity_tela_principal);

        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(button==v){
            startActivity(new Intent(this, ListaEventos.class));
        }
    }
//
    private void carregaListaEvento(){
        Evento.listaEventos.clear();
        GregorianCalendar calendar=new GregorianCalendar();
        calendar.set(2016, 3, 22);
        Evento.listaEventos.add(new Evento("Palestra 1", "Palestrante", "ID Aqui", calendar.getTime()));
        calendar.set(2016, 3, 22);
        Evento.listaEventos.add(new Evento("Palestra 2", "Palestrante", "ID Aqui", calendar.getTime()));
        calendar.set(2016, 3, 23);
        Evento.listaEventos.add(new Evento("Palestra 3", "Palestrante", "ID Aqui", calendar.getTime()));
        calendar.set(2016, 3, 24);
        Evento.listaEventos.add(new Evento("Palestra 4", "Palestrante", "ID Aqui", calendar.getTime()));
        calendar.set(2016, 3, 25);
        Evento.listaEventos.add(new Evento("Palestra 5", "Palestrante", "ID Aqui", calendar.getTime()));
        calendar.set(2016, 3, 26);
        Evento.listaEventos.add(new Evento("Palestra 6", "Palestrante", "ID Aqui", calendar.getTime()));
        calendar.set(2016, 3, 27);
        Evento.listaEventos.add(new Evento("Palestra 7", "Palestrante", "ID Aqui", calendar.getTime()));
        calendar.set(2016, 3, 28);
        Evento.listaEventos.add(new Evento("Palestra 8", "Palestrante", "ID Aqui", calendar.getTime()));

    }
}
