package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.slider.Slider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class InputActivity extends AppCompatActivity {
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    TextView textView;
    Slider slider;
    TextView textView2;
    Slider slider1;
    TextView textView3;
    Slider slider2;
    Button updtbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        slider = findViewById(R.id.HeartRateslider);
        textView =findViewById(R.id.hrtext3);
        slider2 = findViewById(R.id.slider3);
        textView2 =findViewById(R.id.hrtext2);
        slider1 = findViewById(R.id.slider1);
        textView3 =findViewById(R.id.hrtext);
        updtbtn=findViewById(R.id.updtbtn);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        slider.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {
                float heartrateval = slider.getValue();
                Integer heartrate =Math.round(heartrateval);
                textView.setText(String.valueOf(heartrate));
            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slide) {
                float heartrateval = slider.getValue();
                Integer heartrate =Math.round(heartrateval);
                textView.setText(String.valueOf(heartrate));
            }
        });    slider2.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider2) {
                float heartrateval = slider2.getValue();
                Integer heartrate =Math.round(heartrateval);
                textView2.setText(String.valueOf(heartrate));
            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slide) {
                float heartrateval = slider2.getValue();
                Integer heartrate =Math.round(heartrateval);
                textView2.setText(String.valueOf(heartrate));
            }
        });
        slider1.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider1) {
                float heartrateval = slider1.getValue();
                Integer heartrate =Math.round(heartrateval);
                textView3.setText(String.valueOf(heartrate));
            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slide) {
                float heartrateval = slider1.getValue();
                Integer heartrate =Math.round(heartrateval);
                textView3.setText(String.valueOf(heartrate));
            }
        });
        updtbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
                DatabaseReference reference = rootNode.getReference("Users");

                //Create helperclass reference and store data using firebase
                UserHelperClass addNewUser = new UserHelperClass("60", "120","papon@gmail.com" , "A+", "88", date);
                reference.child("120").setValue(addNewUser);

                //We will also create a Session here in next videos to keep the user logged In

               // startActivity(new Intent(getApplicationContext(), InputActivity.class));
               // finish();
            }
        });
    }


}