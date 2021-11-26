package com.chartboost.sdk.Tracking;

import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.chartboost.sdk.Tracking.d */
public class C1265d {

    /* renamed from: a */
    private int f2935a = 10;

    /* renamed from: b */
    private int f2936b = 30;

    /* renamed from: c */
    private HashMap<String, Long> f2937c = new HashMap<>();

    /* renamed from: d */
    private HashMap<String, Integer> f2938d = new HashMap<>();

    /* renamed from: e */
    private HashSet<String> f2939e = new HashSet<>();

    public C1265d(int i, int i2) {
        this.f2935a = i;
        this.f2936b = i2;
    }

    /* renamed from: a */
    private long m3207a(long j, long j2) {
        return (j - j2) / 1000;
    }

    /* renamed from: b */
    public synchronized C1270i mo10253b(C1270i iVar) {
        if (iVar == null) {
            return null;
        }
        String f = iVar.mo10282f();
        long g = iVar.mo10283g();
        long a = m3208a(iVar);
        m3209a(f, g);
        if (m3207a(g, a) > ((long) this.f2936b)) {
            this.f2937c.remove(f);
            m3209a(f, g);
            this.f2938d.remove(f);
        }
        if (this.f2939e.contains(f)) {
            return null;
        }
        if (m3206a(f, m3205a(f)) <= this.f2935a) {
            return iVar;
        }
        this.f2939e.add(iVar.mo10282f());
        return new C1267f("too_many_events", f, "", "");
    }

    /* renamed from: a */
    private void m3209a(String str, long j) {
        if (!this.f2937c.containsKey(str)) {
            this.f2937c.put(str, Long.valueOf(j));
        }
    }

    /* renamed from: a */
    private int m3206a(String str, int i) {
        int i2 = i + 1;
        this.f2938d.put(str, Integer.valueOf(i2));
        return i2;
    }

    /* renamed from: a */
    private int m3205a(String str) {
        Integer num = this.f2938d.get(str);
        if (num == null) {
            num = 0;
        }
        return num.intValue();
    }

    /* renamed from: a */
    private long m3208a(C1270i iVar) {
        Long l = this.f2937c.get(iVar.mo10282f());
        if (l == null) {
            l = Long.valueOf(iVar.mo10283g());
        }
        return l.longValue();
    }
}
