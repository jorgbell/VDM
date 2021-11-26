package com.applovin.mediation;

public interface MaxAd {
    String getAdUnitId();

    String getAdValue(String str);

    String getAdValue(String str, String str2);

    String getCreativeId();

    MaxAdFormat getFormat();

    String getNetworkName();

    String getPlacement();

    double getRevenue();
}
