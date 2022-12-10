package com.cse464.floralstore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cse464.floralstore.R;

public class SignUpActivity extends AppCompatActivity {
    EditText signUpPageEmail,signUpPagePassword,signUpPageConfirmPassword;
    Button SignUpButton;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpPageEmail = findViewById(R.id.signUpPageEmail);
        signUpPagePassword = findViewById(R.id.signUpPagePassword);
        signUpPageConfirmPassword = findViewById(R.id.signUpPageConfirmPassword);
        SignUpButton = findViewById(R.id.SignUpButton);

        myDB = new DBHelper(this);

        View.OnClickListener signUpButtonListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = signUpPageEmail.getText().toString();
                String password = signUpPagePassword.getText().toString();
                String confirmPassword = signUpPageConfirmPassword.getText().toString();

                if(email.equals("") || password.equals("") || confirmPassword.equals("")){
                    Toast.makeText(SignUpActivity.this,"Please Fill Up All Fields!", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(confirmPassword.equals(password) == false){
                        Toast.makeText(SignUpActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                        signUpPagePassword.setText("");
                        signUpPageConfirmPassword.setText("");
                    }
                    else {
                        if(myDB.SignUpVerification(email) == true){
                            Toast.makeText(SignUpActivity.this,"User already exists!", Toast.LENGTH_SHORT).show();
                            signUpPageEmail.setText("");
                            signUpPagePassword.setText("");
                            signUpPageConfirmPassword.setText("");
                        }
                        else {
                            if(myDB.insertData(email,password) == true){
                                Toast.makeText(SignUpActivity.this,"User Registered Successfully!",Toast.LENGTH_SHORT).show();
                                signUpPageEmail.setText("");
                                signUpPagePassword.setText("");
                                signUpPageConfirmPassword.setText("");
                            }
                            else {
                                Toast.makeText(SignUpActivity.this,"Error! Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                        }

                    }

                }
            }
        };

        SignUpButton.setOnClickListener(signUpButtonListener);
    }
}