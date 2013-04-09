package com.crunchers.boyardroid;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FridgeResults extends Activity {
	
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> recipes = new ArrayList<String>();
	private Cursor c;
	private DataBaseHelper db;
	private SQLiteDatabase database;

	

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
		
		findRecipes();
		//recipes.add("Banana");
		setContentView(R.layout.activity_fridge_results);
		listView = (ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,recipes);
		
		if(listView!=null)
			listView.setAdapter(adapter);
		else
			Toast.makeText(getApplicationContext(), "listView is null", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fridge_recipe_results, menu);
		return true;
	}
	
	public void findRecipes()
	{
		
		String results = "Select r1.nm From (select recipe.name nm, count(*)cnt from recipe " +
				 "left join recipecontains on recipecontains.recipe_id = recipe._id " +
				 "left join ingredient on ingredient._id = recipecontains.ingredient_id " +
				 "Where ingredient.name in (Select Fridge.Ingredient From Fridge) Group by recipe.name) " +
				 "r1 Join (select recipe.name nm, count(*) cnt from recipe left join recipecontains on recipecontains.recipe_id = recipe._id " +
				 "left join ingredient on ingredient._id = recipecontains.ingredient_id group by recipe.name) r on r.nm = r1.nm Where  (Cast(r1.cnt AS REAL)/Cast(r.cnt AS REAL)) >= .75";
		
		c = database.rawQuery(results, null);
		
		recipes.clear();
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			String rec = c.getString(0);
			
			if(!recipes.contains(rec))
				recipes.add(rec);
		}
		
		c.close();
	}

}
