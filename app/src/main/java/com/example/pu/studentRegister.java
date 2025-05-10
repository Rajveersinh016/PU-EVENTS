package com.example.pu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class studentRegister extends AppCompatActivity {

    ImageView back;

    EditText sName,sPersnolId,sParulId,sInstitue,sNumber,eventName;

    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        eventName = findViewById(R.id.eventName);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        String username = getIntent().getStringExtra("Name");
        eventName.setText(username);
        
        sName = findViewById(R.id.studentName);
        sPersnolId = findViewById(R.id.studentPersonalEmail);
        sParulId = findViewById(R.id.studentEmail);
        sInstitue = findViewById(R.id.studentInstitute);
        sNumber = findViewById(R.id.studentNumber);
        register = findViewById(R.id.registerStudent);




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadData();
            }
        });





    }

    private void uploadData() {

        String Name = sName.getText().toString();
        String PersnolId = sPersnolId.getText().toString();
        String ParulId = sParulId.getText().toString();
        String Institute = sInstitue.getText().toString();
        String Number = sNumber.getText().toString();
        String EventName = eventName.getText().toString();


        Student dataclass = new Student(Name,PersnolId,ParulId,Institute,Number,EventName);

        FirebaseDatabase.getInstance().getReference("Students").child(Name)
                .setValue(dataclass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(studentRegister.this, "Registation successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(studentRegister.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
}