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
    PersonAdaptor adaptor;
    ArrayList<Person> items;
    Button addNewContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        items = new ArrayList<>();
        items.add(new Person("Ali","012012012"));

         adaptor = new PersonAdaptor(this,items);
         listView.setAdapter(adaptor);

         addNewContact = findViewById(R.id.addNewContact);

         addNewContact.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                 startActivity(intent);
             }
         });

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
                 startActivity(intent);
             }
         });
    }
}
