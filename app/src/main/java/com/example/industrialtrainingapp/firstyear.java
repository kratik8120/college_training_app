package com.example.industrialtrainingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class firstyear extends AppCompatActivity {

    TextView heading, name, sec, duration, organisation, technology, url, phoneno, project, mode, roll;
    Button submit;
    EditText ename, eroll, emode, eduration, esec, eorg, etec, eurl, ephone, eproj;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageReference = storage.getReference();

    private static final int PICK_FILE_REQUEST_CODE = 100;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstyear);

        heading = findViewById(R.id.head);
        name = findViewById(R.id.name1);
        sec = findViewById(R.id.sec);
        duration = findViewById(R.id.Duration);
        organisation = findViewById(R.id.org);
        technology = findViewById(R.id.tec);
        url = findViewById(R.id.url);
        phoneno = findViewById(R.id.phone);
        project = findViewById(R.id.project);
        mode = findViewById(R.id.mode);
        roll = findViewById(R.id.roll);
        submit = findViewById(R.id.submit);
        ename = findViewById(R.id.ename);
        esec = findViewById(R.id.esec);
        eduration = findViewById(R.id.enterduration);
        eorg = findViewById(R.id.eorg);
        etec = findViewById(R.id.etec);
        eurl = findViewById(R.id.eurl);
        ephone = findViewById(R.id.ephone);
        eproj = findViewById(R.id.eproj);
        emode = findViewById(R.id.emode);
        eroll = findViewById(R.id.eroll);

        // Set up click listener for the URL field
        eurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                try {
                    startActivityForResult(intent, PICK_FILE_REQUEST_CODE);
                } catch (Exception e) {
                    Toast.makeText(firstyear.this, "Unable to open gallery", Toast.LENGTH_SHORT).show();
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ename.getText().toString();
                String usersec = esec.getText().toString();
                String userduration = eduration.getText().toString();
                String userproj = eproj.getText().toString();
                String userorg = eorg.getText().toString();
                String usertech = etec.getText().toString();
                String userroll = eroll.getText().toString();
                String usermode = emode.getText().toString();
                String userphone = ephone.getText().toString();
                String userurl = eurl.getText().toString();

                if (username.isEmpty() || userroll.isEmpty() || userphone.isEmpty()) {
                    Toast.makeText(firstyear.this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                Map<String, Object> users = new HashMap<>();
                users.put("name", username);
                users.put("organisation", userorg);
                users.put("duration", userduration);
                users.put("phoneno", userphone);
                users.put("roll", userroll);
                users.put("technology", usertech);
                users.put("project", userproj);
                users.put("url", userurl);
                users.put("mode", usermode);
                users.put("sec", usersec);

                db.collection("first").document(userroll).set(users)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(firstyear.this, "Data is saved", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(firstyear.this, "There is a problem", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                uploadFileToFirebase(selectedImageUri);
            } else {
                Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void uploadFileToFirebase(Uri fileUri) {
        String fileName = System.currentTimeMillis() + ".jpg"; // Adjust file extension as needed
        StorageReference fileRef = storageReference.child("uploads/" + fileName);

        fileRef.putFile(fileUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        fileRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                                if (task.isSuccessful()) {
                                    Uri downloadUri = task.getResult();
                                    eurl.setText(downloadUri.toString());
                                    Toast.makeText(firstyear.this, "File uploaded successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(firstyear.this, "Failed to get file URL", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(firstyear.this, "File upload failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        }
    }






