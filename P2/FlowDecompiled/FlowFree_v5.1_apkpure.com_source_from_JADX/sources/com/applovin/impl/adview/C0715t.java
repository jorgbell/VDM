package com.applovin.impl.adview;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.utils.C1123j;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.t */
public class C0715t {

    /* renamed from: a */
    private final int f695a;

    /* renamed from: b */
    private final int f696b;

    /* renamed from: c */
    private final int f697c;

    /* renamed from: d */
    private final int f698d;

    /* renamed from: e */
    private final boolean f699e;

    /* renamed from: f */
    private final int f700f;

    /* renamed from: g */
    private final int f701g;

    /* renamed from: h */
    private final int f702h;

    /* renamed from: i */
    private final float f703i;

    /* renamed from: j */
    private final float f704j;

    public C0715t(JSONObject jSONObject, C1062k kVar) {
        C1107r z = kVar.mo9411z();
        z.mo9586c("VideoButtonProperties", "Updating video button properties with JSON = " + C1123j.m2607f(jSONObject));
        this.f695a = C1123j.m2592b(jSONObject, "width", 64, kVar);
        this.f696b = C1123j.m2592b(jSONObject, "height", 7, kVar);
        this.f697c = C1123j.m2592b(jSONObject, "margin", 20, kVar);
        this.f698d = C1123j.m2592b(jSONObject, "gravity", 85, kVar);
        this.f699e = C1123j.m2568a(jSONObject, "tap_to_fade", Boolean.FALSE, kVar).booleanValue();
        this.f700f = C1123j.m2592b(jSONObject, "tap_to_fade_duration_milliseconds", 500, kVar);
        this.f701g = C1123j.m2592b(jSONObject, "fade_in_duration_milliseconds", 500, kVar);
        this.f702h = C1123j.m2592b(jSONObject, "fade_out_duration_milliseconds", 500, kVar);
        this.f703i = C1123j.m2565a(jSONObject, "fade_in_delay_seconds", 1.0f, kVar);
        this.f704j = C1123j.m2565a(jSONObject, "fade_out_delay_seconds", 6.0f, kVar);
    }

    /* renamed from: a */
    public int mo8286a() {
        return this.f695a;
    }

    /* renamed from: b */
    public int mo8287b() {
        return this.f696b;
    }

    /* renamed from: c */
    public int mo8288c() {
        return this.f697c;
    }

    /* renamed from: d */
    public int mo8289d() {
        return this.f698d;
    }

    /* renamed from: e */
    public boolean mo8290e() {
        return this.f699e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0715t tVar = (C0715t) obj;
        return this.f695a == tVar.f695a && this.f696b == tVar.f696b && this.f697c == tVar.f697c && this.f698d == tVar.f698d && this.f699e == tVar.f699e && this.f700f == tVar.f700f && this.f701g == tVar.f701g && this.f702h == tVar.f702h && Float.compare(tVar.f703i, this.f703i) == 0 && Float.compare(tVar.f704j, this.f704j) == 0;
    }

    /* renamed from: f */
    public long mo8292f() {
        return (long) this.f700f;
    }

    /* renamed from: g */
    public long mo8293g() {
        return (long) this.f701g;
    }

    /* renamed from: h */
    public long mo8294h() {
        return (long) this.f702h;
    }

    public int hashCode() {
        int i = ((((((((((((((this.f695a * 31) + this.f696b) * 31) + this.f697c) * 31) + this.f698d) * 31) + (this.f699e ? 1 : 0)) * 31) + this.f700f) * 31) + this.f701g) * 31) + this.f702h) * 31;
        float f = this.f703i;
        int i2 = 0;
        int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.f704j;
        if (f2 != 0.0f) {
            i2 = Float.floatToIntBits(f2);
        }
        return floatToIntBits + i2;
    }

    /* renamed from: i */
    public float mo8296i() {
        return this.f703i;
    }

    /* renamed from: j */
    public float mo8297j() {
        return this.f704j;
    }

    public String toString() {
        return "VideoButtonProperties{widthPercentOfScreen=" + this.f695a + ", heightPercentOfScreen=" + this.f696b + ", margin=" + this.f697c + ", gravity=" + this.f698d + ", tapToFade=" + this.f699e + ", tapToFadeDurationMillis=" + this.f700f + ", fadeInDurationMillis=" + this.f701g + ", fadeOutDurationMillis=" + this.f702h + ", fadeInDelay=" + this.f703i + ", fadeOutDelay=" + this.f704j + '}';
    }
}
