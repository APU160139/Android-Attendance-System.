package com.example.mdapuhosen.androidattendancesystem;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    int [] image ={R.drawable.attendance204,R.drawable.profile204,R.drawable.course,R.drawable.statistics};
    String[] Feature;
    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Feature = getResources().getStringArray(R.array.Feature);
        gridview = findViewById(R.id.grid);
        CustomAdapter adapter = new CustomAdapter(this, Feature, image);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){
                    Intent intent = new Intent(MainActivity.this,Attendance.class);
                    startActivity(intent);
                }
                else if (position==1){
                    Intent intent = new Intent(MainActivity.this,Add_student.class);
                    startActivity(intent);
                }
                else if (position==2){
                    Intent intent = new Intent(MainActivity.this,Show_cours.class);
                    startActivity(intent);
                }
                else if (position==3){
                    Intent intent = new Intent(MainActivity.this,Statistics.class);
                    startActivity(intent);
                }
            }
        });

    }
}