package com.crunchers.boyardroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class QuickRecipe extends Activity {

	
	
	Button fruit;
	Button meat;
	Button vegetable;
	Button grain;
	Button dairy;
	Button spice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quick_recipe);
		
		fruit = (Button)findViewById(R.id.fruit);
		fruit.setOnClickListener(new OnClickListener() {
		  public void onClick(View v){
		       Intent i=new Intent(getApplicationContext(),Fruit.class);
		       startActivity(i);
		  }
		});
		meat = (Button)findViewById(R.id.meat);
		meat.setOnClickListener(new OnClickListener() {
		  public void onClick(View v){
		       Intent i=new Intent(getApplicationContext(),Meat.class);
		       startActivity(i);
		  }
		});
		vegetable = (Button)findViewById(R.id.vegetable);
		vegetable.setOnClickListener(new OnClickListener() {
		  public void onClick(View v){
		       Intent i=new Intent(getApplicationContext(),Vegetable.class);
		       startActivity(i);
		  }
		});
		grain = (Button)findViewById(R.id.grain);
		grain.setOnClickListener(new OnClickListener() {
		  public void onClick(View v){
		       Intent i=new Intent(getApplicationContext(),Grain.class);
		       startActivity(i);
		  }
		});
		dairy = (Button)findViewById(R.id.dairy);
		dairy.setOnClickListener(new OnClickListener() {
		  public void onClick(View v){
		       Intent i=new Intent(getApplicationContext(),Dairy.class);
		       startActivity(i);
		  }
		});
		spice = (Button)findViewById(R.id.spice);
		spice.setOnClickListener(new OnClickListener() {
		  public void onClick(View v){
		       Intent i=new Intent(getApplicationContext(),Spice.class);
		       startActivity(i);
		  }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_quick_recipe, menu);
		return true;
	}

	
	
}
