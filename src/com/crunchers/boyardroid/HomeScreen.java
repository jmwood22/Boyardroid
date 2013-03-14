package com.crunchers.boyardroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeScreen extends Activity 
{

Button fridge;
Button quickRecipe;
@Override
public void onCreate(Bundle savedInstanceState) 
{
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.activity_home_screen);
	 fridge=(Button)findViewById(R.id.fridge);
	 fridge.setOnClickListener(new OnClickListener()
	 {
	  public void onClick(View v)
	   {
	       Intent i=new Intent(getApplicationContext(),Fridge.class);
	       startActivity(i);
	    }
	 });
	

	quickRecipe=(Button)findViewById(R.id.quick_recipe);
	quickRecipe.setOnClickListener(new OnClickListener()
	{
	 public void onClick(View v)
	  {
	      Intent i=new Intent(getApplicationContext(),QuickRecipe.class);
	      startActivity(i);
	   }
	}
	);
}



}
