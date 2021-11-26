package com.applovin.impl.sdk.p038d;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p037c.C0967d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.f */
public class C0983f {

    /* renamed from: a */
    private final List<C0985a> f1946a;

    /* renamed from: b */
    private final Object f1947b = new Object();

    /* renamed from: c */
    private final C1062k f1948c;

    /* renamed from: d */
    private final C1107r f1949d;

    /* renamed from: com.applovin.impl.sdk.d.f$a */
    private static class C0985a {

        /* renamed from: a */
        private final Long f1950a;

        /* renamed from: b */
        private final String f1951b;

        /* renamed from: c */
        private final String f1952c;

        /* renamed from: d */
        private final String f1953d;

        private C0985a(String str, Throwable th) {
            this.f1951b = str;
            this.f1950a = Long.valueOf(System.currentTimeMillis());
            String str2 = null;
            this.f1952c = th != null ? th.getClass().getName() : null;
            this.f1953d = th != null ? th.getMessage() : str2;
        }

        private C0985a(JSONObject jSONObject) throws JSONException {
            this.f1951b = jSONObject.getString("ms");
            this.f1950a = Long.valueOf(jSONObject.getLong("ts"));
            JSONObject optJSONObject = jSONObject.optJSONObject("ex");
            String str = null;
            this.f1952c = optJSONObject != null ? optJSONObject.getString("nm") : null;
            this.f1953d = optJSONObject != null ? optJSONObject.getString("rn") : str;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public JSONObject m1860a() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ms", this.f1951b);
            jSONObject.put("ts", this.f1950a);
            if (!TextUtils.isEmpty(this.f1952c)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("nm", this.f1952c);
                if (!TextUtils.isEmpty(this.f1953d)) {
                    jSONObject2.put("rn", this.f1953d);
                }
                jSONObject.put("ex", jSONObject2);
            }
            return jSONObject;
        }

        public String toString() {
            return "ErrorLog{timestampMillis=" + this.f1950a + ",message='" + this.f1951b + '\'' + ",throwableName='" + this.f1952c + '\'' + ",throwableReason='" + this.f1953d + '\'' + '}';
        }
    }

    public C0983f(C1062k kVar) {
        this.f1948c = kVar;
        this.f1949d = kVar.mo9411z();
        this.f1946a = new ArrayList();
    }

    /* renamed from: d */
    private void m1855d() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f1947b) {
            for (C0985a next : this.f1946a) {
                try {
                    jSONArray.put(next.m1860a());
                } catch (JSONException e) {
                    this.f1949d.mo9581a("ErrorManager", Boolean.FALSE, "Failed to convert error log into json.", e);
                    this.f1946a.remove(next);
                }
            }
        }
        this.f1948c.mo9357a(C0967d.f1861p, jSONArray.toString());
    }

    /* renamed from: a */
    public JSONArray mo9193a() {
        JSONArray jSONArray;
        synchronized (this.f1947b) {
            jSONArray = new JSONArray();
            for (C0985a a : this.f1946a) {
                try {
                    jSONArray.put(a.m1860a());
                } catch (JSONException e) {
                    this.f1949d.mo9581a("ErrorManager", Boolean.FALSE, "Failed to convert error log into json.", e);
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public void mo9194a(String str, Throwable th) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f1947b) {
                if (this.f1946a.size() < ((Integer) this.f1948c.mo9350a(C0965b.f1757dY)).intValue()) {
                    this.f1946a.add(new C0985a(str, th));
                    m1855d();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo9195b() {
        String str = (String) this.f1948c.mo9379b(C0967d.f1861p, null);
        if (str != null) {
            synchronized (this.f1947b) {
                try {
                    this.f1946a.clear();
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            this.f1946a.add(new C0985a(jSONArray.getJSONObject(i)));
                        } catch (JSONException e) {
                            this.f1949d.mo9581a("ErrorManager", Boolean.FALSE, "Failed to convert error json into a log.", e);
                        }
                    }
                } catch (JSONException e2) {
                    this.f1949d.mo9585b("ErrorManager", "Unable to convert String to json.", e2);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo9196c() {
        synchronized (this.f1947b) {
            this.f1946a.clear();
            this.f1948c.mo9383b(C0967d.f1861p);
        }
    }
}
