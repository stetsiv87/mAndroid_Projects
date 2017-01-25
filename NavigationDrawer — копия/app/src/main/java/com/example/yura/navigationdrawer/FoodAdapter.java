package com.example.yura.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yura.navigationdrawer.food.CookerEntity;
import com.example.yura.navigationdrawer.food.Food;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Yura on 28.12.2016.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {
    Context context;


    public FoodAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.items, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = myViewHolder.getAdapterPosition();
                Intent mIntent = new Intent(context, Main2Activity.class);
                mIntent.putExtra("key", position);
                context.startActivity(mIntent);
                Toast.makeText(context, "Recycle Click" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Food myFood = CookerEntity.getInstance().getFoodList().get(position);
        AssetManager assetManager = context.getAssets();
        InputStream mInputStream = null;
        try {
            mInputStream = assetManager.open(myFood.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(mInputStream);
        holder.mImageView.setImageBitmap(bitmap);
        holder.mfavorite.setBackgroundResource(R.drawable.favorites_unselected_18dp);
        holder.mfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myFood.getBookmarkedState() == true) {
                    myFood.setBookmarkState(false);
                    holder.mfavorite.setBackgroundResource(R.drawable.favorites_unselected_18dp);
                } else {
                    myFood.setBookmarkState(true);
                    holder.mfavorite.setBackgroundResource(R.drawable.favorites_selected_18dp);
                }
                Toast.makeText(context, "Bookmark Click " + myFood.getBookmarkedState(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.mContectMenu.setBackgroundResource(R.drawable.menu);
        holder.mContectMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.showContextMenu();
            }
        });
    }


    @Override
    public int getItemCount() {
        return CookerEntity.getInstance().getFoodList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private Button mfavorite;
        private Button mContectMenu;

        public MyViewHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.iv_image);
            // mRect = (Rect) itemView.findViewById(R.id.rect_id);
            mfavorite = (Button) itemView.findViewById(R.id.iv_favorite);
            mContectMenu = (Button) itemView.findViewById(R.id.menu);

        }
    }
}
