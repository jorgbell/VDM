package com.flurry.sdk;

import android.os.SystemClock;
import org.json.JSONException;

/* renamed from: com.flurry.sdk.jn */
public abstract class C1892jn implements C1895jq {

    /* renamed from: a */
    private long f4649a = System.currentTimeMillis();

    /* renamed from: b */
    private long f4650b = SystemClock.elapsedRealtime();

    /* renamed from: c */
    private C1894jp f4651c;

    /* renamed from: d */
    private boolean f4652d;

    public C1892jn(C1894jp jpVar) {
        this.f4651c = jpVar;
        this.f4652d = true;
    }

    /* renamed from: c */
    public final long mo11557c() {
        return this.f4649a;
    }

    /* renamed from: d */
    public final long mo11558d() {
        return this.f4650b;
    }

    /* renamed from: e */
    public final String mo11559e() {
        try {
            return this.f4651c.mo11543a().toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: f */
    public final C1894jp mo11560f() {
        return this.f4651c;
    }

    /* renamed from: h */
    public final boolean mo11562h() {
        return this.f4652d;
    }

    /* renamed from: g */
    public final byte mo11561g() {
        return (this.f4652d ^ true) | true ? (byte) 1 : 0;
    }
}
