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

    public CategoriesAdapter(Context context, ArrayList<Categories> categories) {
        super(context, 0, categories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.categories_item, parent, false);
        }

        Categories categories = getItem(position);

        View categoryView = listItemView.findViewById(R.id.category_view);
        categoryView.setBackgroundResource(R.color.accent);

        ImageView categoryImage = listItemView.findViewById(R.id.category_image);
        categoryImage.setImageResource(categories.getmCategoryImage());

        TextView categoryName = listItemView.findViewById(R.id.category_name);
        categoryName.setText(categories.getmCategoryName());

        return listItemView;
    }
}

