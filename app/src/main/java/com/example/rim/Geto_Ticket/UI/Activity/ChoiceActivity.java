package com.example.rim.Geto_Ticket.UI.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.rim.Geto_Ticket.R;

/**
 * Created by rim on 26/03/17.
 */

public class ChoiceActivity extends AppCompatActivity implements View.OnClickListener{
    TextView login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_signup_layout);
        login = (TextView)findViewById(R.id.login_textview);
        signup = (TextView)findViewById(R.id.signup_textview);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==login.getId()){
            Intent i = new Intent(ChoiceActivity.this, LoginActivity.class);
            startActivity(i);
        }else if(v.getId()==signup.getId()){
            Intent i = new Intent(ChoiceActivity.this, SignupActivity.class);
            startActivity(i);

        }

    }
}
