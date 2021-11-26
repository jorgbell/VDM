package com.chartboost.sdk.Tracking;

import android.content.SharedPreferences;
import com.chartboost.sdk.Libraries.C1214c;
import java.util.UUID;

/* renamed from: com.chartboost.sdk.Tracking.g */
public class C1268g {

    /* renamed from: a */
    private SharedPreferences f2951a;

    /* renamed from: b */
    private String f2952b;

    /* renamed from: c */
    private long f2953c = 0;

    /* renamed from: d */
    private int f2954d = 0;

    /* renamed from: e */
    private int f2955e = 0;

    /* renamed from: f */
    private int f2956f = 0;

    /* renamed from: g */
    private int f2957g = 0;

    public C1268g(SharedPreferences sharedPreferences) {
        this.f2951a = sharedPreferences;
        this.f2954d = m3229f();
    }

    /* renamed from: f */
    private int m3229f() {
        SharedPreferences sharedPreferences = this.f2951a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("session_key", 0);
        }
        return -1;
    }

    /* renamed from: g */
    private void m3230g() {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f2951a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putInt("session_key", this.f2954d).apply();
        }
    }

    /* renamed from: a */
    public void mo10258a() {
        this.f2952b = m3228b();
        this.f2953c = System.currentTimeMillis();
        this.f2955e = 0;
        this.f2956f = 0;
        this.f2957g = 0;
        this.f2954d++;
        m3230g();
    }

    /* renamed from: b */
    public int mo10260b(int i) {
        if (i == 0) {
            return this.f2955e;
        }
        if (i == 1) {
            return this.f2956f;
        }
        if (i != 3) {
            return 0;
        }
        return this.f2957g;
    }

    /* renamed from: c */
    public int mo10261c() {
        return this.f2954d;
    }

    /* renamed from: d */
    public long mo10262d() {
        return System.currentTimeMillis() - this.f2953c;
    }

    /* renamed from: e */
    public String mo10263e() {
        return this.f2952b;
    }

    /* renamed from: b */
    private String m3228b() {
        String uuid = UUID.randomUUID().toString();
        String a = C1214c.m2927a(uuid);
        return a != null ? a : uuid;
    }

    /* renamed from: a */
    public void mo10259a(int i) {
        if (i == 0) {
            this.f2955e++;
        } else if (i == 1) {
            this.f2956f++;
        } else if (i == 3) {
            this.f2957g++;
        }
    }
}
