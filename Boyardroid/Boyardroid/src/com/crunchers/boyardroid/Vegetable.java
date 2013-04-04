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

	Button findRecipes;
	Button add;
	CheckBox avocado;
	CheckBox beet;
	CheckBox blackOlive;
	CheckBox broccolli;
	CheckBox celery;
	CheckBox carrot;
	CheckBox cauliflower;
	CheckBox cucumber;
	CheckBox eggplant;
	CheckBox garlic;
	CheckBox ginger;
	CheckBox greenBean;
	CheckBox jalapeno;
	CheckBox lettuce;
	CheckBox olive;
	CheckBox onion;
	CheckBox peas;
	CheckBox pepper;
	CheckBox pickle;
	CheckBox potato;
	CheckBox pumpkin;
	CheckBox radish;
	CheckBox spinach;
	CheckBox squash;
	CheckBox tomato;
	CheckBox yam;
	CheckBox zuchini;
	
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
				  QuickRecipe.addToList("Avocado");
			  else
				  QuickRecipe.removeFromList("Avocado");
		  }
		});
		
		beet = (CheckBox)findViewById(R.id.beet);
		beet.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Beet");
			  else
				  QuickRecipe.removeFromList("Beet");
		  }
		});
		
		blackOlive = (CheckBox)findViewById(R.id.blackolive);
		blackOlive.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Black Olive");
			  else
				  QuickRecipe.removeFromList("Black Olive");
		  }
		});
		
		broccolli = (CheckBox)findViewById(R.id.broccolli);
		broccolli.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Broccolli");
			  else
				  QuickRecipe.removeFromList("Broccolli");
		  }
		});
		
		celery = (CheckBox)findViewById(R.id.celery);
		celery.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Celery");
			  else
				  QuickRecipe.removeFromList("Celery");
		  }
		});
		
		carrot = (CheckBox)findViewById(R.id.carrot);
		carrot.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Carrot");
			  else
				  QuickRecipe.removeFromList("Carrot");
		  }
		});
		
		cauliflower = (CheckBox)findViewById(R.id.cauliflower);
		cauliflower.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Cauliflower");
			  else
				  QuickRecipe.removeFromList("Cauliflower");
		  }
		});
		
		cucumber = (CheckBox)findViewById(R.id.cucumber);
		cucumber.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Cucumber");
			  else
				  QuickRecipe.removeFromList("Cucumber");
		  }
		});
		
		eggplant = (CheckBox)findViewById(R.id.eggplant);
		eggplant.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Eggplant");
			  else
				  QuickRecipe.removeFromList("Eggplant");
		  }
		});
		
		garlic = (CheckBox)findViewById(R.id.garlic);
		garlic.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Garlic");
			  else
				  QuickRecipe.removeFromList("Garlic");
		  }
		});
		
		ginger = (CheckBox)findViewById(R.id.ginger);
		ginger.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Ginger");
			  else
				  QuickRecipe.removeFromList("Ginger");
		  }
		});
		
		greenBean = (CheckBox)findViewById(R.id.greenbean);
		greenBean.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Green Bean");
			  else
				  QuickRecipe.removeFromList("Green Bean");
		  }
		});
		
		jalapeno = (CheckBox)findViewById(R.id.jalapeno);
		jalapeno.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Jalapeno");
			  else
				  QuickRecipe.removeFromList("Jalapeno");
		  }
		});
		
		lettuce = (CheckBox)findViewById(R.id.lettuce);
		lettuce.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Lettuce");
			  else
				  QuickRecipe.removeFromList("Lettuce");
		  }
		});
		
		olive = (CheckBox)findViewById(R.id.olive);
		olive.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Olive");
			  else
				  QuickRecipe.removeFromList("Olive");
		  }
		});
		
		onion = (CheckBox)findViewById(R.id.onion);
		onion.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Onion");
			  else
				  QuickRecipe.removeFromList("Onion");
		  }
		});
		
		peas = (CheckBox)findViewById(R.id.peas);
		peas.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Peas");
			  else
				  QuickRecipe.removeFromList("Peas");
		  }
		});
		
		pepper = (CheckBox)findViewById(R.id.pepper);
		pepper.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Pepper");
			  else
				  QuickRecipe.removeFromList("Pepper");
		  }
		});
		
		pickle = (CheckBox)findViewById(R.id.pickle);
		pickle.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Pickle");
			  else
				  QuickRecipe.removeFromList("Pickle");
		  }
		});
		
		potato = (CheckBox)findViewById(R.id.potato);
		potato.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Potato");
			  else
				  QuickRecipe.removeFromList("Potato");
		  }
		});
		
		pumpkin = (CheckBox)findViewById(R.id.pumpkin);
		pumpkin.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Pumpkin");
			  else
				  QuickRecipe.removeFromList("Pumpkin");
		  }
		});
		
		radish = (CheckBox)findViewById(R.id.radish);
		radish.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Radish");
			  else
				  QuickRecipe.removeFromList("Radish");
		  }
		});
		
		spinach = (CheckBox)findViewById(R.id.spinach);
		spinach.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Spinach");
			  else
				  QuickRecipe.removeFromList("Spinach");
		  }
		});
		
		squash = (CheckBox)findViewById(R.id.squash);
		squash.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Squash");
			  else
				  QuickRecipe.removeFromList("Squash");
		  }
		});
		
		tomato = (CheckBox)findViewById(R.id.tomato);
		tomato.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Tomato");
			  else
				  QuickRecipe.removeFromList("Tomato");
		  }
		});
		
		yam = (CheckBox)findViewById(R.id.yam);
		yam.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Yam");
			  else
				  QuickRecipe.removeFromList("Yam");
		  }
		});
		
		zuchini = (CheckBox)findViewById(R.id.zuchini);
		zuchini.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  QuickRecipe.addToList("Zuchini");
			  else
				  QuickRecipe.removeFromList("Zuchini");
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
