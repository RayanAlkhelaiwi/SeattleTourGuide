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

public class ActivitiesCategory extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        context = this;

        //ArrayList that holds the places' information
        final ArrayList<CityAttraction> cityAttractions = new ArrayList<>();

        cityAttractions.add(new CityAttraction("Space Needle", "400 Broad St.", "Monday - Sunday", "9:00 AM - 8:00 PM", R.drawable.activity_list));
        cityAttractions.add(new CityAttraction("Chihuly Garden and Glass", "305 Harrison St.", "Monday - Sunday", "9:00 AM - 7:00 PM", R.drawable.activity_list));
        cityAttractions.add(new CityAttraction("Snoqualmie Falls", "6501 Railroad Ave SE", "Monday - Sunday", "7:00 AM - 6:00 PM", R.drawable.activity_list));
        cityAttractions.add(new CityAttraction("Benaroya Hall", "200 University St.", "Monday - Friday", "5:30 AM - 7:00 PM", R.drawable.activity_list));

        //Custom adapter that accepts the context, ArrayList and the color of the list item
        AttractionAdapter attractionAdapter = new AttractionAdapter(this, cityAttractions, R.color.primary);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(attractionAdapter);

        //OnClick Item Listener for each item of the list view (Specified by the position), to have an explicit intent to move to place's location
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                switch (position) {
                    case 0: //Intent for the first list item, for the location
                        String uriOne = String.format(Locale.ENGLISH, "geo:%f,%f", 47.6205, -122.3493);
                        Intent activityOne = new Intent(Intent.ACTION_VIEW, Uri.parse(uriOne));
                        context.startActivity(activityOne);
                        break;

                    case 1: //Intent for the following list item, for the location
                        String uriTwo = String.format(Locale.ENGLISH, "geo:%f,%f", 47.6206, -122.3505);
                        Intent activityTwo = new Intent(Intent.ACTION_VIEW, Uri.parse(uriTwo));
                        context.startActivity(activityTwo);
                        break;

                    case 2: //Intent for the following list item, for the location
                        String uriThree = String.format(Locale.ENGLISH, "geo:%f,%f", 47.542932, -121.836834);
                        Intent activityThree = new Intent(Intent.ACTION_VIEW, Uri.parse(uriThree));
                        context.startActivity(activityThree);
                        break;

                    case 3: //Intent for the following list item, for the location
                        String uriFour = String.format(Locale.ENGLISH, "geo:%f,%f", 47.6081, -122.3370);
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