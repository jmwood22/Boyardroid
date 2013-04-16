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
import android.support.v4.app.NavUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class Vegetable extends Activity {

	private Button findRecipes, add;
	private CheckBox avocado, beet, blackOlive, broccolli, celery, carrot, cauliflower, cucumber;
	private CheckBox eggplant, garlic, ginger, greenBean, jalapeno, lettuce, olive, onion, peas;
	private CheckBox pepper, pickle, potato, pumpkin, radish, spinach, squash, tomato, yam, zuchini;
	
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> vegetables = new ArrayList<String>();
	
	private ListManager lm = new ListManager();
	
	private DataBaseHelper db;
	private static SQLiteDatabase database;
	private Cursor c;
	
	private MediaPlayer mp;
	
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
			
			if(vegetables.size()==0)
				getVegetables();
			
			listView = (ListView)findViewById(R.id.listView1);
			adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_multiple_choice, vegetables );
			listView.setAdapter(adapter);
			listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	    	listView.setOnItemClickListener(new OnItemClickListener(){
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id){
					CheckedTextView check = (CheckedTextView)view;
					if(check.isChecked())
					{
						check.setChecked(false);
						lm.removeFromTempList(vegetables.get(position));
					}
					else
					{
						check.setChecked(true);
						lm.addToTempList(vegetables.get(position));
					}
				}
	    	});
		}
		
		else
		{
		setContentView(R.layout.activity_vegetable);
		
		avocado = (CheckBox)findViewById(R.id.avocado);
		avocado.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Vegetable.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Zuchini");
			  else
				  lm.removeFromTempList("Zuchini");
		  }
		});
		
		
		}
		
		findRecipes = (Button)findViewById(R.id.findRecipes);
		findRecipes.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  if(listToggle)
				  listToggle = false;
			  else
				  listToggle = true;
			  

			  mp = MediaPlayer.create(Vegetable.this, R.raw.search);
			  mp.start();
			  Intent intent = getIntent();
			  finish();
			  startActivity(intent);
		  }
		});
		
		
			add = (Button)findViewById(R.id.add);
			add.setOnClickListener(new OnClickListener() 
			{
			public void onClick(View v)
		  	{	
		      	lm.mergeLists(); 
				 mp = MediaPlayer.create(Vegetable.this, R.raw.select);
				 mp.start();
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
	private void getVegetables() 
	{
		String results = "Select Ingredient.Name From Ingredient Where Ingredient.Category = 'Veggie' Order By Ingredient.Name";
		
		c = database.rawQuery(results, null);
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			String veg = c.getString(0);
			
			if(!vegetables.contains(veg))
				vegetables.add(veg);
		}
		
		c.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_vegetable, menu);
		
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
	    if ( keyCode == KeyEvent.KEYCODE_MENU ) 
	    {
			  mp = MediaPlayer.create(Vegetable.this, R.raw.opendoor);
			  mp.start();
	    	Intent i=new Intent(getApplicationContext(),HomeScreen.class);
		    startActivity(i); 
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
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
