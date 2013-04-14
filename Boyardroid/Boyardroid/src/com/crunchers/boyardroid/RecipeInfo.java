package com.crunchers.boyardroid;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.TextView;

public class RecipeInfo extends Activity {
	
	private String recipe;
	private String recipeInfo;
	
	private TextView textView;
	
	private DataBaseHelper db;
	private static SQLiteDatabase database;
	private Cursor c;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		db = new DataBaseHelper(this);
		 
		 try {
		  
		 db.createDataBase();
		  
		 } catch (IOException ioe) {
		  
		 throw new Error("Unable to create database");
		  
		 }
		  
		 try {
		  
		 db.openDataBase();
		  
		 }catch(SQLException sqle){
		  
		 throw sqle;
		  
		 }
		 
		database = db.getWritableDatabase();
		
		setContentView(R.layout.activity_recipe_info);
		
		textView = (TextView)this.findViewById(R.id.textView1);
		textView.setMovementMethod(new ScrollingMovementMethod());
		
		Intent i = getIntent();
		recipe = i.getExtras().getString("recipe");
		
		getRecipeInfo();
		
		textView.setText(recipeInfo);
	}

	private void getRecipeInfo() 
	{
		String results = "Select Recipe.Info From Recipe Where Recipe.Name = '" + recipe + "'";
		
		c = database.rawQuery(results, null);
		
		c.moveToFirst();
		
		recipeInfo = c.getString(0);
		
		c.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recipe_info, menu);
		
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
	    if ( keyCode == KeyEvent.KEYCODE_MENU ) 
	    {
	    	Intent i=new Intent(getApplicationContext(),HomeScreen.class);
		    startActivity(i); 
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}

}
