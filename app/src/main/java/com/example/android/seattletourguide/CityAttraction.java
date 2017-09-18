package com.example.android.seattletourguide;

/**
 * Created by Rean on 9/16/2017.
 */

public class CityAttraction {

    private final int NO_IMAGE = -1;
    private String mPlaceName;
    private String mPlaceAddress;
    private String mOperationDays;
    private String mOperationHours;
    private int mPlaceImage = 0;
    private int mPlaceAudioVideo = 0;

    public CityAttraction(String placeName, String placeAddress, String operationDays, String operationHours, int placeAudioVideo) {
        mPlaceName = placeName;
        mPlaceAddress = placeAddress;
        mOperationDays = operationDays;
        mOperationHours = operationHours;
        mPlaceAudioVideo = placeAudioVideo;
    }

    public CityAttraction(String placeName, String placeAddress, String operationDays, String operationHours, int placeAudioVideo, int placeImage) {
        mPlaceName = placeName;
        mPlaceAddress = placeAddress;
        mOperationDays = operationDays;
        mOperationHours = operationHours;
        mPlaceAudioVideo = placeAudioVideo;
        mPlaceImage = placeImage;
    }

    public String getmPlaceName() {
        return mPlaceName;
    }

    public String getmPlaceAddress() {
        return mPlaceAddress;
    }

    public String getmOperationDays() {
        return mOperationDays;
    }

    public String getmOperationHours() {
        return mOperationHours;
    }

    public void setPlaceImage(int placeImage) {
        this.mPlaceImage = placeImage;
    }

    public int getmPlaceImage() {
        return mPlaceImage;
    }

    public int getmPlaceAudioVideo() {
        return mPlaceAudioVideo;
    }

    public boolean hasImage() {
        return mPlaceImage != NO_IMAGE;
    }
}