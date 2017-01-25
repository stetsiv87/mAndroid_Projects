package com.example.yura.navigationdrawer.watch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Yura on 18.12.2016.
 */

public class WatchHands extends View {
    public WatchHands(Context context) {
        super(context);
    }

    public WatchHands(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WatchHands(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = canvas.getWidth()/2;
        float height = canvas.getHeight()/2;
        float radius = 300;

        Paint painter = new Paint(Paint.ANTI_ALIAS_FLAG);
        painter.setColor(Color.BLACK);
        painter.setStrokeWidth(10);
        canvas.drawLine(width, height, width, height-radius, painter);
    }

    public void setTime(int time) {
        setRotation(time);
    }
}
