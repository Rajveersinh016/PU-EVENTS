package com.example.pu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FacultyActivity extends AppCompatActivity {

    Button facultyLogin;

    EditText facultyemail,facultyPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        facultyemail = findViewById(R.id.facultyEmail);
        facultyPassword = findViewById(R.id.facultyPassword);

        facultyLogin = findViewById(R.id.facultylogin);
        facultyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              check();

            }
        });
    }

    private void check() {


        if (facultyemail.getText().toString().equals("TEC") && facultyPassword.getText().toString().equals("TEC")
                || facultyemail.getText().toString().equals("WDC") && facultyPassword.getText().toString().equals("WDC")
                || facultyemail.getText().toString().equals("IRC") && facultyPassword.getText().toString().equals("IRC")
                || facultyemail.getText().toString().equals("CDC") && facultyPassword.getText().toString().equals("CDC")
        ){

            String username = facultyemail.getText().toString();
            Toast.makeText(FacultyActivity.this, "Now you can add events", Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(getApplicationContext(),AddeventsActivity.class);
            intent.putExtra("keyname",username);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }


    }
}