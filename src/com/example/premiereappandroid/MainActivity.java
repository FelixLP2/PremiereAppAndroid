package com.example.premiereappandroid;

import com.example.premiereappandroid.activities.OAuthActivity;
import com.facebook.android.Facebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	@Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.welcome);
	    
	    Button facebook = (Button) findViewById(R.id.button_facebook);
	    Button twitter = (Button) findViewById(R.id.button_twitter);

	    facebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(MainActivity.this, FacebookActivity.class);
            	startActivity(intent);
            }
        });
	    
	    twitter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(MainActivity.this, OAuthActivity.class);
            	startActivity(intent);
            }
        });


	}

}
