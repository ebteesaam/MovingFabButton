package com.example.android.movingbutton;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private boolean b = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FloatingActionButton fab = findViewById(R.id.fab);
        final FloatingActionButton fab1 = findViewById(R.id.fab_1);
        final FloatingActionButton fab2 = findViewById(R.id.fab_2);


        //Animations
        final Animation show_fab_1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fab1_show);
        final Animation hide_fab_1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fab1_hide);

        final Animation show_fab_2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fab2_show);
        final Animation hide_fab_2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fab2_hide);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b == true) {
                    final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fab1.getLayoutParams();
                    layoutParams.rightMargin += (int) (fab1.getWidth() * 1.6);
                    layoutParams.bottomMargin += (int) (fab1.getWidth() * 0.25);
                    fab1.setLayoutParams(layoutParams);
                    fab1.startAnimation(show_fab_1);
                    fab1.setClickable(true);

                    final RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) fab2.getLayoutParams();
                    layoutParams2.rightMargin += (int) (fab2.getWidth() * 0.25);
                    layoutParams2.bottomMargin += (int) (fab2.getWidth() * 1.6);
                    fab2.setLayoutParams(layoutParams2);
                    fab2.startAnimation(show_fab_2);
                    fab2.setClickable(true);
                    b = false;
                } else if (b == false) {
                    final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fab1.getLayoutParams();
                    layoutParams.rightMargin += (int) (fab1.getWidth() * -1.6);
                    layoutParams.bottomMargin += (int) (fab1.getWidth() * -0.25);
                    fab1.setLayoutParams(layoutParams);
                    fab1.startAnimation(hide_fab_1);

                    final RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) fab2.getLayoutParams();
                    layoutParams2.rightMargin += (int) (fab2.getWidth() * -0.25);
                    layoutParams2.bottomMargin += (int) (fab2.getWidth() * -1.6);
                    fab2.setLayoutParams(layoutParams2);
                    fab2.startAnimation(hide_fab_2);
                    fab2.setClickable(false);
                    b = true;
                }
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, AnnouncementActivity.class);
//                startActivity(intent);
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, AnnouncementGeneralActivity.class);
//                startActivity(intent);
            }
        });


    }

}
