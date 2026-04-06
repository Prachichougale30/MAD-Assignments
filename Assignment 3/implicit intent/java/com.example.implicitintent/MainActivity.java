package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnWebsite, btnDial, btnEmail, btnShare, btnMap, btnWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWebsite = findViewById(R.id.btnWebsite);
        btnDial = findViewById(R.id.btnDial);
        btnEmail = findViewById(R.id.btnEmail);
        btnShare = findViewById(R.id.btnShare);
        btnMap = findViewById(R.id.btnMap);
        btnWifi = findViewById(R.id.btnWifi);

 
        btnWebsite.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

       
        btnDial.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:8446041838"));
            startActivity(intent);
        });

   
        btnEmail.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"prachichougale2530@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Test Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello from my app!");
            startActivity(Intent.createChooser(intent, "Send Email"));
        });

        btnShare.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello World!");
            startActivity(Intent.createChooser(intent, "Share via"));
        });

     
        btnMap.setOnClickListener(view -> {
            Uri uri = Uri.parse("geo:37.7749,-122.4194");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

       
        btnWifi.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivity(intent);
        });
    }
}
