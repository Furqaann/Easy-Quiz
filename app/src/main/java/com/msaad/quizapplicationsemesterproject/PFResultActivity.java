package com.msaad.quizapplicationsemesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PFResultActivity extends AppCompatActivity {

    TextView tv, tv2, tv3;
    Button btnh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pfresult);

        tv = findViewById(R.id.tvres);
        tv2 = findViewById(R.id.tvres2);
        tv3 = findViewById(R.id.tvres3);
        btnh = findViewById(R.id.btnhome);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + PFQuestions.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + PFQuestions.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + PFQuestions.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        PFQuestions.correct=0;
        PFQuestions.wrong=0;

        btnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(in);
            }
        });
    }
}