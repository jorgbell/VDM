package com.chartboost.sdk.Networking.requests.models;

public class MediationModel {
    private String adapterVersion;
    private String mediation;
    private String mediationVersion;

    public MediationModel(String str, String str2, String str3) {
        this.mediation = str;
        this.mediationVersion = str2;
        this.adapterVersion = str3;
    }

    public String getAdapterVersion() {
        return this.adapterVersion;
    }

    public String getMediation() {
        return this.mediation;
    }

    public String getMediationVersion() {
        return this.mediationVersion;
    }
}
