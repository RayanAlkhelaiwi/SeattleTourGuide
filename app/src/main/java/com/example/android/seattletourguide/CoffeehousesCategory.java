package com.example.android.seattletourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Rean on 9/21/2017.
 */

public class CoffeehousesCategory extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        context = this;

        //ArrayList that holds the places information
        final ArrayList<CityAttraction> cityAttractions = new ArrayList<>();

        cityAttractions.add(new CityAttraction("Seattle Coffee Works", "107 Pike St.", "Monday - Sunday", "6:30 AM - 7:30 PM", R.drawable.coffeehouse_list));
        cityAttractions.add(new CityAttraction("Milstead & Co.", "1001 Maintwo Street", "Monday - Sunday", "6:00 AM - 6:00 PM", R.drawable.coffeehouse_list));
        cityAttractions.add(new CityAttraction("La Marzocco Cafe", "472 1st Ave N", "Monday - Sunday", "7:00 AM - 6:00 PM", R.drawable.coffeehouse_list));
        cityAttractions.add(new CityAttraction("Starbucks (Original)", "1912 Pike Pl", "Monday - Sunday", "6:00 AM - 9:00 PM", R.drawable.coffeehouse_list));

        //Custom adapter that accepts the context, ArrayList and the color of the list item
        AttractionAdapter attractionAdapter = new AttractionAdapter(this, cityAttractions, R.color.primary);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(attractionAdapter);

        //OnClick Item Listener for each item of the list view (Specified by the position), to have an explicit intent to move to place's location
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                switch (position) {
                    case 0: //Intent for the first list item, for the location
                        String uriOne = String.format(Locale.ENGLISH, "geo:%f,%f", 47.6089, -122.3395);
                        Intent activityOne = new Intent(Intent.ACTION_VIEW, Uri.parse(uriOne));
                        context.startActivity(activityOne);
                        break;

                    case 1: //Intent for the following list item, for the location
                        String uriTwo = String.format(Locale.ENGLISH, "geo:%f,%f", 47.6494, -122.3478);
                        Intent activityTwo = new Intent(Intent.ACTION_VIEW, Uri.parse(uriTwo));
                        context.startActivity(activityTwo);
                        break;

                    case 2: //Intent for the following list item, for the location
                        String uriThree = String.format(Locale.ENGLISH, "geo:%f,%f", 47.6228, -122.3552);
                        Intent activityThree = new Intent(Intent.ACTION_VIEW, Uri.parse(uriThree));
                        context.startActivity(activityThree);
                        break;

                    case 3: //Intent for the following list item, for the location
                        String uriFour = String.format(Locale.ENGLISH, "geo:%f,%f", 47.6101, -122.3425);
                        Intent activityFour = new Intent(Intent.ACTION_VIEW, Uri.parse(uriFour));
                        context.startActivity(activityFour);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}