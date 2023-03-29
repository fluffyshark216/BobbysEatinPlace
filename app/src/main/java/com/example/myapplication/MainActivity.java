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
    private RadioGroup contact;
    private RadioButton radioButton;
    private RadioButton radioButtonTwo;
    private EditText edtEmail;
    private EditText edtPhone;
    private TextView txtEmail;
    private TextView txtPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        contact = findViewById(R.id.radioGroup);
        radioButton = findViewById(R.id.rbEmail);
        radioButtonTwo = findViewById(R.id.rbPhone);
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("Email",String.valueOf(R.id.edtEmail));
                editor.putString("Phone",String.valueOf(R.id.edtPhone));
                editor.putString("Name",String.valueOf(R.id.edtName));
                editor.putString("PartySize",String.valueOf(R.id.edtPartySize));
                editor.apply();

                startActivity(new Intent(MainActivity.this, ThankYou.class));
            }
        });


    }
}