package com.example.yura.navigationdrawer.food;

/**
 * Created by Yura on 20.12.2016.
 */

public interface Food {
  String getPath();
  String[] getSteps();
  String getIngredients();
  boolean getBookmarkedState();
  void setBookmarkState(boolean state);
  int [] getTimeList ();

}
