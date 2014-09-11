package com.example.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

	private EditText name,tel;
	private Button commit;
	private DBManger dbManger;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        commit=(Button) findViewById(R.id.button1);
        name=(EditText) findViewById(R.id.editText1);
        tel=(EditText) findViewById(R.id.editText2);
        
        dbManger=new DBManger(this);
        
        commit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Person person=new Person(name.getText().toString(),tel.getText().toString());
				dbManger.Add(person);
			}
		});
    }
    
    
    protected void onStop(){
    	super.onStop();
    	dbManger.close();
    }
    
    
}
