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

    private int mBackgroundColor;

    public AttractionAdapter(Context context, ArrayList<CityAttraction> cityAttractions, int backgroundColor) {
        super(context, 0, cityAttractions);
        mBackgroundColor = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.attraction_items, parent, false);
        }

        CityAttraction currentAttraction = getItem(position);

        View placeLinearLayout = listItemView.findViewById(R.id.place_linear_layout);
        placeLinearLayout.setBackgroundResource(mBackgroundColor);

        View operationLinearLayout = listItemView.findViewById(R.id.operation_linear_layout);
        operationLinearLayout.setBackgroundResource(mBackgroundColor);

        TextView placeName = listItemView.findViewById(R.id.place_name);
        placeName.setText(currentAttraction.getmPlaceName());

        TextView placeAddress = listItemView.findViewById(R.id.place_address);
        placeAddress.setText(currentAttraction.getmPlaceAddress());

        TextView operationDays = listItemView.findViewById(R.id.operation_days);
        operationDays.setText(currentAttraction.getmOperationDays());

        TextView operationHours = listItemView.findViewById(R.id.operation_hours);
        operationHours.setText(currentAttraction.getmOperationHours());

        ImageView placeImage = listItemView.findViewById(R.id.place_image);

        if (currentAttraction.hasImage()) {
            placeImage.setImageResource(currentAttraction.getmPlaceImage());

            placeImage.setVisibility(View.VISIBLE);
        } else {
            placeImage.setVisibility(View.GONE);
            currentAttraction.setPlaceImage(0);
        }

        return listItemView;
    }
}
