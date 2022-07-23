package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class homeActivity2 extends AppCompatActivity {
    public ImageButton home;
    public ImageButton Input;
    public ImageButton stat;
    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        Input = findViewById(R.id.inputbtn);
        stat= findViewById(R.id.statbtn);
        home = findViewById(R.id.homebtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeActivity2.this,homeActivity2.class);
                overridePendingTransition(0,0);
                startActivity(intent);

            }
        });
        Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeActivity2.this,InputActivity.class);
                overridePendingTransition(0,0);
                startActivity(intent);

            }
        });
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeActivity2.this,statistics.class);
                overridePendingTransition(0,0);
                startActivity(intent);

            }
        });
    }
}