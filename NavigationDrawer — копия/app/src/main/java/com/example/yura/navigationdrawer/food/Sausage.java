package com.example.yura.navigationdrawer.food;

/**
 * Created by Yura on 27.12.2016.
 */

public class Sausage implements Food {

    private boolean bookmarkState = false;
    private String mPath = "images/sausage.jpg";

    @Override
    public String getPath() {
        return mPath;
    }

    @Override
    public String[] getSteps() {
        return new String[0];
    }

    @Override
    public String getIngredients() {
        return null;
    }

    @Override
    public boolean getBookmarkedState() {
        return bookmarkState;
    }

    @Override
    public void setBookmarkState(boolean state) {
        this.bookmarkState = state;
    }

    @Override
    public int[] getTimeList() {
        return new int[0];
    }


}
