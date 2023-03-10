package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
         Button getStartedButton = findViewById(R.id.button_get_started);
         getStartedButton.setOnClickListener(new View.OnClickListener() {
@Override
 public void onClick(View v) {
                 Intent intent = new Intent(WelcomeActivity.this, SignupActivity.class);
                 startActivity(intent);
                 finish();
                 }});

         Button alreadyHaveAccountButton = findViewById(R.id.Already_Have_An_Account);
         alreadyHaveAccountButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }});

    }
    }
