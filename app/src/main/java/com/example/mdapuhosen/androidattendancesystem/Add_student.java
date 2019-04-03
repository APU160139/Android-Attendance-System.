package com.example.mdapuhosen.androidattendancesystem;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Add_student extends AppCompatActivity implements View.OnClickListener{

    private EditText stu_name,stu_roll,stu_contact;
    private Button addStudent;
    MyDatabaseHelper myDatabaseHelper;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        stu_name = findViewById(R.id.name);
        stu_roll = findViewById(R.id.roll);
        stu_contact = findViewById(R.id.contact);
        addStudent=findViewById(R.id.STUDENTSAVE);
        addStudent.setOnClickListener(this);


        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        ArrayList<String> listPro = myDatabaseHelper.getAllProvinces();
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_layout,R.id.txt,listPro);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        String nim = stu_name.getText().toString();
        String rol = stu_roll.getText().toString();
        String con = stu_contact.getText().toString();
        String classSelected = spinner.getSelectedItem().toString();

        if (v.getId()==R.id.STUDENTSAVE){
            long rowIdd = myDatabaseHelper.insertDataStudent(classSelected,nim,rol,con);
            if (rowIdd>0){
                Toast.makeText(getApplicationContext(), "Student Added", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Student Added error", Toast.LENGTH_LONG).show();
            }
        }

    }
}
