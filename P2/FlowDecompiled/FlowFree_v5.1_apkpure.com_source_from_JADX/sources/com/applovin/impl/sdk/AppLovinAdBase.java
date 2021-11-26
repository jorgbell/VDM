package com.applovin.impl.sdk;

import android.graphics.Color;
import com.applovin.impl.sdk.p035a.C0925b;
import com.applovin.impl.sdk.p035a.C0928d;
import com.applovin.impl.sdk.p035a.C0940h;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Arrays;
import org.json.JSONObject;

public abstract class AppLovinAdBase implements AppLovinAd {

    /* renamed from: a */
    private final int f1329a;
    protected final JSONObject adObject;
    protected final Object adObjectLock;

    /* renamed from: b */
    private C0928d f1330b;

    /* renamed from: c */
    private final long f1331c;

    /* renamed from: d */
    private C0940h f1332d;
    protected final JSONObject fullResponse;
    protected final Object fullResponseLock;
    /* access modifiers changed from: protected */
    public final C1062k sdk;
    protected final C0925b source;

    protected AppLovinAdBase(JSONObject jSONObject, JSONObject jSONObject2, C0925b bVar, C1062k kVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (kVar != null) {
            this.adObject = jSONObject;
            this.fullResponse = jSONObject2;
            this.source = bVar;
            this.sdk = kVar;
            this.adObjectLock = new Object();
            this.fullResponseLock = new Object();
            this.f1331c = System.currentTimeMillis();
            char[] charArray = jSONObject.toString().toCharArray();
            Arrays.sort(charArray);
            this.f1329a = new String(charArray).hashCode();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* access modifiers changed from: protected */
    public boolean containsKeyForAdObject(String str) {
        boolean has;
        synchronized (this.adObjectLock) {
            has = this.adObject.has(str);
        }
        return has;
    }

    public boolean equals(Object obj) {
        AppLovinAd b;
        if ((obj instanceof C0940h) && (b = ((C0940h) obj).mo9077b()) != null) {
            obj = b;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) obj;
        C0928d dVar = this.f1330b;
        if (dVar == null ? appLovinAdBase.f1330b == null : dVar.equals(appLovinAdBase.f1330b)) {
            return this.source == appLovinAdBase.source && this.f1329a == appLovinAdBase.f1329a;
        }
        return false;
    }

    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1);
    }

    public String getAdValue(String str) {
        return getAdValue(str, (String) null);
    }

    public String getAdValue(String str, String str2) {
        return C1123j.m2594b(getJsonObjectFromAdObject("ad_values", new JSONObject()), str, str2, this.sdk);
    }

    public C0928d getAdZone() {
        C0928d dVar = this.f1330b;
        if (dVar != null) {
            if (dVar.mo8974c() != null && this.f1330b.mo8975d() != null) {
                return this.f1330b;
            }
            if (getSize() == null && getType() == null) {
                return this.f1330b;
            }
        }
        C0928d a = C0928d.m1539a(getSize(), getType(), getStringFromFullResponse("zone_id", (String) null), this.sdk);
        this.f1330b = a;
        return a;
    }

