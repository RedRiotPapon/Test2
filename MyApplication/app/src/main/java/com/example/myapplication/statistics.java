package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class statistics extends AppCompatActivity {

    public String  val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics2);
        BarChart barChart = findViewById(R.id.barChart) ;
//        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
//        DatabaseReference reference = rootNode.getReference("Users");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                   val  =  String.valueOf(dataSnapshot1.child("120").getValue());
//
//                }
//            }
//
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        ArrayList<BarEntry> visitors = new ArrayList<>() ;
        visitors.add(new BarEntry( 2014, 420));
        visitors.add(new BarEntry( 2015, 475));
        visitors.add(new BarEntry( 2016, 508));
        visitors.add(new BarEntry( 2017, 660));
        visitors.add(new BarEntry( 2018, 550));
        visitors.add(new BarEntry( 2019, 630));
        visitors.add(new BarEntry(2020, 470));
        BarDataSet barDataSet = new BarDataSet (visitors,"Visitors ") ;
        barDataSet .setColors(ColorTemplate. MATERIAL_COLORS);
        barDataSet .setValueTextColor(Color. BLACK);
        barDataSet .setValueTextSize (20f) ;
        BarData barData = new BarData(barDataSet);
        barChart. setFitBars (true) ;
        barChart.setData (barData );
        barChart.getDescription() . setText ( "Bar Chart Example" );
        barChart.animateY( 2000);

    }
}