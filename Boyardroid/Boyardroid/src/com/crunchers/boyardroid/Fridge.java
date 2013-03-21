package com.crunchers.boyardroid;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class Fridge extends Activity 
{
	Button add;
	static ArrayList<String> listItems = new ArrayList<String>();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);
        
        add = (Button)findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
		       Intent i=new Intent(getApplicationContext(),QuickRecipe.class);
		       startActivity(i);
		  }
		});
          
        //TEST OF LISTVIEW AND SCROLL FUNCTION!
        ListView listView = (ListView)findViewById(R.id.listView1);
    	/*listItems.add("Chicken");
    	listItems.add("Lettuce");
    	listItems.add("Tomatoes");
    	listItems.add("Eggs");
    	listItems.add("Ketchup");
    	listItems.add("Bread");
    	listItems.add("Swiss Cheese");*/
    	final ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, listItems );
    	listView.setAdapter(adapter);
    	
    }
	
	//adds ingredient to fridge
	public static void addToFridge(String ingredient)
	{
		listItems.add(ingredient);
	}
	public static void removeFromFridge(String ingredient)
	{
		listItems.remove(ingredient);
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
