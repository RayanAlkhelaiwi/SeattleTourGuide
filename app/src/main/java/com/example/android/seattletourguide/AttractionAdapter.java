package com.example.android.seattletourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rean on 9/16/2017.
 */

public class AttractionAdapter extends ArrayAdapter<CityAttraction> {

    private int mBackgroundColor; //A variable to accept a certain color

    //Constructor
    public AttractionAdapter(Context context, ArrayList<CityAttraction> cityAttractions, int backgroundColor) {
        super(context, 0, cityAttractions);
        mBackgroundColor = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        //If the list is null, do the inflater
        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.attraction_item, parent, false);
        }

        CityAttraction currentAttraction = getItem(position);

        //Retrieve the layout built for the items, to change the color
        View placeLinearLayout = listItemView.findViewById(R.id.place_linear_layout);
        placeLinearLayout.setBackgroundResource(mBackgroundColor);

        //Retrieve the layout built for the items, to change the color
        View operationLinearLayout = listItemView.findViewById(R.id.operation_linear_layout);
        operationLinearLayout.setBackgroundResource(mBackgroundColor);

        TextView placeName = listItemView.findViewById(R.id.place_name);
        placeName.setText(currentAttraction.getPlaceName());

        TextView placeAddress = listItemView.findViewById(R.id.place_address);
        placeAddress.setText(currentAttraction.getPlaceAddress());

        TextView operationDays = listItemView.findViewById(R.id.operation_days);
        operationDays.setText(currentAttraction.getOperationDays());

        TextView operationHours = listItemView.findViewById(R.id.operation_hours);
        operationHours.setText(currentAttraction.getOperationHours());

        ImageView placeImage = listItemView.findViewById(R.id.place_image);
        placeImage.setImageResource(currentAttraction.getPlaceImage());

        return listItemView;
    }
}
