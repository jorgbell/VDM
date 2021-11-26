package com.applovin.impl.sdk.p035a;

import android.net.Uri;
import com.applovin.impl.adview.C0651i;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import com.mopub.common.AdType;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.a */
public final class C0924a extends C0934g {

    /* renamed from: a */
    private final String f1388a = mo7824c();

    /* renamed from: b */
    private final String f1389b = mo8958h();

    /* renamed from: c */
    private final String f1390c = m1514aL();

    public C0924a(JSONObject jSONObject, JSONObject jSONObject2, C0925b bVar, C1062k kVar) {
        super(jSONObject, jSONObject2, bVar, kVar);
    }

    /* renamed from: aL */
    private String m1514aL() {
        return getStringFromAdObject("stream_url", "");
    }

    /* renamed from: a */
    public void mo7815a() {
        synchronized (this.adObjectLock) {
            C1123j.m2584a(this.adObject, AdType.HTML, this.f1388a, this.sdk);
            C1123j.m2584a(this.adObject, "stream_url", this.f1390c, this.sdk);
        }
    }

    /* renamed from: a */
    public void mo8955a(Uri uri) {
        synchronized (this.adObjectLock) {
            C1123j.m2584a(this.adObject, "video", uri.toString(), this.sdk);
        }
    }

    /* renamed from: a */
    public void mo8956a(String str) {
        synchronized (this.adObjectLock) {
            C1123j.m2584a(this.adObject, AdType.HTML, str, this.sdk);
        }
    }

    /* renamed from: b */
    public JSONObject mo7823b() {
        JSONObject e;
        synchronized (this.fullResponseLock) {
            e = C1123j.m2606e(this.fullResponse);
        }
        JSONArray b = C1123j.m2599b(e, "ads", new JSONArray(), this.sdk);
        if (b.length() > 0) {
            JSONObject a = C1123j.m2581a(b, 0, new JSONObject(), this.sdk);
            C1123j.m2584a(a, AdType.HTML, this.f1388a, this.sdk);
            C1123j.m2584a(a, "video", this.f1389b, this.sdk);
            C1123j.m2584a(a, "stream_url", this.f1390c, this.sdk);
        }
        return e;
    }

    /* renamed from: c */
    public String mo7824c() {
        String b;
        synchronized (this.adObjectLock) {
            b = C1123j.m2594b(this.adObject, AdType.HTML, (String) null, this.sdk);
        }
        return b;
    }

    /* renamed from: d */
    public String mo7825d() {
        return this.f1389b;
    }

    /* renamed from: e */
    public boolean mo7826e() {
        return this.adObject.has("stream_url");
    }

    /* renamed from: f */
    public void mo8957f() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    /* renamed from: g */
    public Uri mo7829g() {
        String aL = m1514aL();
        if (C1155o.m2673b(aL)) {
            return Uri.parse(aL);
        }
        String h = mo8958h();
        if (C1155o.m2673b(h)) {
            return Uri.parse(h);
        }
        return null;
    }

    /* renamed from: h */
    public String mo8958h() {
        return getStringFromAdObject("video", "");
    }

    public boolean hasVideoUrl() {
        return mo7829g() != null;
    }

    /* renamed from: i */
    public Uri mo7834i() {
        String stringFromAdObject = getStringFromAdObject("click_url", "");
        if (C1155o.m2673b(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: j */
    public Uri mo7835j() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        return C1155o.m2673b(stringFromAdObject) ? Uri.parse(stringFromAdObject) : mo7834i();
    }

    /* renamed from: k */
    public float mo8959k() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    /* renamed from: l */
    public boolean mo8960l() {
        return getBooleanFromAdObject("close_button_graphic_hidden", Boolean.FALSE);
    }

    /* renamed from: m */
    public boolean mo8961m() {
        if (this.adObject.has("close_button_expandable_hidden")) {
            return getBooleanFromAdObject("close_button_expandable_hidden", Boolean.FALSE);
        }
        return true;
    }

    /* renamed from: n */
    public C0651i.C0652a mo8962n() {
        return mo9018a(getIntFromAdObject("expandable_style", C0651i.C0652a.INVISIBLE.mo8193a()));
    }
}
