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

	private Button findRecipes, add;
	private CheckBox apple, orange, lime, blueberry, grape, banana, lemon;
	
	private ListManager lm = new ListManager();
	
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
				  lm.addToTempList("Apple");
			  else
				  lm.removeFromTempList("Apple");
		  }
		});
		
		
		banana = (CheckBox)findViewById(R.id.banana);
		banana.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Banana");
			  else
				  lm.removeFromTempList("Banana");
		  }
		});
		
		
		orange = (CheckBox)findViewById(R.id.orange);
		orange.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Orange");
			  else
				  lm.removeFromTempList("Orange");
		  }
		});
		
		
		lemon = (CheckBox)findViewById(R.id.lemon);
		lemon.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Lemon");
			  else
				  lm.removeFromTempList("Lemon");
		  }
		});
		
		
		lime = (CheckBox)findViewById(R.id.lime);
		lime.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Lime");
			  else
				  lm.removeFromTempList("Lime");
		  }
		});
		
		
		blueberry = (CheckBox)findViewById(R.id.blueberry);
		blueberry.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Blueberry");
			  else
				  lm.removeFromTempList("Blueberry");
		  }
		});
		
		
		grape = (CheckBox)findViewById(R.id.grape);
		grape.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Grape");
			  else
				  lm.removeFromTempList("Grape");
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
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_fruit, menu);
		return true;
	}

}
