package com.flurry.sdk;

import android.text.TextUtils;

/* renamed from: com.flurry.sdk.bs */
public final class C1590bs extends C1566bn {
    public C1590bs() {
        super("Streaming", "FlurryStreamingWithFramesDataSender");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final String mo11329d() {
        String b = C1650d.m4337b();
        if (TextUtils.isEmpty(b)) {
            return "https://data.flurry.com/v1/flr.do";
        }
        return b + "/v1/flr.do";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo11323a(int i, String str, String str2) {
        if (C1913n.m4811a().f4732k.f3888d.get()) {
            C1698dz.m4443a(i, str, str2, true);
            return;
        }
        C1739fe.m4511a("last_streaming_http_error_code", i);
        C1739fe.m4513a("last_streaming_http_error_message", str);
        C1739fe.m4513a("last_streaming_http_report_identifier", str2);
    }
}
