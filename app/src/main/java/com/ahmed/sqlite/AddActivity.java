package com.ahmed.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText contact_Name,phone_Number;
    Button addContact;

    MyHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        contact_Name = findViewById(R.id.contact_name);
        phone_Number = findViewById(R.id.contact_phone);
        addContact = findViewById(R.id.addContact);


        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = contact_Name.getText().toString();
                String phone = phone_Number.getText().toString();

                Contact contact = new Contact(name,phone);

                myHelper = new MyHelper(AddActivity.this);
                myHelper.addContact(contact);
            }
        });
    }
}
