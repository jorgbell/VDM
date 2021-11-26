package com.applovin.sdk;

import java.util.Locale;

public class AppLovinAdSize {
    public static final AppLovinAdSize BANNER = new AppLovinAdSize(-1, 50, "BANNER");
    public static final AppLovinAdSize CROSS_PROMO = new AppLovinAdSize(-1, -1, "XPROMO");
    public static final AppLovinAdSize INTERSTITIAL = new AppLovinAdSize(-1, -1, "INTER");
    public static final AppLovinAdSize LEADER = new AppLovinAdSize(-1, 90, "LEADER");
    @Deprecated
    public static final AppLovinAdSize MREC = new AppLovinAdSize(300, 250, "MREC");
    public static final int SPAN = -1;

    /* renamed from: a */
    private final String f2596a;

    /* renamed from: b */
    private final int f2597b;

    /* renamed from: c */
    private final int f2598c;

    private AppLovinAdSize(int i, int i2, String str) {
        this.f2597b = i;
        this.f2598c = i2;
        this.f2596a = str;
    }

    public static AppLovinAdSize fromString(String str) {
        if ("BANNER".equalsIgnoreCase(str)) {
            return BANNER;
        }
        if ("MREC".equalsIgnoreCase(str)) {
            return MREC;
        }
        if ("LEADER".equalsIgnoreCase(str)) {
            return LEADER;
        }
        if ("INTERSTITIAL".equalsIgnoreCase(str) || "INTER".equalsIgnoreCase(str)) {
            return INTERSTITIAL;
        }
        if ("XPROMO".equalsIgnoreCase(str)) {
            return CROSS_PROMO;
        }
        throw new IllegalArgumentException("Unknown Ad Size: " + str);
    }

    public int getHeight() {
        return this.f2598c;
    }

    public String getLabel() {
        return this.f2596a.toUpperCase(Locale.ENGLISH);
    }

    public int getWidth() {
        return this.f2597b;
    }

    public String toString() {
        return getLabel();
    }
}
