package com.example.android.seattletourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.categories_list);

        ArrayList<Categories> categories = new ArrayList<>();

        categories.add(new Categories(R.drawable.activity_category, "Activities"));
        categories.add(new Categories(R.drawable.coffeehouse_category, "Coffeehouses"));
        categories.add(new Categories(R.drawable.restaurant_category, "Restaurants"));
        categories.add(new Categories(R.drawable.museum_category, "Museums"));

        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(this, categories);

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(categoriesAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                switch (position) {
                    case 0:
                        Intent activitiesIntent = new Intent(getApplicationContext(), ActivitiesCategory.class);
                        startActivity(activitiesIntent);
                        break;

                    case 1:
                        Intent coffeehousesIntent = new Intent(getApplicationContext(), CoffeehousesCategory.class);
                        startActivity(coffeehousesIntent);
                        break;

                    case 2:
                        Intent restaurantsIntent = new Intent(getApplicationContext(), RestaurantsCategory.class);
                        startActivity(restaurantsIntent);
                        break;

                    case 3:
                        Intent museumsIntent = new Intent(getApplicationContext(), MuseumsCategory.class);
                        startActivity(museumsIntent);
                        break;

                    default:
                        break;
                }
            }
        });
    }
}
