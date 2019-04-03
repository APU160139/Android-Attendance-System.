package com.example.mdapuhosen.androidattendancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        ArrayList<String> listPro = myDatabaseHelper.getAllProvinces();
        Spinner spin = findViewById(R.id.spin);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.txt,listPro);
        spin.setAdapter(adapter);
    }
}
