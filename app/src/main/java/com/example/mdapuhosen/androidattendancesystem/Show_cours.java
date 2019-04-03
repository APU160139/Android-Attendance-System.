package com.example.mdapuhosen.androidattendancesystem;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Show_cours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cours);
        FloatingActionButton floatingActionButton = findViewById(R.id.fabe);
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        ArrayList<String> listPro = myDatabaseHelper.getAllProvinces();
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.txt,listPro);
        listView.setAdapter(adapter);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Show_cours.this,Add_course.class);
                startActivity(intent);
            }
        });

    }
}
