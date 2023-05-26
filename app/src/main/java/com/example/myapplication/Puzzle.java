package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Puzzle extends AppCompatActivity {
    TextView randomNumber1, randomNumber2;
    EditText editAnswer;
    Integer response, result;
    Button checkAnsw;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.6),(int)(height*.4));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;

        params.x=0;
        params.y=-20;

        getWindow().setAttributes(params);

        randomNumber1=findViewById(R.id.num1);
        randomNumber2=findViewById(R.id.num2);
        editAnswer=findViewById(R.id.editAnswer);
        checkAnsw=findViewById(R.id.check);
        solveIt();

        checkAnsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });

        //get user name
        Intent intent = getIntent();
        name = intent.getStringExtra("name");

    }

    @SuppressLint("SuspiciousIndentation")
    private void checkAnswer() {
        String userAnswer = editAnswer.getText().toString();
        try {
            response = Integer.parseInt(userAnswer);
            if (response == result) {
                Toast.makeText(this, "Have a nice day "+ name +"!! ", Toast.LENGTH_SHORT).show();
                //this.finishAffinity();
                Intent intent = new Intent(Puzzle.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            } else
                Toast.makeText(this, "Your answer is wrong, wakeup!! ", Toast.LENGTH_SHORT).show();
                solveIt();

        } catch (NumberFormatException ex) {
            ex.printStackTrace();

        }
    }

    private void solveIt() {
        randomNumber1.setText(null);
        randomNumber2.setText(null);
        editAnswer.setText(null);

        Random r = new Random();
        // Generate random integers in range 0 to 9
        int r1 = r.nextInt(100);
        int r2 = r.nextInt(10);
        result = r1*r2;

        String myR1=String.valueOf(r1);
        String myR2=String.valueOf(r2);

        randomNumber1.setText(myR1);
        randomNumber2.setText(myR2);
    }

}