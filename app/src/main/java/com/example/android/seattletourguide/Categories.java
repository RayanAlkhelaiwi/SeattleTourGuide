package com.example.android.seattletourguide;

/**
 * Created by Rean on 9/22/2017.
 */

public class Categories {

    private int mCategoryImage;
    private String mCategoryName;

    public Categories(int categoryImage, String categoryName) {
        mCategoryImage = categoryImage;
        mCategoryName = categoryName;
    }

    public int getmCategoryImage() {
        return mCategoryImage;
    }

    public String getmCategoryName() {
        return mCategoryName;
    }
}
