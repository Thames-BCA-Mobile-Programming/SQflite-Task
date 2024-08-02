package com.Amisha.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    static String DB_NAME = "user_info.db";
    static int DB_VERSION = 1;
    static String TABLE_NAME = "users";
    static String COLUMN_ID = "id";
    static String COLUMN_NAME = "name";
    static String COLUMN_AGE = "age";
    static String COLUMN_OCCUPATION = "occupation";
    static String COLUMN_ADDRESS = "address" ;

    DbHelper(Context context) {
        //DB CREATING DONE
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create db table here
        // create table table_name
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_AGE + " INTEGER, " +
                COLUMN_OCCUPATION + " TEXT, " +
                COLUMN_ADDRESS + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    long addUsers(UserDataModel dataClass){
        SQLiteDatabase sd = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME,dataClass.name);
        cv.put(COLUMN_AGE,dataClass.age);
        cv.put(COLUMN_OCCUPATION,dataClass.occupation);
        cv.put(COLUMN_ADDRESS,dataClass.address);

        long res = sd.insert(TABLE_NAME, null, cv);
        Log.d("Inserting data ", "addUsers: " +cv.toString());
        return  res;
    }

    Cursor reaData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = null;
        if(db!=null){
            cursor = db.rawQuery(query,null);
        }
        return  cursor;

    }

}
