package com.sundyplay.sunjiaqi.sun1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sunjiaqi on 23/06/2015.
 */
public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;
    String query = "CREATE TABLE "+NameTable.NameInfo.TABLE_NAME+" ("+NameTable.NameInfo.NAME+" TEXT);";

    public DatabaseOperations(Context context) {

        super(context, NameTable.NameInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations", "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
        Log.d("Database operations", "table created");
    }

    public void putInfo(DatabaseOperations ddd, String name){
        SQLiteDatabase db = ddd.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NameTable.NameInfo.NAME, name);
        long k = db.insert(NameTable.NameInfo.TABLE_NAME,null,cv);
        Log.d("Database operations", "one row inserted");
    }

    public Cursor getInfo(){
        SQLiteDatabase db = getReadableDatabase();
        //String[] coloums = {NameTable.NameInfo.NAME};
        Cursor cursor = db.rawQuery("select * from "+ NameTable.NameInfo.TABLE_NAME,null);
        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
