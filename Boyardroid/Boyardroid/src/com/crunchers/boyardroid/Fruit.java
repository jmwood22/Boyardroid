package com.crunchers.boyardroid;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Fruit extends Activity 
{

	private Button findRecipes, add;
	private CheckBox apple, orange, lime, blueberry, grape, banana, lemon;
	
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> ingredients = new ArrayList<String>();
	
	private ListManager lm = new ListManager();
	
	private DataBaseHelper db;
	private static SQLiteDatabase database;
	private Cursor c;
	
	private MediaPlayer mp;
	
	private static boolean listToggle = false;
	
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
		
		if(listToggle)
		{
			setContentView(R.layout.ingredient_list);
			
			if(ingredients.size()==0)
				getIngredients();
			
			listView = (ListView)findViewById(R.id.listView1);
			adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_multiple_choice, ingredients );
			listView.setAdapter(adapter);
			listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	    	listView.setOnItemClickListener(new OnItemClickListener(){
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id){
					CheckedTextView check = (CheckedTextView)view;
					if(check.isChecked())
					{
						check.setChecked(false);
						lm.removeFromTempList(ingredients.get(position));
					}
					else
					{
						check.setChecked(true);
						lm.addToTempList(ingredients.get(position));
					}
				}
	    	});
		}
		
		else
		{
		setContentView(R.layout.activity_fruit);
		
		
		apple = (CheckBox)findViewById(R.id.apple);
		apple.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Fruit.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Apple");
			  else
				  lm.removeFromTempList("Apple");
		  }
		});
		
		
		banana = (CheckBox)findViewById(R.id.banana);
		banana.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Fruit.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Banana");
			  else
				  lm.removeFromTempList("Banana");
		  }
		});
		
		
		orange = (CheckBox)findViewById(R.id.orange);
		orange.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Fruit.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Orange");
			  else
				  lm.removeFromTempList("Orange");
		  }
		});
		
		
		lemon = (CheckBox)findViewById(R.id.lemon);
		lemon.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Fruit.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Lemon");
			  else
				  lm.removeFromTempList("Lemon");
		  }
		});
		
		
		lime = (CheckBox)findViewById(R.id.lime);
		lime.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Fruit.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Lime");
			  else
				  lm.removeFromTempList("Lime");
		  }
		});
		
		
		blueberry = (CheckBox)findViewById(R.id.blueberry);
		blueberry.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Fruit.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Blueberry");
			  else
				  lm.removeFromTempList("Blueberry");
		  }
		});
		
		
		grape = (CheckBox)findViewById(R.id.grape);
		grape.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Fruit.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Grape");
			  else
				  lm.removeFromTempList("Grape");
		  }
		});
		}
		
		
		findRecipes = (Button)findViewById(R.id.findRecipes);
		findRecipes.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if(listToggle)
				  listToggle = false;
			  else
				  listToggle = true;
			  
	  			 
				  mp = MediaPlayer.create(Fruit.this, R.raw.search);
				  mp.start();
			  Intent intent = getIntent();
			  finish();
			  startActivity(intent);
		  }
		});
		
		
		add = (Button)findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Fruit.this, R.raw.select);
			  mp.start();
		      lm.mergeLists(); 
			  Intent i=new Intent(getApplicationContext(),QuickRecipe.class);
		       startActivity(i);
		  }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_fruit, menu);
		
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
	    if ( keyCode == KeyEvent.KEYCODE_MENU ) 
	    {  			 
			  mp = MediaPlayer.create(Fruit.this, R.raw.opendoor);
			  mp.start();
	    	Intent i=new Intent(getApplicationContext(),HomeScreen.class);
		    startActivity(i); 
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	private void getIngredients() 
	{
		String results = "Select Ingredient.Name From Ingredient Where Ingredient.Category = 'Fruit' Order By Ingredient.Name";
		
		c = database.rawQuery(results, null);
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			String veg = c.getString(0);
			
			if(!ingredients.contains(veg))
				ingredients.add(veg);
		}
		
		c.close();
	}

}
