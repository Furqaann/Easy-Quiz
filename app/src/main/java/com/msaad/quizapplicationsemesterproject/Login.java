package com.msaad.quizapplicationsemesterproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.uname);
        password = findViewById(R.id.upass);
        btnlogin = findViewById(R.id.loginbtn);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("")) {
                    Toast.makeText(Login.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass == true){
                        Toast.makeText(Login.this, "User Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent iud = new Intent(getApplicationContext(), UserDashboard.class);
                        startActivity(iud);
                    }
                    else{
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}