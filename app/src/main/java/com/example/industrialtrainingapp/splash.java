package com.example.industrialtrainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {


    TextView textView,base;
    Animation bottom,top;
    ImageView image;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        top=AnimationUtils.loadAnimation(this,R.anim.top);
        bottom=AnimationUtils.loadAnimation(this,R.anim.bottom);
        textView=findViewById(R.id.textView5);
        image=findViewById(R.id.imageView3);
        base=findViewById(R.id.base);

        image.setAnimation(top);
        textView.setAnimation(bottom);
        base.setAnimation(bottom);
        Intent i=new Intent(splash.this, MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent i=new Intent(splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },5000);
    }
}