package com.example.pu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ImageView profileImage,eventsImage,faqImage,newsImage,user;

    TextView profiletxt,eventstxt,faqtxt,newstxt;

    CardView cdcCard,tecCard,wdcCard,ircCard,tpcCard,srcCard,grcCard,edcCard,rdcCard;
    FloatingActionButton floatingActionButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });


        bottomNavigation();
        floatingActionButton();
        cardclick();


    }

    private void cardclick() {
        cdcCard= findViewById(R.id.cdcCard);
        wdcCard = findViewById(R.id.wdcCard);
        tecCard = findViewById(R.id.tecCard);
        ircCard = findViewById(R.id.ircCard);
        tpcCard = findViewById(R.id.tpcCard);
        srcCard = findViewById(R.id.srcCard);
        rdcCard = findViewById(R.id.rdcCard);
        edcCard = findViewById(R.id.edcCard);
        grcCard = findViewById(R.id.grcCard);

        cdcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CdcActivity.class);
                startActivity(intent);
            }
        });

        wdcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WdcActivity.class);
                startActivity(intent);

            }
        });
        tecCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TecActivity.class);
                startActivity(intent);


            }
        });
        ircCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WdcActivity.class);
                startActivity(intent);
            }
        });
        tpcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WdcActivity.class);
                startActivity(intent);
            }
        });
        srcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WdcActivity.class);
                startActivity(intent);
            }
        });
        grcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WdcActivity.class);
                startActivity(intent);
            }
        });
        edcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WdcActivity.class);
                startActivity(intent);
            }
        });
        rdcCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WdcActivity.class);
                startActivity(intent);
            }
        });

    }


    private void floatingActionButton() {
        floatingActionButton = findViewById(R.id.floatingbtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Only admin can log In", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),FacultyActivity.class);
                startActivity(intent);
            }
        });
    }


    private void bottomNavigation() {
        profileImage = findViewById(R.id.profileImage);
        eventsImage = findViewById(R.id.eventsImage);
        faqImage = findViewById(R.id.faqImage);
        newsImage = findViewById(R.id.newsImage);

        profiletxt = findViewById(R.id.profiletxt);
        eventstxt = findViewById(R.id.eventstxt);
        faqtxt = findViewById(R.id.faqtxt);
        newstxt = findViewById(R.id.newstxt);

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
                startActivity(intent);
            }
        });
        profiletxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        newsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "PU News", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),NewsActivity.class);
                startActivity(intent);
            }
        });
        newstxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "PU News", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),NewsActivity.class);
                startActivity(intent);
            }
        });
        faqImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "FAQ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),faqActivity.class);
                startActivity(intent);
            }
        });
        faqtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "FAQ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),faqActivity.class);
                startActivity(intent);
            }
        });

    }
}