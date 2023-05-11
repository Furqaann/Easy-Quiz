package com.msaad.quizapplicationsemesterproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserDashboard extends AppCompatActivity {

    Button PF, OOP, Random, logbtn;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        PF = findViewById(R.id.FQuestions);
        OOP = findViewById(R.id.OOPQuestions);
        Random = findViewById(R.id.RPQuestions);
        logbtn = findViewById(R.id.logoutbtn);
        DB = new DBHelper(this);

        PF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iPFq = new Intent(getApplicationContext(), PFQuestions.class);
                startActivity(iPFq);
            }
        });

        OOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iOOPq = new Intent(getApplicationContext(), OOPQuestions.class);
                startActivity(iOOPq);
            }
        });

        Random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iRq = new Intent(getApplicationContext(), RandomQuestions.class);
                startActivity(iRq);
            }
        });

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "User Logged Out", Toast.LENGTH_SHORT).show();
                Intent iRq = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(iRq);
            }
        });

    }
}