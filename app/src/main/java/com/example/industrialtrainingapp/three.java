package com.example.industrialtrainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class three extends AppCompatActivity {

    TextView eroll,ename,emode,heading,duration,eurl,ephone,eduration,eorg,etec,eproj,esec,name,sec,organisation,technology,url,phoneno,project,mode,roll;

//    Button submit;

    ArrayList<itemlist> listAllItem;
    FirebaseFirestore db;
    Context context;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

                heading=findViewById(R.id.headhhhh);
                name=findViewById(R.id.nameeee);
                sec=findViewById(R.id.seccc);
//                duration=findViewById(R.id.dddddd);
                organisation=findViewById(R.id.organ);
                technology=findViewById(R.id.technog);
                url=findViewById(R.id.urll);
//                phoneno=findViewById(R.id.phoneee);
                project=findViewById(R.id.proooj);
                mode=findViewById(R.id.modeeee);
                roll=findViewById(R.id.roooll);
                ename=findViewById(R.id.enternameee);
                esec=findViewById(R.id.enterseccc);
//                eduration=findViewById(R.id.enterdddd);
                eorg=findViewById(R.id.enterorg);
              eproj=findViewById(R.id.enterproooj);
                eurl=findViewById(R.id.enterurlll);
//                ephone=findViewById(R.id.enterp);
               etec=findViewById(R.id.entertech);
                emode=findViewById(R.id.entermodeee);
                eroll=findViewById(R.id.enterroooll);
                db=FirebaseFirestore.getInstance();

                Intent intent = getIntent();
                if (intent != null) {
                    itemlist selectedStudent = (itemlist) intent.getSerializableExtra("selectedStudent");

                    if (selectedStudent != null) {
                        // Display student details
                        ename.setText(selectedStudent.getName());
                        eroll.setText(selectedStudent.getRoll());
                        esec.setText(selectedStudent.getSec());
//                       ephone.setText(Math.toIntExact(selectedStudent.getPhoneno()));
                eproj.setText(selectedStudent.getProject());
                        eorg.setText(selectedStudent.getOrganisation());
               etec.setText(selectedStudent.getTechnology());
                        emode.setText(selectedStudent.getMode());
                        eurl.setText(selectedStudent.getUrl());
                    }

                }

            }

        }


