package com.crunchers.boyardroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class Meat extends Activity {

	Button findRecipes;
	Button add;
	CheckBox bacon;
	CheckBox bologna;
	CheckBox chicken;
	CheckBox clam;
	CheckBox crab;
	CheckBox crawfish;
	CheckBox eggs;
	CheckBox groundBeef;
	CheckBox ham;
	CheckBox lamb;
	CheckBox lobster;
	CheckBox oyster;
	CheckBox pepperoni;
	CheckBox pork;
	CheckBox sausage;
	CheckBox scallop;
	CheckBox shrimp;
	CheckBox solami;
	CheckBox steak;
	CheckBox turkey;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meat);
		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);
		bacon = (CheckBox)findViewById(R.id.bacon);
		bacon.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Bacon");
			  else
				  QuickRecipe.removeFromList("Bacon");
		  }
		});
		
		bologna = (CheckBox)findViewById(R.id.bologna);
		bologna.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Bologna");
			  else
				  QuickRecipe.removeFromList("Bologna");
		  }
		});
		
		
		chicken = (CheckBox)findViewById(R.id.chicken);
		chicken.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Chicken");
			  else
				  QuickRecipe.removeFromList("Chicken");
		  }
		});
		
		clam = (CheckBox)findViewById(R.id.clam);
		clam.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Clam");
			  else
				  QuickRecipe.removeFromList("Clam");
		  }
		});
		
		
		crab = (CheckBox)findViewById(R.id.crab);
		crab.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Crab");
			  else
				  QuickRecipe.removeFromList("Crab");
		  }
		});
		
		crawfish = (CheckBox)findViewById(R.id.crawfish);
		crawfish.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Crawfish");
			  else
				  QuickRecipe.removeFromList("Crawfish");
		  }
		});
		
		
		eggs = (CheckBox)findViewById(R.id.eggs);
		eggs.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Eggs");
			  else
				  QuickRecipe.removeFromList("Eggs");
		  }
		});
		
		groundBeef = (CheckBox)findViewById(R.id.ground_beef);
		groundBeef.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Ground Beef");
			  else
				  QuickRecipe.removeFromList("Ground Beef");
		  }
		});
		
		
		ham = (CheckBox)findViewById(R.id.ham);
		ham.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Ham");
			  else
				  QuickRecipe.removeFromList("Ham");
		  }
		});
		
		lamb = (CheckBox)findViewById(R.id.lamb);
		lamb.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Lamb");
			  else
				  QuickRecipe.removeFromList("Lamb");
		  }
		});
		
		lobster = (CheckBox)findViewById(R.id.lobster);
		lobster.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("lobster");
			  else
				  QuickRecipe.removeFromList("lobster");
		  }
		});
		
		oyster = (CheckBox)findViewById(R.id.oyster);
		oyster.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Oyster");
			  else
				  QuickRecipe.removeFromList("Oyster");
		  }
		});
		
		pepperoni = (CheckBox)findViewById(R.id.pepperoni);
		pepperoni.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Pepperoni");
			  else
				  QuickRecipe.removeFromList("Pepperoni");
		  }
		});
		
		pork = (CheckBox)findViewById(R.id.pork);
		pork.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Pork");
			  else
				  QuickRecipe.removeFromList("Pork");
		  }
		});
		
		sausage = (CheckBox)findViewById(R.id.sausage);
		sausage.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Sausage");
			  else
				  QuickRecipe.removeFromList("Sausage");
		  }
		});
		
		scallop = (CheckBox)findViewById(R.id.scallop);
		scallop.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Scallop");
			  else
				  QuickRecipe.removeFromList("Scallop");
		  }
		});
		
		shrimp = (CheckBox)findViewById(R.id.shrimp);
		shrimp.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Shrimp");
			  else
				  QuickRecipe.removeFromList("Shrimp");
		  }
		});
		
		solami = (CheckBox)findViewById(R.id.solami);
		solami.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Solami");
			  else
				  QuickRecipe.removeFromList("Solami");
		  }
		});
		
		steak = (CheckBox)findViewById(R.id.steak);
		steak.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Steak");
			  else
				  QuickRecipe.removeFromList("Steak");
		  }
		});
		
		turkey = (CheckBox)findViewById(R.id.turkey);
		turkey.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Turkey");
			  else
				  QuickRecipe.removeFromList("Turkey");
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_meat, menu);
		return true;
	}

	

}
