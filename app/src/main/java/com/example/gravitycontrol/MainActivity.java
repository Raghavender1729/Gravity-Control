package com.example.gravitycontrol;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linear;
    private ImageView image;
    private int n = 0;
    private int h;
    private ObjectAnimator animator = new ObjectAnimator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear = findViewById(R.id.linear);
        image = findViewById(R.id.image);
        n = 0;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        final int h = dm.heightPixels;

        linear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                if (n == 0) {
                    animator.setTarget(image);
                    animator.setPropertyName("translationY");
                    animator.setFloatValues((image.getTranslationY()),(float) (h-250));
                    animator.setDuration((2200));
                    animator.setInterpolator(new AccelerateInterpolator());
                    animator.start();
                    n++;
                }
                else {
                    animator.setTarget(image);
                    animator.setPropertyName("translationY");
                    animator.setFloatValues((image.getTranslationY()), (float) (0));
                    animator.setDuration((2200));
                    animator.setInterpolator(new AccelerateInterpolator());
                    animator.start();
                    n--;
                }

            }
        });
    }


}
