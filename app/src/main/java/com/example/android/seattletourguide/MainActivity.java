package com.example.android.seattletourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the content of the activity to use the categories_list.xml layout file
        setContentView(R.layout.categories_list);

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(getApplicationContext(), getString(R.string.sample_admob_app_id));

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayList<Categories> categories = new ArrayList<>();

        //An ArrayList that holds the categories' information
        categories.add(new Categories(R.mipmap.activity_category, R.string.activities_category));
        categories.add(new Categories(R.mipmap.coffeehouse_category, R.string.coffeehouses_category));
        categories.add(new Categories(R.mipmap.restaurant_category, R.string.restaurants_category));
        categories.add(new Categories(R.mipmap.museum_category, R.string.museums_category));

        //Custom adapter that accepts the context, ArrayList and the color of the category
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(this, categories, R.color.accent);

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(categoriesAdapter);

        //OnClick Item Listener for each item of the grid view (Specified by the position), to have an explicit intent to move to specific class
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                switch (position) {
                    case 0: //For the Activities Category
                        Intent activitiesIntent = new Intent(getApplicationContext(), ActivitiesCategory.class);
                        startActivity(activitiesIntent);
                        break;

                    case 1: //For the Coffeehouses Category
                        Intent coffeehousesIntent = new Intent(getApplicationContext(), CoffeehousesCategory.class);
                        startActivity(coffeehousesIntent);
                        break;

                    case 2: //For the Restaurants Category
                        Intent restaurantsIntent = new Intent(getApplicationContext(), RestaurantsCategory.class);
                        startActivity(restaurantsIntent);
                        break;

                    case 3: //For the Museums Category
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
