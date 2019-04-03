package com.example.mdapuhosen.androidattendancesystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME= "Course_Info.db";
    private static final String TABLE_NAME="Course_add";
    private static final String ID="ID";
    private static final String COURSE_NAME="Course_Name";
    private static final String COURSE_Code="Course_Code";
    private static final String DEPT="Dept_Name";

    private static final String TABLE_NAME_STUDENT="Student_add";
    private static final String STUDENT_NAME="Student_Name";
    private static final String SELECT="Course_select";
    private static final String STUDENT_ROLL="Student_Roll";
    private static final String STUDENT_CONTACT="Student_Contact";
    private static final String STUDENT_ID="Student_Id";
    private static final String CREATE_TABLE_STUDENT="CREATE TABLE "+TABLE_NAME_STUDENT+"("+STUDENT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+SELECT+" VARCHAR(50),"+STUDENT_NAME+" VARCHAR(50),"+STUDENT_ROLL+" INTEGER(50),"+STUDENT_CONTACT+" INTEGER(50));";
    private static final String DROP_TABLE_STUDENT="DROP TABLE IF EXISTS "+TABLE_NAME_STUDENT;


    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COURSE_NAME+" VARCHAR(50),"+COURSE_Code+" VARCHAR(50),"+DEPT+" VARCHAR(50));";
    private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;

    private Context context;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       try {

            db.execSQL(CREATE_TABLE);
            db.execSQL(CREATE_TABLE_STUDENT);

        }
        catch(Exception e){
            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {

            db.execSQL(DROP_TABLE);
            db.execSQL(DROP_TABLE_STUDENT);
            onCreate(db);
        }catch (Exception e){

            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_LONG).show();
        }


    }

    public long insertData(String nam,String cod,String dep)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COURSE_NAME,nam);
        contentValues.put(COURSE_Code,cod);
        contentValues.put(DEPT,dep);
        long rowId = db.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }
    public long insertDataStudent(String select,String nim,String rol,String con)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SELECT,select);
        contentValues.put(STUDENT_NAME,nim);
        contentValues.put(STUDENT_ROLL,rol);
        contentValues.put(STUDENT_CONTACT,con);
        long rowIdd = db.insert(TABLE_NAME_STUDENT,null,contentValues);
        return rowIdd;
    }

    public ArrayList<String> getAllProvinces(){
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        db.beginTransaction();
        try {
            String selectQuery = "SELECT "+COURSE_NAME+" FROM " + TABLE_NAME;
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    String pName = cursor.getString(cursor.getColumnIndex(COURSE_NAME));
                    list.add(pName);
                }
            }
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            db.endTransaction();
            db.close();
        }
        return list;
    }

    public ArrayList<String> getAllStudent(){
        ArrayList<String> file = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        db.beginTransaction();
        try {
            String selectQuery = "SELECT "+STUDENT_ROLL+" FROM "+TABLE_NAME_STUDENT+" ORDER BY "+STUDENT_ROLL+"";
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    String pName = cursor.getString(cursor.getColumnIndex(STUDENT_ROLL));
                    file.add(pName);
                }
            }
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            db.endTransaction();
            db.close();
        }
        return file;
    }
}
