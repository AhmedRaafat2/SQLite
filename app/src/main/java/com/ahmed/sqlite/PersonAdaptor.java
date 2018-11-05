package com.ahmed.sqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdaptor extends ArrayAdapter<Person> {
    public PersonAdaptor(@NonNull Context context, @NonNull ArrayList<Person> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row, parent, false);
        TextView name = convertView.findViewById(R.id.nameTextView);
        TextView phone = convertView.findViewById(R.id.numberTextView);
        ImageView personImage = convertView.findViewById(R.id.imagePerson);

        Person person = getItem(position);
        name.setText(person.getName());
        phone.setText(person.getPhoneNumber());
        personImage.setImageResource(person.getImageID());

        return convertView;
    }
}
