package com.example.activitytest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	String tag = "Lifecycle";
	String action = "com.example.activitytest.TurnActivity";
	int request_code = 1;

	public void onClick(View view) {
		startActivityForResult(new Intent(action), request_code);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == request_code) {
			if (resultCode == RESULT_OK) {
				EditText editText = (EditText) findViewById(R.id.name01);
				editText.setText(data.getData().toString());
				Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void clear(View view) {
		AlertDialog.Builder builder = new Builder(MainActivity.this);
		builder.setMessage("确认情况输入框内容吗？");
		builder.setTitle("提示");
		builder.setPositiveButton("确认", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				EditText editText = (EditText) findViewById(R.id.name01);
				editText.setText("");
				Log.d(tag, "清除输入框内容！");
			}
		});

		builder.setNegativeButton("取消", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.create().show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(tag, "Create");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onStart() {
		super.onStart();
		Log.d(tag, "onStart");
	}

	public void onRestart() {
		super.onRestart();
		Log.d(tag, "onRestart");
	}

	public void onResume() {
		super.onResume();
		Log.d(tag, "onResume");
	}

	public void onPause() {
		super.onPause();
		Log.d(tag, "onPause");
	}

	public void onStop() {
		super.onStop();
		Log.d(tag, "onStop");
	}

	public void onDestroy() {
		super.onDestroy();
		Log.d(tag, "onDestroy");
	}

}
