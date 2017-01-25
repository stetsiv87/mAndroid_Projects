package com.example.yura.navigationdrawer.food;


public class Omelette implements Food {

    private String mPath = "images/omlet.jpg";
    private boolean bookmarkState = false;

    private int [] timeList = {5,10,15};

    public int[] getTimeList() {
        return timeList;
    }

    @Override
    public String getPath() {
        return mPath;
    }

    @Override
    public String[] getSteps() {
        return steps;
    }

    @Override
    public String getIngredients() {
        return ingredients;
    }

    @Override
    public boolean getBookmarkedState() {
        return bookmarkState;
    }

    @Override
    public void setBookmarkState(boolean state) {
        this.bookmarkState=state;
    }

    private String ingredients = "Eggs, milk, cheese, tomato, butter, salt, pepper";
    private String[] steps = {"1.Beat eggs, milk, salt, and pepper in bowl until blended",
            "2.Heat butter in large nonstick skillet over medium heat until hot.Pour in egg mixture",
            "3.Gently pull the eggs across the pan."};



}
