package com.crunchers.boyardroid;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
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

public class Meat extends Activity {

	private Button findRecipes, add;
	private CheckBox bacon, bologna, chicken, clam, crab, crawfish, eggs, groundBeef, ham, lamb;
	private CheckBox lobster, oyster, pepperoni, pork, sausage, scallop, shrimp, solami, steak, turkey;
	
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> ingredients = new ArrayList<String>();
	
	private ListManager lm = new ListManager();
	
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
		setContentView(R.layout.activity_meat);
		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);
		bacon = (CheckBox)findViewById(R.id.bacon);
		bacon.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Bacon");
			  else
				  lm.removeFromTempList("Bacon");
		  }
		});
		
		bologna = (CheckBox)findViewById(R.id.bologna);
		bologna.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Bologna");
			  else
				  lm.removeFromTempList("Bologna");
		  }
		});
		
		
		chicken = (CheckBox)findViewById(R.id.chicken);
		chicken.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Chicken");
			  else
				  lm.removeFromTempList("Chicken");
		  }
		});
		
		clam = (CheckBox)findViewById(R.id.clam);
		clam.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Clam");
			  else
				  lm.removeFromTempList("Clam");
		  }
		});
		
		
		crab = (CheckBox)findViewById(R.id.crab);
		crab.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Crab");
			  else
				  lm.removeFromTempList("Crab");
		  }
		});
		
		crawfish = (CheckBox)findViewById(R.id.crawfish);
		crawfish.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Crawfish");
			  else
				  lm.removeFromTempList("Crawfish");
		  }
		});
		
		
		eggs = (CheckBox)findViewById(R.id.eggs);
		eggs.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Eggs");
			  else
				  lm.removeFromTempList("Eggs");
		  }
		});
		
		groundBeef = (CheckBox)findViewById(R.id.ground_beef);
		groundBeef.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Ground Beef");
			  else
				  lm.removeFromTempList("Ground Beef");
		  }
		});
		
		
		ham = (CheckBox)findViewById(R.id.ham);
		ham.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Ham");
			  else
				  lm.removeFromTempList("Ham");
		  }
		});
		
		lamb = (CheckBox)findViewById(R.id.lamb);
		lamb.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Lamb");
			  else
				  lm.removeFromTempList("Lamb");
		  }
		});
		
		lobster = (CheckBox)findViewById(R.id.lobster);
		lobster.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("lobster");
			  else
				  lm.removeFromTempList("lobster");
		  }
		});
		
		oyster = (CheckBox)findViewById(R.id.oyster);
		oyster.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Oyster");
			  else
				  lm.removeFromTempList("Oyster");
		  }
		});
		
		pepperoni = (CheckBox)findViewById(R.id.pepperoni);
		pepperoni.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Pepperoni");
			  else
				  lm.removeFromTempList("Pepperoni");
		  }
		});
		
		pork = (CheckBox)findViewById(R.id.pork);
		pork.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Pork");
			  else
				  lm.removeFromTempList("Pork");
		  }
		});
		
		sausage = (CheckBox)findViewById(R.id.sausage);
		sausage.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Sausage");
			  else
				  lm.removeFromTempList("Sausage");
		  }
		});
		
		scallop = (CheckBox)findViewById(R.id.scallop);
		scallop.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Scallop");
			  else
				  lm.removeFromTempList("Scallop");
		  }
		});
		
		shrimp = (CheckBox)findViewById(R.id.shrimp);
		shrimp.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Shrimp");
			  else
				  lm.removeFromTempList("Shrimp");
		  }
		});
		
		solami = (CheckBox)findViewById(R.id.solami);
		solami.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Solami");
			  else
				  lm.removeFromTempList("Solami");
		  }
		});
		
		steak = (CheckBox)findViewById(R.id.steak);
		steak.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Steak");
			  else
				  lm.removeFromTempList("Steak");
		  }
		});
		
		turkey = (CheckBox)findViewById(R.id.turkey);
		turkey.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Turkey");
			  else
				  lm.removeFromTempList("Turkey");
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
		      lm.mergeLists(); 
			  Intent i=new Intent(getApplicationContext(),QuickRecipe.class);
		      startActivity(i);
		  }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_meat, menu);
		
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

	private void getIngredients() 
	{
		String results = "Select Ingredient.Name From Ingredient Where Ingredient.Category = 'Meat' Order By Ingredient.Name";
		
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
