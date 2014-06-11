package com.example.premiereappandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.TextView;

import com.facebook.*;
import com.facebook.model.*;

public class FacebookActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.facebook_main);

    // start Facebook Login
    Session.openActiveSession(this, true, new Session.StatusCallback() {

      // callback when session changes state
      @Override
      public void call(Session session, SessionState state, Exception exception) {
        if (session.isOpened()) {

          // make request to the /me API
          Request.newMeRequest(session, new Request.GraphUserCallback() {

            // callback after Graph API response with user object
            @Override
            public void onCompleted(GraphUser user, Response response) {
              if (user != null) {
                TextView pseudo = (TextView) findViewById(R.id.editPseudo);
                pseudo.setText(user.getName());
                
                TextView firstName = (TextView) findViewById(R.id.editFirstName);
                firstName.setText(user.getFirstName());
                
                TextView lastName = (TextView) findViewById(R.id.editLastName);
                lastName.setText(user.getLastName());
                
                Spinner spinner = (Spinner) findViewById(R.id.spinner1);
                
                if(user.asMap().get("gender").toString().equals("male")){
                	spinner.setSelection(0);
                }
                else {
                	spinner.setSelection(1);
                }
              }
            }
          }).executeAsync();
        }
      }
    });
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
  }

}