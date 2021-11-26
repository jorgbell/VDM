package com.applovin.impl.sdk;

import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinUserSegment;

/* renamed from: com.applovin.impl.sdk.e */
class C0988e implements AppLovinUserSegment {

    /* renamed from: a */
    private String f1978a;

    C0988e() {
    }

    public String getName() {
        return this.f1978a;
    }

    public void setName(String str) {
        if (str != null) {
            if (str.length() > 32) {
                C1107r.m2484i("AppLovinUserSegment", "Setting name greater than 32 characters: " + str);
            }
            if (!C1155o.m2677e(str)) {
                C1107r.m2484i("AppLovinUserSegment", "Setting name that is not alphanumeric: " + str);
            }
        }
        this.f1978a = str;
    }

    public String toString() {
        return "AppLovinUserSegment{name=" + getName() + '}';
    }
}
