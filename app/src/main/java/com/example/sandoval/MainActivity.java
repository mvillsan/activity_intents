package com.example.sandoval;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button imBtn, exBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imBtn = findViewById(R.id.imp_btn);
        exBtn = findViewById(R.id.exp_btn);

        imBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImplicit();
            }
        });

        exBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExplicit();
            }
        });
    }

    public void openImplicit(){
        Intent intent = new Intent(this, AlarmClockAct.class);
        startActivity(intent);
    }

    public void openExplicit(){
        Intent intent = new Intent(getApplicationContext(), ExplicitAct.class);
        startActivity(intent);
    }
}