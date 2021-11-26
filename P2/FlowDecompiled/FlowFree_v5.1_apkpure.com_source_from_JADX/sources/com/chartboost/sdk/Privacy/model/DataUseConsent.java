package com.chartboost.sdk.Privacy.model;

import org.json.JSONObject;

public interface DataUseConsent {
    String getConsent();

    String getPrivacyStandard();

    boolean isValidConsent(String str);

    JSONObject toJson();
}
