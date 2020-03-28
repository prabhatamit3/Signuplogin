package com.example.signuplogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Sign_log extends AppCompatActivity {
     EditText login_user,login_password;
    TextView signup_switch;
    Button login;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signactivity);
        signup_switch=findViewById(R.id.signup_transfer);
        login_user=findViewById(R.id.loginuser);
        login_password=findViewById(R.id.loginpass);
        login_password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (keyCode== KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN){
                    Toast.makeText(Sign_log.this,"Enter pressed",Toast.LENGTH_LONG).show();
                    log_in(view);
                }
                return false;
            }
        });


        signup_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Sign_log.this,Signup.class);
                startActivity(intent);
            }
        });
       /* findViewById(R.id.login_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog =new ProgressDialog(Sign_log.this);
                progressDialog.setMessage("logging "+ login_user.getText().toString() +"in");
                progressDialog.show();



                ParseUser.logInInBackground(login_user.getText().toString(), login_password.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (e== null && user!= null){

                            Intent intent1=new Intent(Sign_log.this,ScrollingActivity.class);
                            startActivity(intent1);


                        }
                        else
                            Toast.makeText(Sign_log.this,e+""+findViewById(R.id.loginuser).toString(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });*/
    }
    public void log_in(View view){
        final ProgressDialog progressDialog = new ProgressDialog(Sign_log.this);
        progressDialog.setMessage("logging " + login_user.getText().toString() + " in");
        progressDialog.show();
        Root_layout_in(view);
        if (login_user.getText().toString().equals("") || login_password.getText().toString().equals("")){
            Toast.makeText(Sign_log.this, "username,password is Missing", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        }
        else {
            ParseUser.logInInBackground(login_user.getText().toString(), login_password.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if (e == null && user != null) {

                        Intent intent1 = new Intent(Sign_log.this, ScrollingActivity.class);
                        startActivity(intent1);


                    } else {
                        Toast.makeText(Sign_log.this, e + "" + findViewById(R.id.loginuser).toString(), Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }

                }
            });
        }
    }
    public void Root_layout_in(View view){
        try {

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }catch (Exception e1){
            e1.printStackTrace();

        }

    }

}
