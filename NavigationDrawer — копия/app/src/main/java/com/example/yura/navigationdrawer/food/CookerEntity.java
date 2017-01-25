package com.example.yura.navigationdrawer.food;

import java.util.ArrayList;

//import com.example.yura.masterchef.food.Chicken;
//import com.example.yura.masterchef.food.Omelette;

/**
 * Created by Yura on 15.12.2016.
 */

public class CookerEntity {

  static CookerEntity cooker = new CookerEntity();
    private ArrayList<Food> mFoods;

    public static CookerEntity getInstance (){
        return cooker;
    }

    private  CookerEntity() {
        mFoods = new ArrayList<>();
        mFoods.add(new Omelette());
        mFoods.add(new Chicken());
        mFoods.add(new Sausage());


    }


    public ArrayList<Food> getFoodList() {
        return mFoods;
    }
}
