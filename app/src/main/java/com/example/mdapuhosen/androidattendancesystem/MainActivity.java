package com.example.mdapuhosen.androidattendancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    int [] image ={R.drawable.attendance204,R.drawable.profile204,R.drawable.schedule,R.drawable.statistics};
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

    }
}