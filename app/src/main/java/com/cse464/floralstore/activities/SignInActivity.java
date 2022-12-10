package com.cse464.floralstore.activities;

import static com.cse464.floralstore.R.id.createAccountButton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cse464.floralstore.MainActivity;
import com.cse464.floralstore.R;

public class SignInActivity extends AppCompatActivity {
    Button CreateAccountButton, SignInButton;
    EditText inputEmail, inputPassword;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        CreateAccountButton = findViewById(createAccountButton);
        SignInButton = findViewById(R.id.SignInButton);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        myDB = new DBHelper(this);

        View.OnClickListener createAccountListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        };
        CreateAccountButton.setOnClickListener(createAccountListener);

        View.OnClickListener signInListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                if (email.equals("") || password.equals("")) {
                    Toast.makeText(SignInActivity.this, "Please Fill Up All Fields!", Toast.LENGTH_SHORT).show();
                } else {
                    if (myDB.SignUpVerification(email) == false) {
                        Toast.makeText(SignInActivity.this, "User Not Found!", Toast.LENGTH_SHORT).show();
                        inputEmail.setText("");
                        inputPassword.setText("");
                    }
                    else if (myDB.SignInVerification(email,password) == false) {
                        Toast.makeText(SignInActivity.this, "Incorrect Credentials! Please Try Again..", Toast.LENGTH_SHORT).show();
                        inputEmail.setText("");
                        inputPassword.setText("");
                    }
                    else {
                        Intent intent = new Intent(SignInActivity.this, ProductListingActivity.class);
                        startActivity(intent);
                    }
                }

            }
        };
        SignInButton.setOnClickListener(signInListener);
    }
}