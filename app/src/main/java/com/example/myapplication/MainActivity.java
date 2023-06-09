package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //setting variables
    private RadioGroup contact;
    private RadioButton radioButton;
    private RadioButton radioButtonTwo;
    private EditText edtEmail;
    private EditText edtPhone;
    private EditText edtName;
    private EditText edtPartySize;
    private TextView txtEmail;
    private TextView txtPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //creating shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        setContentView(R.layout.activity_main);
        //setting variables
        edtName = findViewById(R.id.edtName);
        edtPartySize = findViewById(R.id.edtPartySize);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        contact = findViewById(R.id.radioGroup);
        radioButton = findViewById(R.id.rbEmail);
        radioButtonTwo = findViewById(R.id.rbPhone);
        //if then statement to change what edit text appears based on what radio button user selects
        radioButton.setOnClickListener(view -> {

            edtEmail.setVisibility(view.VISIBLE);
            txtEmail.setVisibility(view.VISIBLE);
            edtPhone.setVisibility(view.INVISIBLE);
            txtPhone.setVisibility(view.INVISIBLE);
        });
        radioButtonTwo.setOnClickListener(view -> {

            edtPhone.setVisibility(view.VISIBLE);
            txtPhone.setVisibility(view.VISIBLE);
            edtEmail.setVisibility(view.INVISIBLE);
            txtEmail.setVisibility(view.INVISIBLE);
        });

        Button button = (Button) findViewById(R.id.btnSubmit);
        //method for button to send data to thank you activity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if then statement based on what radio button is checked then corresponding data is sent
                if(radioButton.isChecked()){
                    editor.putString("ContactMethod",edtEmail.getText().toString());

                }
                else if(radioButtonTwo.isChecked()){
                    editor.putString("ContactMethod",edtPhone.getText().toString());

                }

                //passing data to next activity
                editor.putString("Name",edtName.getText().toString());
                editor.putString("PartySize",edtPartySize.getText().toString());
                editor.apply();
                //starting the next activity
                startActivity(new Intent(MainActivity.this, ThankYou.class));
            }
        });


    }
}