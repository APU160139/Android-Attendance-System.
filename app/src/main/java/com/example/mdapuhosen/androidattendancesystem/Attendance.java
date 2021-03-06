package com.example.mdapuhosen.androidattendancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


public class Attendance extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        ArrayList<String> listPro = myDatabaseHelper.getAllProvinces();
        Spinner sp = findViewById(R.id.attendanceSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.txt,listPro);
        sp.setAdapter(adapter);

        final ListView listView = findViewById(R.id.attendanceListViwe);
        final ArrayList<String> arrayList = myDatabaseHelper.getAllStudent();
        final ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,R.layout.student_list,R.id.attendanceName,arrayList);
        listView.setAdapter(adapt);



    }
}
