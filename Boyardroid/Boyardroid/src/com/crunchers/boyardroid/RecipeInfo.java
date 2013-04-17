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
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
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
		
		getRecipeInfo();
		
		textView.setText(recipeInfo);
	}

	private void getRecipeInfo() 
	{
		String results = "Select Recipe.Info From Recipe Where Recipe.Name = '" + recipe + "'";
		
		c = database.rawQuery(results, null);
		
		c.moveToFirst();
		
		recipeInfo = c.getString(0);
		
		c.close();
	}
	
	public void findIngredients(String recipe)
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
	    	LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
	    	View popupView = layoutInflater.inflate(R.layout.activity_popup_window, null);  
	        final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	        
	    	findIngredients(recipe);
	    	//setContentView(R.layout.activity_popup_window);
	    	listView = (ListView)popupView.findViewById(R.id.junk);
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
						tempList.remove(ingredients.get(position));
					}
					else
					{
						check.setChecked(true);
						tempList.add(ingredients.get(position));
					}
				}
				
				

	    	});  
	                
	        Button yes = (Button)popupView.findViewById(R.id.yes);
	        yes.setOnClickListener(new Button.OnClickListener(){
	        @Override
	        public void onClick(View v) {
	         // TODO Auto-generated method stub
	        	
	        	
	        	
	        	
	        	
	        	popupWindow.dismiss();
	        	if(lm.getFlag())
	        	{
	        		for(int i = 0; i < tempList.size(); i++)
		        	{
		        		lm.removeFromFridge(tempList.get(i));
		        	}
	        		Intent i=new Intent(getApplicationContext(),FridgeResults.class);
	  		      	startActivity(i); 
	        	}
	        	else
	        	{
	        		for(int i = 0; i < tempList.size(); i++)
		        	{
		        		lm.removeFromQuickList(tempList.get(i));
		        	}
	        		Intent i=new Intent(getApplicationContext(),QuickRecipeResults.class);
  		      		startActivity(i); 
	        	}
	        }});
	        
	        Button no = (Button)popupView.findViewById(R.id.no);
	        no.setOnClickListener(new Button.OnClickListener(){
	        @Override
	        public void onClick(View v) {
	         // TODO Auto-generated method stub
	        	//setContentView(R.layout.activity_recipe_info);
	        	popupWindow.dismiss();
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
	        }});
	                  
	        popupWindow.showAtLocation(popupView, 1, 1, 1);
	            
	      }
	       
	    
	    return super.onKeyDown(keyCode, event);
	}

}
