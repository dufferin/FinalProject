package com.example.finalproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by Dell on 1/12/2560.
 */

public class FoodDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "foods.db";
    private static final int DATABASE_VERSION = 8;

    public static final String TABLE_NAME = "menu";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "food";
    public static final String COL_PRICE = "price";
    public static final String COL_AMOUNT = "amount";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_TITLE + " TEXT, "
            + COL_PRICE + " TEXT, "
            + COL_AMOUNT + " TEXT)";

    public FoodDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, "moo");
        cv.put(COL_PRICE, "191");
        cv.put(COL_AMOUNT, "100");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "cow");
        cv.put(COL_PRICE, "199");
        cv.put(COL_AMOUNT, "200");
        db.insert(TABLE_NAME, null, cv);
    }
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
