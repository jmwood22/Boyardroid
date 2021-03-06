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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class Fridge extends Activity 
{
	private Button add, remove, find, recipes;
	
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private static ArrayList<String> tempList = new ArrayList<String>();
	private Cursor c;
	
	private DataBaseHelper db;
	private static SQLiteDatabase database;
	
	private MediaPlayer mp;
	
	private ListManager lm = new ListManager();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
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
		 
		 if(lm.getFridgeList().size()==0)
		 {
			 getFridgeIngredients();
		 }
		 
        setContentView(R.layout.activity_fridge);
		listView = (ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_multiple_choice, lm.getFridgeList() );
		listView.setAdapter(adapter);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    	listView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				CheckedTextView check = (CheckedTextView)view;
				if(check.isChecked())
				{
					check.setChecked(false);
					tempList.remove(lm.getFridgeList().get(position));
				}
				else
				{
					check.setChecked(true);
					tempList.add(lm.getFridgeList().get(position));
				}
			}
			
			

    	});
    	
    	find = (Button)findViewById(R.id.button4);
    	find.setOnClickListener(new OnClickListener()
    	{
    		public void onClick(View v)
    		{
    				
    			if(lm.getFridgeList().size()>0)
    			{
    					database.execSQL("DELETE FROM Fridge");
    					for(int i = 0;i<lm.getFridgeList().size();i++)
    					{
    						database.execSQL("INSERT INTO Fridge (Ingredient) VALUES ('" + lm.getFridgeList().get(i) +"')");
    					}
    			}

  			  mp = MediaPlayer.create(Fridge.this, R.raw.search);
  			  mp.start();
    			Intent i=new Intent(getApplicationContext(),FridgeResults.class);
  		      	startActivity(i); 
    		}

			
    	});
    	
    	recipes = (Button)findViewById(R.id.button3);
    	recipes.setOnClickListener(new OnClickListener()
    	{
    		public void onClick(View v)
    		{
    			  mp = MediaPlayer.create(Fridge.this, R.raw.pot);
      			  mp.start();
    			Intent i = new Intent(getApplicationContext(),Recipes.class);
    			startActivity(i);
    		}
    	});
        
    	add = (Button)findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Fridge.this, R.raw.select);
			  mp.start();
			  lm.FridgeListTrue();
			  Intent i=new Intent(getApplicationContext(),QuickRecipe.class);
		      startActivity(i);
		  }
		});
		remove = (Button)findViewById(R.id.remove);
		remove.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {  			 
			  mp = MediaPlayer.create(Fridge.this, R.raw.drop);
			  mp.start();
		       removeFromFridge();
		  }
		});
				 
    }
	
	private void getFridgeIngredients() 
	{
		String results = "Select Fridge.Ingredient From Fridge Order By Fridge.Ingredient";
		c = database.rawQuery(results, null);


		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			String rec = c.getString(0);

			if(!lm.getFridgeList().contains(rec))
				lm.addToFridge(rec);
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
	
	/*public SparseBooleanArray tempArray()
	{
		SparseBooleanArray sp = listView.getCheckedItemPositions();
		return sp;
	}
	
	
	//adds ingredient to fridge
	public static void addToFridgeList(String ingredient)
	{
		lm.getFridgeList().add(ingredient);
	}
	
	
	*/
    //removes ingredients from fridge
	public void removeFromFridge()
	{
		for (int i = 0; i < tempList.size(); i++) {
			lm.getFridgeList().remove(tempList.get(i));
			database.execSQL("DELETE FROM Fridge WHERE Fridge.Ingredient = '" + tempList.get(i) + "'");
			adapter.notifyDataSetChanged();
		}
		tempList.clear();
		for(int i = 0; i < lm.getFridgeList().size();i++){
			listView.setItemChecked(i, false);
		}
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_fridge, menu); 
		
        return true;
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
	    if ( keyCode == KeyEvent.KEYCODE_MENU ) 
	    {
	    	Intent i=new Intent(getApplicationContext(),HomeScreen.class);
		    startActivity(i); 
	        return true;
	    }
	    
	    else if(keyCode == KeyEvent.KEYCODE_BACK)
	    {
	    	Intent i=new Intent(getApplicationContext(),HomeScreen.class);
		    startActivity(i); 
	        return true;
	    }
	    
	    return super.onKeyDown(keyCode, event);
	}
	
	
    /*
    public void onClick(DialogInterface dialog, int which) 
    {
		switch(which) {
		case DialogInterface.BUTTON_POSITIVE:
			Intent i = new Intent(getApplicationContext(), QuickRecipe.class);
			startActivity(i);
			break;
		case DialogInterface.BUTTON_NEGATIVE:
			//Do nothing
		}
		
	}
	
	public void dialogBtn(View v) 
	{
		new AlertDialog.Builder(this)
		.setTitle("More?")
		.setMessage("Add more ingredients?")
		.setPositiveButton("Yes", this)
		.setNegativeButton("No", this)
		.show();
	}*/

}
