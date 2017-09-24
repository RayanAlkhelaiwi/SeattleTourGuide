package com.example.android.seattletourguide;

/**
 * Created by Rean on 9/15/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

//Splash Screen to appear at the launch of the app (The manifest is edited accordingly)
public class SplashScreen extends Activity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.splash_screen);

        int SPLASH_SCREEN_LENGTH = 1000; //To hold the Splash Screen for 1 second (1000 milliseconds)
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_SCREEN_LENGTH);
    }
}