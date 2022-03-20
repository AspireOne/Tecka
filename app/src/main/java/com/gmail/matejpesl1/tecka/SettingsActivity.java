package com.gmail.matejpesl1.tecka;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle("Možnosti");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.help).setOnClickListener(v -> new Intent(Intent.ACTION_VIEW, Uri.parse("https://ockodoc.mzcr.cz/napoveda/tecka/cz")));
        findViewById(R.id.bottomPanel).setOnClickListener(v -> showPreferencesPopup(v));
    }

    public void showPreferencesPopup(View view) {
        SettingsActivity.this.startActivity(new Intent(SettingsActivity.this, AppPrefsActivity.class));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
