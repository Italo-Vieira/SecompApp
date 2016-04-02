package com.example.italo.secompapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Italo on 20/03/2016.
 */
public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Secomp.db";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE="preseca";
    public static final String PARTICIPANTE_ID="participante_id";
    public static final String EVENTO_ID="evento_ID";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + "(" +
                        PARTICIPANTE_ID + " TEXT, " +
                        EVENTO_ID + " TEXT) "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
    public boolean insertPresenca(String participanteID, Evento evento) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTO_ID, evento.getEventoID());
        contentValues.put(PARTICIPANTE_ID, participanteID);
        db.insert(TABLE, null, contentValues);
        return true;
    }
    public Cursor getInsertPresenca() {
        SQLiteDatabase db = this.getReadableDatabase();
        return res db.rawQuery( "SELECT * FROM " + TABLE, null );

    }
}