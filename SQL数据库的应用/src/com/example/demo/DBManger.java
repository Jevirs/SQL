package com.example.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBManger {
	private DBHelper dbHelper;
	private SQLiteDatabase db;
	
	public DBManger(Context context) {
		// TODO Auto-generated constructor stub
	dbHelper=new DBHelper(context);
	db=dbHelper.getWritableDatabase();
	}
	
	public void Add(Person person){
		ContentValues cValues=new ContentValues();
		cValues.put("name",person.name);
		cValues.put("tel", person.tel);
		db.insert("demo", null, cValues);
		Log.i("DBManger", "add");
}
	public void Delete(Person person){
		int id=person.id;
		db.delete("person", "age >= ?", new String[]{String.valueOf(id)});  		   
} 
	public void Updata(Person person){
		ContentValues cValues=new ContentValues();
		cValues.put("name", person.name);
		cValues.put("tel", person.tel);
		int id=person.id;
		db.update("demo", cValues, "id=?", new String[]{String.valueOf(id)});
	}
	
	public void close(){
		db.close();
		Log.i("DBManger", "close");
	}
}