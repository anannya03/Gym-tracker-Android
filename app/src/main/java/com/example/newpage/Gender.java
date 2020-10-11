package com.example.newpage;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Gender extends AppCompatActivity {

    Button female;
    Button male;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        female = (Button) findViewById(R.id.female);
        female.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openFemale();
            }
        });

        male = (Button) findViewById(R.id.female);
        male.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openMale();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    public void openFemale(){
        Toast.makeText(this, "Female selected", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Goal.class);
        startActivity(intent);
    }

    public void openMale(){
        Toast.makeText(this, "Male selected", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Goal.class);
        startActivity(intent);
    }
}