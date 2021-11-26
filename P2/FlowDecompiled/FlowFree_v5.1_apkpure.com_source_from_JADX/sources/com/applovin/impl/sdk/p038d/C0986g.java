package com.applovin.impl.sdk.p038d;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.d.g */
public class C0986g {

    /* renamed from: a */
    public static final C0986g f1954a = m1862a("ad_req");

    /* renamed from: b */
    public static final C0986g f1955b = m1862a("ad_imp");

    /* renamed from: c */
    public static final C0986g f1956c = m1862a("ad_session_start");

    /* renamed from: d */
    public static final C0986g f1957d = m1862a("ad_imp_session");

    /* renamed from: e */
    public static final C0986g f1958e = m1862a("cached_files_expired");

    /* renamed from: f */
    public static final C0986g f1959f = m1862a("cache_drop_count");

    /* renamed from: g */
    public static final C0986g f1960g = m1863a("sdk_reset_state_count", true);

    /* renamed from: h */
    public static final C0986g f1961h = m1863a("ad_response_process_failures", true);

    /* renamed from: i */
    public static final C0986g f1962i = m1863a("response_process_failures", true);

    /* renamed from: j */
    public static final C0986g f1963j = m1863a("incent_failed_to_display_count", true);

    /* renamed from: k */
    public static final C0986g f1964k = m1862a("app_paused_and_resumed");

    /* renamed from: l */
    public static final C0986g f1965l = m1863a("ad_rendered_with_mismatched_sdk_key", true);

    /* renamed from: m */
    public static final C0986g f1966m = m1862a("ad_shown_outside_app_count");

    /* renamed from: n */
    public static final C0986g f1967n = m1862a("med_ad_req");

    /* renamed from: o */
    public static final C0986g f1968o = m1863a("med_ad_response_process_failures", true);

    /* renamed from: p */
    public static final C0986g f1969p = m1863a("med_adapters_failed_init_missing_activity", true);

    /* renamed from: q */
    public static final C0986g f1970q = m1863a("med_waterfall_ad_no_fill", true);

    /* renamed from: r */
    public static final C0986g f1971r = m1863a("med_waterfall_ad_adapter_load_failed", true);

    /* renamed from: s */
    public static final C0986g f1972s = m1863a("med_waterfall_ad_invalid_response", true);

    /* renamed from: t */
    private static final Set<String> f1973t = new HashSet(32);

    /* renamed from: v */
    private static final Set<C0986g> f1974v = new HashSet(16);

    /* renamed from: u */
    private final String f1975u;

    static {
        m1862a("fullscreen_ad_nil_vc_count");
        m1862a("applovin_bundle_missing");
    }

    private C0986g(String str) {
        this.f1975u = str;
    }

    /* renamed from: a */
    private static C0986g m1862a(String str) {
        return m1863a(str, false);
    }

    /* renamed from: a */
    private static C0986g m1863a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            Set<String> set = f1973t;
            if (!set.contains(str)) {
                set.add(str);
                C0986g gVar = new C0986g(str);
                if (z) {
                    f1974v.add(gVar);
                }
                return gVar;
            }
            throw new IllegalArgumentException("Key has already been used: " + str);
        }
        throw new IllegalArgumentException("No key name specified");
    }

    /* renamed from: b */
    public static Set<C0986g> m1864b() {
        return f1974v;
    }

    /* renamed from: a */
    public String mo9198a() {
        return this.f1975u;
    }
}
