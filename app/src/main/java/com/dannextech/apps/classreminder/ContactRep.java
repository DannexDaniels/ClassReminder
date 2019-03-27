package com.dannextech.apps.classreminder;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ContactRep extends AppCompatActivity {

    EditText etMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_rep);

        etMessage = findViewById(R.id.etMessage);

    }

    public void sendMessage(View v){
        String message = etMessage.getText().toString().trim();
        if (message.equals("")){
            etMessage.setError("Required");
        }else{
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT,"CONTACTING CLASS REP");
            intent.putExtra(Intent.EXTRA_TEXT,message);
            try{
                startActivity(Intent.createChooser(intent,"Send message..."));
            }catch (android.content.ActivityNotFoundException exception){
                Snackbar.make(v,"There is no messaging clients installed",Snackbar.LENGTH_SHORT).show();
            }
        }

    }

    public void makeCall(View v){
        startActivityForResult(new Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI), 1);
    }
}
