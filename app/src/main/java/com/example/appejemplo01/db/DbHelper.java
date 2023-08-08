package com.example.appejemplo01.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NOMBRE="agenda.db";
    public static final String TABLE_CONTACTOS="t_contactos";
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_CONTACTOS+"(" +
                "dni VARCHAR(8) PRIMARY KEY," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "direccion TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // ejecutar cuando cambia la versión de la base de datos
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_CONTACTOS);
        onCreate(sqLiteDatabase);
    }
}
