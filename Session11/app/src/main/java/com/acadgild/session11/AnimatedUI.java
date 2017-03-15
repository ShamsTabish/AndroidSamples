package com.acadgild.session11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class AnimatedUI extends AppCompatActivity{
    TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_ui);
        myText=(TextView)findViewById(R.id.myTextView);

//        Animation fadeAnimation= AnimationUtils.loadAnimation(this,R.anim.demo_animation);
//
//        myText.setAnimation(fadeAnimation);

    }
    public void animateMe(View v){

        Animation fadeAnimation= AnimationUtils.loadAnimation(this,R.anim.demo_animation);

        myText.setAnimation(fadeAnimation);

        fadeAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(AnimatedUI.this, "Starting the Animation", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(AnimatedUI.this, "Ended....", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        myText.startAnimation(fadeAnimation);

    }


}
