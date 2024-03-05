package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button returne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        returne = findViewById(R.id.returne);
        returne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent= new Intent(SecondActivity.this,MainActivity.class);
             startActivity(intent);


            }



        });






    }
}

