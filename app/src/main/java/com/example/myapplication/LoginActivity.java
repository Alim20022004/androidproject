package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText = findViewById(R.id.editText_email1);
        passwordEditText = findViewById(R.id.editText_password1);
        loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            NetworkUtils.validateCredentials(LoginActivity.this, email, password, new NetworkUtils.VolleyCallback() {
                @Override
                public void onSuccess(String result) {
                    if (result.trim().equals("success")) {
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(String error) {
                    Toast.makeText(LoginActivity.this, "Error occurred: " + error, Toast.LENGTH_SHORT).show();
                }
            });

        });
    }
}
