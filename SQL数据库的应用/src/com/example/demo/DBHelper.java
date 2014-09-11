package com.example.demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context) {
		super(context, "demo", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	    db.execSQL("create table demo(id INTEGER PRIMARY KEY,name varchar(20),tel varchar(11))");
	    
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table demo");
		onCreate(db);
	}

}
