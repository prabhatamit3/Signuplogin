package com.example.signuplogin;

import android.app.Activity;
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
import android.app.Application;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class Signup extends AppCompatActivity {
     EditText regpassword,regusername,reg_email;
     Button register;
     TextView signin_transition;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        findViewById(R.id.signin_transfer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(Signup.this,Sign_log.class);
                startActivity(intent2);
            }
        });

        regusername=findViewById(R.id.regusername);
        regpassword=findViewById(R.id.regpassword);
        reg_email=findViewById(R.id.email_reg);
        signin_transition=findViewById(R.id.signin_transfer);
        register=findViewById(R.id.register);
        regpassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (keyCode== KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN){
                    Toast.makeText(Signup.this,"Enter pressed",Toast.LENGTH_LONG).show();
                    Sign_up(view);
                }
                return false;
            }
        });

     /*   register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog =new ProgressDialog(Signup.this);
                progressDialog.setMessage("Signing "+ regusername.getText().toString() +"up");
                progressDialog.show();
                if (regusername.getText().toString().equals("") || regpassword.getText().toString().equals(("")) ||
                        reg_email.getText().toString().equals((""))) {

                    Toast.makeText(Signup.this, "username,password,Email is Missing", Toast.LENGTH_LONG).show();

                } else {

                    ParseUser user = new ParseUser();
                    user.setUsername(regusername.getText().toString());
                    user.setPassword(regpassword.getText().toString());
                    user.setEmail(reg_email.getText().toString());

                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(Signup.this, regusername.getText().toString() + "is Registered", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Signup.this, Sign_log.class);
                                startActivity(intent);
                                progressDialog.dismiss();

                            } else
                                Toast.makeText(Signup.this, e + "", Toast.LENGTH_LONG).show();
                        }
                    });


                }

            }
        });*/


    }
    public void Sign_up(View view){
        Root_layout(view);
        final ProgressDialog progressDialog =new ProgressDialog(Signup.this);
        progressDialog.setMessage("Signing "+ regusername.getText().toString() +"up");
        progressDialog.show();
        if (regusername.getText().toString().equals("") || regpassword.getText().toString().equals(("")) ||
                reg_email.getText().toString().equals((""))) {

            Toast.makeText(Signup.this, "username,password,Email is Missing", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();

        } else {

            ParseUser user = new ParseUser();
            user.setUsername(regusername.getText().toString());
            user.setPassword(regpassword.getText().toString());
            user.setEmail(reg_email.getText().toString());

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(Signup.this, regusername.getText().toString() + "is Registered", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Signup.this, Sign_log.class);
                        startActivity(intent);


                    } else {
                        Toast.makeText(Signup.this, e + "", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                }
            });


        }


    }
    public void Root_layout(View view){
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }catch (Exception e2){
            e2.printStackTrace();
        }
    }
}
