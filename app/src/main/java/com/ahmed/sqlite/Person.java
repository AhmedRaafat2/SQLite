package com.ahmed.sqlite;

public class Person {

    private int imageID;
    String name,phoneNumber;

    public Person(String name, String phoneNumber) {
        this.imageID = imageID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
