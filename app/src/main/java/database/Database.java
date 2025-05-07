package database;

import android.content.Context;
import android.database.sqlite.*;
import android.database.Cursor;
import android.content.ContentValues;


import java.util.List;

import models.Depense;

public class Database extends SQLiteOpenHelper {

    private static final String DB_NAME = "depenses.db";
    private static final int DB_VERSION = 1;

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");
        db.execSQL("CREATE TABLE expenses(id INTEGER PRIMARY KEY AUTOINCREMENT, userId INTEGER, title TEXT, amount REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS expenses");
        onCreate(db);
    }

    public boolean registerUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("password", password);
        long result = db.insert("users", null, cv);
        return result != -1;
    }

    public int loginUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM users WHERE username=? AND password=?", new String[]{username, password});
        if (cursor.moveToFirst()) {
            return cursor.getInt(0);
        }
        return -1;
    }

    public boolean addExpense(int userId, String title, double amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("userId", userId);
        cv.put("title", title);
        cv.put("amount", amount);
        long result = db.insert("expenses", null, cv);
        return result != -1;
    }

    public Cursor getExpenses(int userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM expenses WHERE userId=?", new String[]{String.valueOf(userId)});
    }
    public boolean insertExpense(int userId, String title, double amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("userId", userId);
        cv.put("title", title);
        cv.put("amount", amount);
        long result = db.insert("expenses", null, cv);
        return result != -1;
    }
    public boolean insertExpense(Depense expense) {
        return false;
    }

    public List<Depense> getAllExpenses(int userId) {

        return java.util.Collections.emptyList();
    }
}
