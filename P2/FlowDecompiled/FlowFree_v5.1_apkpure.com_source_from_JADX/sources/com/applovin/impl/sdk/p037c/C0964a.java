package com.applovin.impl.sdk.p037c;

import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.c.a */
public class C0964a<T> extends C0965b<T> {

    /* renamed from: A */
    public static final C0965b<Boolean> f1523A;

    /* renamed from: B */
    public static final C0965b<Boolean> f1524B;

    /* renamed from: C */
    public static final C0965b<Long> f1525C = C0965b.m1746a("ad_expiration_ms", Long.valueOf(TimeUnit.HOURS.toMillis(4)));

    /* renamed from: D */
    public static final C0965b<Boolean> f1526D;

    /* renamed from: E */
    public static final C0965b<Long> f1527E = C0965b.m1746a("fullscreen_ad_displayed_timeout_ms", -1L);

    /* renamed from: F */
    public static final C0965b<Long> f1528F = C0965b.m1746a("ad_hidden_timeout_ms", -1L);

    /* renamed from: G */
    public static final C0965b<Boolean> f1529G;

    /* renamed from: H */
    public static final C0965b<Long> f1530H;

    /* renamed from: I */
    public static final C0965b<Boolean> f1531I;

    /* renamed from: J */
    public static final C0965b<Integer> f1532J = C0965b.m1746a("mute_state", 2);

    /* renamed from: K */
    public static final C0965b<Boolean> f1533K;

    /* renamed from: L */
    public static final C0965b<String> f1534L = C0965b.m1746a("saf", "");

    /* renamed from: M */
    public static final C0965b<String> f1535M = C0965b.m1746a("saui", "");

    /* renamed from: N */
    public static final C0965b<Integer> f1536N = C0965b.m1746a("mra", -1);

    /* renamed from: O */
    public static final C0965b<String> f1537O = C0965b.m1746a("mra_af", "INTER,REWARDED,REWARDED_INTER,BANNER,LEADER,MREC");

    /* renamed from: P */
    public static final C0965b<Boolean> f1538P;

    /* renamed from: Q */
    public static final C0965b<Long> f1539Q = C0965b.m1746a("lpd_s", -1L);

    /* renamed from: R */
    public static final C0965b<Boolean> f1540R;

    /* renamed from: S */
    public static final C0965b<Boolean> f1541S;

    /* renamed from: a */
    public static final C0965b<String> f1542a = C0965b.m1746a("afi", "");

    /* renamed from: b */
    public static final C0965b<Long> f1543b;

    /* renamed from: c */
    public static final C0965b<String> f1544c = C0965b.m1746a("mediation_endpoint", "https://ms.applovin.com/");