    /* access modifiers changed from: protected */
    public boolean getBooleanFromAdObject(String str, Boolean bool) {
        boolean booleanValue;
        synchronized (this.adObjectLock) {
            booleanValue = C1123j.m2568a(this.adObject, str, bool, this.sdk).booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: protected */
    public boolean getBooleanFromFullResponse(String str, boolean z) {
        boolean booleanValue;
        synchronized (this.fullResponseLock) {
            booleanValue = C1123j.m2568a(this.fullResponse, str, Boolean.valueOf(z), this.sdk).booleanValue();
        }
        return booleanValue;
    }

    public String getClCode() {
        String stringFromAdObject = getStringFromAdObject("clcode", "");
        return C1155o.m2673b(stringFromAdObject) ? stringFromAdObject : getStringFromFullResponse("clcode", "");
    }

    /* access modifiers changed from: protected */
    public int getColorFromAdObject(String str, int i) {
        String stringFromAdObject = getStringFromAdObject(str, (String) null);
        return C1155o.m2673b(stringFromAdObject) ? Color.parseColor(stringFromAdObject) : i;
    }

    public long getCreatedAtMillis() {
        return this.f1331c;
    }

    public C0940h getDummyAd() {
        return this.f1332d;
    }

    public long getFetchLatencyMillis() {
        return getLongFromFullResponse("ad_fetch_latency_millis", -1);
    }

    public long getFetchResponseSize() {
        return getLongFromFullResponse("ad_fetch_response_size", -1);
    }

    /* access modifiers changed from: protected */
    public float getFloatFromAdObject(String str, float f) {
        float a;
        synchronized (this.adObjectLock) {
            a = C1123j.m2565a(this.adObject, str, f, this.sdk);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public float getFloatFromFullResponse(String str, float f) {
        float a;
        synchronized (this.fullResponseLock) {
            a = C1123j.m2565a(this.fullResponse, str, f, this.sdk);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public int getIntFromAdObject(String str, int i) {
        int b;
        synchronized (this.adObjectLock) {
            b = C1123j.m2592b(this.adObject, str, i, this.sdk);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public int getIntFromFullResponse(String str, int i) {
        int b;
        synchronized (this.fullResponseLock) {
            b = C1123j.m2592b(this.fullResponse, str, i, this.sdk);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public JSONObject getJsonObjectFromAdObject(String str, JSONObject jSONObject) {
        JSONObject b;
        synchronized (this.adObjectLock) {
            b = C1123j.m2600b(this.adObject, str, jSONObject, this.sdk);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public JSONObject getJsonObjectFromFullResponse(String str, JSONObject jSONObject) {
        JSONObject b;
        synchronized (this.fullResponseLock) {
            b = C1123j.m2600b(this.fullResponse, str, jSONObject, this.sdk);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public long getLongFromAdObject(String str, long j) {
        long a;
        synchronized (this.adObjectLock) {
            a = C1123j.m2566a(this.adObject, str, j, this.sdk);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public long getLongFromFullResponse(String str, long j) {
        long a;
        synchronized (this.fullResponseLock) {
            a = C1123j.m2566a(this.fullResponse, str, j, this.sdk);
        }
        return a;
    }

    public String getPrimaryKey() {
        return getStringFromAdObject("pk", "NA");
    }

    public String getRawFullResponse() {
        String jSONObject;
        synchronized (this.fullResponseLock) {
            jSONObject = this.fullResponse.toString();
        }
        return jSONObject;
    }

    public C1062k getSdk() {
        return this.sdk;
    }

    public String getSecondaryKey1() {
        return getStringFromAdObject("sk1", (String) null);
    }

    public String getSecondaryKey2() {
        return getStringFromAdObject("sk2", (String) null);
    }

    public AppLovinAdSize getSize() {
        return AppLovinAdSize.fromString(getStringFromFullResponse("ad_size", (String) null));
    }

    public C0925b getSource() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    public String getStringFromAdObject(String str, String str2) {
        String b;
        synchronized (this.adObjectLock) {
            b = C1123j.m2594b(this.adObject, str, str2, this.sdk);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public String getStringFromFullResponse(String str, String str2) {
        String b;
        synchronized (this.fullResponseLock) {
            b = C1123j.m2594b(this.fullResponse, str, str2, this.sdk);
        }
        return b;
    }

    public AppLovinAdType getType() {
        return AppLovinAdType.fromString(getStringFromFullResponse("ad_type", (String) null));
    }

    public String getZoneId() {
        if (getAdZone().mo8976e()) {
            return null;
        }
        return getStringFromFullResponse("zone_id", (String) null);
    }

    public boolean hasShown() {
        return getBooleanFromAdObject("shown", Boolean.FALSE);
    }

    public boolean hasVideoUrl() {
        this.sdk.mo9411z().mo9588e("AppLovinAdBase", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    public int hashCode() {
        return this.f1329a;
    }

    public boolean isVideoAd() {
        return this.adObject.has("is_video_ad") ? getBooleanFromAdObject("is_video_ad", Boolean.FALSE) : hasVideoUrl();
    }

    public void setDummyAd(C0940h hVar) {
        this.f1332d = hVar;
    }

    public void setHasShown(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("shown", z);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean shouldCancelHtmlCachingIfShown() {
        return getBooleanFromAdObject("chcis", Boolean.FALSE);
    }

    public String toString() {
        return "AppLovinAd{adIdNumber=" + getAdIdNumber() + ", source=" + getSource() + ", zoneId='" + getZoneId() + "'" + '}';
    }
}
