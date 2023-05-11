package com.msaad.quizapplicationsemesterproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText username, password, useremail;
    Button btnsignup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.uname);
        password = findViewById(R.id.upass);
        useremail = findViewById(R.id.uemail);
        btnsignup = findViewById(R.id.supbtn);
        DB = new DBHelper(this);

        btnsignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String Useremail = useremail.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(SignUp.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                }
                else{
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser == false){
                            Boolean insert = DB.insertData(user, pass, Useremail);
                            if(insert == true){
                                Toast t = Toast.makeText(SignUp.this, "User Sign Up Successfull", Toast.LENGTH_LONG);
                                t.show();
                                Intent iud = new Intent(getApplicationContext(), UserDashboard.class);
                                startActivity(iud);
                            }
                            else{
                                Toast.makeText(SignUp.this, "User Sign Up Failed", Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(SignUp.this, "User Already Exists. Please Sign In", Toast.LENGTH_LONG).show();
                            Intent ilgn = new Intent(getApplicationContext(), Login.class);
                            startActivity(ilgn);
                        }
                    }
                }
        });
    }
}