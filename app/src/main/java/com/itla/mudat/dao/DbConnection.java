package com.itla.mudat.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Frandy Javier AP on 11/25/2017.
 */

public class DbConnection extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "mudat.db";
    public static int DATABASE_VERSION = 1;

    public static String LOG_T = "DbConnection";

    public DbConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SqlHelper.CREATE_TABLE_USUARIOS);
        db.execSQL(SqlHelper.CREATE_TABLE_CATEGORIAS);
        db.execSQL(SqlHelper.CREATE_TABLE_ANUNCIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
