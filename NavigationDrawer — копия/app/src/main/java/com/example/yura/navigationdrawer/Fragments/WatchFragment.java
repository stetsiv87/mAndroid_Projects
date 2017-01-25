package com.example.yura.navigationdrawer.Fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.yura.navigationdrawer.OnDialogDoneListener;
import com.example.yura.navigationdrawer.R;
import com.example.yura.navigationdrawer.watch.Watch;
import com.example.yura.navigationdrawer.watch.WatchHands;

/**
 * Created by Yura on 15.12.2016.
 */

public class WatchFragment extends DialogFragment implements View.OnClickListener {
    int rotate = 1;
    Watch mWatch;
    int  timeMyFood;
    int descendingCount;
    Thread mThread = null;
    Button continue_bt;
    TextView timeView;
    Handler handler;
    public static int stepsCounter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Dialog dialog = new Dialog(context);
        dialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            this.timeMyFood = bundle.getInt("time",0);
            this.descendingCount = timeMyFood;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.watch_fragment, container, true);
        mWatch = (Watch) view.findViewById(R.id.watch);
        continue_bt = (Button) view.findViewById(R.id.fg_continue);
        timeView = (TextView)view.findViewById(R.id.time_to_cook);
        continue_bt.setEnabled(false);
        handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                timeView.setText("It will take: " +(descendingCount--));
                if (msg.what == timeMyFood) {
                    continue_bt.setEnabled(true);
                }
            }
        } ;
        startapp(view);
        continue_bt.setOnClickListener(this);

        return view;
    }


    public void  startapp(View v) {
        for (int j = 0; j < 1; j++) {
            System.out.println("main thread...");
            Task mTask = new Task();
            mThread = new Thread(mTask);
            mThread.start();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mThread.interrupt();
    }

    @Override
    public void onClick(View view) {
        stepsCounter++;
       OnDialogDoneListener myListener = (OnDialogDoneListener) getActivity();
       myListener.onDialogDone(stepsCounter,true);

        dismiss();
    }

    class Task implements Runnable {
            int value = 0;


            @Override
            public synchronized void run() {

                    for (int i = 0; i <= timeMyFood; i++) {
                        System.out.println("second thread...");
                        rotate += 6;

                        mWatch.setTime(rotate);
                        handler.sendEmptyMessage(i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (getView() != null) {
                            WatchHands ca = (WatchHands) getView().findViewById(R.id.arrow);
                            ca.setTime(value);
                        } else {
                            dismiss();
                            Log.e("ASD", "ASD");
                        }
                    }
            }
    }
}


