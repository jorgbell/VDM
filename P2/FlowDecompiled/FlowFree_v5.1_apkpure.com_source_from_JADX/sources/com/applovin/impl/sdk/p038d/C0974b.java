package com.applovin.impl.sdk.p038d;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.d.b */
public class C0974b {

    /* renamed from: A */
    public static final C0974b f1888A = m1797a("wvhec", "WEB_VIEW_HTTP_ERROR_COUNT");

    /* renamed from: B */
    public static final C0974b f1889B = m1797a("wvrec", "WEB_VIEW_RENDER_ERROR_COUNT");

    /* renamed from: C */
    public static final C0974b f1890C = m1797a("wvsem", "WEB_VIEW_SSL_ERROR_MESSAGES");

    /* renamed from: D */
    public static final C0974b f1891D = m1797a("wvruc", "WEB_VIEW_RENDERER_UNRESPONSIVE_COUNT");

    /* renamed from: G */
    private static final Set<String> f1892G = new HashSet(32);

    /* renamed from: a */
    static final C0974b f1893a = m1797a("sas", "AD_SOURCE");

    /* renamed from: b */
    static final C0974b f1894b = m1797a("srt", "AD_RENDER_TIME");

    /* renamed from: c */
    static final C0974b f1895c = m1797a("sft", "AD_FETCH_TIME");

    /* renamed from: d */
    static final C0974b f1896d = m1797a("sfs", "AD_FETCH_SIZE");

    /* renamed from: e */
    static final C0974b f1897e = m1797a("sadb", "AD_DOWNLOADED_BYTES");

    /* renamed from: f */
    static final C0974b f1898f = m1797a("sacb", "AD_CACHED_BYTES");

    /* renamed from: g */
    static final C0974b f1899g = m1797a("stdl", "TIME_TO_DISPLAY_FROM_LOAD");

    /* renamed from: h */
    static final C0974b f1900h = m1797a("stdi", "TIME_TO_DISPLAY_FROM_INIT");

    /* renamed from: i */
    static final C0974b f1901i = m1797a("snas", "AD_NUMBER_IN_SESSION");

    /* renamed from: j */
    static final C0974b f1902j = m1797a("snat", "AD_NUMBER_TOTAL");

    /* renamed from: k */
    static final C0974b f1903k = m1797a("stah", "TIME_AD_HIDDEN_FROM_SHOW");

    /* renamed from: l */
    static final C0974b f1904l = m1797a("stas", "TIME_TO_SKIP_FROM_SHOW");

    /* renamed from: m */
    static final C0974b f1905m = m1797a("stac", "TIME_TO_CLICK_FROM_SHOW");

    /* renamed from: n */
    static final C0974b f1906n = m1797a("stbe", "TIME_TO_EXPAND_FROM_SHOW");

    /* renamed from: o */
    static final C0974b f1907o = m1797a("stbc", "TIME_TO_CONTRACT_FROM_SHOW");

    /* renamed from: p */
    static final C0974b f1908p = m1797a("saan", "AD_SHOWN_WITH_ACTIVE_NETWORK");

    /* renamed from: q */
    static final C0974b f1909q = m1797a("suvs", "INTERSTITIAL_USED_VIDEO_STREAM");

    /* renamed from: r */
    static final C0974b f1910r = m1797a("sugs", "AD_USED_GRAPHIC_STREAM");

    /* renamed from: s */
    static final C0974b f1911s = m1797a("svpv", "INTERSTITIAL_VIDEO_PERCENT_VIEWED");

    /* renamed from: t */
    static final C0974b f1912t = m1797a("stpd", "INTERSTITIAL_PAUSED_DURATION");

    /* renamed from: u */
    static final C0974b f1913u = m1797a("shsc", "HTML_RESOURCE_CACHE_SUCCESS_COUNT");

    /* renamed from: v */
    static final C0974b f1914v = m1797a("shfc", "HTML_RESOURCE_CACHE_FAILURE_COUNT");

    /* renamed from: w */
    static final C0974b f1915w = m1797a("schc", "AD_CANCELLED_HTML_CACHING");

    /* renamed from: x */
    static final C0974b f1916x = m1797a("smwm", "AD_SHOWN_IN_MULTIWINDOW_MODE");

    /* renamed from: y */
    static final C0974b f1917y = m1797a("vssc", "VIDEO_STREAM_STALLED_COUNT");

    /* renamed from: z */
    public static final C0974b f1918z = m1797a("wvem", "WEB_VIEW_ERROR_MESSAGES");

    /* renamed from: E */
    private final String f1919E;

    /* renamed from: F */
    private final String f1920F;

    static {
        m1797a("sisw", "IS_STREAMING_WEBKIT");
        m1797a("surw", "UNABLE_TO_RETRIEVE_WEBKIT_HTML_STRING");
        m1797a("surp", "UNABLE_TO_PERSIST_WEBKIT_HTML_PLACEMENT_REPLACED_STRING");
        m1797a("swhp", "SUCCESSFULLY_PERSISTED_WEBKIT_HTML_STRING");
        m1797a("skr", "STOREKIT_REDIRECTED");
        m1797a("sklf", "STOREKIT_LOAD_FAILURE");
        m1797a("skps", "STOREKIT_PRELOAD_SKIPPED");
    }

    private C0974b(String str, String str2) {
        this.f1919E = str;
        this.f1920F = str2;
    }

    /* renamed from: a */
    private static C0974b m1797a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Set<String> set = f1892G;
            if (set.contains(str)) {
                throw new IllegalArgumentException("Key has already been used: " + str);
            } else if (!TextUtils.isEmpty(str2)) {
                set.add(str);
                return new C0974b(str, str2);
            } else {
                throw new IllegalArgumentException("No debug name specified");
            }
        } else {
            throw new IllegalArgumentException("No key name specified");
        }
    }

    /* renamed from: a */
    public String mo9156a() {
        return this.f1919E;
    }

    /* renamed from: b */
    public String mo9157b() {
        return this.f1920F;
    }
}
