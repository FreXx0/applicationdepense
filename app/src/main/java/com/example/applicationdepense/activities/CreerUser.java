package com.example.applicationdepense.activities;

import static android.os.Build.VERSION_CODES.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
        import androidx.appcompat.app.AppCompatActivity;


import database.Database;

public class CreerUser extends AppCompatActivity {

    EditText username, password;
    Button registerBtn;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R);

        username = findViewById(R);
        password = findViewById(R);
        registerBtn = findViewById(R);
        db = new Database(this);

        registerBtn.setOnClickListener(v -> {
            boolean success = db.registerUser(username.getText().toString(), password.getText().toString());
            if (success) {
                Toast.makeText(this, "Compte créé", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CreerUser.this, LoginActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
