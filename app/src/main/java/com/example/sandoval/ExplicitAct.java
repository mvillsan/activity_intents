package com.example.sandoval;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExplicitAct extends AppCompatActivity {

    EditText txtString;
    TextView txtResult;
    Button palind, vowel, strCntr, colorResource, prevAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        txtString = findViewById(R.id.txtString);
        txtResult = findViewById(R.id.txtResult);
        palind = findViewById(R.id.palind_btn);
        vowel = findViewById(R.id.vowel_btn);
        strCntr = findViewById(R.id.str_btn);
        colorResource = findViewById(R.id.color_btn);
        prevAct = findViewById(R.id.back_btn);

        palind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonCheckPalindrome();
            }
        });

        vowel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vowelCounter();
            }
        });

        strCntr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strCounter();
            }
        });

        colorResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color();
            }
        });

        prevAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prev();
            }
        });
    }

    public void buttonCheckPalindrome(){
        String str = txtString.getText().toString();
        String nullStr = null;
        char[] charInput = txtString.getText().toString().toLowerCase().toCharArray();
        int intLength = charInput.length;

        if(TextUtils.isEmpty(str))
        {
            Toast.makeText(getApplicationContext(), "Please Input a String", Toast.LENGTH_SHORT).show();
        }

        else{
            boolean isPalindrome = true;
            for (int i=0; i<intLength/2; i++){
                if (charInput[i] != charInput[intLength-1-i]){
                    isPalindrome = false;
                    txtResult.setText("");
                    break;
                }
            }

            if (isPalindrome){
                txtResult.setText("Palindrome");
            }
            else {
                Toast.makeText(getApplicationContext(), "It's NOT a Palindrome.", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void vowelCounter(){
        int vowels = 0;
        String str = txtString.getText().toString();

        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // check if character is any of a, e, i, o, u
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                ++vowels;
            }
        }

        txtResult.setText("# of VOWELS: " + vowels);
    }

    public void strCounter(){
        String str = txtString.getText().toString();
        int cntr;

        cntr = str.length();

        txtResult.setText("Total # of CHARACTERS: " + cntr);
    }

    public void color(){
        int redColor = getResources().getColor(R.color.red);
        int greenColor = getResources().getColor(R.color.green);
        int blueColor = getResources().getColor(R.color.blue);
        int yellowColor = getResources().getColor(R.color.yellow);
        int blackColor = getResources().getColor(R.color.black);

        String str = txtString.getText().toString();

        if(str.equals("red") || str.equals("RED") || str.equals("Red")){
            txtResult.setText(str);
            txtResult.setTextColor(redColor);
        }
        else if(str.equals("green") || str.equals("GREEN") || str.equals("Green")){
            txtResult.setText(str);
            txtResult.setTextColor(greenColor);
        }
        else if(str.equals("blue") || str.equals("BLUE") || str.equals("Blue")){
            txtResult.setText(str);
            txtResult.setTextColor(blueColor);
        }
        else if(str.equals("yellow") || str.equals("YELLOW") || str.equals("Yellow")){
            txtResult.setText(str);
            txtResult.setTextColor(yellowColor);
        }
        else {
            txtResult.setText(str);
            txtResult.setTextColor(blackColor);
        }
    }

    public void prev(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}