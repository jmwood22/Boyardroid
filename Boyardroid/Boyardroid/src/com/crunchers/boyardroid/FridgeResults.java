package com.crunchers.boyardroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ExpandableListView;

public class FridgeResults extends Activity {
	
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
		
		setContentView(R.layout.activity_fridge_results);
		lm.setViewRecipes(false);
		ExpandList = (ExpandableListView) findViewById(R.id.ExpList);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(FridgeResults.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
        
		ExpandList.setOnItemLongClickListener(new OnItemLongClickListener(){
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
			{
				if(ExpandableListView.getPackedPositionType(id)==ExpandableListView.PACKED_POSITION_TYPE_GROUP)
				{	
					int groupPosition = ExpandableListView.getPackedPositionGroup(id);
					
					Intent i=new Intent(getApplicationContext(),RecipeInfo.class);
					i.putExtra("recipe", recipes.get(groupPosition));
  		      		startActivity(i); 
  		      		return true;
				}
				return false;
			}
    	});
		
	}
	
	@Override
	protected void onPause()
	{
		Context context = getApplicationContext();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> tasks = activityManager.getRunningTasks(1);
        if (!tasks.isEmpty()) {
          ComponentName topActivity = tasks.get(0).topActivity; 
          if (!topActivity.getPackageName().equals(context.getPackageName())) {
            Intent service = new Intent(getApplicationContext(), MusicService.class);
            stopService(service);
          }
        }
        super.onPause();

	}
	
	@Override
	protected void onResume()
	{
	  Intent intent = new Intent();
  	  intent.setClass(getApplicationContext(), MusicService.class); 
  	  getApplicationContext().startService(intent);
  	  super.onResume();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fridge_recipe_results, menu);
		
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
	    
	    else if(keyCode == KeyEvent.KEYCODE_BACK)
	    {
        		Intent i=new Intent(getApplicationContext(),Fridge.class);
	      		startActivity(i);
	    }
	    
	    return super.onKeyDown(keyCode, event);
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
				rec = "\t\t(Needed)\t" + rec;
			else
				rec = "\t\t\t\t\t\t\t\t" + rec;
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
	
	public ArrayList<ExpandListGroup> SetStandardGroups() 
	{
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
    	
        return list;
    }

}
