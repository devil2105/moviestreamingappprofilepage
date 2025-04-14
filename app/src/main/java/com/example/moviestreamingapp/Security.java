package com.example.moviestreamingapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Security extends AppCompatActivity {

    Button btnChangePassword, btnPrivacyPolicy;
    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_security);

        btnChangePassword = findViewById(R.id.btnChangePassword);
        btnPrivacyPolicy = findViewById(R.id.btnPrivacyPolicy);
        switch1 = findViewById(R.id.switch1);

        btnChangePassword.setOnClickListener(v -> {
            Toast.makeText(this, "Change Password clicked", Toast.LENGTH_SHORT).show();
        });

        btnPrivacyPolicy.setOnClickListener(v -> {
            // Example: open privacy policy link
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://yourapp.com/privacy"));
            startActivity(browserIntent);
        });

        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Two-Factor Authentication Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Two-Factor Authentication Disabled", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}