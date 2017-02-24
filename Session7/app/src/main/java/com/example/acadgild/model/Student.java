package com.example.acadgild.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Student extends SQLiteOpenHelper{

    final String NAME_COLUMN="name";
    final String ID_COLUMN="id";

    final String STUDENT_TABLE="Student";

    public Student(Context context, String name) {
        super(context, name, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+STUDENT_TABLE+" ( "+NAME_COLUMN+" varchar(20), "+ID_COLUMN+" number(2))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String name, int id){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID_COLUMN,id);
        contentValues.put(NAME_COLUMN,name);
        db.insert(STUDENT_TABLE,null,contentValues);
        db.close();
    }

    public List<String> getAllStudents(){
        List<String> studentList=new ArrayList<String>();
        SQLiteDatabase db=getReadableDatabase();
//        String []columns={"id","name"};
        Cursor cursor=db.query(STUDENT_TABLE,null,null,null,null,null,ID_COLUMN+" DESC");
        if(cursor.moveToFirst()){
            do{
                String name=cursor.getString(cursor.getColumnIndex(NAME_COLUMN));
                int id=cursor.getInt(cursor.getColumnIndex(ID_COLUMN));
                studentList.add("  "+name+"\t\t\t"+id+"\n\n");
            }while (cursor.moveToNext());
        }else{
            studentList.add("-------Empty------");
        }
        db.close();
        return studentList;
    }
    public void updateStudent(String name, String id){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME_COLUMN,name);
        db.update(STUDENT_TABLE,contentValues," name  like %?%",new String[]{name});
        db.close();
    }

    public void delete(String name, String id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(STUDENT_TABLE,NAME_COLUMN+" like ? or "+ID_COLUMN+" = ?",new String[]{name,id});
        db.close();
    }

}
