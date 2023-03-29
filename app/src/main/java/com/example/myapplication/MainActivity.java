package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup contact;
    private RadioButton radioButton;
    private RadioButton radioButtonTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact = findViewById(R.id.radioGroup);
        radioButton = findViewById(R.id.radioButton);
        radioButtonTwo = findViewById(R.id.radioButton2);
        radioButton.setOnClickListener(view -> {

        });
        radioButtonTwo.setOnClickListener(view -> {

        });

        Button button = (Button) findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ThankYou.class));
            }
        });
    }
}