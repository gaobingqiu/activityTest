package com.example.activitytest;

import com.example.activitytest.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class TurnActivity extends Activity {
	String tag = "Lifecycle";
	
	public void onClick(View view){
		Intent data = new Intent();
		EditText name = (EditText)findViewById(R.id.name02);
		data.setData(Uri.parse(name.getText().toString()));
		setResult(RESULT_OK, data);
		finish();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(tag, "TurnCreate");
		setContentView(R.layout.turnactivity);
	}
}
