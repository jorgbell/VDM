package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.p023c.C0788c;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.utils.C1114c;
import com.applovin.impl.sdk.utils.C1117e;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppLovinSdk {
    private static final String TAG = "AppLovinSdk";
    public static final String VERSION = getVersion();
    public static final int VERSION_CODE = getVersionCode();
    private static final Map<String, AppLovinSdk> sdkInstances = new HashMap();
    private static final Object sdkInstancesLock = new Object();
    public final C1062k coreSdk;

    public interface SdkInitializationListener {
        void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration);
    }

    /* renamed from: com.applovin.sdk.AppLovinSdk$a */
    private static class C1197a extends AppLovinSdkSettings {
        C1197a(Context context) {
            super(context);
        }
    }

    private AppLovinSdk(C1062k kVar) {
        this.coreSdk = kVar;
    }

    /* renamed from: a */
    public static AppLovinSdk m2840a(boolean z, String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (appLovinSdkSettings == null) {
            throw new IllegalArgumentException("No userSettings specified");
        } else if (context != null) {
            synchronized (sdkInstancesLock) {
                Map<String, AppLovinSdk> map = sdkInstances;
                if (map.containsKey(str)) {
                    AppLovinSdk appLovinSdk = map.get(str);
                    return appLovinSdk;
                }
                if (!TextUtils.isEmpty(str)) {
                    String str2 = File.separator;
                    if (str.contains(str2)) {
                        C1107r.m2484i(TAG, "\n**************************************************\nINVALID SDK KEY: " + str + "\n**************************************************\n");
                        if (!map.isEmpty()) {
                            AppLovinSdk next = map.values().iterator().next();
                            return next;
                        }
                        str = str.replace(str2, "");
                    }
                }
                C1062k kVar = new C1062k();
                kVar.mo9364a(z, str, appLovinSdkSettings, context);
                AppLovinSdk appLovinSdk2 = new AppLovinSdk(kVar);
                kVar.mo9360a(appLovinSdk2);
                map.put(str, appLovinSdk2);
                return appLovinSdk2;
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* renamed from: a */
    public static List<AppLovinSdk> m2841a() {
        return new ArrayList(sdkInstances.values());
    }

    public static AppLovinSdk getInstance(Context context) {
        return getInstance(new C1197a(context), context);
    }

    public static AppLovinSdk getInstance(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (context != null) {
            return getInstance(C1114c.m2509a(context).mo9605a("applovin.sdk.key", ""), appLovinSdkSettings, context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    public static AppLovinSdk getInstance(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        return m2840a(false, str, appLovinSdkSettings, context);
    }

    private static String getVersion() {
        return "10.1.2";
    }

    private static int getVersionCode() {
        return 10010299;
    }

    public static void initializeSdk(Context context) {
        initializeSdk(context, (SdkInitializationListener) null);
    }

    public static void initializeSdk(Context context, SdkInitializationListener sdkInitializationListener) {
        if (context != null) {
            AppLovinSdk instance = getInstance(context);
            if (instance != null) {
                instance.initializeSdk(sdkInitializationListener);
            } else {
                C1107r.m2484i(TAG, "Unable to initialize AppLovin SDK: SDK object not created");
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    static void reinitializeAll(Boolean bool, Boolean bool2, Boolean bool3) {
        synchronized (sdkInstancesLock) {
            for (AppLovinSdk next : sdkInstances.values()) {
                next.coreSdk.mo9382b();
                next.coreSdk.mo9393i();
                if (bool != null) {
                    C1107r z = next.coreSdk.mo9411z();
                    z.mo9586c(TAG, "Toggled 'huc' to " + bool);
                    next.getEventService().trackEvent("huc", C1117e.m2524a("value", bool.toString()));
                }
                if (bool2 != null) {
                    C1107r z2 = next.coreSdk.mo9411z();
                    z2.mo9586c(TAG, "Toggled 'aru' to " + bool2);
                    next.getEventService().trackEvent("aru", C1117e.m2524a("value", bool2.toString()));
                }
                if (bool3 != null) {
                    C1107r z3 = next.coreSdk.mo9411z();
                    z3.mo9586c(TAG, "Toggled 'dns' to " + bool3);
                    next.getEventService().trackEvent("dns", C1117e.m2524a("value", bool3.toString()));
                }
            }
        }
    }

    public AppLovinAdService getAdService() {
        return this.coreSdk.mo9404t();
    }

    public List<MaxMediatedNetworkInfo> getAvailableMediatedNetworks() {
        JSONArray a = C0788c.m1111a(this.coreSdk);
        ArrayList arrayList = new ArrayList(a.length());
        for (int i = 0; i < a.length(); i++) {
            arrayList.add(new MaxMediatedNetworkInfoImpl(C1123j.m2581a(a, i, (JSONObject) null, this.coreSdk), this.coreSdk));
        }
        return arrayList;
    }

    public AppLovinSdkConfiguration getConfiguration() {
        return this.coreSdk.mo9402r();
    }

    public AppLovinEventService getEventService() {
        return this.coreSdk.mo9406u();
    }

    public String getMediationProvider() {
        return this.coreSdk.mo9403s();
    }

    public AppLovinPostbackService getPostbackService() {
        return this.coreSdk.mo9346W();
    }

    public String getSdkKey() {
        return this.coreSdk.mo9409x();
    }

    public AppLovinSdkSettings getSettings() {
        return this.coreSdk.mo9400p();
    }

    public String getUserIdentifier() {
        return this.coreSdk.mo9397m();
    }

    public AppLovinUserSegment getUserSegment() {
        return this.coreSdk.mo9401q();
    }

    public AppLovinUserService getUserService() {
        return this.coreSdk.mo9407v();
    }

    public AppLovinVariableService getVariableService() {
        return this.coreSdk.mo9408w();
    }

    public boolean hasCriticalErrors() {
        return this.coreSdk.mo9410y();
    }

    public void initializeSdk() {
    }

    public void initializeSdk(SdkInitializationListener sdkInitializationListener) {
        this.coreSdk.mo9359a(sdkInitializationListener);
    }

    public boolean isEnabled() {
        return this.coreSdk.mo9388d();
    }

    public void setMediationProvider(String str) {
        this.coreSdk.mo9386c(str);
    }

    public void setPluginVersion(String str) {
        this.coreSdk.mo9361a(str);
    }

    public void setUserIdentifier(String str) {
        this.coreSdk.mo9384b(str);
    }

    public void showMediationDebugger() {
        this.coreSdk.mo9396l();
    }

    public String toString() {
        return "AppLovinSdk{sdkKey='" + getSdkKey() + "', isEnabled=" + isEnabled() + ", isFirstSession=" + this.coreSdk.mo9337N() + '}';
    }
}
