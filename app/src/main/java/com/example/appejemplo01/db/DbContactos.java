package com.example.appejemplo01.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContactos extends DbHelper{
    Context context;
    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarContacto(String dni, String nombre, String apellido, String email, String direccion){
        long id=0;
        try{
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("dni", dni);
        values.put("nombre", nombre);
        values.put("apellido", apellido);
        values.put("email", email);
        values.put("direccion", direccion);

        id = db.insert(TABLE_CONTACTOS, null,values);
        } catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
