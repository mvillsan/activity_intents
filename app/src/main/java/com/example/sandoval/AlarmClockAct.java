package com.example.sandoval;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlarmClockAct extends AppCompatActivity {

    Button btn_alarm, prevBtnn;
    EditText txtHour, txtMin, txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmclock);

        btn_alarm = findViewById(R.id.btn_alarm);
        txtHour = findViewById(R.id.txtHour);
        txtMin = findViewById(R.id.txtMin);
        txtMsg = findViewById(R.id.txtMsg);
        prevBtnn = findViewById(R.id.prev_btn);

        btn_alarm.setOnClickListener(setAlarm);
        prevBtnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevAct();
            }
        });
    }

    View.OnClickListener setAlarm = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            int hr = Integer.parseInt(txtHour.getText().toString());
            int min = Integer.parseInt(txtMin.getText().toString());
            String msg = txtMsg.getText().toString();

            createAlarm(hr, min, msg);
        }
    };

    private void createAlarm(int hr,int min, String msg){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE,msg)
                .putExtra(AlarmClock.EXTRA_HOUR,hr)
                .putExtra(AlarmClock.EXTRA_MINUTES,min);

        if(intent.resolveActivity(getPackageManager()) != null) {
            if(hr <= 24 && min <= 59){
                startActivity(intent);
                txtHour.setText("");
                txtMin.setText("");
                txtMsg.setText("");
            }
            else {
                Toast.makeText(getApplicationContext(), "Invalid TIME", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "There is NO APP that support this action.", Toast.LENGTH_SHORT).show();
        }

    }

    public void prevAct(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}