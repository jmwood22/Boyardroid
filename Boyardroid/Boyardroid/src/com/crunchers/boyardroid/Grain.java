package com.crunchers.boyardroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.support.v4.app.NavUtils;

public class Grain extends Activity {

	Button findRecipes;
	Button add;
	CheckBox bagel;
	CheckBox bread;
	CheckBox cereal;
	CheckBox cracker;
	CheckBox oatmeal;
	CheckBox pasta;
	CheckBox rice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grain);
		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);
		bagel = (CheckBox)findViewById(R.id.bagel);
		bagel.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Bagel");
			  else
				  QuickRecipe.removeFromList("Bagel");
		  }
		});
		
		bread = (CheckBox)findViewById(R.id.bread);
		bread.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Bread");
			  else
				  QuickRecipe.removeFromList("Bread");
		  }
		});
		
		cereal = (CheckBox)findViewById(R.id.cereal);
		cereal.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Cereal");
			  else
				  QuickRecipe.removeFromList("Cereal");
		  }
		});
		
		cracker = (CheckBox)findViewById(R.id.cracker);
		cracker.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Cracker");
			  else
				  QuickRecipe.removeFromList("Cracker");
		  }
		});
		
		oatmeal = (CheckBox)findViewById(R.id.oatmeal);
		oatmeal.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Oatmeal");
			  else
				  QuickRecipe.removeFromList("Oatmeal");
		  }
		});
		
		pasta = (CheckBox)findViewById(R.id.pasta);
		pasta.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Pasta");
			  else
				  QuickRecipe.removeFromList("Pasta");
		  }
		});
		
		rice = (CheckBox)findViewById(R.id.rice);
		rice.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Rice");
			  else
				  QuickRecipe.removeFromList("Rice");
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
		getMenuInflater().inflate(R.menu.activity_grain, menu);
		return true;
	}

	//@Override(for the home button once we add it)
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

}
