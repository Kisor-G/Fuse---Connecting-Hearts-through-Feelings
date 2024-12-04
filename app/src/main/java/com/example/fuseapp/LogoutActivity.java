package com.example.fuseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {

    private Button confirmLogoutButton, cancelLogoutButton;
    private TextView logoutMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        // Initialize UI elements
        confirmLogoutButton = findViewById(R.id.buttonConfirmLogout);
        cancelLogoutButton = findViewById(R.id.buttonCancelLogout);
        logoutMessage = findViewById(R.id.textViewLogoutMessage);

        // Set logout confirmation message
        logoutMessage.setText("Are you sure you want to log out?");

        // Confirm logout functionality
        confirmLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear session (if any) and redirect to LoginActivity
                Toast.makeText(LogoutActivity.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        // Cancel logout functionality
        cancelLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the LogoutActivity and return to the previous activity
                finish();
            }
        });
    }
}
