package com.crunchers.boyardroid;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
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
protected void onPause() {
  Context context = getApplicationContext();
  ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
  List<RunningTaskInfo> tasks = activityManager.getRunningTasks(1);
  if (!tasks.isEmpty()) {
    ComponentName topActivity = tasks.get(0).topActivity; 
    if (!topActivity.getPackageName().equals(context.getPackageName())) 
      stopService(service);   
  }
  super.onPause();
}

@Override
public void onResume()
{
	startService(service);
	super.onResume();
}

@Override
public void onDestroy()
{
	stopService(service);
	super.onDestroy();
}

}
