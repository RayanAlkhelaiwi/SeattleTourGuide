package com.example.android.seattletourguide;

/**
 * Created by Rean on 9/22/2017.
 */

//Custom class to accept a category name and its image, to use in the ArrayList
public class Categories {

    private int mCategoryImage;
    private int mCategoryName;

    //Constructor
    public Categories(int categoryImage, int categoryName) {
        mCategoryImage = categoryImage;
        mCategoryName = categoryName;
    }

    public int getmCategoryImage() {
        return mCategoryImage;
    }

    public int getmCategoryName() {
        return mCategoryName;
    }
}
