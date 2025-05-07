package com.example.applicationdepense.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.applicationdepense.R;
import android.database.Cursor;
import android.widget.*;

import java.util.ArrayList;

import database.Database;

public class MainActivity extends AppCompatActivity {

    EditText title, amount;
    Button addBtn;
    ListView expenseList;
    ArrayAdapter<String> adapter;
    ArrayList<String> expenses = new ArrayList<>();
    Database db;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = getIntent().getIntExtra("userId", -1);
        amount = findViewById(R.id.main);
        addBtn = findViewById(R.id.main);
        db = new Database(this);

        loadExpenses();

        addBtn.setOnClickListener(v -> {
            String t = title.getText().toString();
            double a = Double.parseDouble(amount.getText().toString());
            db.addExpense(userId, t, a);
            loadExpenses();
        });
    }

    private void loadExpenses() {
        expenses.clear();
        Cursor c = db.getExpenses(userId);
        while (c.moveToNext()) {
            expenses.add(c.getString(2) + " - " + c.getDouble(3) + "€");
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, expenses);
        expenseList.setAdapter(adapter);
    }
}
