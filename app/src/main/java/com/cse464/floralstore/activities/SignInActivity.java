package com.cse464.floralstore.activities;

import static com.cse464.floralstore.R.id.createAccountButton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cse464.floralstore.MainActivity;
import com.cse464.floralstore.R;

public class SignInActivity extends AppCompatActivity {
    Button CreateAccountButton, SignInButton;
    EditText inputEmail, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        CreateAccountButton = findViewById(createAccountButton);
        SignInButton = findViewById(R.id.SignInButton);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);

        View.OnClickListener createAccountListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        };
        CreateAccountButton.setOnClickListener(createAccountListener);
    }
}