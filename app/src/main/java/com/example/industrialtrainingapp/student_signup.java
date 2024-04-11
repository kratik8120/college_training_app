package com.example.industrialtrainingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class student_signup extends AppCompatActivity {


    TextView Signup;
    TextView Name;
    EditText entername;
    TextView rollno;
    EditText enterroll;

    TextView mail;
    EditText entermail;
    TextView pswd;
    EditText enterpswd;

    TextView alreadyaccount;

    TextView shouldbe,character,upper,lower,number;
    TextView login;

    Button signup;

    String regex = "^[a-z0-9+_.-]+@[a-zA-Z0-9.-]+$";

    String pff = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";

//    String roll="^[A-Z][0-9].{10,15}$";

    FirebaseAuth auth=FirebaseAuth.getInstance();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_signup);
        Signup=findViewById(R.id.heading);
        Name=findViewById(R.id.name);
        entername=findViewById(R.id.entername);
        rollno=findViewById(R.id.rollno);
        enterroll=findViewById(R.id.enterrolno);
        mail=findViewById(R.id.mailid);
        entermail=findViewById(R.id.entermail);
        pswd=findViewById(R.id.pswd);
        enterpswd=findViewById(R.id.enter);
        signup=findViewById(R.id.submit);
        alreadyaccount=findViewById(R.id.textView);
        login=findViewById(R.id.textView2);
        shouldbe=findViewById(R.id.shouldbe);
        character=findViewById(R.id.character);
        upper=findViewById(R.id.upper);
        lower=findViewById(R.id.lower);
        number=findViewById(R.id.number);





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), student_login.class);
                startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName=entername.getText().toString();
                String userEmail=entermail.getText().toString();
                String userRoll=enterroll.getText().toString();
                String userPassword=enterpswd.getText().toString();
                 Boolean check=validateInfo(userName,userRoll,userEmail,userPassword);

                 if(check==true) {
                     SignUpFirebase(userName, userRoll, userEmail, userPassword);
                 }
                 else{
                     Toast.makeText(student_signup.this, "some problem", Toast.LENGTH_SHORT).show();
                 }

            }

        });
    }

    private Boolean validateInfo(String userName, String userRoll, String userEmail, String userPassword) {

        if(TextUtils.isEmpty(userName)){
            entername.requestFocus();
            entername.setError("enter the name");
            return false;
        }
        else if (TextUtils.isEmpty(userEmail)) {

            entermail.requestFocus();
            entermail.setError("enter the mail");
            return false;
        }
//        else if (!userEmail.matches(regex)) {
//
//            entermail.requestFocus();
//            entermail.setError("not valid");
//            return false;
//        }
        else if (userPassword.length()<8) {

            enterpswd.requestFocus();
            enterpswd.setError("limit extend");
            return false;
//            Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(userRoll)) {
            
            enterroll.requestFocus();
            enterroll.setError("enter the roll");
            return false;

        }

//        else if (!userRoll.matches(roll)) {
//            enterroll.requestFocus();
//            enterroll.setError("not valid");
//            return false;
//
//        }

        else if (TextUtils.isEmpty(userPassword)){
            enterpswd.requestFocus();
            enterpswd.setError("enter the pass");
            return false;

        }
        else if (!userPassword.matches(pff)) {

            enterpswd.getText().clear();
            enterpswd.requestFocus();
            enterpswd.setError("not valid");
            return false;
        }
        else {
            return true;
        }
    }

    public void SignUpFirebase(String userName,String userRoll,String userEmail,String userPassword) {
        auth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            try {
                                Toast.makeText(student_signup.this, "Your Account is Created", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(student_signup.this, student_detail.class);
                                startActivity(i);

                            } catch (Exception e) {
                                Toast.makeText(student_signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                            else{
                                // If sign in fails, display a message to the user.
                                Toast.makeText(student_signup.this, "There is problem", Toast.LENGTH_SHORT).show();
                            }
                        }


                });

    }
}