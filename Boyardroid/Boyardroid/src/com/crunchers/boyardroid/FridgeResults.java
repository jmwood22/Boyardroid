package com.crunchers.boyardroid;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

public class FridgeResults extends Activity {
	
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> recipes = new ArrayList<String>();
	private ArrayList<String> ingredients = new ArrayList<String>();
	private Cursor c;
	private DataBaseHelper db;
	private SQLiteDatabase database;
	private ListManager lm = new ListManager();
	
	private ExpandListAdapter ExpAdapter;
	private ArrayList<ExpandListGroup> ExpListItems;
	private ExpandableListView ExpandList;


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
		
		ExpandList = (ExpandableListView) findViewById(R.id.ExpList);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(FridgeResults.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
        /*
		listView = (ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,recipes);
		
		if(listView!=null)
			listView.setAdapter(adapter);
		else
			Toast.makeText(getApplicationContext(), "listView is null", Toast.LENGTH_LONG).show();
		*/
		ExpandList.setOnItemLongClickListener(new OnItemLongClickListener(){
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
			{
				//Toast.makeText(getApplicationContext(),ExpListItems.,Toast.LENGTH_SHORT).show();
				Intent i=new Intent(getApplicationContext(),RecipeInfo.class);
				i.putExtra("recipe", recipes.get(position));
  		      	startActivity(i); 
  		      	return false;
			}
    	});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fridge_recipe_results, menu);
		return true;
	}
	
	
	public void findIngredients(String recipe)
	{
		String results = "Select Ingredient.Name From Ingredient Left Join RecipeContains On Ingredient._id = RecipeContains.Ingredient_id " +
							"Left Join Recipe On Recipe._id = RecipeContains.Recipe_id Where Recipe.Name = '" + recipe + "'";
		c = database.rawQuery(results, null);
		
		ingredients.clear();
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			String rec = c.getString(0);
			if(!lm.getFridgeList().contains(rec))
				rec += " needed";
			if(!ingredients.contains(rec))
				ingredients.add(rec);
		}
		
		c.close();
	}
	
	
	
	public void findRecipes()
	{
		
		String results = "Select r1.nm From (select recipe.name nm, count(*)cnt from recipe " +
				 "left join recipecontains on recipecontains.recipe_id = recipe._id " +
				 "left join ingredient on ingredient._id = recipecontains.ingredient_id " +
				 "Where ingredient.name in (Select Fridge.Ingredient From Fridge) Group by recipe.name) " +
				 "r1 Join (select recipe.name nm, count(*) cnt from recipe left join recipecontains on recipecontains.recipe_id = recipe._id " +
				 "left join ingredient on ingredient._id = recipecontains.ingredient_id group by recipe.name) r on r.nm = r1.nm Where  (Cast(r1.cnt AS REAL)/Cast(r.cnt AS REAL)) >= .25";
		
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
	
	public ArrayList<ExpandListGroup> SetStandardGroups() {
    	ArrayList<ExpandListGroup> list = new ArrayList<ExpandListGroup>();
    	ArrayList<ExpandListChild> list2 = new ArrayList<ExpandListChild>();
    	
    	
    	
    	for(int i = 0; i < recipes.size(); i++)
    	{
    		String temp = recipes.get(i);
    		ExpandListGroup tempGroup = new ExpandListGroup();
    		tempGroup.setName(temp);
    		findIngredients(temp);
    		for(int j = 0; j < ingredients.size(); j++)
    		{
    			ExpandListChild tempChild = new ExpandListChild();
    			tempChild.setName(ingredients.get(j));
    			tempChild.setTag(null);
    			list2.add(tempChild);
    		}
    		tempGroup.setItems(list2);
    		
    		list.add(tempGroup);
    		list2 = new ArrayList<ExpandListChild>();
    	}
    	
    	
    	
    	
    	/*
        ExpandListGroup gru1 = new ExpandListGroup();
        gru1.setName("Recipe1");
        
        ExpandListChild ch1_1 = new ExpandListChild();
        ch1_1.setName("Ingredient1");
        ch1_1.setTag(null);
        list2.add(ch1_1);
        
        ExpandListChild ch1_2 = new ExpandListChild();
        ch1_2.setName("Ingredient2");
        ch1_2.setTag(null);
        list2.add(ch1_2);
        
        ExpandListChild ch1_3 = new ExpandListChild();
        ch1_3.setName("Ingredient3");
        ch1_3.setTag(null);
        list2.add(ch1_3);
        gru1.setItems(list2);
        
        list2 = new ArrayList<ExpandListChild>();
        
        ExpandListGroup gru2 = new ExpandListGroup();
        gru2.setName("Recipe2");
        ExpandListChild ch2_1 = new ExpandListChild();
        ch2_1.setName("Ingredient1");
        ch2_1.setTag(null);
        list2.add(ch2_1);
        ExpandListChild ch2_2 = new ExpandListChild();
        ch2_2.setName("Ingredient2");
        ch2_2.setTag(null);
        list2.add(ch2_2);
        ExpandListChild ch2_3 = new ExpandListChild();
        ch2_3.setName("Ingredient3");
        ch2_3.setTag(null);
        list2.add(ch2_3);
        gru2.setItems(list2);
        list.add(gru1);
        list.add(gru2);
        */
        return list;
    }

}
