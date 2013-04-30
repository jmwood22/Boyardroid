package com.crunchers.boyardroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class RecipeInfo extends Activity {
	
	private String recipe;
	private String recipeInfo;
	private ArrayList<String> ingredients = new ArrayList<String>();
	private ArrayList<String> tempList = new ArrayList<String>();
	private TextView textView;
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private ListManager lm = new ListManager();
	private DataBaseHelper db;
	private static SQLiteDatabase database;
	private Cursor c;
	private Button addToFav;
	
	private MediaPlayer mp;

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
		
		setContentView(R.layout.activity_recipe_info);
		
		textView = (TextView)this.findViewById(R.id.textView1);
		textView.setMovementMethod(new ScrollingMovementMethod());
		
		Intent i = getIntent();
		recipe = i.getExtras().getString("recipe");
		setTitle(recipe);
		
		addToFav = (Button)findViewById(R.id.button1);
		
		if(checkFavRecipe())
			addToFav.setText("Remove From Favorites?");
		else
			addToFav.setText("Add To Favorites?");
		
		addToFav.setOnClickListener(new OnClickListener() 
		{
		  public void onClick(View v)
		  {
			 toggleFav();
		  }
		});
		
		addToFrequency();
		getRecipeInfo();
		findIngredients();
		
		textView.setText(recipeInfo);
	}

	protected void toggleFav() 
	{
		if(checkFavRecipe())
		{
			 String fav = "Update Recipe Set Favorite = 0 Where Name = '" + recipe + "'";
				
			 database.execSQL(fav);
			  
			 Toast.makeText(getApplicationContext(), "Unfavorited", Toast.LENGTH_SHORT).show();
			 Intent intent = getIntent();
			 finish();
			 startActivity(intent);
		}
		
		else
		{
			 String fav = "Update Recipe Set Favorite = 1 Where Name = '" + recipe + "'";
				
			 database.execSQL(fav);
			  
			 Toast.makeText(getApplicationContext(), "Favorited", Toast.LENGTH_SHORT).show();
			 Intent intent = getIntent();
			 finish();
			 startActivity(intent);
		}
	}

	private boolean checkFavRecipe() 
	{
		String results = "Select Recipe.Favorite From Recipe Where Recipe.Name = '" + recipe + "'";
		String val;
		c = database.rawQuery(results, null);
		
		c.moveToFirst();
		
		val = c.getString(0);
		
		c.close();
		
		if(val.equals("1"))
			return true;
		else
			return false;
	}

	private void addToFrequency() 
	{
		String freq = "Update Recipe Set Frequency = Frequency + 1 Where Name = '" + recipe + "'";
		
		database.execSQL(freq);
	}

	private void getRecipeInfo() 
	{
		String results = "Select Recipe.Info From Recipe Where Recipe.Name = '" + recipe + "'";
		
		c = database.rawQuery(results, null);
		
		c.moveToFirst();
		
		recipeInfo = c.getString(0);
		
		c.close();
	}
	
	public void findIngredients()
	{
		String results = "Select Fridge.Ingredient From Fridge Where Fridge.Ingredient In (Select Ingredient.Name From Ingredient Left Join RecipeContains On Ingredient._id = RecipeContains.Ingredient_id " +
							"Left Join Recipe On Recipe._id = RecipeContains.Recipe_id Where Recipe.Name = '" + recipe + "')";
		c = database.rawQuery(results, null);
		
		ingredients.clear();
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			String rec = c.getString(0);
			
			if(!ingredients.contains(rec))
				ingredients.add(rec);
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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recipe_info, menu);
		
		return true;
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) 
	{
	    if ( keyCode == KeyEvent.KEYCODE_MENU ) 
	    {  			 
			  mp = MediaPlayer.create(RecipeInfo.this, R.raw.opendoor);
			  mp.start();
	    	Intent i=new Intent(getApplicationContext(),HomeScreen.class);
		    startActivity(i); 
	        return true;
	    }
		
		
	    if(keyCode == KeyEvent.KEYCODE_BACK)
	    {
	    	
	    	if(ingredients.size()!=0)
	    	{
	    	final CharSequence[] items = new CharSequence[ingredients.size()];
	    	boolean[] checks = new boolean[ingredients.size()];
	    	for(int i = 0; i<ingredients.size(); i++)
	    	{
	    		items[i] = ingredients.get(i);
	    		checks[i] = false;
	    	}

	    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    	builder.setTitle("Would you like to remove any ingredients?");
	    	builder.setMultiChoiceItems(items, checks ,new DialogInterface.OnMultiChoiceClickListener() {
	    	    public void onClick(DialogInterface dialog, int item, boolean isChecked) {
	    	         if(isChecked)
	    	         {
	    	        	 tempList.add(ingredients.get(item));
	    	         }
	    	         else
	    	        	 tempList.remove(ingredients.get(item));
	    	    }
	    	});
	    	builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                	if(lm.getFlag())
                	{
                		for(int i = 0; i<tempList.size(); i++)
                    	{
                			lm.removeFromFridge(tempList.get(i));
                    	}
                    
                		Intent i=new Intent(getApplicationContext(),FridgeResults.class);
  		      			startActivity(i); 
                	}
                	
                	else
                	{
                		for(int i = 0; i<tempList.size(); i++)
                    	{
                			lm.removeFromQuickList(tempList.get(i));
                    	}
                    
                		Intent i=new Intent(getApplicationContext(),QuickRecipeResults.class);
  		      			startActivity(i);
                	}
                }
            });
	    	builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                	
                	if(lm.getFlag())
                	{
                		Intent i=new Intent(getApplicationContext(),FridgeResults.class);
  		      			startActivity(i);
                	}
                	else
                	{
                		Intent i=new Intent(getApplicationContext(),QuickRecipeResults.class);
  		      			startActivity(i);
                	}
                }
            });
	    	builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                	if(lm.getFlag())
                	{
                		//Intent i=new Intent(getApplicationContext(),FridgeResults.class);
  		      			//startActivity(i);
                	}
                	else
                	{
                		//Intent i=new Intent(getApplicationContext(),QuickRecipeResults.class);
  		      			//startActivity(i);
                	}
                }
            });
	    	AlertDialog alert = builder.create();
	    	alert.show();
	    	
	      }
	    	else
	    	{
	    		if(lm.getViewRecipes())
	    		{
	    			Intent i=new Intent(getApplicationContext(),Recipes.class);
	      			startActivity(i);
	    		}
	    		
	    		else if(lm.getFlag())
            	{
            		Intent i=new Intent(getApplicationContext(),FridgeResults.class);
		      			startActivity(i);
            	}
            	else
            	{
            		Intent i=new Intent(getApplicationContext(),QuickRecipeResults.class);
		      			startActivity(i);
            	}
	    	}
	    }
	    return super.onKeyDown(keyCode, event);
	}

}
