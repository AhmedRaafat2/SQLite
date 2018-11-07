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

public class PersonAdaptor extends ArrayAdapter<Contact> {
    public PersonAdaptor(@NonNull Context context, @NonNull ArrayList<Contact> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row, parent, false);
        TextView name = convertView.findViewById(R.id.nameTextView);
        TextView phone = convertView.findViewById(R.id.numberTextView);
        ImageView personImage = convertView.findViewById(R.id.imagePerson);

        Contact contact = getItem(position);
        name.setText(contact.getName());
        phone.setText(contact.getPhoneNumber());
        personImage.setImageResource(contact.getImageID());

        return convertView;
    }
}