    /* renamed from: d */
    public static final C0965b<String> f1545d = C0965b.m1746a("mediation_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: e */
    public static final C0965b<Long> f1546e;

    /* renamed from: f */
    public static final C0965b<Long> f1547f;

    /* renamed from: g */
    public static final C0965b<Long> f1548g;

    /* renamed from: h */
    public static final C0965b<Boolean> f1549h;

    /* renamed from: i */
    public static final C0965b<String> f1550i = C0965b.m1746a("postback_macros", "{\"{MCODE}\":\"mcode\",\"{BCODE}\":\"bcode\",\"{ICODE}\":\"icode\",\"{SCODE}\":\"scode\"}");

    /* renamed from: j */
    public static final C0965b<Boolean> f1551j;

    /* renamed from: k */
    public static final C0965b<Long> f1552k;

    /* renamed from: l */
    public static final C0965b<Long> f1553l;

    /* renamed from: m */
    public static final C0965b<Long> f1554m;

    /* renamed from: n */
    public static final C0965b<Long> f1555n;

    /* renamed from: o */
    public static final C0965b<String> f1556o = C0965b.m1746a("ad_load_failure_refresh_ignore_error_codes", "204");

    /* renamed from: p */
    public static final C0965b<Long> f1557p = C0965b.m1746a("refresh_ad_on_app_resume_elapsed_threshold_ms", 0L);

    /* renamed from: q */
    public static final C0965b<Boolean> f1558q;

    /* renamed from: r */
    public static final C0965b<Boolean> f1559r;

    /* renamed from: s */
    public static final C0965b<Boolean> f1560s;

    /* renamed from: t */
    public static final C0965b<Long> f1561t = C0965b.m1746a("ad_view_fade_in_animation_ms", 150L);

    /* renamed from: u */
    public static final C0965b<Long> f1562u = C0965b.m1746a("ad_view_fade_out_animation_ms", 150L);

    /* renamed from: v */
    public static final C0965b<Long> f1563v = C0965b.m1746a("fullscreen_display_delay_ms", 600L);

    /* renamed from: w */
    public static final C0965b<Long> f1564w = C0965b.m1746a("ahdm", 500L);

    /* renamed from: x */
    public static final C0965b<Long> f1565x = C0965b.m1746a("ad_view_refresh_precache_request_viewability_undesired_flags", 502L);

    /* renamed from: y */
    public static final C0965b<Long> f1566y;

    /* renamed from: z */
    public static final C0965b<Boolean> f1567z;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f1543b = C0965b.m1746a("afi_ms", Long.valueOf(timeUnit.toMillis(5)));
        f1546e = C0965b.m1746a("fetch_next_ad_retry_delay_ms", Long.valueOf(timeUnit.toMillis(2)));
        f1547f = C0965b.m1746a("fetch_next_ad_timeout_ms", Long.valueOf(timeUnit.toMillis(5)));
        f1548g = C0965b.m1746a("fetch_mediation_debugger_info_timeout_ms", Long.valueOf(timeUnit.toMillis(7)));
        Boolean bool = Boolean.TRUE;
        f1549h = C0965b.m1746a("auto_init_mediation_debugger", bool);
        Boolean bool2 = Boolean.FALSE;
        f1551j = C0965b.m1746a("persistent_mediated_postbacks", bool2);
        f1552k = C0965b.m1746a("max_signal_provider_latency_ms", Long.valueOf(timeUnit.toMillis(30)));
        f1553l = C0965b.m1746a("default_adapter_timeout_ms", Long.valueOf(timeUnit.toMillis(10)));
        f1554m = C0965b.m1746a("ad_refresh_ms", Long.valueOf(timeUnit.toMillis(30)));
        f1555n = C0965b.m1746a("ad_load_failure_refresh_ms", Long.valueOf(timeUnit.toMillis(30)));
        f1558q = C0965b.m1746a("refresh_ad_view_timer_responds_to_background", bool);
        f1559r = C0965b.m1746a("refresh_ad_view_timer_responds_to_store_kit", bool);
        f1560s = C0965b.m1746a("refresh_ad_view_timer_responds_to_window_visibility_changed", bool2);
        f1566y = C0965b.m1746a("ad_view_refresh_precache_request_delay_ms", Long.valueOf(timeUnit.toMillis(2)));
        f1567z = C0965b.m1746a("ad_view_block_publisher_load_if_refresh_scheduled", bool);
        f1523A = C0965b.m1746a("fullscreen_ads_block_publisher_load_if_another_showing", bool);
        f1524B = C0965b.m1746a("fabsina", bool2);
        f1526D = C0965b.m1746a("saewib", bool2);
        f1529G = C0965b.m1746a("schedule_ad_hidden_on_ad_dismiss", bool2);
        f1530H = C0965b.m1746a("ad_hidden_on_ad_dismiss_callback_delay_ms", Long.valueOf(timeUnit.toMillis(1)));
        f1531I = C0965b.m1746a("proe", bool2);
        f1533K = C0965b.m1746a("adapters_to_re_fetch_sdk_version_if_empty", bool);
        f1538P = C0965b.m1746a("pmp", bool2);
        f1540R = C0965b.m1746a("fetch_mediated_ad_gzip", bool2);
        f1541S = C0965b.m1746a("max_postback_gzip", bool2);
    }
}
