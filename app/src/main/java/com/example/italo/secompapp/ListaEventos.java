package com.example.italo.secompapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Italo on 20/03/2016.
 */
public class ListaEventos extends AppCompatActivity implements ExpandableListView.OnChildClickListener{
    private HashMap<Integer,ArrayList<Evento>> dados;
    private ExpandableListView expandableView;
    private String contents;
    ExpandableAdapter eAdapter;
    private int auxGroupPosition;
    private int auxChildPosition;
    private View auxView;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventos_lista);
        setTitle("Eventos");
        expandableView=(ExpandableListView) findViewById(R.id.expandableListView);
        dados=new HashMap<>();
        ArrayList<Integer> daysOfWeek=new ArrayList<>();

        for(int i=1;i<8;i++){
            ArrayList<Evento> aux= Evento.getEventsInADayOfWeek(i);
            if(aux.size()>0) {
                dados.put(i, aux);
                daysOfWeek.add(i);
            }
        }
        expandableView.setOnChildClickListener(this);
        eAdapter=new ExpandableAdapter(this,dados,daysOfWeek);
        expandableView.setAdapter(eAdapter);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        startActivityForResult(intent, 0);
        auxGroupPosition=groupPosition;
        auxChildPosition=childPosition;
        auxView=v;
        return false;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                contents = intent.getStringExtra("SCAN_RESULT");
                DataBase db= new DataBase(this);
                if(db.insertPresenca(contents,(Evento) eAdapter.getChild(auxGroupPosition,auxChildPosition))) {
                    Toast.makeText(this, "Presença Confirmada!", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent("com.google.zxing.client.android.SCAN");
                    intent2.putExtra("SCAN_MODE", "QR_CODE_MODE");
                    startActivityForResult(intent2, 0);
                }
                else
                    Toast.makeText(this,"Preseça não foi confirmada!",Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this,"Cancelado",Toast.LENGTH_SHORT).show();
            }
        }
    }

}

