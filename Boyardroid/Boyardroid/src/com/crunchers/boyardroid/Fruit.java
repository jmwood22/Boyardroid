package com.crunchers.boyardroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class Fruit extends Activity 
{

	Button findRecipes;
	Button add;
	CheckBox apple;
	CheckBox orange;
	CheckBox lime;
	CheckBox blueberry;
	CheckBox grape;
	CheckBox banana;
	CheckBox lemon;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fruit);
		
		
		apple = (CheckBox)findViewById(R.id.apple);
		apple.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Apple");
			  else
				  QuickRecipe.removeFromList("Apple");
		  }
		});
		
		
		banana = (CheckBox)findViewById(R.id.banana);
		banana.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Banana");
			  else
				  QuickRecipe.removeFromList("Banana");
		  }
		});
		
		
		orange = (CheckBox)findViewById(R.id.orange);
		orange.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Orange");
			  else
				  QuickRecipe.removeFromList("Orange");
		  }
		});
		
		
		lemon = (CheckBox)findViewById(R.id.lemon);
		lemon.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Lemon");
			  else
				  QuickRecipe.removeFromList("Lemon");
		  }
		});
		
		
		lime = (CheckBox)findViewById(R.id.lime);
		lime.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Lime");
			  else
				  QuickRecipe.removeFromList("Lime");
		  }
		});
		
		
		blueberry = (CheckBox)findViewById(R.id.blueberry);
		blueberry.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Blueberry");
			  else
				  QuickRecipe.removeFromList("Blueberry");
		  }
		});
		
		
		grape = (CheckBox)findViewById(R.id.grape);
		grape.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Grape");
			  else
				  QuickRecipe.removeFromList("Grape");
		  }
		});
		
		
		findRecipes = (Button)findViewById(R.id.findRecipes);
		findRecipes.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  
		  }
		});
		
		
		add = (Button)findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
		      QuickRecipe.mergeLists(); 
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

}
