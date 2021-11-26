package com.chartboost.sdk.Networking.requests.models;

public class ShowParamsModel {
    private String adId;
    private String location;

    public ShowParamsModel(String str, String str2) {
        this.adId = str;
        this.location = str2;
    }

    public String getAdId() {
        return this.adId;
    }

    public String getLocation() {
        return this.location;
    }
}
