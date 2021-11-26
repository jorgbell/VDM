package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.webkit.WebSettings;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.w */
public final class C0719w {

    /* renamed from: a */
    private C1062k f707a;

    /* renamed from: b */
    private JSONObject f708b;

    public C0719w(JSONObject jSONObject, C1062k kVar) {
        this.f707a = kVar;
        this.f708b = jSONObject;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(21)
    /* renamed from: a */
    public Integer mo8302a() {
        int i;
        String b = C1123j.m2594b(this.f708b, "mixed_content_mode", (String) null, this.f707a);
        if (C1155o.m2673b(b)) {
            if ("always_allow".equalsIgnoreCase(b)) {
                i = 0;
            } else if ("never_allow".equalsIgnoreCase(b)) {
                i = 1;
            } else if ("compatibility_mode".equalsIgnoreCase(b)) {
                i = 2;
            }
            return Integer.valueOf(i);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public WebSettings.PluginState mo8303b() {
        String b = C1123j.m2594b(this.f708b, "plugin_state", (String) null, this.f707a);
        if (C1155o.m2673b(b)) {
            if ("on".equalsIgnoreCase(b)) {
                return WebSettings.PluginState.ON;
            }
            if ("on_demand".equalsIgnoreCase(b)) {
                return WebSettings.PluginState.ON_DEMAND;
            }
            if ("off".equalsIgnoreCase(b)) {
                return WebSettings.PluginState.OFF;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Boolean mo8304c() {
        return C1123j.m2568a(this.f708b, "allow_file_access", (Boolean) null, this.f707a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Boolean mo8305d() {
        return C1123j.m2568a(this.f708b, "load_with_overview_mode", (Boolean) null, this.f707a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Boolean mo8306e() {
        return C1123j.m2568a(this.f708b, "use_wide_view_port", (Boolean) null, this.f707a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public Boolean mo8307f() {
        return C1123j.m2568a(this.f708b, "allow_content_access", (Boolean) null, this.f707a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public Boolean mo8308g() {
        return C1123j.m2568a(this.f708b, "use_built_in_zoom_controls", (Boolean) null, this.f707a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public Boolean mo8309h() {
        return C1123j.m2568a(this.f708b, "display_zoom_controls", (Boolean) null, this.f707a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public Boolean mo8310i() {
        return C1123j.m2568a(this.f708b, "save_form_data", (Boolean) null, this.f707a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public Boolean mo8311j() {
        return C1123j.m2568a(this.f708b, "geolocation_enabled", (Boolean) null, this.f707a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public Boolean mo8312k() {
        return C1123j.m2568a(this.f708b, "need_initial_focus", (Boolean) null, this.f707a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public Boolean mo8313l() {
        return C1123j.m2568a(this.f708b, "allow_file_access_from_file_urls", (Boolean) null, this.f707a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public Boolean mo8314m() {
        return C1123j.m2568a(this.f708b, "allow_universal_access_from_file_urls", (Boolean) null, this.f707a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public Boolean mo8315n() {
        return C1123j.m2568a(this.f708b, "offscreen_pre_raster", (Boolean) null, this.f707a);
    }
}
