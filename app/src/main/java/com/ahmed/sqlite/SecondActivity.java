package com.ahmed.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView contact_Name,phone_Number;
    Button addContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        contact_Name = findViewById(R.id.contact_name);
        phone_Number = findViewById(R.id.contact_phone);
        addContact = findViewById(R.id.addContact);
    }
}
