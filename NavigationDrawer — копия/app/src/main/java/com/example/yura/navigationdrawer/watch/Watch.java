package com.example.yura.navigationdrawer.watch;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Yura on 19.12.2016.
 */

public class Watch extends RelativeLayout {

    WatchFace mWatchFace;
    WatchHands mWatchHands;

    public Watch(Context context) {
        super(context);
        initialize(context);
    }

    public Watch(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public Watch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {
        mWatchFace = new WatchFace(context);
        addView(mWatchFace);

        mWatchHands = new WatchHands(context);
        addView(mWatchHands);

    }

    public void setTime(int time) {
        mWatchHands.setTime(time);
    }

}
