package com.ahmed.sqlite;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {

    EditText contact_Name_Update, phone_Number_Update;
    Button updateContact;
    AlertDialog alertDialog;
    int id;
    MyHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        contact_Name_Update = findViewById(R.id.contact_name_update);
        phone_Number_Update = findViewById(R.id.contact_phone_update);
        updateContact = findViewById(R.id.updateContact);

        //For update activity be filled with contact selected data
        id = getIntent().getIntExtra("id",0);
        myHelper = new MyHelper(this);
        final Contact contact = myHelper.getContact(id);
        contact_Name_Update.setText(contact.getName());
        phone_Number_Update.setText(contact.getPhoneNumber());

        updateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = contact_Name_Update.getText().toString();
                String phone = phone_Number_Update.getText().toString();
                Contact newContact = new Contact(id,name,phone);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                showAlert();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
    private void showAlert(){
        //Making Alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                myHelper.deleteContact(id);
                finish();

            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog = builder.create();
        alertDialog.show();

    }



}


