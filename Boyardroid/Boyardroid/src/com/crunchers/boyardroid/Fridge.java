package com.crunchers.boyardroid;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class Fridge extends Activity 
{
	Button add;
	Button remove;
	Button find;
	ListView listView;
	ArrayAdapter<String> adapter;
	static ArrayList<String> listItems = new ArrayList<String>();
	static ArrayList<String> tempList = new ArrayList<String>();
	static String fridgeItems = "";
	String query;
	static Cursor c;
	
	DataBaseHelper db;
	static SQLiteDatabase database;
	
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
		 database.execSQL("CREATE TABLE IF NOT EXISTS FRIDGE (_id INTEGER PRIMARY KEY, ingredient TEXT)");
		 
        setContentView(R.layout.activity_fridge);
		listView = (ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_multiple_choice, listItems );
		listView.setAdapter(adapter);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    	listView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				CheckedTextView check = (CheckedTextView)view;
				if(check.isChecked())
				{
					check.setChecked(false);
					tempList.remove(listItems.get(position));
				}
				else
				{
					check.setChecked(true);
					tempList.add(listItems.get(position));
				}
			}
			
			

    	});
    	
    	find = (Button)findViewById(R.id.button4);
    	find.setOnClickListener(new OnClickListener()
    	{
    		public void onClick(View v)
    		{
    			//database.execSQL("DELETE FROM Fridge");
    			//database.execSQL("INSERT INTO Fridge VALUES (" + fridgeItems.substring(0, fridgeItems.length()-2) + ")");
    			
    			
    			//Toast.makeText(getApplicationContext(), fridgeItems.substring(0, fridgeItems.length()-2), Toast.LENGTH_LONG).show();
    			//Toast.makeText(getApplicationContext(), "INSERT INTO Fridge (Ingredient) VALUES (" + fridgeItems.substring(0, fridgeItems.length()-2) + ")", Toast.LENGTH_LONG).show();
    			
    			if(listItems.size()>0)
    			{
    					database.execSQL("DELETE FROM Fridge");
    					for(int i = 0;i<listItems.size();i++)
    					{
    						database.execSQL("INSERT INTO Fridge (Ingredient) VALUES ('" + listItems.get(i) +"')");
    					}
    			}
    			
    			Intent i=new Intent(getApplicationContext(),FridgeResults.class);
  		      	startActivity(i); 
    			
  		      	
  		      	//c.moveToFirst();
    			
    			//String[] cols = c.getColumnNames();
    			
    			//int test = c.getColumnIndex("nm");
    			
    			
    			//String tester = "";
    			//tester+= test;
    			
    			//for(int i = 0; i<cols.length;i++)
    			//Toast.makeText(getApplicationContext(), c.getString(c.getColumnIndex("nm")), Toast.LENGTH_LONG).show();
    			
    			//Toast.makeText(getApplicationContext(), c.getString(1), Toast.LENGTH_LONG).show();
    			//Toast.makeText(getApplicationContext(), c.getString(2), Toast.LENGTH_LONG).show();
    			//Intent i = new Intent(getApplicationContext(),QuickRecipe.class);
    			//startActivity(i);
    			//c.close();
    		}

			
    	});
        
    	add = (Button)findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  HomeScreen.fridgeList = true;
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
	
	public SparseBooleanArray tempArray()
	{
		SparseBooleanArray sp = listView.getCheckedItemPositions();
		return sp;
	}
	
	
	//adds ingredient to fridge
	public static void addToFridgeList(String ingredient)
	{
		listItems.add(ingredient);
		//database.execSQL("CREATE TABLE Fridge (_id INTEGER PRIMARY KEY, ingredient TEXT)");
		//database.execSQL("INSERT INTO Fridge (Ingredient) VALUES ('" + ingredient + "')");
		
		//fridgeItems += "'" + ingredient + "', ";
		
	}
	
	
	//removes ingredients from fridge
	public void removeFromFridge()
	{
		for (int i = 0; i < tempList.size(); i++) {
			listItems.remove(tempList.get(i));
			database.execSQL("DELETE FROM Fridge WHERE Fridge.Ingredient = '" + tempList.get(i) + "'");
			adapter.notifyDataSetChanged();
		}
		tempList.clear();
		for(int i = 0; i < listItems.size();i++){
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
	
	public void findRecipes()
	{
		
		fridgeItems = fridgeItems.substring(0, fridgeItems.length()-2);
		
		String results = "Select r1.nm From (select recipe.name nm, count(*)cnt from recipe " +
				 "left join recipecontains on recipecontains.recipe_id = recipe._id " +
				 "left join ingredient on ingredient._id = recipecontains.ingredient_id " +
				 "Where ingredient.name in (Select Fridge.Ingredient From Fridge) Group by recipe.name) " +
				 "r1 Join (select recipe.name nm, count(*) cnt from recipe left join recipecontains on recipecontains.recipe_id = recipe._id " +
				 "left join ingredient on ingredient._id = recipecontains.ingredient_id group by recipe.name) r on r.nm = r1.nm Where (r1.cnt/r.cnt) > .10 ";
		
		//String[] cols = new String[]{"_id","nm"};
		c = database.rawQuery(results, null);
		
		
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
