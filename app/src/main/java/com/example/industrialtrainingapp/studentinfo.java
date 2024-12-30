package com.example.industrialtrainingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class studentinfo extends AppCompatActivity {

    // UI elements
    EditText ename, eroll, emode, eduration, esec, eorg, etec, ephone, eproj, eurl;
    Button submit;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentinfo);

        // Initialize UI elements
        ename = findViewById(R.id.ename);
        eroll = findViewById(R.id.eroll);
        emode = findViewById(R.id.emode);
        eduration = findViewById(R.id.enterduration);
        esec = findViewById(R.id.esec);
        eorg = findViewById(R.id.eorg);
        etec = findViewById(R.id.etec);
        ephone = findViewById(R.id.ephone);
        eproj = findViewById(R.id.eproj);
        eurl = findViewById(R.id.eurl);
        submit = findViewById(R.id.submit);

        // Handle submit button click
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fetch user input
                String username = ename.getText().toString();
                String userroll = eroll.getText().toString();
                String usermode = emode.getText().toString();
                String userduration = eduration.getText().toString();
                String usersec = esec.getText().toString();
                String userorg = eorg.getText().toString();
                String usertech = etec.getText().toString();
                String userphone = ephone.getText().toString();
                String userproj = eproj.getText().toString();
                String userurl = eurl.getText().toString();

                // Validate input
                if (username.isEmpty() || userroll.isEmpty() || usermode.isEmpty() || userduration.isEmpty() || usersec.isEmpty() ||
                        userorg.isEmpty() || usertech.isEmpty() || userphone.isEmpty() || userproj.isEmpty() || userurl.isEmpty()) {
                    Toast.makeText(studentinfo.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Prepare data to save in Firestore
                Map<String, Object> studentInfo = new HashMap<>();
                studentInfo.put("name", username);
                studentInfo.put("roll", userroll);
                studentInfo.put("mode", usermode);
                studentInfo.put("duration", userduration);
                studentInfo.put("section", usersec);
                studentInfo.put("organisation", userorg);
                studentInfo.put("technology", usertech);
                studentInfo.put("phone", userphone);
                studentInfo.put("project", userproj);
                studentInfo.put("url", userurl);

                // Save data to Firestore
                db.collection("users")
                        .add(studentInfo)
                        .addOnCompleteListener(new OnCompleteListener<com.google.firebase.firestore.DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<com.google.firebase.firestore.DocumentReference> task) {
                                if (task.isSuccessful()) {
                                    // Notify success
                                    Toast.makeText(studentinfo.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
                                } else {
                                    // Notify failure
                                    Toast.makeText(studentinfo.this, "Error saving data.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.e("Firestore Error", "Error saving document", e);
                            }
                        });
            }
        });
    }
}
