package com.example.textview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String[] str = {"one","two","three","asdfgf"};
    final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
    final TextView[] tv = new TextView[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            for (int i=0; i<str.length; i++)
            {
            tv[i] = new TextView(this);
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams
                    ((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 50;
            params.topMargin  = i*50;
            tv[i].setText(str[i]);
            tv[i].setTextSize((float) 20);
            tv[i].setPadding(20, 50, 20, 50);
            tv[i].setLayoutParams(params);
            rl.addView(tv[i]);
        }
    }
}
