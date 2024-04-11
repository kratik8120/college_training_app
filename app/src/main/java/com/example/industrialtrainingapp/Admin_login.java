package com.example.industrialtrainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Admin_login extends AppCompatActivity {

    TextView head,id,pass;
    EditText enterid,enterpass;
    Button login;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        head=findViewById(R.id.textView);
        id=findViewById(R.id.textView2);
        pass=findViewById(R.id.textView3);
        enterid=findViewById(R.id.editTextName);
        enterpass=findViewById(R.id.editTextPassword);
        login=findViewById(R.id.buttonSubmit);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userid = enterid.getText().toString();
                String userpass = enterpass.getText().toString();

                if (TextUtils.isEmpty(userid)) {
                    Toast.makeText(Admin_login.this, "Enter the id", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(userpass)) {
                    Toast.makeText(Admin_login.this, "Enter the password", Toast.LENGTH_SHORT).show();
                }

                if (userpass.length() >= 7)
                {
                    Toast.makeText(Admin_login.this, "password can't be more than 6 character", Toast.LENGTH_SHORT).show();
                }
                Intent i=new Intent(Admin_login.this, Recycler.class);
                startActivity(i);
                finish();

            }
        });
    }
}