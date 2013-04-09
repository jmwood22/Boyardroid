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

public class Vegetable extends Activity {

	private Button findRecipes, add;
	private CheckBox avocado, beet, blackOlive, broccolli, celery, carrot, cauliflower, cucumber;
	private CheckBox eggplant, garlic, ginger, greenBean, jalapeno, lettuce, olive, onion, peas;
	private CheckBox pepper, pickle, potato, pumpkin, radish, spinach, squash, tomato, yam, zuchini;
	
	private ListManager lm = new ListManager();
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vegetable);
		
		avocado = (CheckBox)findViewById(R.id.avocado);
		avocado.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Avocado");
			  else
				  lm.removeFromTempList("Avocado");
		  }
		});
		
		beet = (CheckBox)findViewById(R.id.beet);
		beet.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Beet");
			  else
				  lm.removeFromTempList("Beet");
		  }
		});
		
		blackOlive = (CheckBox)findViewById(R.id.blackolive);
		blackOlive.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Black Olive");
			  else
				  lm.removeFromTempList("Black Olive");
		  }
		});
		
		broccolli = (CheckBox)findViewById(R.id.broccolli);
		broccolli.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Broccolli");
			  else
				  lm.removeFromTempList("Broccolli");
		  }
		});
		
		celery = (CheckBox)findViewById(R.id.celery);
		celery.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Celery");
			  else
				  lm.removeFromTempList("Celery");
		  }
		});
		
		carrot = (CheckBox)findViewById(R.id.carrot);
		carrot.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Carrot");
			  else
				  lm.removeFromTempList("Carrot");
		  }
		});
		
		cauliflower = (CheckBox)findViewById(R.id.cauliflower);
		cauliflower.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Cauliflower");
			  else
				  lm.removeFromTempList("Cauliflower");
		  }
		});
		
		cucumber = (CheckBox)findViewById(R.id.cucumber);
		cucumber.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Cucumber");
			  else
				  lm.removeFromTempList("Cucumber");
		  }
		});
		
		eggplant = (CheckBox)findViewById(R.id.eggplant);
		eggplant.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Eggplant");
			  else
				  lm.removeFromTempList("Eggplant");
		  }
		});
		
		garlic = (CheckBox)findViewById(R.id.garlic);
		garlic.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Garlic");
			  else
				  lm.removeFromTempList("Garlic");
		  }
		});
		
		ginger = (CheckBox)findViewById(R.id.ginger);
		ginger.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Ginger");
			  else
				  lm.removeFromTempList("Ginger");
		  }
		});
		
		greenBean = (CheckBox)findViewById(R.id.greenbean);
		greenBean.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Green Bean");
			  else
				  lm.removeFromTempList("Green Bean");
		  }
		});
		
		jalapeno = (CheckBox)findViewById(R.id.jalapeno);
		jalapeno.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Jalapeno");
			  else
				  lm.removeFromTempList("Jalapeno");
		  }
		});
		
		lettuce = (CheckBox)findViewById(R.id.lettuce);
		lettuce.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Lettuce");
			  else
				  lm.removeFromTempList("Lettuce");
		  }
		});
		
		olive = (CheckBox)findViewById(R.id.olive);
		olive.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Olive");
			  else
				  lm.removeFromTempList("Olive");
		  }
		});
		
		onion = (CheckBox)findViewById(R.id.onion);
		onion.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Onion");
			  else
				  lm.removeFromTempList("Onion");
		  }
		});
		
		peas = (CheckBox)findViewById(R.id.peas);
		peas.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Peas");
			  else
				  lm.removeFromTempList("Peas");
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
		
		pickle = (CheckBox)findViewById(R.id.pickle);
		pickle.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Pickle");
			  else
				  lm.removeFromTempList("Pickle");
		  }
		});
		
		potato = (CheckBox)findViewById(R.id.potato);
		potato.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Potato");
			  else
				  lm.removeFromTempList("Potato");
		  }
		});
		
		pumpkin = (CheckBox)findViewById(R.id.pumpkin);
		pumpkin.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Pumpkin");
			  else
				  lm.removeFromTempList("Pumpkin");
		  }
		});
		
		radish = (CheckBox)findViewById(R.id.radish);
		radish.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Radish");
			  else
				  lm.removeFromTempList("Radish");
		  }
		});
		
		spinach = (CheckBox)findViewById(R.id.spinach);
		spinach.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Spinach");
			  else
				  lm.removeFromTempList("Spinach");
		  }
		});
		
		squash = (CheckBox)findViewById(R.id.squash);
		squash.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Squash");
			  else
				  lm.removeFromTempList("Squash");
		  }
		});
		
		tomato = (CheckBox)findViewById(R.id.tomato);
		tomato.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Tomato");
			  else
				  lm.removeFromTempList("Tomato");
		  }
		});
		
		yam = (CheckBox)findViewById(R.id.yam);
		yam.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Yam");
			  else
				  lm.removeFromTempList("Yam");
		  }
		});
		
		zuchini = (CheckBox)findViewById(R.id.zuchini);
		zuchini.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Zuchini");
			  else
				  lm.removeFromTempList("Zuchini");
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
		getMenuInflater().inflate(R.menu.activity_vegetable, menu);
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
