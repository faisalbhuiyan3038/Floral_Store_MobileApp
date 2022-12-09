package com.cse464.floralstore.activities;

import static com.cse464.floralstore.R.id.createAccountButton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cse464.floralstore.MainActivity;
import com.cse464.floralstore.R;

public class SignInActivity extends AppCompatActivity {
    private Button CreateNewAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        CreateNewAccountButton = (Button) findViewById(createAccountButton);
        View.OnClickListener createAccountListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        };
        CreateNewAccountButton.setOnClickListener(createAccountListener);
    }
}