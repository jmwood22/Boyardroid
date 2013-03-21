package com.crunchers.boyardroid;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class QuickRecipeList extends Activity 
{
	
	static ArrayList<String> quickListItems = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quick_recipe_list);
		
		ListView listView = (ListView)findViewById(R.id.listView1);
    	
    	final ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, quickListItems );
    	listView.setAdapter(adapter);
	}
	
	//adds ingredient to fridge
		public static void addToQuick(String ingredient)
		{
			quickListItems.add(ingredient);
		}
		public static void removeFromQuick(String ingredient)
		{
			quickListItems.remove(ingredient);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quick_recipe_list, menu);
		return true;
	}

}
