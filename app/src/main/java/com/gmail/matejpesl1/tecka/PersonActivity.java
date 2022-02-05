package com.gmail.matejpesl1.tecka;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class PersonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        setTitle("Osoba");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);

        findViewById(R.id.country_validation_layout).setOnClickListener(v -> {
            Intent validationCountryActivity = new Intent(this, ValidationCountryActivity.class);
            this.startActivity(validationCountryActivity);
        });

        findViewById(R.id.person_card).setOnClickListener(v -> {
            Intent qrActivity = new Intent(this, QrActivity.class);
            this.startActivity(qrActivity);
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.person_menu, menu);
        return true;
    }
}
