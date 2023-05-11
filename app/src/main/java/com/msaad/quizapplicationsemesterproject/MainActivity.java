package com.msaad.quizapplicationsemesterproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.lgnbtn);
        btn2 = findViewById(R.id.sbtn);
        DB = new DBHelper(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ilogin = new Intent(getApplicationContext(), Login.class);
                startActivity(ilogin);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent isignup = new Intent(getApplicationContext(), SignUp.class);
                startActivity(isignup);
            }
        });

    }
}