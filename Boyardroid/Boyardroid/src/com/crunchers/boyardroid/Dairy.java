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

public class Dairy extends Activity {

	Button findRecipes;
	Button add;
	CheckBox bleuCheese;
	CheckBox butter;
	CheckBox cheese;
	CheckBox cheese2;
	CheckBox feta;
	CheckBox gouda;
	CheckBox milk;
	CheckBox mozzarella;
	CheckBox munster;
	CheckBox parmesan;
	CheckBox pepperjack;
	CheckBox provolone;
	CheckBox sourCream;
	CheckBox swiss;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dairy);
		
		bleuCheese = (CheckBox)findViewById(R.id.bleucheese);
		bleuCheese.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Bleu Cheese");
			  else
				  QuickRecipe.removeFromList("Bleu Cheese");
		  }
		});
		
		butter = (CheckBox)findViewById(R.id.butter);
		butter.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Butter");
			  else
				  QuickRecipe.removeFromList("Butter");
		  }
		});
		
		
		cheese = (CheckBox)findViewById(R.id.cheese);
		cheese.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Cheese");
			  else
				  QuickRecipe.removeFromList("Cheese");
		  }
		});
		
		cheese2 = (CheckBox)findViewById(R.id.cheese2);
		cheese2.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Cheese 2");
			  else
				  QuickRecipe.removeFromList("Cheese 2");
		  }
		});
		
		
		feta = (CheckBox)findViewById(R.id.feta);
		feta.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Feta");
			  else
				  QuickRecipe.removeFromList("Feta");
		  }
		});
		
		gouda = (CheckBox)findViewById(R.id.gouda);
		gouda.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Gouda");
			  else
				  QuickRecipe.removeFromList("Gouda");
		  }
		});
		
		
		milk = (CheckBox)findViewById(R.id.milk);
		milk.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Milk");
			  else
				  QuickRecipe.removeFromList("Milk");
		  }
		});
		
		mozzarella = (CheckBox)findViewById(R.id.mozzarella);
		mozzarella.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Mozzarella");
			  else
				  QuickRecipe.removeFromList("Mozzarella");
		  }
		});
		
		
		munster = (CheckBox)findViewById(R.id.munster);
		munster.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Munster");
			  else
				  QuickRecipe.removeFromList("Munster");
		  }
		});
		
		parmesan = (CheckBox)findViewById(R.id.parmesan);
		parmesan.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Parmesan");
			  else
				  QuickRecipe.removeFromList("Parmesan");
		  }
		});
		
		pepperjack = (CheckBox)findViewById(R.id.pepperjack);
		pepperjack.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Pepperjack");
			  else
				  QuickRecipe.removeFromList("Pepperjack");
		  }
		});
		
		provolone = (CheckBox)findViewById(R.id.provolone);
		provolone.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Provolone");
			  else
				  QuickRecipe.removeFromList("Provolone");
		  }
		});
		
		sourCream = (CheckBox)findViewById(R.id.sourcream);
		sourCream.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Sour Cream");
			  else
				  QuickRecipe.removeFromList("Sour Cream");
		  }
		});
		
		swiss = (CheckBox)findViewById(R.id.swiss);
		swiss.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Swiss");
			  else
				  QuickRecipe.removeFromList("Swiss");
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
		getMenuInflater().inflate(R.menu.activity_dairy, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
