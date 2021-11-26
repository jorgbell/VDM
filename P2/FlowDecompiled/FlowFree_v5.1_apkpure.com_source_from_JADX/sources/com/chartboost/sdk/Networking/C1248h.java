package com.chartboost.sdk.Networking;

import android.content.Context;
import android.net.NetworkInfo;
import com.chartboost.sdk.Libraries.CBLogging;

/* renamed from: com.chartboost.sdk.Networking.h */
public class C1248h {

    /* renamed from: a */
    private Context f2869a;

    /* renamed from: b */
    private C1253k f2870b = new C1253k();

    public C1248h(Context context) {
        this.f2869a = context;
    }

    /* renamed from: a */
    public String mo10149a() {
        C1253k kVar = this.f2870b;
        if (kVar == null) {
            return "Unknown";
        }
        switch (kVar.mo10164d(this.f2869a)) {
            case 1:
                return "Ethernet";
            case 2:
                return "WIFI";
            case 3:
                return "Cellular_Unknown";
            case 4:
                return "Cellular_2G";
            case 5:
                return "Cellular_3G";
            case 6:
                return "Cellular_4G";
            default:
                return "Unknown";
        }
    }

    /* renamed from: b */
    public int mo10150b() {
        Context context = this.f2869a;
        if (context == null) {
            return 0;
        }
        if (this.f2870b.mo10163c(context) == null) {
            CBLogging.m2903a("CBReachability", "NETWORK TYPE: unknown");
            return -1;
        }
        NetworkInfo a = this.f2870b.mo10161a(this.f2869a);
        if (a == null || !a.isConnected()) {
            CBLogging.m2903a("CBReachability", "NETWORK TYPE: NO Network");
            return 0;
        } else if (a.getType() == 1) {
            CBLogging.m2903a("CBReachability", "NETWORK TYPE: TYPE_WIFI");
            return 1;
        } else {
            CBLogging.m2903a("CBReachability", "NETWORK TYPE: TYPE_MOBILE");
            return 2;
        }
    }

    /* renamed from: c */
    public int mo10151c() {
        C1253k kVar = this.f2870b;
        if (kVar != null) {
            return kVar.mo10164d(this.f2869a);
        }
        return 0;
    }

    /* renamed from: d */
    public boolean mo10152d() {
        return this.f2870b.mo10165e(this.f2869a);
    }

    /* renamed from: a */
    public int mo10148a(Context context) {
        C1253k kVar = this.f2870b;
        if (kVar != null) {
            return kVar.mo10162b(context);
        }
        return 0;
    }
}
