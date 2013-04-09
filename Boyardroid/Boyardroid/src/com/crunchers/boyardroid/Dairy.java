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

	private Button findRecipes,add;
	private CheckBox bleuCheese, butter, cheese, cheese2, feta, gouda, milk;
	private CheckBox mozzarella, munster, parmesan, pepperjack, provolone, sourCream, swiss;
	
	private ListManager lm = new ListManager();
	
	
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
				  lm.addToTempList("Bleu Cheese");
			  else
				  lm.removeFromTempList("Bleu Cheese");
		  }
		});
		
		butter = (CheckBox)findViewById(R.id.butter);
		butter.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Butter");
			  else
				  lm.removeFromTempList("Butter");
		  }
		});
		
		
		cheese = (CheckBox)findViewById(R.id.cheese);
		cheese.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Cheese");
			  else
				  lm.removeFromTempList("Cheese");
		  }
		});
		
		cheese2 = (CheckBox)findViewById(R.id.cheese2);
		cheese2.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Cheese 2");
			  else
				  lm.removeFromTempList("Cheese 2");
		  }
		});
		
		
		feta = (CheckBox)findViewById(R.id.feta);
		feta.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Feta");
			  else
				  lm.removeFromTempList("Feta");
		  }
		});
		
		gouda = (CheckBox)findViewById(R.id.gouda);
		gouda.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Gouda");
			  else
				  lm.removeFromTempList("Gouda");
		  }
		});
		
		
		milk = (CheckBox)findViewById(R.id.milk);
		milk.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Milk");
			  else
				  lm.removeFromTempList("Milk");
		  }
		});
		
		mozzarella = (CheckBox)findViewById(R.id.mozzarella);
		mozzarella.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Mozzarella");
			  else
				  lm.removeFromTempList("Mozzarella");
		  }
		});
		
		
		munster = (CheckBox)findViewById(R.id.munster);
		munster.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Munster");
			  else
				  lm.removeFromTempList("Munster");
		  }
		});
		
		parmesan = (CheckBox)findViewById(R.id.parmesan);
		parmesan.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Parmesan");
			  else
				  lm.removeFromTempList("Parmesan");
		  }
		});
		
		pepperjack = (CheckBox)findViewById(R.id.pepperjack);
		pepperjack.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Pepperjack");
			  else
				  lm.removeFromTempList("Pepperjack");
		  }
		});
		
		provolone = (CheckBox)findViewById(R.id.provolone);
		provolone.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Provolone");
			  else
				  lm.removeFromTempList("Provolone");
		  }
		});
		
		sourCream = (CheckBox)findViewById(R.id.sourcream);
		sourCream.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Sour Cream");
			  else
				  lm.removeFromTempList("Sour Cream");
		  }
		});
		
		swiss = (CheckBox)findViewById(R.id.swiss);
		swiss.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Swiss");
			  else
				  lm.removeFromTempList("Swiss");
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
