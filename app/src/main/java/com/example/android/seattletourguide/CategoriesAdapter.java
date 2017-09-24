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
 * Created by Rean on 9/22/2017.
 */

public class CategoriesAdapter extends ArrayAdapter<Categories> {

    private int mBackgroundColor; //A variable to accept a certain color

    //Constructor
    public CategoriesAdapter(Context context, ArrayList<Categories> categories, int backgroundColor) {
        super(context, 0, categories);
        mBackgroundColor = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        //If the list is null, do the inflater
        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.categories_item, parent, false);
        }

        Categories categories = getItem(position);

        //Retrieve the layout built for the items, to change the color
        View categoryView = listItemView.findViewById(R.id.category_view);
        categoryView.setBackgroundResource(mBackgroundColor);

        ImageView categoryImage = listItemView.findViewById(R.id.category_image);
        categoryImage.setImageResource(categories.getmCategoryImage());

        TextView categoryName = listItemView.findViewById(R.id.category_name);
        categoryName.setText(categories.getmCategoryName());

        return listItemView;
    }
}

