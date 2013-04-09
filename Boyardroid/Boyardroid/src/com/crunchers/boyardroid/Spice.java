package com.crunchers.boyardroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class Spice extends Activity {
	
	private Button findRecipes, add;
	private CheckBox jelly, ketchup, mustard, peanutbutter, pepper, salt, spice;
	
	private ListManager lm = new ListManager();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spice);

		
		jelly = (CheckBox)findViewById(R.id.jelly);
		jelly.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Jelly");
			  else
				  lm.removeFromTempList("Jelly");
		  }
		});
		
		ketchup = (CheckBox)findViewById(R.id.ketchup);
		ketchup.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Ketchup");
			  else
				  lm.removeFromTempList("Ketchup");
		  }
		});
		
		mustard = (CheckBox)findViewById(R.id.mustard);
		mustard.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Mustard");
			  else
				  lm.removeFromTempList("Mustard");
		  }
		});
		
		peanutbutter = (CheckBox)findViewById(R.id.peanutbutter);
		peanutbutter.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("PeanutButter");
			  else
				  lm.removeFromTempList("PeanutButter");
		  }
		});
		
		pepper = (CheckBox)findViewById(R.id.pepper);
		pepper.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Pepper");
			  else
				  lm.removeFromTempList("Pepper");
		  }
		});
		
		salt = (CheckBox)findViewById(R.id.salt);
		salt.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Salt");
			  else
				  lm.removeFromTempList("Salt");
		  }
		});
		
		spice = (CheckBox)findViewById(R.id.spice);
		spice.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Spice");
			  else
				  lm.removeFromTempList("Spice");
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
		      lm.mergeLists(); 
			  Intent i=new Intent(getApplicationContext(),QuickRecipe.class);
		       startActivity(i);
		  }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_spice, menu);
		return true;
	}

	//@Override(might need for the home button)
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
