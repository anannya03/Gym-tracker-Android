package com.example.newpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgottenPassword extends AppCompatActivity {

    Button resetPwd;
    TextView logIn;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);

        email = findViewById(R.id.editTextTextEmailAddressPwd);


        resetPwd = (Button) findViewById(R.id.forgotPasswordBtn);
        resetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();
            }
        });

        logIn = (TextView) findViewById(R.id.logInTextPwd);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogIn();
            }
        });
    }
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    private void openLogIn() {
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }

    private void openResetButton() {
        Toast.makeText(this, "Email is sent to the specified mail id.", Toast.LENGTH_SHORT).show();
    }

    void checkDataEntered() {

        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
        }
        else{
            openResetButton();
        }
    }
}