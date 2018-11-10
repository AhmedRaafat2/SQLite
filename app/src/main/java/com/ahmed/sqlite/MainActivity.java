package com.ahmed.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ContactAdaptor adaptor;
    ArrayList<Contact> items;
    Button addNewContact;
    MyHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);

        /*
        items = new ArrayList<>();
        items.add(new Contact("Ali","012012012"));

         adaptor = new ContactAdaptor(this,items);
         listView.setAdapter(adaptor);
*/
         addNewContact = findViewById(R.id.addNewContact);

         addNewContact.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this,AddActivity.class);
                 startActivity(intent);
             }
         });



        /*
         //
        myHelper = new MyHelper(this);
        ArrayList<Contact> contacts = myHelper.getAllContacts();
         //
        ContactAdaptor adaptor = new ContactAdaptor(this,contacts);
        listView.setAdapter(adaptor);
*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact selected_Contact = (Contact) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
                intent.putExtra("id",selected_Contact.getId());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        myHelper = new MyHelper(this);
        ArrayList<Contact> contacts = myHelper.getAllContacts();
        //
        ContactAdaptor adaptor = new ContactAdaptor(this,contacts);
        listView.setAdapter(adaptor);
    }
}
