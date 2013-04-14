package com.crunchers.boyardroid;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeScreen extends Activity 
{

private Button fridge;
private Button quickRecipe;
private Intent service;
private MediaPlayer mp;

@Override
public void onCreate(Bundle savedInstanceState) 
{
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.activity_home_screen);
	 service = new Intent(this,MusicService.class);
	 startService(service);
	 fridge=(Button)findViewById(R.id.fridge);
	 fridge.setOnClickListener(new OnClickListener()
	 {
	  public void onClick(View v)
	  {
		  mp = MediaPlayer.create(HomeScreen.this, R.raw.fridgeopen);
		  mp.start();
		  Intent i=new Intent(getApplicationContext(),Fridge.class);
	       startActivity(i);
	    }
	 });
	

	quickRecipe=(Button)findViewById(R.id.quick_recipe);
	quickRecipe.setOnClickListener(new OnClickListener()
	{
	 public void onClick(View v)
	  {
		  mp = MediaPlayer.create(HomeScreen.this, R.raw.quickrecipeopen);
		  mp.start();
		 Intent i=new Intent(getApplicationContext(),QuickRecipeList.class);
	      startActivity(i);
	   }
	}
	);
}

@Override
public void onDestroy()
{
	stopService(service);
	super.onDestroy();
}

}
