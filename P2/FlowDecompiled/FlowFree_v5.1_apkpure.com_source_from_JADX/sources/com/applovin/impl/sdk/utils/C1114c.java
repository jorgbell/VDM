package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.applovin.impl.sdk.C1107r;

/* renamed from: com.applovin.impl.sdk.utils.c */
public class C1114c {

    /* renamed from: a */
    private static C1114c f2386a;

    /* renamed from: b */
    private static final Object f2387b = new Object();

    /* renamed from: c */
    private final Bundle f2388c;

    /* renamed from: d */
    private final int f2389d;

    private C1114c(Context context) {
        Bundle bundle = null;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            C1107r.m2480c("AndroidManifest", "Failed to get meta data.", e);
        } catch (Throwable th) {
            this.f2388c = null;
            throw th;
        }
        this.f2388c = bundle;
        int i = 0;
        try {
            XmlResourceParser openXmlResourceParser = context.getAssets().openXmlResourceParser("AndroidManifest.xml");
            int eventType = openXmlResourceParser.getEventType();
            int i2 = 0;
            do {
                if (2 == eventType) {
                    try {
                        if (openXmlResourceParser.getName().equals("application")) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= openXmlResourceParser.getAttributeCount()) {
                                    break;
                                }
                                String attributeName = openXmlResourceParser.getAttributeName(i3);
                                String attributeValue = openXmlResourceParser.getAttributeValue(i3);
                                if (attributeName.equals("networkSecurityConfig")) {
                                    i2 = Integer.valueOf(attributeValue.substring(1)).intValue();
                                    break;
                                }
                                i3++;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i = i2;
                        try {
                            C1107r.m2480c("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
                        } finally {
                            this.f2389d = i;
                        }
                    }
                }
                eventType = openXmlResourceParser.next();
            } while (eventType != 1);
            this.f2389d = i2;
        } catch (Throwable th3) {
            th = th3;
            C1107r.m2480c("AndroidManifest", "Failed to parse AndroidManifest.xml.", th);
        }
    }

    /* renamed from: a */
    public static C1114c m2509a(Context context) {
        C1114c cVar;
        synchronized (f2387b) {
            if (f2386a == null) {
                f2386a = new C1114c(context);
            }
            cVar = f2386a;
        }
        return cVar;
    }

    /* renamed from: a */
    public String mo9605a(String str, String str2) {
        Bundle bundle = this.f2388c;
        return bundle != null ? bundle.getString(str, str2) : str2;
    }

    /* renamed from: a */
    public boolean mo9606a() {
        return this.f2389d != 0;
    }

    /* renamed from: a */
    public boolean mo9607a(String str) {
        Bundle bundle = this.f2388c;
        if (bundle != null) {
            return bundle.containsKey(str);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo9608a(String str, boolean z) {
        Bundle bundle = this.f2388c;
        return bundle != null ? bundle.getBoolean(str, z) : z;
    }
}
