package com.example.finalproject.model;

/**
 * Created by Dell on 1/12/2560.
 */

public class Foods {

    public final int id;
    public final String foodsName;
    public final String foodsPrice;
    public final String foodsAmount;

    public Foods(int id,String foodsName,String foodsPrice,String foodsAmount){
        this.id = id;
        this.foodsAmount = foodsAmount;
        this.foodsName = foodsName;
        this.foodsPrice = foodsPrice;
    }
}
