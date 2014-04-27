package com.nati.volleytest;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {
	RequestQueue reqQueue;
	TextView tv;
	JsonObjectRequest jsonObjectRequest;
	Button clickButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		reqQueue=Volley.newRequestQueue(this);
		tv=(TextView)findViewById(R.id.text_view_test);
		clickButton=(Button)findViewById(R.id.click_button);
		init();
		
	}
	void init()
	{
		jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,"http://192.168.200.1:81/test-list/volley-test/index.php",null, new Response.Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
				tv.setText(response.toString());
			}
			
			
			
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		clickButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tv.setText("Loading....");
				reqQueue.add(jsonObjectRequest);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
