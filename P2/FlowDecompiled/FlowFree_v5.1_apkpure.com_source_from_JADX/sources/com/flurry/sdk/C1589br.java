package com.flurry.sdk;

/* renamed from: com.flurry.sdk.br */
public final class C1589br extends C1566bn {
    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final String mo11329d() {
        return "https://data.flurry.com/aap.do";
    }

    public C1589br() {
        super("Analytics", "FlurryStreamingUpdateDataSender");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo11323a(int i, String str, String str2) {
        if (C1913n.m4811a().f4732k.f3888d.get()) {
            C1698dz.m4443a(i, str, str2, true);
            return;
        }
        C1739fe.m4511a("last_legacy_http_error_code", i);
        C1739fe.m4513a("last_legacy_http_error_message", str);
        C1739fe.m4513a("last_legacy_http_report_identifier", str2);
    }
}
