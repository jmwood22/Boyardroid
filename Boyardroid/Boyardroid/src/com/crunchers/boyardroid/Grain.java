package com.crunchers.boyardroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class Grain extends Activity {

	private Button findRecipes, add;
	private CheckBox bagel, bread, cereal, cracker, oatmeal, pasta, rice;
	
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> ingredients = new ArrayList<String>();
	
	private ListManager lm = new ListManager();
	
	private MediaPlayer mp;
	
	private DataBaseHelper db;
	private static SQLiteDatabase database;
	private Cursor c;
	
	private static boolean listToggle = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		db = new DataBaseHelper(this);
		 
		 try {
		  
		 db.createDataBase();
		  
		 } catch (IOException ioe) {
		  
		 throw new Error("Unable to create database");
		  
		 }
		  
		 try {
		  
		 db.openDataBase();
		  
		 }catch(SQLException sqle){
		  
		 throw sqle;
		  
		 }
		 
		database = db.getWritableDatabase();
		
		if(listToggle)
		{
			setContentView(R.layout.ingredient_list);
			
			if(ingredients.size()==0)
				getIngredients();
			
			listView = (ListView)findViewById(R.id.listView1);
			adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_multiple_choice, ingredients );
			listView.setAdapter(adapter);
			listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	    	listView.setOnItemClickListener(new OnItemClickListener(){
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id){
					CheckedTextView check = (CheckedTextView)view;
					if(check.isChecked())
					{
						check.setChecked(false);
						lm.removeFromTempList(ingredients.get(position));
					}
					else
					{
						check.setChecked(true);
						lm.addToTempList(ingredients.get(position));
					}
				}
	    	});
		}
		
		else
		{
		setContentView(R.layout.activity_grain);
		
		
		bagel = (CheckBox)findViewById(R.id.bagel);
		bagel.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  mp = MediaPlayer.create(Grain.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Grain.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Grain.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Grain.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Grain.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Grain.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Grain.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Rice");
			  else
				  lm.removeFromTempList("Rice");
		  }
		});
		}
		
		findRecipes = (Button)findViewById(R.id.findRecipes);
		findRecipes.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  mp = MediaPlayer.create(Grain.this, R.raw.search);
			  mp.start();
			  getIngredients();
			  Toast.makeText(getApplicationContext(), "Nothing to Toggle", Toast.LENGTH_LONG).show();
		  }
		});
		
		
		add = (Button)findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  mp = MediaPlayer.create(Grain.this, R.raw.select);
			  mp.start();
		      lm.mergeLists(); 
			  Intent i=new Intent(getApplicationContext(),QuickRecipe.class);
		       startActivity(i);
		  }
		});
		
	}

	@Override
	protected void onPause()
	{
		Context context = getApplicationContext();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> tasks = activityManager.getRunningTasks(1);
        if (!tasks.isEmpty()) {
          ComponentName topActivity = tasks.get(0).topActivity; 
          if (!topActivity.getPackageName().equals(context.getPackageName())) {
            Intent service = new Intent(getApplicationContext(), MusicService.class);
            stopService(service);
          }
        }
        super.onPause();

	}
	
	@Override
	protected void onResume()
	{
	  Intent intent = new Intent();
  	  intent.setClass(getApplicationContext(), MusicService.class); 
  	  getApplicationContext().startService(intent);
  	  super.onResume();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_grain, menu);
		
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
	    if ( keyCode == KeyEvent.KEYCODE_MENU ) 
	    {
			  mp = MediaPlayer.create(Grain.this, R.raw.opendoor);
			  mp.start();
	    	Intent i=new Intent(getApplicationContext(),HomeScreen.class);
		    startActivity(i); 
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
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

	
	private void getIngredients() 
	{
		String results = "Select Recipe.Info From Recipe Where Recipe._id = 1";
		
		c = database.rawQuery(results, null);
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			String veg = c.getString(0);
			
			if(!ingredients.contains(veg))
				ingredients.add(veg);
		}
		
		c.close();
	}
}
