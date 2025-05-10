package com.example.pu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    ImageView news,events,share,logout,backbtn,faq;

    TextView newstxt,eventstxt,sharetxt,logouttxt,faqtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // open the select activity
        openactivity();

    }

    private void openactivity() {


        faq = findViewById(R.id.faq);
        news = findViewById(R.id.news);
        events = findViewById(R.id.events);
        share = findViewById(R.id.share);
        backbtn = findViewById(R.id.back);

        faqtxt = findViewById(R.id.faqtxt);
        newstxt = findViewById(R.id.newstxt);
        eventstxt = findViewById(R.id.eventstxt);
        sharetxt = findViewById(R.id.sharetxt);



        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Back to Events", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "FAQ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),faqActivity.class);
                startActivity(intent);
            }
        });
        faqtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "FAQ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),faqActivity.class);
                startActivity(intent);
            }
        });


        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "PU News", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),NewsActivity.class);
                startActivity(intent);
            }
        });
        newstxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "PU News", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),NewsActivity.class);
                startActivity(intent);
            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Events", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        eventstxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Events", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "You can share the app", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Hello");
                intent.setType("text/plain");

                if(intent.resolveActivity(getPackageManager())!= null){
                    startActivity(intent);
                }
            }
        });
        sharetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "You can share the app", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Hello");
                intent.setType("text/plain");

                if(intent.resolveActivity(getPackageManager())!= null){
                    startActivity(intent);
                }
            }
        });


    }
}