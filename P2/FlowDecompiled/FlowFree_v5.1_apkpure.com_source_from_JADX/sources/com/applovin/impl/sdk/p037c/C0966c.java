package com.applovin.impl.sdk.p037c;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.c.c */
public class C0966c {

    /* renamed from: a */
    protected final C1062k f1836a;

    /* renamed from: b */
    protected final C1107r f1837b;

    /* renamed from: c */
    protected final Context f1838c;

    /* renamed from: d */
    protected final SharedPreferences f1839d;

    /* renamed from: e */
    private final Map<String, Object> f1840e = new HashMap();

    /* renamed from: f */
    private final Object f1841f = new Object();

    /* renamed from: g */
    private Map<String, Object> f1842g;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0966c(com.applovin.impl.sdk.C1062k r4) {
        /*
            r3 = this;
            r3.<init>()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r3.f1840e = r0
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.f1841f = r0
            r3.f1836a = r4
            com.applovin.impl.sdk.r r0 = r4.mo9411z()
            r3.f1837b = r0
            android.content.Context r0 = r4.mo9334J()
            r3.f1838c = r0
            java.lang.String r1 = "com.applovin.sdk.1"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            r3.f1839d = r0
            java.lang.Class<com.applovin.impl.sdk.c.b> r0 = com.applovin.impl.sdk.p037c.C0965b.class
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x003a }
            java.lang.Class.forName(r0)     // Catch:{ all -> 0x003a }
            java.lang.Class<com.applovin.impl.sdk.c.a> r0 = com.applovin.impl.sdk.p037c.C0964a.class
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x003a }
            java.lang.Class.forName(r0)     // Catch:{ all -> 0x003a }
        L_0x003a:
            com.applovin.sdk.AppLovinSdkSettings r0 = r4.mo9400p()     // Catch:{ all -> 0x0058 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x0058 }
            java.lang.String r1 = "localSettings"
            java.lang.reflect.Field r0 = com.applovin.impl.sdk.utils.C1160r.m2711a((java.lang.Class) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0058 }
            r1 = 1
            r0.setAccessible(r1)     // Catch:{ all -> 0x0058 }
            com.applovin.sdk.AppLovinSdkSettings r4 = r4.mo9400p()     // Catch:{ all -> 0x0058 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0058 }
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch:{ all -> 0x0058 }
            r3.f1842g = r4     // Catch:{ all -> 0x0058 }
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p037c.C0966c.<init>(com.applovin.impl.sdk.k):void");
    }

    /* renamed from: a */
    private static Object m1751a(String str, JSONObject jSONObject, Object obj) throws JSONException {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    /* renamed from: e */
    private String m1752e() {
        return "com.applovin.sdk." + C1160r.m2708a(this.f1836a.mo9409x()) + ".";
    }

    /* renamed from: a */
    public <T> C0965b<T> mo9120a(String str, C0965b<T> bVar) {
        synchronized (this.f1841f) {
            for (C0965b<T> next : C0965b.m1747c()) {
                if (next.mo9117a().equals(str)) {
                    return next;
                }
            }
            return bVar;
        }
    }

    /* renamed from: a */
    public <T> T mo9121a(C0965b<T> bVar) {
        if (bVar != null) {
            synchronized (this.f1841f) {
                Object obj = this.f1840e.get(bVar.mo9117a());
                if (obj == null) {
                    T b = bVar.mo9118b();
                    return b;
                }
                T a = bVar.mo9116a(obj);
                return a;
            }
        }
        throw new IllegalArgumentException("No setting type specified");
    }

    /* renamed from: a */
    public void mo9122a() {
        if (this.f1838c != null) {
            String e = m1752e();
            synchronized (this.f1841f) {
                SharedPreferences.Editor edit = this.f1839d.edit();
                for (C0965b next : C0965b.m1747c()) {
                    Object obj = this.f1840e.get(next.mo9117a());
                    if (obj != null) {
                        this.f1836a.mo9362a(e + next.mo9117a(), obj, edit);
                    }
                }
                edit.apply();
            }
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* renamed from: a */
    public <T> void mo9123a(C0965b<?> bVar, Object obj) {
        if (bVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        } else if (obj != null) {
            synchronized (this.f1841f) {
                this.f1840e.put(bVar.mo9117a(), obj);
            }
        } else {
            throw new IllegalArgumentException("No new value specified");
        }
    }

    /* renamed from: a */
    public void mo9124a(JSONObject jSONObject) {
        C1107r rVar;
        String str;
        String str2;
        synchronized (this.f1841f) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && next.length() > 0) {
                    try {
                        C0965b<Long> a = mo9120a(next, (C0965b) null);
                        if (a != null) {
                            this.f1840e.put(a.mo9117a(), m1751a(next, jSONObject, a.mo9118b()));
                            if (a == C0965b.f1820em) {
                                this.f1840e.put(C0965b.f1821en.mo9117a(), Long.valueOf(System.currentTimeMillis()));
                            }
                        }
                    } catch (JSONException e) {
                        th = e;
                        rVar = this.f1837b;
                        str = "SettingsManager";
                        str2 = "Unable to parse JSON settingsValues array";
                        rVar.mo9585b(str, str2, th);
                    } catch (Throwable th) {
                        th = th;
                        rVar = this.f1837b;
                        str = "SettingsManager";
                        str2 = "Unable to convert setting object ";
                        rVar.mo9585b(str, str2, th);
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.applovin.impl.sdk.c.b<java.lang.String>, com.applovin.impl.sdk.c.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> mo9125b(com.applovin.impl.sdk.p037c.C0965b<java.lang.String> r1) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.mo9121a(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.util.List r1 = com.applovin.impl.sdk.utils.C1117e.m2521a((java.lang.String) r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p037c.C0966c.mo9125b(com.applovin.impl.sdk.c.b):java.util.List");
    }

    /* renamed from: b */
    public void mo9126b() {
        if (this.f1838c != null) {
            String e = m1752e();
            synchronized (this.f1841f) {
                for (C0965b next : C0965b.m1747c()) {
                    try {
                        Object a = this.f1836a.mo9352a(e + next.mo9117a(), null, (Class) next.mo9118b().getClass(), this.f1839d);
                        if (a != null) {
                            this.f1840e.put(next.mo9117a(), a);
                        }
                    } catch (Exception e2) {
                        C1107r rVar = this.f1837b;
                        rVar.mo9585b("SettingsManager", "Unable to load \"" + next.mo9117a() + "\"", e2);
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* renamed from: c */
    public List<MaxAdFormat> mo9127c(C0965b<String> bVar) {
        ArrayList arrayList = new ArrayList(6);
        for (String formatFromString : mo9125b(bVar)) {
            arrayList.add(MaxAdFormat.formatFromString(formatFromString));
        }
        return arrayList;
    }

    /* renamed from: c */
    public void mo9128c() {
        synchronized (this.f1841f) {
            this.f1840e.clear();
        }
        this.f1836a.mo9355a(this.f1839d);
    }

    /* renamed from: d */
    public boolean mo9129d() {
        return this.f1836a.mo9400p().isVerboseLoggingEnabled() || ((Boolean) mo9121a(C0965b.f1573Y)).booleanValue();
    }
}
