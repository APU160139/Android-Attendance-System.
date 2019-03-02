package com.example.mdapuhosen.androidattendancesystem;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_course extends AppCompatActivity {
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        Button btn = (Button) findViewById(R.id.buttonSAVE);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDatabase(v);
            }
        });
    }


    public void saveToDatabase(View view) {
        EditText name = (EditText) findViewById(R.id.course_name);
        EditText code = (EditText) findViewById(R.id.code);
        EditText dept = (EditText) findViewById(R.id.dept);


        if (name.getText().length() < 2 || code.getText().length() == 0 || dept.getText().length() < 2 ) {
            AlertDialog.Builder alert = new AlertDialog.Builder(activity);
            alert.setTitle("Invalid");
            alert.setMessage("Insufficient Data");
            alert.setPositiveButton("OK", null);
            alert.show();
            return;
        }

        String qu = "INSERT INTO COURSE VALUES('" + name.getText().toString() + "'," +
                "'" + name.getText().toString().toUpperCase() + "'," +
                "'" + code.getText().toString() + "'," +
                "" + Integer.parseInt(dept.getText().toString()) + ");";
        Log.d("Student Reg", qu);
        MainActivity.handler.execAction(qu);
        qu = "SELECT * FROM STUDENT WHERE regno = '" + code.getText().toString() + "';";
        Log.d("Student Reg", qu);
        if (MainActivity.handler.execQuery(qu) != null) {
            Toast.makeText(getBaseContext(), "Course Added", Toast.LENGTH_LONG).show();
            this.finish();
        }
    }
    }

