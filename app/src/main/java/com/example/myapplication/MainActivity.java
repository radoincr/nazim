package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button registerButton;

    private int wrongAttempts = 0;
    private boolean buttonEnabled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonEnabled) {
                    String email = emailEditText.getText().toString();
                    String password = passwordEditText.getText().toString();

                    if (email.equals("a") && password.equals("a")) {

                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        Toast.makeText(MainActivity.this, "true", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    } else {


                        wrongAttempts++;

                        if (wrongAttempts >= 5) {
                            // Disable the button for 5 seconds
                            buttonEnabled = false;
                            registerButton.setEnabled(false);
                            Toast.makeText(MainActivity.this, "Button disabled for 5 seconds", Toast.LENGTH_SHORT).show();

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Enable the button after 5 seconds
                                    buttonEnabled = true;
                                    registerButton.setEnabled(true);
                                    wrongAttempts = 0; // Reset the counter
                                    Toast.makeText(MainActivity.this, "Button enabled", Toast.LENGTH_SHORT).show();
                                }
                            }, 5000);
                            // 5000 milliseconds = 5 seconds

                        } else {
                            Toast.makeText(MainActivity.this, "false", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Button disabled, please wait", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

