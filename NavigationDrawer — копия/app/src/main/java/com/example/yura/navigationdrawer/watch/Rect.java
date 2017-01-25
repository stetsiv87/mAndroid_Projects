package com.example.yura.navigationdrawer.watch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Yura on 12.01.2017.
 */

public class Rect extends View {
    public Rect(Context context) {
        super(context);
    }

    public Rect(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Rect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLUE);


        canvas.drawRect(300,400,400,400,mPaint);
        mPaint.setColor(Color.BLACK);
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
