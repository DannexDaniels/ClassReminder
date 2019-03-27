package com.dannextech.apps.classreminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Boolean fabExpanded;
    private FloatingActionButton fab;

    private LinearLayout llfabSendMessage, llfabAddClass;

    private RecyclerView rvClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ClassQueries queries = new ClassQueries(MainActivity.this);

        llfabAddClass = findViewById(R.id.fabMakeUpClass);
        llfabSendMessage = findViewById(R.id.fabContactRep);

        rvClasses = findViewById(R.id.rvClasses);

        rvClasses.setHasFixedSize(true);
        rvClasses.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvClasses.setAdapter(new ClassAdapter(queries.retrieveClasses(), MainActivity.this));
        rvClasses.setItemAnimator(new DefaultItemAnimator());

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fabExpanded == true){
                    closeSubMenuFab();
                }else {
                    openSubMenuFab();
                }
            }
        });
        //to make main fab to collapse at the beginning
        closeSubMenuFab();
    }

    private void closeSubMenuFab() {
        llfabAddClass.setVisibility(View.INVISIBLE);
        llfabSendMessage.setVisibility(View.INVISIBLE);
        //CHANGE MAIN FAB ICON
        fab.setImageResource(R.drawable.ic_add_black_24dp);
        fabExpanded = false;
    }

    private void openSubMenuFab() {
        llfabAddClass.setVisibility(View.VISIBLE);
        llfabSendMessage.setVisibility(View.VISIBLE);
        //CHANGE MAIN FAB ICON
        fab.setImageResource(R.drawable.ic_close_black_24dp);
        fabExpanded = true;
    }
    public void contactRep(View v){
        startActivity(new Intent(MainActivity.this, ContactRep.class));
    }

    public void addMakeUpClass(View v){
        startActivity(new Intent(MainActivity.this, AddMakeUpClass.class));
    }

}
