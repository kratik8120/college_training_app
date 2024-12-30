package com.example.industrialtrainingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class thirdyear extends AppCompatActivity {

    TextView eroll,ename,emode,heading,eurl,ephone,eduration,eorg,etec,eproj,esec,name,sec,organisation,technology,url,phoneno,project,mode,roll;

//    Button submit;

    ArrayList<itemlist> listAllItem;
    FirebaseFirestore db;
    Context context;
    FirebaseFirestore b;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdyear);

                heading=findViewById(R.id.head);
                name=findViewById(R.id.name1);
                sec=findViewById(R.id.sec);
//                duration=findViewById(R.id.Duration);
                organisation=findViewById(R.id.org);
//                technology=findViewById(R.id.t);
                url=findViewById(R.id.url);
                phoneno=findViewById(R.id.phone);
//                project=findViewById(R.id.pp);
                mode=findViewById(R.id.mode);
                roll=findViewById(R.id.roll);
                ename=findViewById(R.id.ename);
                esec=findViewById(R.id.esec);
                eduration=findViewById(R.id.enterduration);
                eorg=findViewById(R.id.eorg);
//              eproj=findViewById(R.id.eppp);
                eurl=findViewById(R.id.eurl);
                ephone=findViewById(R.id.ephone);
//                etec=findViewById(R.id.tt);
                emode=findViewById(R.id.emode);
                eroll=findViewById(R.id.eroll);
                b=FirebaseFirestore.getInstance();

//        eurl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String imageUrl=eurl.getText().toString();
//                Intent i=new Intent(thirdyear.this,webview.class);
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
//                ephone.setText(selectedStudent.getPhoneno());
               eproj.setText(selectedStudent.getProject());
                eorg.setText(selectedStudent.getOrganisation());
                etec.setText(selectedStudent.getTechnology());
                emode.setText(selectedStudent.getMode());
                eurl.setText(selectedStudent.getUrl());
            }
            else {
                // Handle the case where selectedStudent is not provided
            }
        }

            }

}
