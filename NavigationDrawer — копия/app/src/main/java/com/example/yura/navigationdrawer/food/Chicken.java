package com.example.yura.navigationdrawer.food;

/**
 * Created by Yura on 20.12.2016.
 */

public class Chicken implements Food {

    private boolean bookmarkState =false;
    private String mPath = "images/chicken.jpg";

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
        this.bookmarkState=state;
    }

    @Override
    public int[] getTimeList() {
        return new int[0];
    }


//    @Override
//    public Bitmap getBitmap(Context context) throws IOException {
//        AssetManager assetManager = context.getAssets();
//        InputStream mInputStream =  assetManager.open(mPath);
//        Bitmap bitmap = BitmapFactory.decodeStream(mInputStream);
//        return bitmap;
//    }
}
