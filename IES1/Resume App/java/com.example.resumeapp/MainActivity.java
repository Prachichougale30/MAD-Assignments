package com.example.resumeapp;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button backBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(v -> {

            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(
                        "com.example.loginapp",
                        "com.example.loginapp.MainActivity"
                ));
                startActivity(intent);
                finish();

            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Login App not found", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
