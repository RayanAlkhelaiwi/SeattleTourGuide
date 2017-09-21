package com.example.android.seattletourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        TextView activities = (TextView) findViewById(R.id.activities);
        TextView coffeehouses = (TextView) findViewById(R.id.coffeehouses);
        TextView restaurants = (TextView) findViewById(R.id.restaurants);
        TextView museums = (TextView) findViewById(R.id.mesuems);

        activities.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent activitiesIntent = new Intent(MainActivity.this, ActivitiesCategory.class);
                startActivity(activitiesIntent);
            }
        });

        coffeehouses.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent coffeehousesIntent = new Intent(MainActivity.this, CoffeehousesCategory.class);
                startActivity(coffeehousesIntent);
            }
        });

        restaurants.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent restaurantsIntent = new Intent(MainActivity.this, RestaurantsCategory.class);
                startActivity(restaurantsIntent);
            }
        });

        museums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent museumsIntent = new Intent(MainActivity.this, MuseumsCategory.class);
                startActivity(museumsIntent);
            }
        });
    }
}
