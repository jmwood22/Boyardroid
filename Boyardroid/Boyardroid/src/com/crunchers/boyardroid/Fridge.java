package com.crunchers.boyardroid;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
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

public class Fridge extends Activity 
{
	Button add;
	Button remove;
	ListView listView;
	ArrayAdapter<String> adapter;
	static ArrayList<String> listItems = new ArrayList<String>();
	static ArrayList<String> tempList = new ArrayList<String>();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
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
	public static void addToFridge(String ingredient)
	{
		listItems.add(ingredient);
	}
	//removes ingredients from fridge
	public void removeFromFridge()
	{
		for (int i = 0; i < tempList.size(); i++) {
			listItems.remove(tempList.get(i));
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
    /** called when the user clicks the breakfast button */
    public void searchbreakfast(View view)
    {
    	//Do something in response to button
    }
    
    /** called when the user clicks the lunch button */
    public void searchlunch(View view)
    {
    	//Do something in response to button
    }
    
    /** called when the user clicks the dinner button */
    public void searchdinner(View view)
    {
    	//Do something in response to button
    }
    /** called when the user clicks the add ingredient button */
    public void addIngre(View view)
    {
    	//Do something in response to button
    }
    /** called when the user clicks the remove ingredient button */
    public void removIngre(View view)
    {
    	//Do something in response to button
    	
    }
    /** called when the user clicks the breakfast button */
    public void favRecipe(View view)
    {
    	//Do something in response to button
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
