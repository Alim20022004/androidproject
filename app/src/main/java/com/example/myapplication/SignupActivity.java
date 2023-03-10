package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttoncreateaccount;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editTextUsername = findViewById(R.id.editText_username);
        editTextEmail = findViewById(R.id.editText_email);
        editTextPassword = findViewById(R.id.editText_password);
        buttoncreateaccount = findViewById(R.id.button_create_account);

        buttoncreateaccount.setOnClickListener(v -> {
            NetworkUtils.signUp(SignupActivity.this, editTextUsername.getText().toString(),
                    editTextEmail.getText().toString(), editTextPassword.getText().toString());
        });

    }

}




