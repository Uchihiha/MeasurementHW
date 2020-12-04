package com.example.measurementhw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button to start new form
        button = (Button) findViewById(R.id.newForm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        // Button to go to list of inspection
        button1 = (Button) findViewById(R.id.viewInspection);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity1();
            }
        });

    }

    public void openNewActivity(){
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }

    public void openNewActivity1(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
