package com.chartboost.sdk.Tracking;

/* renamed from: com.chartboost.sdk.Tracking.i */
public abstract class C1270i {

    /* renamed from: a */
    private String f2963a;

    /* renamed from: b */
    private String f2964b;

    /* renamed from: c */
    private long f2965c;

    /* renamed from: d */
    private float f2966d;

    /* renamed from: e */
    private C1271a f2967e;

    /* renamed from: f */
    private C1269h f2968f;

    /* renamed from: g */
    private String f2969g;

    /* renamed from: h */
    private String f2970h;

    /* renamed from: i */
    private boolean f2971i;

    /* renamed from: com.chartboost.sdk.Tracking.i$a */
    public enum C1271a {
        INFO,
        CRITICAL,
        ERROR
    }

    public C1270i(String str, String str2, String str3, String str4) {
        m3241a(str, str2, str3, str4);
    }

    /* renamed from: a */
    private void m3241a(String str, String str2, String str3, String str4) {
        mo10280d(str);
        mo10278c(str2);
        mo10270a(0.0f);
        mo10273a(str3);
        mo10275b(str4);
        this.f2965c = System.currentTimeMillis();
        this.f2971i = false;
        mo10271a(new C1269h("", "", "", "", ""));
    }

    /* renamed from: b */
    public void mo10275b(String str) {
        this.f2970h = str;
    }

    /* renamed from: c */
    public void mo10278c(String str) {
        this.f2964b = str;
    }

    /* renamed from: d */
    public void mo10280d(String str) {
        this.f2963a = str;
    }

    /* renamed from: e */
    public String mo10281e() {
        return this.f2964b;
    }

    /* renamed from: f */
    public String mo10282f() {
        return this.f2963a;
    }

    /* renamed from: g */
    public long mo10283g() {
        return this.f2965c;
    }

    /* renamed from: h */
    public long mo10284h() {
        return this.f2965c / 1000;
    }

    /* renamed from: i */
    public C1269h mo10285i() {
        return this.f2968f;
    }

    /* renamed from: j */
    public C1271a mo10286j() {
        return this.f2967e;
    }

    public String toString() {
        return "TrackingEvent{mName='" + this.f2963a + '\'' + ", mMessage='" + this.f2964b + '\'' + ", mTimestamp=" + this.f2965c + ", mLatency=" + this.f2966d + ", mType=" + this.f2967e + ", trackAd=" + this.f2968f + ", impressionAdType=" + this.f2969g + ", location=" + this.f2970h + '}';
    }

    /* renamed from: b */
    public boolean mo10276b() {
        return this.f2971i;
    }

    /* renamed from: c */
    public float mo10277c() {
        return this.f2966d;
    }

    /* renamed from: d */
    public String mo10279d() {
        return this.f2970h;
    }

    /* renamed from: a */
    public void mo10270a(float f) {
        this.f2966d = f;
    }

    /* renamed from: a */
    public void mo10272a(C1271a aVar) {
        this.f2967e = aVar;
    }

    /* renamed from: a */
    public void mo10271a(C1269h hVar) {
        this.f2968f = hVar;
    }

    /* renamed from: a */
    public String mo10269a() {
        return this.f2969g;
    }

    /* renamed from: a */
    public void mo10273a(String str) {
        this.f2969g = str;
    }

    /* renamed from: a */
    public void mo10274a(boolean z) {
        this.f2971i = z;
    }
}
