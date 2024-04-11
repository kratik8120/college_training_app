package com.example.industrialtrainingapp;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class student_login extends AppCompatActivity {

    TextView intro;
    TextView email;
    EditText enteremail;
    TextView pswd;
    EditText enterpswd;
    Button login;


    FirebaseAuth auth=FirebaseAuth.getInstance();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        intro=findViewById(R.id.heading);
        email=findViewById(R.id.name);
        enteremail=findViewById(R.id.entermail);
        enterpswd=findViewById(R.id.enter);
        pswd=findViewById(R.id.pswd);
        login=findViewById(R.id.submit);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail=enteremail.getText().toString();
                String userPassword=enterpswd.getText().toString();
                SignInFirebase(userEmail,userPassword);
                if(TextUtils.isEmpty(userEmail))
                {
                    Toast.makeText(student_login.this, "enter the MailId", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(userPassword))
                {
                    Toast.makeText(student_login.this, "enter the password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void SignInFirebase(String userEmail,String userPassword) {
        auth.signInWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(student_login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(student_login.this, student_detail.class);
                            startActivity(i);

                        } else {
                            Toast.makeText(student_login.this, "Mail Id or password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}