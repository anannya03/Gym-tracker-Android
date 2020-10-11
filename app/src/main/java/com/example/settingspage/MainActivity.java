package com.example.settingspage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button payment;
    private Button password;
    private Button termsOfUse;
    private Button logOut;
    private Button contactUs;
    private Button version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactUs = (Button)findViewById(R.id.contactUs);

        contactUs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openContactUs();

            }
        });

        button = (Button) findViewById(R.id.contact);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
            }
        });

        payment = (Button) findViewById(R.id.payment);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPayment();
            }
        });

        termsOfUse = findViewById(R.id.termsOfUse);
        termsOfUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTermsOfUse();
            }
        });

        password = (Button) findViewById(R.id.password);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPassword();
            }
        });

        logOut = (Button) findViewById(R.id.logOut);
        logOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openAlert();
            }
        });

        version = (Button) findViewById(R.id.version);
        version.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVersion();
            }
        });
    }

    private void openContactUs() {
        Intent intent = new Intent(this, ContactUsInstagram.class);
        startActivity(intent);
    }

    void openContact(){
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }

    void openPayment(){
        Intent intent = new Intent(this, PaymentDetails.class);
        startActivity(intent);
    }

    void openPassword(){
        Intent intent = new Intent(this, ResetPassword.class);
        startActivity(intent);
    }

    void openTermsOfUse(){
        Intent intent = new Intent(this, TermsOfUse.class);
        startActivity(intent);
    }

    void openAlert(){
        LogOutAlert logOutAlert = new LogOutAlert();
        logOutAlert.show(getSupportFragmentManager(), "Log Out alert");
    }

    void openVersion(){
        Intent intent = new Intent(this, AboutThisVersion.class);
        startActivity(intent);
    }

}
