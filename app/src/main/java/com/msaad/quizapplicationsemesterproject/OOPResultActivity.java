package com.msaad.quizapplicationsemesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OOPResultActivity extends AppCompatActivity {

    TextView tv, tv2, tv3;
    Button btnh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oopresult);

        tv = findViewById(R.id.tvres);
        tv2 = findViewById(R.id.tvres2);
        tv3 = findViewById(R.id.tvres3);
        btnh = findViewById(R.id.btnhome);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + OOPQuestions.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + OOPQuestions.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + OOPQuestions.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        OOPQuestions.correct=0;
        OOPQuestions.wrong=0;

        btnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(in);
            }
        });

    }
}