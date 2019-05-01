package com.thriftyApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "thrifty.db";
    private static final String TABLE_SIGNUP = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_MOBILE = "mobile";
    private static final String COLUMN_BUDGET = "budget";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD= "password";

    SQLiteDatabase db;
    private static final String CREATE_TABLE_SIGNUP = "CREATE TABLE " + TABLE_SIGNUP  + "( " + COLUMN_ID + " INTEGER PRIMARY KEY NOT NULL , " + COLUMN_NAME + " TEXT NOT NULL , " + COLUMN_EMAIL +" TEXT NOT NULL, " + COLUMN_MOBILE +" INTEGER NOT NULL, " + COLUMN_BUDGET + " INTEGER NOT NULL, " + COLUMN_PASSWORD + " TEXT NOT NULL );";

    @Override
    public void onCreate(SQLiteDatabase db2) {
        db = db2;
        db.execSQL (CREATE_TABLE_SIGNUP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS " + TABLE_SIGNUP;
        db.execSQL (query);

    }

    public DatabaseHelper (Context context) {

        super(context,DATABASE_NAME,null, DATABASE_VERSION);

    }

    public void insertContact(Contact c) {

        db = this.getWritableDatabase ();
        ContentValues values = new ContentValues ();
        values.put (COLUMN_NAME, c.getName ());
        values.put (COLUMN_EMAIL, c.getEmailId ());
        values.put (COLUMN_MOBILE, c.getMobile ());
        values.put (COLUMN_BUDGET, c.getBudget ());
        values.put (COLUMN_PASSWORD, c.getPassword ());

        db.insert (TABLE_SIGNUP, null, values);
    }

    public String searchPass (String user) {

        String u, pass = "Not Found";
        db = this.getReadableDatabase ();
        String query = "SELECT " + COLUMN_EMAIL + ", " + COLUMN_PASSWORD + " FROM " + TABLE_SIGNUP;
        Cursor cursor = db.rawQuery (query, null);
        if (cursor.moveToFirst ()) {
            do {
                u = cursor.getString (0);
                Log.i("user",u);
                if(u.equals (user)) {
                    pass = cursor.getString (1);
                    Log.i("Password is ",pass);
                    break;
                }
            }while(cursor.moveToNext ());
        }
        db.close ();
        return pass;
    }
}
