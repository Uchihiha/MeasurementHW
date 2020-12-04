package com.example.measurementhw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

   DatabaseHelper myDB;
   Button submit, view;
   EditText et1, et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12;




    // Instance for Radio Buttons
    RadioGroup radioGroup;
    RadioButton radioButton;

    // Instance for Buttons

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        myDB = new DatabaseHelper(this);

        // Linking editText

        et1 = (EditText) findViewById(R.id.date);
        et2 = (EditText) findViewById(R.id.site);
        et3 = (EditText) findViewById(R.id.name);
        et4 = (EditText) findViewById(R.id.phone);
        et5 = (EditText) findViewById(R.id.email);
        et6 = (EditText) findViewById(R.id.notes);
        et7 = (EditText) findViewById(R.id.blockModel);
        et8 = (EditText) findViewById(R.id.serialNumber);
        et9 = (EditText) findViewById(R.id.noofsheaves);
        et10 = (EditText) findViewById(R.id.diam);
        et11 = (EditText) findViewById(R.id.ropeSize);
        et12 = (EditText) findViewById(R.id.finalNotes);

        // View button

        view = (Button) findViewById(R.id.view);

        // Submit button
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = et1.getText().toString();
                if(et1.length() != 0){
                    AddData(newEntry);
                    et1.setText("");
                }else{
                    Toast.makeText(FirstActivity.this,"This field cannot be empty!",Toast.LENGTH_LONG).show();
                }
            }
        });

        // View Button

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        // Radio Button Start
        radioGroup = findViewById(R.id.radioGroup);






        // Button to go to HOME
        button1 = (Button) findViewById(R.id.home);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity1();
            }
        });
    }


    // Method to go to HOME
    public void openNewActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Radio Button
    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected: "+ radioButton.getText(), Toast.LENGTH_SHORT).show();
    }


    // Add data from edittext to database and display it
    //Add Data Method
    // Fix this too run the app successfully
    public void AddData(String newEntry){
        boolean insertData = myDB.addData(newEntry);

        if(insertData==true){
            Toast.makeText(FirstActivity.this,"Measurement stored successfully !",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(FirstActivity.this,"Something went wrong. Please Try Again !",Toast.LENGTH_LONG).show();
        }
    }
}
