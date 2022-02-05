package com.gmail.matejpesl1.tecka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_gov);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        findViewById(R.id.country_validation_layout).setOnClickListener(v -> {
            Intent validationCountryActivity = new Intent(MainActivity.this, ValidationCountryActivity.class);
            MainActivity.this.startActivity(validationCountryActivity);
        });

        findViewById(R.id.person_card).setOnClickListener(v -> {
            Intent personActivity = new Intent(MainActivity.this, PersonActivity.class);
            MainActivity.this.startActivity(personActivity);
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Class cls;

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_message_list:
                cls = MessagesActivity.class;
                break;
            case R.id.action_add_certificate:
                cls = AddCertificateActivity.class;
                break;
            case R.id.action_settings:
                cls = SettingsActivity.class;
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        MainActivity.this.startActivity(new Intent(MainActivity.this, cls));
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}