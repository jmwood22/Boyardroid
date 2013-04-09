package com.crunchers.boyardroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class Grain extends Activity {

	private Button findRecipes, add;
	private CheckBox bagel, bread, cereal, cracker, oatmeal, pasta, rice;
	
	private ListManager lm = new ListManager();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grain);
		
		
		bagel = (CheckBox)findViewById(R.id.bagel);
		bagel.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Bagel");
			  else
				  lm.removeFromTempList("Bagel");
		  }
		});
		
		bread = (CheckBox)findViewById(R.id.bread);
		bread.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Bread");
			  else
				  lm.removeFromTempList("Bread");
		  }
		});
		
		cereal = (CheckBox)findViewById(R.id.cereal);
		cereal.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Cereal");
			  else
				  lm.removeFromTempList("Cereal");
		  }
		});
		
		cracker = (CheckBox)findViewById(R.id.cracker);
		cracker.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Cracker");
			  else
				  lm.removeFromTempList("Cracker");
		  }
		});
		
		oatmeal = (CheckBox)findViewById(R.id.oatmeal);
		oatmeal.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Oatmeal");
			  else
				  lm.removeFromTempList("Oatmeal");
		  }
		});
		
		pasta = (CheckBox)findViewById(R.id.pasta);
		pasta.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Pasta");
			  else
				  lm.removeFromTempList("Pasta");
		  }
		});
		
		rice = (CheckBox)findViewById(R.id.rice);
		rice.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Rice");
			  else
				  lm.removeFromTempList("Rice");
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
