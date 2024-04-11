package com.example.industrialtrainingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class studentinfo extends AppCompatActivity  {

    TextView heading,name,sec,duration,organisation,technology,url,phoneno,project,mode,roll;
    Button submit;
    EditText ename,eroll,emode,eduration,esec,eorg,etec,eurl,ephone,eproj;

FirebaseFirestore db=FirebaseFirestore.getInstance();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentinfo);
        heading=findViewById(R.id.head);
        name=findViewById(R.id.name1);
        sec=findViewById(R.id.sec);
        duration=findViewById(R.id.Duration);
        organisation=findViewById(R.id.org);
        technology=findViewById(R.id.tec);
        url=findViewById(R.id.url);
        phoneno=findViewById(R.id.phone);
        project=findViewById(R.id.project);
        mode=findViewById(R.id.mode);
        roll=findViewById(R.id.roll);
        submit=findViewById(R.id.submit);
        ename=findViewById(R.id.ename);
        esec=findViewById(R.id.esec);
        eduration=findViewById(R.id.enterduration);
        eorg=findViewById(R.id.eorg);
        etec=findViewById(R.id.etec);
        eurl=findViewById(R.id.eurl);
        ephone=findViewById(R.id.ephone);
        eproj=findViewById(R.id.eproj);
        emode=findViewById(R.id.emode);
        eroll=findViewById(R.id.eroll);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=ename.getText().toString();
                String usersec=esec.getText().toString();
                String userduration=eduration.getText().toString();
                String userproj=eproj.getText().toString();
                String userorg=eorg.getText().toString();
                String usertech=etec.getText().toString();
                String userroll=eroll.getText().toString();
                String usermode=emode.getText().toString();
                String userphone=ephone.getText().toString();
                String userurl=eurl.getText().toString();

                Map<String,Object> users=new HashMap<>();
                users.put("name",username);
                users.put("organisation",userorg);
                users.put("duration",userduration);
                users.put("phoneno",userphone);
                users.put("roll",userroll);
                users.put("technology",usertech);
                users.put("project",userproj);
                users.put("url",userurl);
                users.put("mode",usermode);
                users.put("sec",usersec);

                db.collection("users").add(users)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(studentinfo.this, "Data is saved", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(studentinfo.this, "There is a problem", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });





    }
}