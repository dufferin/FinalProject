package com.example.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import com.example.finalproject.adapter.FoodsAdapter;
import com.example.finalproject.db.FoodDB;
import com.example.finalproject.model.Foods;
public class MainActivity extends AppCompatActivity {

    private FoodDB mHelper;
    private SQLiteDatabase mDb;
    int number = 0;
    private ArrayList<Foods> mFoodItemList = new ArrayList<>();
    private FoodsAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper = new FoodDB(this);
        mDb = mHelper.getReadableDatabase();


        loadDataFromDb();
        mAdapter = new FoodsAdapter(
                this,
                R.layout.item,
                mFoodItemList
        );

        ListView lv = findViewById(R.id.list_view);
        lv.setAdapter(mAdapter);




    }



    private void loadDataFromDb() {
        Cursor cursor = mDb.query(
                FoodDB.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        mFoodItemList.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(FoodDB.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(FoodDB.COL_TITLE));
            String price = cursor.getString(cursor.getColumnIndex(FoodDB.COL_PRICE));
            String amount = cursor.getString(cursor.getColumnIndex(FoodDB.COL_AMOUNT));

            Foods item= new Foods(id, title, price, amount);
            mFoodItemList.add(item);
        }
    }

}
