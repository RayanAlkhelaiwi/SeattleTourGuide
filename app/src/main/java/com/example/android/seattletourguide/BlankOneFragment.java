package com.example.android.seattletourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankOneFragment extends Fragment {


    public BlankOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.city_attraction_list, container, false);

        ArrayList<CityAttraction> cityAttractions = new ArrayList<>();

        cityAttractions.add(new CityAttraction("Cozy Coffee", "1234 Name Street", "Monday - Friday", "9 AM - 8:30 PM", R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Cozy Coffee", "1234 Name Street", "Monday - Friday", "9 AM - 8:30 PM", R.mipmap.ic_launcher));
        cityAttractions.add(new CityAttraction("Cozy Coffee", "1234 Name Street", "Monday - Friday", "9 AM - 8:30 PM", R.mipmap.ic_launcher));

        AttractionAdapter attractionAdapter = new AttractionAdapter(getActivity(), cityAttractions, R.color.colorPrimary);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(attractionAdapter);

        return rootView;
    }

}
