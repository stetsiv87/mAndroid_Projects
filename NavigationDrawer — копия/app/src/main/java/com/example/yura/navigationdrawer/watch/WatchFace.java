package com.example.yura.navigationdrawer.watch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Yura on 18.12.2016.
 */

public class WatchFace extends View {
    public WatchFace(Context context) {
        super(context);
    }

    public WatchFace(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WatchFace(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint myPaint = new Paint();
        myPaint.setColor(Color.WHITE);


        float width = canvas.getWidth() / 2;
        float heigth = canvas.getHeight() / 2;
        float x_miss = 15;
        float y_miss = 50;
        float radius = 300;

        //canvas.drawRect(width,heigth,300,400,myPaint);

        canvas.drawCircle(width, heigth, 300, myPaint);

        myPaint.setColor(Color.BLACK);
        myPaint.setTypeface(Typeface.DEFAULT_BOLD);
        myPaint.setTextSize(myPaint.getTextSize()*4);
        canvas.drawText("12", width-x_miss-13, (heigth-radius+y_miss), myPaint);
        canvas.drawText("6", width-x_miss-13, (heigth+radius-10), myPaint);
        canvas.drawText("9", width-radius, heigth+x_miss+5, myPaint);
        canvas.drawText("3", width+radius-y_miss-17, heigth+x_miss+5, myPaint);

    }

}
