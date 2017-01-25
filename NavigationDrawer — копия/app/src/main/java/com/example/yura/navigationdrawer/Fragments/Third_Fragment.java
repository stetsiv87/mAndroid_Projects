package com.example.yura.navigationdrawer.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Yura on 02.01.2017.
 */

public class Third_Fragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(cameraIntent);
    }
    
}
