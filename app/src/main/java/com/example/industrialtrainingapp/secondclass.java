package com.example.industrialtrainingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.industrialtrainingapp.databinding.ActivitySecondclassBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class secondclass extends AppCompatActivity {

    TextView eroll,ename,emode,heading,duration,eurl,ephone,eduration,eorg,etec,eproj,esec,name,sec,organisation,technology,url,phoneno,project,mode,roll;

    ArrayList<itemlist> listAllItem;
    FirebaseFirestore db;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondclass);
        heading=findViewById(R.id.infotitle);
        name=findViewById(R.id.nametext);
        sec=findViewById(R.id.sectext);
//                duration=findViewById(R.id.dddddd);
        organisation=findViewById(R.id.organtext);
        technology=findViewById(R.id.technogtext);
        url=findViewById(R.id.urltext);
//                phoneno=findViewById(R.id.phoneee);
        project=findViewById(R.id.projtext);
        mode=findViewById(R.id.modetext);
        roll=findViewById(R.id.rolltext);
        ename=findViewById(R.id.enternametext);
        esec=findViewById(R.id.entersectext);
//                eduration=findViewById(R.id.enterdddd);
        eorg=findViewById(R.id.enterorgantext);
        eproj=findViewById(R.id.enterprojtext);
        eurl=findViewById(R.id.enterurltext);
//                ephone=findViewById(R.id.enterp);
        etec=findViewById(R.id.entertechnogtext);
        emode=findViewById(R.id.entermodetext);
        eroll=findViewById(R.id.enterrolltext);
        db=FirebaseFirestore.getInstance();

//        eurl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String imageUrl=eurl.getText().toString();
//                Intent i=new Intent(secondclass.this,webview.class);
//                i.putExtra("imageUrl", imageUrl);
//                startActivity(i);
//            }
//        });
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