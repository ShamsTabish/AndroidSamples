package com.acadgild.session10;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class PaletteDemo extends AppCompatActivity {
    Palette myImagePalette;
    RelativeLayout baseLayout;
    CardView myCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette_demo);
        myCard=(CardView)findViewById(R.id.cardView);
        baseLayout=(RelativeLayout)findViewById(R.id.activity_palette_demo);
        loadImageAndColorize();
    }

    void loadImageAndColorize(){
        Bitmap myImage=BitmapFactory.decodeResource(getResources(),R.drawable.flower);

        myImagePalette=Palette.from(myImage).generate();
        getWindow().setBackgroundDrawable(
                new ColorDrawable(myImagePalette.getDarkMutedColor(Color.RED))
        );

        myCard.setBackgroundColor(myImagePalette.getLightMutedColor(Color.YELLOW));
    }

}
