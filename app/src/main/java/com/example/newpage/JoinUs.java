package com.example.newpage;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class JoinUs extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText password;
    EditText email;
    DatePickerDialog picker;
    EditText editText;
    Button joinUs;
    TextView logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_us);

        joinUs = (Button) findViewById(R.id.joinUs);
        joinUs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkDataEntered();

            }
        });

        firstName = findViewById(R.id.editTextFirstName);
        lastName = findViewById(R.id.editTextTextLastName);
        password = findViewById(R.id.editTextTextPassword);
        email = findViewById(R.id.editTextTextEmailAddress);

        logIn = findViewById(R.id.logInTextView);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogIn();
            }
        });

        editText = (EditText) findViewById(R.id.editTextTextBirthDate);
        editText.setInputType(InputType.TYPE_NULL);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(JoinUs.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                editText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);
                picker.show();
            }
        });

    }

    private void openLogIn() {
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }

    private void openJoinUs() {
        Intent intent = new Intent(this, GetStartedJoin.class);
        startActivity(intent);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(firstName)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(lastName)) {
            lastName.setError("Last name is required!");
        }

        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
        }

        if(isEmpty(password)) {
            password.setError("Enter valid password");
        }
        else {
            if(password.getText().toString().length() < 9) {
                password.setError("Minimum 8 characters");
            }
            openJoinUs();
        }

    }
}



