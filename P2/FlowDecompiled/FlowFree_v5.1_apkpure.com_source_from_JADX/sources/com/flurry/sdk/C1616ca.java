package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.flurry.sdk.ca */
public final class C1616ca {

    /* renamed from: a */
    public SharedPreferences f4079a;

    /* renamed from: b */
    int f4080b = 0;

    /* renamed from: c */
    long f4081c;

    /* renamed from: d */
    private Timer f4082d;

    /* renamed from: e */
    private final Object f4083e;

    public C1616ca() {
        long j = 604800000;
        this.f4081c = 604800000;
        this.f4083e = new Object();
        Context a = C1536b.m4057a();
        if (a != null) {
            this.f4079a = a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
            C1564bl.m4094a();
            this.f4080b = C1564bl.m4096b(a);
            SharedPreferences sharedPreferences = this.f4079a;
            this.f4081c = sharedPreferences != null ? sharedPreferences.getLong("refreshFetch", 604800000) : j;
        }
    }

    /* renamed from: a */
    public final int mo11374a() {
        SharedPreferences sharedPreferences = this.f4079a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("appVersion", 0);
        }
        return 0;
    }

    /* renamed from: e */
    private void m4215e() {
        SharedPreferences sharedPreferences = this.f4079a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("appVersion").apply();
        }
    }

    /* renamed from: a */
    public final synchronized void mo11376a(TimerTask timerTask, long j) {
        synchronized (this.f4083e) {
            C1648cy.m4319a("ConfigMeta", "Record retry after " + j + " msecs.");
            Timer timer = new Timer("retry-scheduler");
            this.f4082d = timer;
            timer.schedule(timerTask, j);
        }
    }

    /* renamed from: b */
    public final void mo11377b() {
        synchronized (this.f4083e) {
            if (this.f4082d != null) {
                C1648cy.m4317a(3, "ConfigMeta", "Clear retry.");
                this.f4082d.cancel();
                this.f4082d.purge();
                this.f4082d = null;
            }
        }
    }

    /* renamed from: c */
    public final void mo11378c() {
        C1648cy.m4319a("ConfigMeta", "Clear all ConfigMeta data.");
        mo11377b();
        m4215e();
        m4216f();
        m4217g();
        m4218h();
        m4219i();
        m4220j();
    }

    /* renamed from: f */
    private void m4216f() {
        SharedPreferences sharedPreferences = this.f4079a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("lastFetch").apply();
        }
    }

    /* renamed from: a */
    public final void mo11375a(long j) {
        SharedPreferences sharedPreferences = this.f4079a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("lastFetch", j).apply();
        }
    }

    /* renamed from: g */
    private void m4217g() {
        SharedPreferences sharedPreferences = this.f4079a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("lastETag").apply();
        }
    }

    /* renamed from: d */
    public final String mo11379d() {
        SharedPreferences sharedPreferences = this.f4079a;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("lastKeyId", (String) null);
        }
        return null;
    }

    /* renamed from: h */
    private void m4218h() {
        SharedPreferences sharedPreferences = this.f4079a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("lastKeyId").apply();
        }
    }

    /* renamed from: i */
    private void m4219i() {
        SharedPreferences sharedPreferences = this.f4079a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("lastRSA").apply();
        }
    }

    /* renamed from: j */
    private void m4220j() {
        SharedPreferences sharedPreferences = this.f4079a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("com.flurry.sdk.variant_ids").apply();
        }
    }
}
