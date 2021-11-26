package com.flurry.sdk;

import com.facebook.ads.AdError;

/* renamed from: com.flurry.sdk.al */
public enum C1502al {
    DeviceId(0, true),
    AndroidAdvertisingId(13, true),
    AndroidInstallationId(14, false),
    a1Cookie(AdError.NO_FILL_ERROR_CODE, true),
    a3Cookie(AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE, true),
    bCookie(1003, true);
    

    /* renamed from: g */
    public final int f3778g;

    /* renamed from: h */
    public final boolean f3779h;

    private C1502al(int i, boolean z) {
        this.f3778g = i;
        this.f3779h = z;
    }
}
