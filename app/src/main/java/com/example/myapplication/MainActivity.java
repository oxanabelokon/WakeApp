package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //BottomNavigationView bottomNavigationView;
    ActivityMainBinding activityMainBinding;
    String ringtone;
    ImageButton cancelButton;


    private TimePicker timePicker;
    private TextClock currentTime;
    private TextView month, day, year;

    private Button alarmSet, alarmCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        replaceFragment(new FirstFragment());
        //setContentView(R.layout.activity_main);


        timePicker = findViewById(R.id.timePicker);
        alarmSet = findViewById(R.id.setAlarm);
        alarmCancel = findViewById(R.id.cancelAlarm);

        currentTime = findViewById(R.id.textClock);


        alarmSet.setOnClickListener(this);

        //alert dialog
        View puzzleCustomDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.alert_dialog, null);
        AlertDialog.Builder puzzleDialog = new AlertDialog.Builder(MainActivity.this);
        puzzleDialog.setView(puzzleCustomDialog);
        final AlertDialog dialog = puzzleDialog.create();

        alarmCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //dialog.show();
                openPopUpWindow();
                //finish();
                //System.exit(0);

            }
        });


        //bottomNavigationView = findViewById(R.id.bottomNav);

        month = findViewById(R.id.month);
        day = findViewById(R.id.day);
        year = findViewById(R.id.year);


       /* cancelButton=findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });*/

        //bottom nav
        activityMainBinding.bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    replaceFragment(new FirstFragment());
                    break;
                case R.id.bottom_person:
                    replaceFragment(new PersonFragment());
                    break;
                case R.id.bottom_settings:
                    replaceFragment(new ThemeFragment());
                    break;
                case R.id.bottom_ringtone:
                    replaceFragment(new RingtoneFragment());
                    break;
            }
            return true;
        });

        //current time display
        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);

        String[] splitdate = formattedDate.split(",");

        month.setText(splitdate[1]);
        day.setText(splitdate[0]);
        year.setText(splitdate[2]);

        //get ringtones
        Intent intent = getIntent();
        ringtone = intent.getStringExtra("sound");
    }


    private void openPopUpWindow() {
        Intent intent = new Intent(this, Puzzle.class);
        startActivity(intent);
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH),
                timePicker.getHour(),
                timePicker.getMinute(), 0);
        alarmSet(cal.getTimeInMillis());

    }

    private void alarmSet(long timeInMillis) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        try {
            Intent intent = new Intent(this, Alarm.class);
            intent.putExtra("ringtone", ringtone);
            if (!(ringtone == null)) {
                sendBroadcast(intent);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent);

                    Toast.makeText(this, "Alarm is set ", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(this, "Ringtone is not set!! ", Toast.LENGTH_SHORT).show();

        } catch (NumberFormatException ex) {
            ex.printStackTrace();


            //Intent intent = new Intent(this,Alarm.class);

            //intent.putExtra("ringtone", ringtone);
            //sendBroadcast(intent);
            // PendingIntent pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);

            //PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

           // alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent);
           // Toast.makeText(this, "Alarm is set ", Toast.LENGTH_LONG).show();
        }


    }
}
