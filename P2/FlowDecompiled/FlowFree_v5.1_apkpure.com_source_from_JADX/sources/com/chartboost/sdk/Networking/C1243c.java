package com.chartboost.sdk.Networking;

import com.chartboost.sdk.Model.CBError;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.chartboost.sdk.Networking.c */
public class C1243c<T> {

    /* renamed from: a */
    public final String f2847a;

    /* renamed from: b */
    public final String f2848b;

    /* renamed from: c */
    public final int f2849c;

    /* renamed from: d */
    public final AtomicInteger f2850d = new AtomicInteger();

    /* renamed from: e */
    public final File f2851e;

    /* renamed from: f */
    public long f2852f;

    /* renamed from: g */
    public long f2853g;

    /* renamed from: h */
    public long f2854h;

    /* renamed from: i */
    public int f2855i;

    public C1243c(String str, String str2, int i, File file) {
        this.f2847a = str;
        this.f2848b = str2;
        this.f2849c = i;
        this.f2851e = file;
        this.f2852f = 0;
        this.f2853g = 0;
        this.f2854h = 0;
        this.f2855i = 0;
    }

    /* renamed from: a */
    public C1244d mo10142a() {
        return new C1244d((Map<String, String>) null, (byte[]) null, (String) null);
    }

    /* renamed from: a */
    public void mo10144a(CBError cBError, C1246f fVar) {
    }

    /* renamed from: a */
    public void mo10145a(T t, C1246f fVar) {
    }

    /* renamed from: b */
    public boolean mo10146b() {
        return this.f2850d.compareAndSet(0, -1);
    }

    /* renamed from: a */
    public C1245e<T> mo10143a(C1246f fVar) {
        return C1245e.m3093a(null);
    }
}
