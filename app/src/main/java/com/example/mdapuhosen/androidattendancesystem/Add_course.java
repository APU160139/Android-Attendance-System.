package com.example.mdapuhosen.androidattendancesystem;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class Add_course extends AppCompatActivity implements View.OnClickListener{
    private EditText edit_name,edit_code,edit_dept;
    private Button add;
    MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        edit_name = findViewById(R.id.course_name);
        edit_code = findViewById(R.id.code);
        edit_dept = findViewById(R.id.dept);
        add=findViewById(R.id.buttonSAVE);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String nam = edit_name.getText().toString();
        String cod = edit_code.getText().toString();
        String dep = edit_dept.getText().toString();
        if (v.getId()==R.id.buttonSAVE){
            long rowId = myDatabaseHelper.insertData(nam,cod,dep);
            if (rowId>0){
                Toast.makeText(getApplicationContext(), "Course Added", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Course Added error", Toast.LENGTH_LONG).show();
            }
        }

    }


}
