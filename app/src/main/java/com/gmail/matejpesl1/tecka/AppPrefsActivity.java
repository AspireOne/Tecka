package com.gmail.matejpesl1.tecka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AppPrefsActivity extends AppCompatActivity {
    public static final String PREF_FILE_NAME = "preferences";
    public static final String PREF_NAME = "name";
    public static final String PREF_SURNAME = "surname";
    public static final String PREF_DATE = "date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_prefs);
        EditText name = findViewById(R.id.NameEditText);
        EditText surname = findViewById(R.id.SurnameEditText);
        EditText date = findViewById(R.id.BirthDateEditText);
        Button saveButton = findViewById(R.id.SaveButton);

        SharedPreferences prefs = getSharedPreferences(PREF_FILE_NAME, 0);
        name.setText(AppPrefsActivity.getName(prefs));
        surname.setText(AppPrefsActivity.getSurname(prefs));
        date.setText(AppPrefsActivity.getDate(prefs));

        saveButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(PREF_NAME, name.getText().toString());
            editor.putString(PREF_SURNAME, surname.getText().toString());
            editor.putString(PREF_DATE, date.getText().toString());
            editor.apply();
            this.finish();
        });
    }

    public static String getName(SharedPreferences prefs) {
        return prefs.getString(PREF_NAME, "Jméno");
    }

    public static String getSurname(SharedPreferences prefs) {
        return prefs.getString(PREF_SURNAME, "Příjmení");
    }

    public static String getDate(SharedPreferences prefs) {
        return prefs.getString(PREF_DATE, "1. 1. 2000");
    }
}