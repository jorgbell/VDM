package com.applovin.impl.sdk.p037c;

import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.c.d */
public class C0967d<T> {

    /* renamed from: A */
    public static final C0967d<String> f1843A;

    /* renamed from: B */
    public static final C0967d<String> f1844B;

    /* renamed from: C */
    public static final C0967d<Boolean> f1845C;

    /* renamed from: a */
    public static final C0967d<String> f1846a;

    /* renamed from: b */
    public static final C0967d<Boolean> f1847b;

    /* renamed from: c */
    public static final C0967d<String> f1848c;

    /* renamed from: d */
    public static final C0967d<Long> f1849d = new C0967d<>("com.applovin.sdk.install_date", Long.class);

    /* renamed from: e */
    public static final C0967d<String> f1850e;

    /* renamed from: f */
    public static final C0967d<String> f1851f;

    /* renamed from: g */
    public static final C0967d<String> f1852g;

    /* renamed from: h */
    public static final C0967d<String> f1853h;

    /* renamed from: i */
    public static final C0967d<String> f1854i;

    /* renamed from: j */
    public static final C0967d<String> f1855j;

    /* renamed from: k */
    public static final C0967d<Boolean> f1856k;

    /* renamed from: l */
    public static final C0967d<Boolean> f1857l;

    /* renamed from: m */
    public static final C0967d<Boolean> f1858m;

    /* renamed from: n */
    public static final C0967d<HashSet> f1859n = new C0967d<>("com.applovin.sdk.impl.postbackQueue.key", HashSet.class);

    /* renamed from: o */
    public static final C0967d<String> f1860o;

    /* renamed from: p */
    public static final C0967d<String> f1861p;

    /* renamed from: q */
    public static final C0967d<HashSet> f1862q = new C0967d<>("com.applovin.sdk.task.stats", HashSet.class);

    /* renamed from: r */
    public static final C0967d<String> f1863r;

    /* renamed from: s */
    public static final C0967d<String> f1864s;

    /* renamed from: t */
    public static final C0967d<String> f1865t;

    /* renamed from: u */
    public static final C0967d<HashSet> f1866u = new C0967d<>("com.applovin.sdk.ad.stats", HashSet.class);

    /* renamed from: v */
    public static final C0967d<Integer> f1867v = new C0967d<>("com.applovin.sdk.last_video_position", Integer.class);

    /* renamed from: w */
    public static final C0967d<Boolean> f1868w;

    /* renamed from: x */
    public static final C0967d<String> f1869x;

    /* renamed from: y */
    public static final C0967d<String> f1870y;

    /* renamed from: z */
    public static final C0967d<String> f1871z;

    /* renamed from: D */
    private final String f1872D;

    /* renamed from: E */
    private final Class<T> f1873E;

    static {
        Class<Boolean> cls = Boolean.class;
        Class<String> cls2 = String.class;
        f1846a = new C0967d<>("com.applovin.sdk.impl.isFirstRun", cls2);
        f1847b = new C0967d<>("com.applovin.sdk.launched_before", cls);
        f1848c = new C0967d<>("com.applovin.sdk.latest_installed_version", cls2);
        f1850e = new C0967d<>("com.applovin.sdk.user_id", cls2);
        f1851f = new C0967d<>("com.applovin.sdk.compass_id", cls2);
        f1852g = new C0967d<>("com.applovin.sdk.compass_random_token", cls2);
        f1853h = new C0967d<>("com.applovin.sdk.applovin_random_token", cls2);
        f1854i = new C0967d<>("com.applovin.sdk.device_test_group", cls2);
        f1855j = new C0967d<>("com.applovin.sdk.variables", cls2);
        f1856k = new C0967d<>("com.applovin.sdk.compliance.has_user_consent", cls);
        f1857l = new C0967d<>("com.applovin.sdk.compliance.is_age_restricted_user", cls);
        f1858m = new C0967d<>("com.applovin.sdk.compliance.is_do_not_sell", cls);
        f1860o = new C0967d<>("com.applovin.sdk.stats", cls2);
        f1861p = new C0967d<>("com.applovin.sdk.errors", cls2);
        f1863r = new C0967d<>("com.applovin.sdk.network_response_code_mapping", cls2);
        f1864s = new C0967d<>("com.applovin.sdk.event_tracking.super_properties", cls2);
        f1865t = new C0967d<>("com.applovin.sdk.request_tracker.counter", cls2);
        f1868w = new C0967d<>("com.applovin.sdk.should_resume_video", cls);
        f1869x = new C0967d<>("com.applovin.sdk.mediation.signal_providers", cls2);
        f1870y = new C0967d<>("com.applovin.sdk.mediation.auto_init_adapters", cls2);
        f1871z = new C0967d<>("com.applovin.sdk.persisted_data", cls2);
        f1843A = new C0967d<>("com.applovin.sdk.mediation_provider", cls2);
        f1844B = new C0967d<>("com.applovin.sdk.mediation.test_mode_network", cls2);
        f1845C = new C0967d<>("com.applovin.sdk.mediation.test_mode_enabled", cls);
    }

    public C0967d(String str, Class<T> cls) {
        this.f1872D = str;
        this.f1873E = cls;
    }

    /* renamed from: a */
    public String mo9130a() {
        return this.f1872D;
    }

    /* renamed from: b */
    public Class<T> mo9131b() {
        return this.f1873E;
    }

    public String toString() {
        return "Key{name='" + this.f1872D + '\'' + ", type=" + this.f1873E + '}';
    }
}
