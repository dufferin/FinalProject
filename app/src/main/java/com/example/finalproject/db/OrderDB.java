package com.example.finalproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import  com.example.finalproject.adapter.FoodsAdapter;
/**
 * Created by Dell on 1/12/2560.
 */

public class OrderDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "order1.db";
    private static final int DATABASE_VERSION = 8;

    public static final String TABLE_NAME = "order1";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "food";
    public static final String COL_PRICE = "price";
    public static final String COL_AMOUNT = "amount";



    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_TITLE + " TEXT, "
            + COL_PRICE + " TEXT, "
            + COL_AMOUNT + " TEXT)";


    public OrderDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {

    }

    public  void insertDatum ( String title, String price, String amount) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_TITLE, title);
        contentValues.put(COL_PRICE, price);
        contentValues.put(COL_AMOUNT, amount);

        db.insert(TABLE_NAME, null, contentValues);
    }
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
