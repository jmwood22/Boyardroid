package com.crunchers.boyardroid;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class Fridge extends Activity 
{
	private Button add, remove, find;
	
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private static ArrayList<String> tempList = new ArrayList<String>();
	
	private DataBaseHelper db;
	private static SQLiteDatabase database;
	
	private ListManager lm = new ListManager();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
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
		 
        setContentView(R.layout.activity_fridge);
		listView = (ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_multiple_choice, lm.getFridgeList() );
		listView.setAdapter(adapter);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    	listView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				CheckedTextView check = (CheckedTextView)view;
				if(check.isChecked())
				{
					check.setChecked(false);
					tempList.remove(lm.getFridgeList().get(position));
				}
				else
				{
					check.setChecked(true);
					tempList.add(lm.getFridgeList().get(position));
				}
			}
			
			

    	});
    	
    	find = (Button)findViewById(R.id.button4);
    	find.setOnClickListener(new OnClickListener()
    	{
    		public void onClick(View v)
    		{
    				
    			if(lm.getFridgeList().size()>0)
    			{
    					database.execSQL("DELETE FROM Fridge");
    					for(int i = 0;i<lm.getFridgeList().size();i++)
    					{
    						database.execSQL("INSERT INTO Fridge (Ingredient) VALUES ('" + lm.getFridgeList().get(i) +"')");
    					}
    			}
    			
    			Intent i=new Intent(getApplicationContext(),FridgeResults.class);
  		      	startActivity(i); 
    		}

			
    	});
        
    	add = (Button)findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  lm.FridgeListTrue();
			  Intent i=new Intent(getApplicationContext(),QuickRecipe.class);
		      startActivity(i);
		  }
		});
		remove = (Button)findViewById(R.id.remove);
		remove.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
		       removeFromFridge();
		  }
		});
				 
    }
	
	/*public SparseBooleanArray tempArray()
	{
		SparseBooleanArray sp = listView.getCheckedItemPositions();
		return sp;
	}
	
	
	//adds ingredient to fridge
	public static void addToFridgeList(String ingredient)
	{
		lm.getFridgeList().add(ingredient);
	}
	
	
	*/
    //removes ingredients from fridge
	public void removeFromFridge()
	{
		for (int i = 0; i < tempList.size(); i++) {
			lm.getFridgeList().remove(tempList.get(i));
			database.execSQL("DELETE FROM Fridge WHERE Fridge.Ingredient = '" + tempList.get(i) + "'");
			adapter.notifyDataSetChanged();
		}
		tempList.clear();
		for(int i = 0; i < lm.getFridgeList().size();i++){
			listView.setItemChecked(i, false);
		}
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_fridge, menu);
        return true;
    }
	
	
    /*
    public void onClick(DialogInterface dialog, int which) 
    {
		switch(which) {
		case DialogInterface.BUTTON_POSITIVE:
			Intent i = new Intent(getApplicationContext(), QuickRecipe.class);
			startActivity(i);
			break;
		case DialogInterface.BUTTON_NEGATIVE:
			//Do nothing
		}
		
	}
	
	public void dialogBtn(View v) 
	{
		new AlertDialog.Builder(this)
		.setTitle("More?")
		.setMessage("Add more ingredients?")
		.setPositiveButton("Yes", this)
		.setNegativeButton("No", this)
		.show();
	}*/

}
