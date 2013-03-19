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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_quick_recipe, menu);
		return true;
	}

	
	
}
