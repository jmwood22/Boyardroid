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

public class Spice extends Activity {
	
	private Button findRecipes, add;
	private CheckBox jelly, ketchup, mustard, peanutbutter, pepper, salt, spice;
	
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> ingredients = new ArrayList<String>();
	
	private ListManager lm = new ListManager();
	
	private MediaPlayer mp;
	
	private DataBaseHelper db;
	private static SQLiteDatabase database;
	private Cursor c;
	
	private static boolean listToggle = false;

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
		setContentView(R.layout.activity_spice);

		
		jelly = (CheckBox)findViewById(R.id.jelly);
		jelly.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Spice.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Jelly");
			  else
				  lm.removeFromTempList("Jelly");
		  }
		});
		
		ketchup = (CheckBox)findViewById(R.id.ketchup);
		ketchup.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Spice.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Ketchup");
			  else
				  lm.removeFromTempList("Ketchup");
		  }
		});
		
		mustard = (CheckBox)findViewById(R.id.mustard);
		mustard.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Spice.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Mustard");
			  else
				  lm.removeFromTempList("Mustard");
		  }
		});
		
		peanutbutter = (CheckBox)findViewById(R.id.peanutbutter);
		peanutbutter.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Spice.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("PeanutButter");
			  else
				  lm.removeFromTempList("PeanutButter");
		  }
		});
		
		pepper = (CheckBox)findViewById(R.id.pepper);
		pepper.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Spice.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Pepper");
			  else
				  lm.removeFromTempList("Pepper");
		  }
		});
		
		salt = (CheckBox)findViewById(R.id.salt);
		salt.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Spice.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Salt");
			  else
				  lm.removeFromTempList("Salt");
		  }
		});
		
		spice = (CheckBox)findViewById(R.id.spice);
		spice.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Spice.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Spice");
			  else
				  lm.removeFromTempList("Spice");
		  }
		});
		}
		
		findRecipes = (Button)findViewById(R.id.findRecipes);
		findRecipes.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Spice.this, R.raw.search);
			  mp.start();
			  if(listToggle)
				  listToggle = false;
			  else
				  listToggle = true;
			  
			  
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
			  mp = MediaPlayer.create(Spice.this, R.raw.select);
			  mp.start();
		      lm.mergeLists(); 
			  Intent i=new Intent(getApplicationContext(),QuickRecipe.class);
		       startActivity(i);
		  }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_spice, menu);
		
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
	    if ( keyCode == KeyEvent.KEYCODE_MENU ) 
	    {  			 
			  mp = MediaPlayer.create(Spice.this, R.raw.opendoor);
			  mp.start();
	    	Intent i=new Intent(getApplicationContext(),HomeScreen.class);
		    startActivity(i); 
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}

	//@Override(might need for the home button)
	//public boolean onOptionsItemSelected(MenuItem item) {
	//	switch (item.getItemId()) {
	//	case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
	//		NavUtils.navigateUpFromSameTask(this);
	//		return true;
	//	}
	//	return super.onOptionsItemSelected(item);
	//}

	private void getIngredients() 
	{
		String results = "Select Ingredient.Name From Ingredient Where Ingredient.Category = 'Herb/Spice' OR Ingredient.Category = 'Spice/Herb' OR Ingredient.Category = 'Condiment' OR Ingredient.Category = 'General' OR Ingredient.Category = 'Sauce' Order By Ingredient.Name";
		
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
