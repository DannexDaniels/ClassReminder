package com.dannextech.apps.classreminder;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ClassDetails extends AppCompatActivity {

    private TextView tvName, tvCode, tvVenue, tvDate, tvTime, tvReminder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_details);

        tvName = findViewById(R.id.tvDetailName);
        tvCode = findViewById(R.id.tvDetailCode);
        tvVenue = findViewById(R.id.tvDetailVenue);
        tvDate = findViewById(R.id.tvDetailDay);
        tvTime = findViewById(R.id.tvDetailTime);
        tvReminder = findViewById(R.id.tvDetailReminder);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        tvReminder.setText(preferences.getString("reminder",""));
        tvTime.setText(preferences.getString("time",""));
        tvDate.setText(preferences.getString("date",""));
        tvVenue.setText(preferences.getString("venue",""));
        tvCode.setText(preferences.getString("code",""));
        tvName.setText(preferences.getString("name",""));
    }

    public void locateClass(View view) {
        Snackbar.make(view,"Not Implemented yet",Snackbar.LENGTH_SHORT).show();
    }
}
