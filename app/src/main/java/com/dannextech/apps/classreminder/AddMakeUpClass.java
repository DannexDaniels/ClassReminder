package com.dannextech.apps.classreminder;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddMakeUpClass extends AppCompatActivity {

    private EditText etCode, etVenue, etName;
    private Spinner spReminder, spVenue, spDay, spTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_make_up_class);

        etName = findViewById(R.id.etName);
        etCode = findViewById(R.id.etCode);
        etVenue = findViewById(R.id.etVenue);

        spReminder = findViewById(R.id.spReminder);
        spTime = findViewById(R.id.spTime);
        spDay = findViewById(R.id.spDay);
        spVenue = findViewById(R.id.spVenue);

    }
    public void submitClass(View v){
        Boolean filled = false;
        String name = null, code = null, venue = null, time = null, date = null, reminder = null;
        if (etName.getText().toString().isEmpty()) {
            etName.setError("required");
            filled = false;
        }else{
            name = etName.getText().toString();
            filled = true;
        }
        if (etCode.getText().toString().isEmpty()) {
            etCode.setError("required");
            filled = false;
        }else{
            code = etCode.getText().toString();
            filled = true;
        }

        if (etVenue.getText().toString().isEmpty() && !spVenue.getSelectedItem().toString().equals("Multi-Purpose Hall")) {
            etVenue.setError("required");
            filled = false;
        }else{
            venue = spVenue.getSelectedItem().toString()+" "+etVenue.getText().toString();
            filled = true;
        }

        reminder = spReminder.getSelectedItem().toString();
        time = spTime.getSelectedItem().toString();
        date = spDay.getSelectedItem().toString();

        if (filled){
            ClassQueries query = new ClassQueries(AddMakeUpClass.this);
            query.saveTask(name,code,venue,date,time,reminder);

            startActivity(new Intent(AddMakeUpClass.this, MainActivity.class));
        }else {
            Snackbar.make(v,"Fill all fields",Snackbar.LENGTH_LONG).show();
        }

    }
}
