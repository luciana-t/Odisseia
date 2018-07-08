package br.trabalho221.odisseia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.content.res.ResourcesCompat;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DBOdisseia.db";
    public static final String TABLE_NAME = "Odisseia_table";
    public static final String ID = "ID";
    public static final String MATERIA = "MATERIA";
    public static final String STATUS = "STATUS";
    public static final String PONTO = "PONTO";
    public static final String UTIL = "UTIL";
    public static final String FACIL = "FACIL";
    public static final String RECOM = "RECOM";
    public static final String COMENT = "COMENT";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, MATERIA TEXT, STATUS BOOLEAN, PONTO INTEGER, UTIL BOOLEAN, FACIL BOOLEAN, RECOM BOOLEAN, COMENT TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String materia, String status, String ponto, String util, String facil, String recom, String coment){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MATERIA, materia);
        contentValues.put(STATUS, status);
        contentValues.put(PONTO, ponto);
        contentValues.put(UTIL, util);
        contentValues.put(FACIL, facil);
        contentValues.put(RECOM, recom);
        contentValues.put(COMENT, coment);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) return false;
        else return true;
    }
}
