package com.crunchers.boyardroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Main extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void onClick(DialogInterface dialog, int which) {
		switch(which) {
		case DialogInterface.BUTTON_POSITIVE:
			Intent i = new Intent(getApplicationContext(), QuickRecipe.class);
			startActivity(i);
			break;
		case DialogInterface.BUTTON_NEGATIVE:
			//Do nothing
		}
		
	}
	
	public void dialogBtn(View v) {
		new AlertDialog.Builder(this)
		.setTitle("More?")
		.setMessage("Add more ingredients?")
		.setPositiveButton("Yes", this)
		.setNegativeButton("No", this)
		.show();
	}

}
