package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppLovinSdkSettings {

    /* renamed from: a */
    private boolean f2601a;

    /* renamed from: b */
    private boolean f2602b;

    /* renamed from: c */
    private boolean f2603c;

    /* renamed from: d */
    private boolean f2604d;

    /* renamed from: e */
    private List<String> f2605e;

    /* renamed from: f */
    private List<String> f2606f;
    private final Map<String, Object> localSettings;
    private final Map<String, String> metaData;

    @Deprecated
    public AppLovinSdkSettings() {
        this((Context) null);
    }

    public AppLovinSdkSettings(Context context) {
        this.localSettings = new HashMap();
        this.metaData = new HashMap();
        this.f2605e = Collections.emptyList();
        this.f2606f = Collections.emptyList();
        this.f2601a = C1160r.m2729a(context);
        this.f2603c = true;
        this.f2604d = true;
    }

    public List<String> getInitializationAdUnitIds() {
        return this.f2606f;
    }

    public List<String> getTestDeviceAdvertisingIds() {
        return this.f2605e;
    }

    public boolean isCreativeDebuggerEnabled() {
        return this.f2603c;
    }

    public boolean isExceptionHandlerEnabled() {
        return this.f2604d;
    }

    public boolean isMuted() {
        return this.f2602b;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f2601a;
    }

    public void setCreativeDebuggerEnabled(boolean z) {
        this.f2603c = z;
    }

    public void setExceptionHandlerEnabled(boolean z) {
        this.f2604d = true;
    }

    public void setInitializationAdUnitIds(List<String> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String next : list) {
                if (C1155o.m2673b(next) && next.length() > 0) {
                    if (next.length() == 16) {
                        arrayList.add(next);
                    } else {
                        C1107r.m2484i("AppLovinSdkSettings", "Unable to set initialization ad unit id (" + next + ") - please make sure it is in the format of XXXXXXXXXXXXXXXX");
                    }
                }
            }
            this.f2606f = arrayList;
            return;
        }
        this.f2606f = Collections.emptyList();
    }

    public void setMuted(boolean z) {
        this.f2602b = z;
    }

    public void setTestDeviceAdvertisingIds(List<String> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String next : list) {
                if (next == null || next.length() != 36) {
                    C1107r.m2484i("AppLovinSdkSettings", "Unable to set test device advertising id (" + next + ") - please make sure it is in the format of xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
                } else {
                    arrayList.add(next);
                }
            }
            this.f2605e = arrayList;
            return;
        }
        this.f2605e = Collections.emptyList();
    }

    public void setVerboseLogging(boolean z) {
        if (C1160r.m2726a()) {
            C1107r.m2484i("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already or AppLovinSdkSettings was initialized without a context.");
            if (C1160r.m2729a((Context) null) != z) {
                C1107r.m2484i("AppLovinSdkSettings", "Attempted to programmatically set verbose logging flag to value different from value configured in Android Manifest.");
                return;
            }
            return;
        }
        this.f2601a = z;
    }

    public String toString() {
        return "AppLovinSdkSettings{isVerboseLoggingEnabled=" + this.f2601a + ", muted=" + this.f2602b + ", testDeviceAdvertisingIds=" + this.f2605e.toString() + ", initializationAdUnitIds=" + this.f2606f.toString() + ", creativeDebuggerEnabled=" + this.f2603c + ", exceptionHandlerEnabled=" + this.f2604d + '}';
    }
}
