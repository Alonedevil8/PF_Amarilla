package com.example.andres.pf_amarillas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andres on 23/11/2016.
 */
public class DbHelper extends SQLiteOpenHelper {


    private static final String DB_NAME ="usurio.sqlite";
    private static final int DB_SCHEME_VERSION = 1;


    public DbHelper (Context context)
    {super(context,DB_NAME, null,DB_SCHEME_VERSION); }


    public void onCreate (SQLiteDatabase db){
        db.execSQL(DataBaseManager.CREATE_TABLE);
    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){}

}