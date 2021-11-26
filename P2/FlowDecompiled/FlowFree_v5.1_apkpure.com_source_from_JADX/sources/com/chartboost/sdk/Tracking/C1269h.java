package com.chartboost.sdk.Tracking;

/* renamed from: com.chartboost.sdk.Tracking.h */
public class C1269h {

    /* renamed from: a */
    private String f2958a;

    /* renamed from: b */
    private String f2959b;

    /* renamed from: c */
    private String f2960c;

    /* renamed from: d */
    private String f2961d;

    /* renamed from: e */
    private String f2962e;

    public C1269h(String str, String str2, String str3, String str4, String str5) {
        this.f2958a = str;
        this.f2959b = str2;
        this.f2960c = str3;
        this.f2961d = str4;
        this.f2962e = str5;
    }

    /* renamed from: a */
    public String mo10264a() {
        return this.f2961d;
    }

    /* renamed from: b */
    public String mo10265b() {
        return this.f2960c;
    }

    /* renamed from: c */
    public String mo10266c() {
        return this.f2959b;
    }

    /* renamed from: d */
    public String mo10267d() {
        return this.f2958a;
    }

    public String toString() {
        String str = this.f2960c;
        if (str != null && str.length() > 20) {
            str = this.f2960c.substring(0, 20);
        }
        return "TrackAd{location='" + this.f2958a + '\'' + "ad_type='" + this.f2959b + '\'' + ", ad_impression_id='" + str + '\'' + ", ad_creative_id='" + this.f2961d + '\'' + ", ad_creative_type='" + this.f2962e + '\'' + '}';
    }
}
