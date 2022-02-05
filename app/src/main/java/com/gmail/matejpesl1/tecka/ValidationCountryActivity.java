package com.gmail.matejpesl1.tecka;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.Date;
import java.util.Locale;

public class ValidationCountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_validation);
        setTitle("Podrobnosti");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_down);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ECAE1A")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + "Parametry" + "</font>", Html.FROM_HTML_SEPARATOR_LINE_BREAK_DIV));
        String date = new SimpleDateFormat("dd. MM. yyyy HH:mm", Locale.getDefault()).format(new Date());
        ((TextView)findViewById(R.id.parametersUpdateTime)).setText(date + " ");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}