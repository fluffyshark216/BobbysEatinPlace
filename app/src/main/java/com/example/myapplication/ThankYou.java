package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class ThankYou extends AppCompatActivity {
    //creating variables for 2nd activity
   TextView txtReservationMade ;
   String contactMethod;
   String reservationName;
   String partySize;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        //getting shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);

        //setting variables equal to the strings from the shared prefs
        txtReservationMade = (TextView) findViewById(R.id.txtReservationMade);
        reservationName = sharedPreferences.getString("Name","");
        partySize = sharedPreferences.getString("PartySize","");
      contactMethod = sharedPreferences.getString("ContactMethod","Value not found");

        //setting text view with data from shared preferences
        txtReservationMade.setText(reservationName + " , your reservation has been made. We will contact your preferred method, " + contactMethod + " when your reservation is ready." + "Current party size: " + partySize);


        }








    }
