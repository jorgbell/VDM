package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.unity3d.ads.metadata.MediationMetaData;
import org.json.JSONException;
import org.json.JSONObject;

public class BreadcrumbAnalyticsEventReceiver implements AnalyticsEventReceiver, BreadcrumbSource {
    private BreadcrumbHandler breadcrumbHandler;

    public void onEvent(String str, Bundle bundle) {
        BreadcrumbHandler breadcrumbHandler2 = this.breadcrumbHandler;
        if (breadcrumbHandler2 != null) {
            try {
                breadcrumbHandler2.handleBreadcrumb("$A$:" + serializeEvent(str, bundle));
            } catch (JSONException unused) {
                Logger.getLogger().mo22339w("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }

    public void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler2) {
        this.breadcrumbHandler = breadcrumbHandler2;
        Logger.getLogger().mo22331d("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    private static String serializeEvent(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put(MediationMetaData.KEY_NAME, str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }
}
