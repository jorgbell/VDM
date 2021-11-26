package com.applovin.impl.sdk.p035a;

import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1062k;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.h */
public final class C0940h extends AppLovinAdBase {

    /* renamed from: a */
    private AppLovinAd f1473a;

    /* renamed from: b */
    private final C0928d f1474b;

    public C0940h(C0928d dVar, C1062k kVar) {
        super(new JSONObject(), new JSONObject(), C0925b.UNKNOWN, kVar);
        this.f1474b = dVar;
    }

    /* renamed from: c */
    private AppLovinAd m1687c() {
        return this.sdk.mo9348Y().mo9115d(this.f1474b);
    }

    /* renamed from: d */
    private String m1688d() {
        C0928d adZone = getAdZone();
        if (adZone == null || adZone.mo8976e()) {
            return null;
        }
        return adZone.mo8972a();
    }

    /* renamed from: a */
    public AppLovinAd mo9075a() {
        return this.f1473a;
    }

    /* renamed from: a */
    public void mo9076a(AppLovinAd appLovinAd) {
        this.f1473a = appLovinAd;
    }

    /* renamed from: b */
    public AppLovinAd mo9077b() {
        AppLovinAd appLovinAd = this.f1473a;
        return appLovinAd != null ? appLovinAd : m1687c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0940h.class != obj.getClass()) {
            return false;
        }
        AppLovinAd b = mo9077b();
        return b != null ? b.equals(obj) : super.equals(obj);
    }

    public long getAdIdNumber() {
        AppLovinAd b = mo9077b();
        if (b != null) {
            return b.getAdIdNumber();
        }
        return 0;
    }

    public C0928d getAdZone() {
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) mo9077b();
        return appLovinAdBase != null ? appLovinAdBase.getAdZone() : this.f1474b;
    }

    public long getCreatedAtMillis() {
        AppLovinAd b = mo9077b();
        if (b instanceof AppLovinAdBase) {
            return ((AppLovinAdBase) b).getCreatedAtMillis();
        }
        return 0;
    }

    public AppLovinAdSize getSize() {
        return getAdZone().mo8974c();
    }

    public C0925b getSource() {
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) mo9077b();
        return appLovinAdBase != null ? appLovinAdBase.getSource() : C0925b.UNKNOWN;
    }

    public AppLovinAdType getType() {
        return getAdZone().mo8975d();
    }

    public String getZoneId() {
        if (this.f1474b.mo8976e()) {
            return null;
        }
        return this.f1474b.mo8972a();
    }

    public int hashCode() {
        AppLovinAd b = mo9077b();
        return b != null ? b.hashCode() : super.hashCode();
    }

    public boolean isVideoAd() {
        AppLovinAd b = mo9077b();
        return b != null && b.isVideoAd();
    }

    public String toString() {
        return "AppLovinAd{ #" + getAdIdNumber() + ", adType=" + getType() + ", adSize=" + getSize() + ", zoneId='" + m1688d() + '\'' + '}';
    }
}
