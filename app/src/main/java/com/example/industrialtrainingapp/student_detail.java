package com.example.industrialtrainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class student_detail extends AppCompatActivity {

    TextView head;
    Button but1,but3,but5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
        head=findViewById(R.id.textView3);
        but1=findViewById(R.id.button3);

        but3=findViewById(R.id.button5);

        but5=findViewById(R.id.button7);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(student_detail.this,studentinfo.class);
                startActivity(i);
                finish();
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(student_detail.this, studentinfo.class);
                startActivity(i);
                finish();
            }
        });

        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(student_detail.this,studentinfo.class);
                startActivity(i);
                finish();
            }
        });

    }
}