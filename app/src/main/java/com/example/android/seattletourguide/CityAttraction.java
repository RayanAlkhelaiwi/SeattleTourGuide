package com.example.android.seattletourguide;

/**
 * Created by Rean on 9/16/2017.
 */

//Custom class to accept a place's name, address, image, its operation days & hours and an introductory audio, to use in the ArrayList
public class CityAttraction {

    private String mPlaceName;
    private String mPlaceAddress;
    private String mOperationDays;
    private String mOperationHours;
    private int mPlaceImage;

    //Constructor
    public CityAttraction(String placeName, String placeAddress, String operationDays, String operationHours, int placeImage) {
        mPlaceName = placeName;
        mPlaceAddress = placeAddress;
        mOperationDays = operationDays;
        mOperationHours = operationHours;
        mPlaceImage = placeImage;
    }

    public String getPlaceName() {
        return mPlaceName;
    }

    public String getPlaceAddress() {
        return mPlaceAddress;
    }

    public String getOperationDays() {
        return mOperationDays;
    }

    public String getOperationHours() {
        return mOperationHours;
    }

    public int getPlaceImage() {
        return mPlaceImage;
    }
}