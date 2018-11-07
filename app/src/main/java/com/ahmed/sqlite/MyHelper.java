package com.ahmed.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyHelper  extends SQLiteOpenHelper{

    //1st declair database schema  ,name,version,table name,....
    private  static  final  String BD_NAME = "ContactData";
    private  static  final  int DB_VERSION = 1;
    private  static  final  String TABLE_NAME = "Contact";
    private  static  final  String KEY_ID = "id";
    private  static  final  String KEY_NAME = "name";
    private  static  final  String KEY_PHONE = "phone";


    public MyHelper(Context context) {
        super(context, KEY_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_Table = "CREATE TABLE " + TABLE_NAME + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                "" + KEY_NAME + " VARCHAR(50)," + KEY_PHONE + " VARCHAR(50))";
        db.execSQL(create_Table);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DELETE_TABLE = "DROP TABLE "+TABLE_NAME+" IF EXISTS";
        db.execSQL(DELETE_TABLE);
        onCreate(db);
    }

    public  void addContact(Contact contact){
        //علشان اضيف الداتا
        //1
        SQLiteDatabase db = getWritableDatabase();
        //2
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PHONE, contact.getPhoneNumber());

        //3
        db.insert(TABLE_NAME,null,values);

    }

    public ArrayList<Contact> getAllContacts(){
        ArrayList<Contact> contacts = new ArrayList<>();
        String SELECT_QUERY = "SELECT * FROM "+TABLE_NAME+"";
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery(SELECT_QUERY,null);

        //علشان محتاجه جوا ال do While
        Contact contact = null;

        //
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                String phone = cursor.getColumnName(cursor.getColumnIndex(KEY_PHONE));
                int id = cursor.getInt(cursor.getColumnIndex(KEY_ID));

                //contact object
                contact = new Contact(id,name,phone);

                //Array
                contacts.add(contact);
            }while (cursor.moveToNext());
        }
        //return ArrayList
        return contacts;
    }
}
