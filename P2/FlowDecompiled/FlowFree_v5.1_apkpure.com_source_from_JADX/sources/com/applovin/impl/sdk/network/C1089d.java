package com.applovin.impl.sdk.network;

import android.content.Context;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p037c.C0968e;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.d */
public class C1089d {

    /* renamed from: a */
    private static final Object f2311a = new Object();

    /* renamed from: a */
    private static JSONObject m2340a(String str, Context context) {
        JSONObject b = m2344b(context);
        if (b == null) {
            b = new JSONObject();
        }
        if (!b.has(str)) {
            try {
                b.put(str, new JSONObject());
            } catch (JSONException unused) {
            }
        }
        return b;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:5|6|7|8|9|10|11|12|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0023 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0026 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m2341a(int r4, java.lang.String r5, android.content.Context r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.Object r0 = f2311a
            monitor-enter(r0)
            java.lang.String r5 = com.applovin.impl.sdk.utils.C1160r.m2748c((java.lang.String) r5)     // Catch:{ all -> 0x002b }
            org.json.JSONObject r1 = m2340a((java.lang.String) r5, (android.content.Context) r6)     // Catch:{ all -> 0x002b }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x002b }
            org.json.JSONObject r2 = r1.optJSONObject(r5)     // Catch:{ all -> 0x002b }
            int r3 = r2.optInt(r4)     // Catch:{ all -> 0x002b }
            int r3 = r3 + 1
            r2.put(r4, r3)     // Catch:{ JSONException -> 0x0023 }
        L_0x0023:
            r1.put(r5, r2)     // Catch:{ JSONException -> 0x0026 }
        L_0x0026:
            m2343a((org.json.JSONObject) r1, (android.content.Context) r6)     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.C1089d.m2341a(int, java.lang.String, android.content.Context):void");
    }

    /* renamed from: a */
    public static void m2342a(Context context) {
        synchronized (f2311a) {
            C0968e.m1768a(C0967d.f1863r, context);
        }
    }

    /* renamed from: a */
    private static void m2343a(JSONObject jSONObject, Context context) {
        C0968e.m1769a(C0967d.f1863r, jSONObject.toString(), context);
    }

    /* renamed from: b */
    public static JSONObject m2344b(Context context) {
        JSONObject jSONObject;
        synchronized (f2311a) {
            try {
                jSONObject = new JSONObject((String) C0968e.m1771b(C0967d.f1863r, "{}", context));
            } catch (JSONException unused) {
                return new JSONObject();
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject;
    }
}
