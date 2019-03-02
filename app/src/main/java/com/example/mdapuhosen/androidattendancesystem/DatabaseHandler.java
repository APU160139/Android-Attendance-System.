package com.example.mdapuhosen.androidattendancesystem;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHandler {
    Activity activity;
    private SQLiteDatabase database;
    public DatabaseHandler(Activity activity) {
        this.activity = activity;
        database = activity.openOrCreateDatabase("ASSIST", activity.MODE_PRIVATE, null);
        createTable();
    }

    public void createTable() {
        try {
            String qu = "CREATE TABLE IF NOT EXISTS STUDENT(name varchar(1000)," +
                    "cl varchar(100), " +
                    "regno varchar(100) primary key, contact varchar(100),roll integer);";
            database.execSQL(qu);
        } catch (Exception e) {
            Toast.makeText(activity, "Error Occured for create table", Toast.LENGTH_LONG).show();
        }

        try {
            String qu = "CREATE TABLE IF NOT EXISTS COURSE(course_name varchar(1000)," +
                    "course_title varchar(100) primary key, " +
                    "dept varchar(100));";
            database.execSQL(qu);
        } catch (Exception e) {
            Toast.makeText(activity, "Error Occured for create table", Toast.LENGTH_LONG).show();
        }
    }

    public boolean execAction(String qu) {
        Log.i("DatabaseHandler", qu);
        try {
            database.execSQL(qu);
        } catch (Exception e) {
            Log.e("DatabaseHandler", qu);
            Toast.makeText(activity, "Error Occured for execAction", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public Cursor execQuery(String qu) {
        try {
            return database.rawQuery(qu, null);
        } catch (Exception e) {
            Log.e("DatabaseHandler", qu);
            Toast.makeText(activity,"Error Occurred for execAction",Toast.LENGTH_LONG).show();
        }
        return null;
    }
}
