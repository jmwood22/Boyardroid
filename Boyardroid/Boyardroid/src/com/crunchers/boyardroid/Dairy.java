package com.crunchers.boyardroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.support.v4.app.NavUtils;

public class Dairy extends Activity {

	private Button findRecipes,add;
	private CheckBox bleuCheese, butter, cheese, cheese2, feta, gouda, milk;
	private CheckBox mozzarella, munster, parmesan, pepperjack, provolone, sourCream, swiss;
	
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
		setContentView(R.layout.activity_dairy);
		
		bleuCheese = (CheckBox)findViewById(R.id.bleucheese);
		bleuCheese.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.click);
			  mp.start();
			  if (((CheckBox) v).isChecked())
				  lm.addToTempList("Swiss");
			  else
				  lm.removeFromTempList("Swiss");
		  }
		});
		}
		
		findRecipes = (Button)findViewById(R.id.findRecipes);
		findRecipes.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			  mp = MediaPlayer.create(Dairy.this, R.raw.search);
			  mp.start();
			  if(listToggle)
				  listToggle = false;
			  else
				  listToggle = true;
			  
			  
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
			  mp = MediaPlayer.create(Dairy.this, R.raw.select);
			  mp.start();
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
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
	    if ( keyCode == KeyEvent.KEYCODE_MENU ) 
	    {
			  mp = MediaPlayer.create(Dairy.this, R.raw.opendoor);
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
	
	private void getIngredients() 
	{
		String results = "Select Ingredient.Name From Ingredient Where Ingredient.Category = 'Dairy' Order By Ingredient.Name";
		
		c = database.rawQuery(results, null);
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			String veg = c.getString(0);
			
			if(!ingredients.contains(veg))
				ingredients.add(veg);
		}
		
		c.close();
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
	

}
