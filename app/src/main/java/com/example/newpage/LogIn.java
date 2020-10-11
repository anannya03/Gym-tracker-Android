package com.example.newpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    Button logIn;
    TextView joinUs;
    TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        logIn = (Button) findViewById(R.id.logIn);
        logIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openLogIn();
            }
        });

        joinUs = (TextView) findViewById(R.id.joinUsText);
        joinUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJoinUs();
            }
        });

        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgotPassword();
            }
        });
    }

    private void openForgotPassword() {
        Intent intent = new Intent(this, ForgottenPassword.class);
        startActivity(intent);
    }

    private void openJoinUs() {
        Intent intent = new Intent(this, JoinUs.class);
        startActivity(intent);
    }

    private void openLogIn() {
        Intent intent = new Intent(this, GetStartedLog.class);
        startActivity(intent);
    }
}