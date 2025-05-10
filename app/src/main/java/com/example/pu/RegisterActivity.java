package com.example.pu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    Button register;

    EditText registerUsername,registerEmail,registerPassword,registerPhone;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerUsername = findViewById(R.id.registerUsername);
        register = findViewById(R.id.registerStudent);
        registerEmail = findViewById(R.id.registerEmail);
        registerPhone = findViewById(R.id.registerPhone);
        registerPassword = findViewById(R.id.registerPassword);





        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                
               String email,password;
               email = String.valueOf(registerEmail.getText());
               password = String.valueOf(registerPassword.getText());

               if (TextUtils.isEmpty(email)){
                   Toast.makeText(RegisterActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                   return;
               }
               if (TextUtils.isEmpty(password)){
                   Toast.makeText(RegisterActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                   return;
               }

               firebaseAuth.createUserWithEmailAndPassword(email,password)
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if(task.isSuccessful()){
                                   Toast.makeText(RegisterActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                                   Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                   startActivity(intent);
                                   finish();
                               }
                               else{
                                   Toast.makeText(RegisterActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
            }
        });



    }
}