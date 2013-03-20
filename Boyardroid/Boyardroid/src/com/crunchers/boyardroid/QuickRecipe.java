package com.crunchers.boyardroid;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class QuickRecipe extends Activity 
{
	
	Button fruit;
	Button meat;
	Button vegetable;
	Button grain;
	Button dairy;
	Button spice;
	
	static ArrayList<String> quickListItems = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quick_recipe);
		
		fruit = (Button)findViewById(R.id.fruit);
		fruit.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
		       Intent i=new Intent(getApplicationContext(),Fruit.class);
		       startActivity(i);
		  }
		});
		
		
		meat = (Button)findViewById(R.id.meat);
		meat.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
		       Intent i=new Intent(getApplicationContext(),Meat.class);
		       startActivity(i);
		  }
		});
		
		
		vegetable = (Button)findViewById(R.id.vegetable);
		vegetable.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
		       Intent i=new Intent(getApplicationContext(),Vegetable.class);
		       startActivity(i);
		  }
		});
		
		
		grain = (Button)findViewById(R.id.grain);
		grain.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
		       Intent i=new Intent(getApplicationContext(),Grain.class);
		       startActivity(i);
		  }
		});
		
		
		dairy = (Button)findViewById(R.id.dairy);
		dairy.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
		       Intent i=new Intent(getApplicationContext(),Dairy.class);
		       startActivity(i);
		  }
		});
		
		
		spice = (Button)findViewById(R.id.spice);
		spice.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
		       Intent i=new Intent(getApplicationContext(),Spice.class);
		       startActivity(i);
		  }
		});
	}
	
	public static void addToList(String ingredient)
	{
		if(Fridge.listItems.indexOf(ingredient)==-1)
			quickListItems.add(ingredient);
	}
	public static void removeFromList(String ingredient)
	{
		quickListItems.remove(ingredient);
	}
	
	public static void mergeLists()
	{
		
		for(int i = 0; i<quickListItems.size();i++)
		{
			addToFridge(quickListItems.get(i));
		}
		
		quickListItems.clear();
	}
	
	//adds ingredient to fridge
		public static void addToFridge(String ingredient)
		{
			Fridge.addToFridge(ingredient);
		}
		public static void removeFromFridge(String ingredient)
		{
			Fridge.removeFromFridge(ingredient);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_quick_recipe, menu);
		return true;
	}

	
	
}
