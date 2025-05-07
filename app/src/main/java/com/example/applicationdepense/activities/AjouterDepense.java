package com.example.applicationdepense.activities;
import static android.os.Build.VERSION_CODES.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import database.Database;
import models.Depense;


public class AjouterDepense extends AppCompatActivity {
    EditText amountEditText = findViewById(R), descriptionEditText;
    Button saveBtn;
    Database db;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R);

        db = new Database(this);
        userId = getIntent().getIntExtra("USER_ID", -1);

        descriptionEditText = findViewById(R);
        saveBtn = findViewById(R);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amountStr = amountEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                if (!amountStr.isEmpty() && !description.isEmpty()) {
                    double amount = Double.parseDouble(amountStr);
                    Depense expense = new Depense(userId, amount, description);
                    boolean inserted = db.insertExpense(expense);
                    if (inserted) {
                        Toast.makeText(AjouterDepense.this, "Dépense ajoutée", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AjouterDepense.this, "Erreur", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AjouterDepense.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
