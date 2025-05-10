package com.example.pu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class AddeventsActivity extends AppCompatActivity  {


    EditText upload_Date,upload_Time,upload_Name,upload_Place,Cell;

    Button save_button;

    FloatingActionButton addImage;

    String imageurl;


    Uri uri;




    ImageView upload_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevents);

        datepicker();
        timepicker();

        upload_Date = findViewById(R.id.Date);
        upload_Time = findViewById(R.id.Time);
        upload_Name = findViewById(R.id.Name);
        upload_Place = findViewById(R.id.Place);
        upload_image = findViewById(R.id.Image);
        save_button = findViewById(R.id.addEvent);
        addImage = findViewById(R.id.addImage);
        Cell = findViewById(R.id.Cell);

        String username = getIntent().getStringExtra("keyname");
        Cell.setText(username);





        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            uri = data.getData();
                            upload_image.setImageURI(uri);
                        } else {
                            Toast.makeText(AddeventsActivity.this, "No image Selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photopicker = new Intent(Intent.ACTION_PICK);
                photopicker.setType("image/+");
                activityResultLauncher.launch(photopicker);

            }
        });

            save_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    savadata();


                }
            });



    }

    private void savadata() {

        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Events Image")
                .child(uri.getLastPathSegment());

        AlertDialog.Builder builder = new AlertDialog.Builder(AddeventsActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();


        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri urlImage = uriTask.getResult();
                imageurl = urlImage.toString();
                uploadData();
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
            }
        });


    }

    private void uploadData() {
        String cell = Cell.getText().toString();
        String Name = upload_Name.getText().toString();
        String Date = upload_Date.getText().toString();
        String Time = upload_Time.getText().toString();
        String Place =upload_Place.getText().toString();


        DataClass dataClass = new DataClass(Name,Date,Time,Place,cell,imageurl);

        FirebaseDatabase.getInstance().getReference("Android Tutorials").child(Name)
                .setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(AddeventsActivity.this, "Event added", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddeventsActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });





    }

    private void timepicker() {
        upload_Time = findViewById(R.id.Time);
        upload_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog =new TimePickerDialog(AddeventsActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {

                        upload_Time.setText(String.valueOf(hours)+":"+String.valueOf(minutes));
                    }
                }, 10, 10, false);

                dialog.show();
            }
        });


    }

    private void datepicker() {
        upload_Date = findViewById(R.id.Date);
        upload_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog dialog = new DatePickerDialog(AddeventsActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        upload_Date.setText(String.valueOf(day)+"/"+String.valueOf(month+1)+"/"+String.valueOf(year));

                    }
                }, 2024, 2, 14);
                dialog.show();
            }
        });

    }



}
