package com.crunchers.boyardroid;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class QuickRecipeList extends Activity 
{
	Button add;
	Button remove;
	ListView listView;
	ArrayAdapter<String> adapter;
	static ArrayList<String> quickListItems = new ArrayList<String>();

	static ArrayList<String> tempList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quick_recipe_list);
		
		listView = (ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_multiple_choice, quickListItems );
		listView.setAdapter(adapter);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setOnItemClickListener(new OnItemClickListener(){
			
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				CheckedTextView check = (CheckedTextView)view;
				if(check.isChecked())
				{
					check.setChecked(false);
					tempList.remove(quickListItems.get(position));
				}
				else
				{
					check.setChecked(true);
					tempList.add(quickListItems.get(position));
				}
			}

    	});
		add = (Button)findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  HomeScreen.fridgeList = false;
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
	
	public void removeFromFridge()
	{
		for (int i = 0; i < tempList.size(); i++) {
			quickListItems.remove(tempList.get(i));
			adapter.notifyDataSetChanged();
		}
		tempList.clear();
		for(int i = 0; i < quickListItems.size();i++){
			listView.setItemChecked(i, false);
		}
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