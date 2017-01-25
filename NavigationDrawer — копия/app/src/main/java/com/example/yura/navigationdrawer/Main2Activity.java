package com.example.yura.navigationdrawer;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yura.navigationdrawer.Fragments.WatchFragment;
import com.example.yura.navigationdrawer.food.CookerEntity;
import com.example.yura.navigationdrawer.food.Food;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements OnDialogDoneListener {

    ImageView foodImage;
    DialogFragment dialogFragment;
    FragmentTransaction transaction;
    TextView tvIngredientsLable;
    TextView tvStepsLable;
    TextView tvIngredientsBody;
    CookerEntity cooker = CookerEntity.getInstance();
    Bundle bundle;
    int[] timeForSteps;
    ArrayList<TextView> textViewList = new ArrayList<>();
    private static int timeIndex = 0;
    Food food;
    Button cookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        System.out.println("Creating method activity");
        final LinearLayout rl = (LinearLayout) findViewById(R.id.rl);
        food = cooker.getFoodList().get(getIntent().getIntExtra("key", 0));
        timeForSteps = food.getTimeList();

        foodImage = (ImageView) findViewById(R.id.food_img);
        AssetManager assetManager = getAssets();
        InputStream mInputStream = null;
        try {
            mInputStream = assetManager.open(food.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(mInputStream);
        foodImage.setImageBitmap(bitmap);


        tvIngredientsLable = (TextView) findViewById(R.id.tv_ingredients);
        tvStepsLable = (TextView) findViewById(R.id.tv_steps);
        tvIngredientsBody = (TextView) findViewById(R.id.et_ingredients_body);
        tvIngredientsBody.setText(food.getIngredients());


        for (int i = 0; i < food.getSteps().length; i++) {
            TextView tv = new TextView(this);
            tv.setText(food.getSteps()[i]);
            tv.setId(i);
            textViewList.add(tv);
            System.out.println("Arrays size " + textViewList.size());
            tv.setTextColor(getResources().getColor(R.color.Black));
            rl.addView(tv);
        }


        cookButton = (Button) findViewById(R.id.button_timer);


        cookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getFragmentManager().beginTransaction();
                dialogFragment = new WatchFragment();
                transaction.add(dialogFragment, "dialog");
                bundle = new Bundle();
                bundle.putInt("time", timeForSteps[timeIndex]);
                dialogFragment.setArguments(bundle);
                transaction.commit();
            }
        });
    }


    @Override
    public void onDialogDone(int stepsCounter, boolean state) {
        this.timeIndex = stepsCounter;
        cookButton.setText("Step " + (timeIndex + 1) + ": start time");
        Toast.makeText(this, "Step" + timeIndex + " has been finished", Toast.LENGTH_SHORT).show();
        if (state) {
            int index = timeIndex - 1;
            textViewList.get(index).setTextColor(getResources().getColor(R.color.ColorGrey));
        }


    }

    @Override
    protected void onStop() {
        super.onStop();
        timeIndex = 0;
        Log.v("TAG", "Stop method");

    }
}

