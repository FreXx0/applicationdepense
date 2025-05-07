package com.example.applicationdepense.activities;

import static android.os.Build.VERSION_CODES.R;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

import adapters.AdapteurDepense;
import database.Database;
import models.Depense;

public class HistoriqueDepense extends AppCompatActivity {

    ListView listView;
    Database db;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R);

        listView = findViewById(R);
        db = new Database(this);
        userId = getIntent().getIntExtra("USER_ID", -1);

        List<Depense> expenses = db.getAllExpenses(userId);
        AdapteurDepense adapter = new AdapteurDepense(this, expenses);
        listView.setAdapter(adapter);
    }
}
