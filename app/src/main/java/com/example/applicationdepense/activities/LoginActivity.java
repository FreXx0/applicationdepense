package com.example.applicationdepense.activities;

import static android.os.Build.VERSION_CODES.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
        import androidx.appcompat.app.AppCompatActivity;


import database.Database;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button loginBtn, registerBtn;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R);

        username = findViewById(R);
        password = findViewById(R);
        loginBtn = findViewById(R);
        registerBtn = findViewById(R);
        db = new Database(this);

        loginBtn.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            int userId = db.loginUser(user, pass);
            if (userId != -1) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("userId", userId);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Identifiants incorrects", Toast.LENGTH_SHORT).show();
            }
        });

        registerBtn.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, CreerUser.class));
        });
    }
}
