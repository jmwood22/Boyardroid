package com.crunchers.boyardroid;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class QuickRecipeList extends Activity 
{
	private Button add, remove, find, recipes;
	private ListView listView;
	private ArrayAdapter<String> adapter;

	private static ArrayList<String> tempList = new ArrayList<String>();
	
	private DataBaseHelper db;
	private static SQLiteDatabase database;
	
	private static ListManager lm = new ListManager();

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
		database.execSQL("CREATE TABLE IF NOT EXISTS QuickList (_id INTEGER PRIMARY KEY, ingredient TEXT)");
		setContentView(R.layout.activity_quick_recipe_list);
		
		listView = (ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_multiple_choice, lm.getQuickList() );
		listView.setAdapter(adapter);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setOnItemClickListener(new OnItemClickListener(){
			
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				CheckedTextView check = (CheckedTextView)view;
				if(check.isChecked())
				{
					check.setChecked(false);
					tempList.remove(lm.getQuickList().get(position));
				}
				else
				{
					check.setChecked(true);
					tempList.add(lm.getQuickList().get(position));
				}
			}

    	});
		
		recipes = (Button)findViewById(R.id.button3);
    	recipes.setOnClickListener(new OnClickListener()
    	{
    		public void onClick(View v)
    		{
    			Intent i = new Intent(getApplicationContext(),Recipes.class);
    			startActivity(i);
    		}
    	});
		
		find = (Button)findViewById(R.id.button4);
    	find.setOnClickListener(new OnClickListener()
    	{
    		public void onClick(View v)
    		{
    			
    			if(lm.getQuickList().size()>0)
    			{
    					database.execSQL("DELETE FROM QuickList");
    					for(int i = 0;i<lm.getQuickList().size();i++)
    					{
    						database.execSQL("INSERT INTO QuickList (Ingredient) VALUES ('" + lm.getQuickList().get(i) +"')");
    					}
    			}
    			
    			Intent i=new Intent(getApplicationContext(),QuickRecipeResults.class);
  		      	startActivity(i); 
    			
    		}

			
    	});
    	
    	
		add = (Button)findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  lm.FridgeListFalse();
			  Intent i=new Intent(getApplicationContext(),QuickRecipe.class);
		      startActivity(i);
		  }
		});
		remove = (Button)findViewById(R.id.remove);
		remove.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
		       removeFromQuickList();
		  }
		});
	}
	
	public void removeFromQuickList()
	{
		for (int i = 0; i < tempList.size(); i++) {
			lm.removeFromQuickList(tempList.get(i));
			database.execSQL("DELETE FROM QuickList WHERE QuickList.Ingredient = '" + tempList.get(i) + "'");
			adapter.notifyDataSetChanged();
		}
		tempList.clear();
		for(int i = 0; i < lm.getQuickList().size();i++){
			listView.setItemChecked(i, false);
		}
	}
	
	//adds ingredient to fridge
		public static void addToQuick(String ingredient)
		{
			lm.addToQuickList(ingredient);
		}
		public static void removeFromQuick(String ingredient)
		{
			lm.removeFromQuickList(ingredient);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quick_recipe_list, menu);
		
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