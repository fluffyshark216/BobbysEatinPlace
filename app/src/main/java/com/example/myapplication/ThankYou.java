package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ThankYou extends AppCompatActivity {
    //creating variables for 2nd activity
   // TextView txtReservationMade = (TextView) findViewById(R.id.txtReservationMade);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
    }
}