package com.applovin.impl.adview.activity;

import android.content.Context;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.activity.b */
public class C0577b {

    /* renamed from: a */
    private final AppLovinFullscreenActivity f320a;

    /* renamed from: b */
    private final int f321b;

    /* renamed from: c */
    private final int f322c;

    /* renamed from: d */
    private final boolean f323d;

    public C0577b(AppLovinFullscreenActivity appLovinFullscreenActivity) {
        this.f320a = appLovinFullscreenActivity;
        int d = C1160r.m2751d((Context) appLovinFullscreenActivity);
        this.f322c = d;
        boolean isTablet = AppLovinSdkUtils.isTablet(appLovinFullscreenActivity);
        this.f323d = isTablet;
        this.f321b = m364a(d, isTablet);
    }

    /* renamed from: a */
    private int m364a(int i, boolean z) {
        if (z) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            return i == 3 ? 1 : -1;
        } else if (i == 0) {
            return 1;
        } else {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 9;
            }
            return i == 3 ? 8 : -1;
        }
    }

    /* renamed from: a */
    private void m365a(int i) {
        try {
            this.f320a.setRequestedOrientation(i);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r6 == 2) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r6 == 1) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r6 != 3) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        if (r6 != 1) goto L_0x001a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m366a(com.applovin.impl.sdk.p035a.C0934g.C0937b r5, int r6, boolean r7) {
        /*
            r4 = this;
            com.applovin.impl.sdk.a.g$b r0 = com.applovin.impl.sdk.p035a.C0934g.C0937b.ACTIVITY_PORTRAIT
            r1 = 3
            r2 = 2
            r3 = 1
            if (r5 != r0) goto L_0x0024
            r5 = 9
            if (r7 == 0) goto L_0x0016
            if (r6 == r3) goto L_0x0010
            if (r6 == r1) goto L_0x0010
            goto L_0x001a
        L_0x0010:
            if (r6 != r3) goto L_0x001a
        L_0x0012:
            r4.m365a((int) r5)
            goto L_0x0042
        L_0x0016:
            if (r6 == 0) goto L_0x001e
            if (r6 == r2) goto L_0x001e
        L_0x001a:
            r4.m365a((int) r3)
            goto L_0x0042
        L_0x001e:
            if (r6 != 0) goto L_0x0021
            goto L_0x001a
        L_0x0021:
            r3 = 9
            goto L_0x001a
        L_0x0024:
            com.applovin.impl.sdk.a.g$b r0 = com.applovin.impl.sdk.p035a.C0934g.C0937b.ACTIVITY_LANDSCAPE
            if (r5 != r0) goto L_0x0042
            r5 = 8
            r0 = 0
            if (r7 == 0) goto L_0x0037
            if (r6 == 0) goto L_0x0032
            if (r6 == r2) goto L_0x0032
            goto L_0x003b
        L_0x0032:
            if (r6 != r2) goto L_0x0035
            goto L_0x0012
        L_0x0035:
            r5 = 0
            goto L_0x0012
        L_0x0037:
            if (r6 == r3) goto L_0x003f
            if (r6 == r1) goto L_0x003f
        L_0x003b:
            r4.m365a((int) r0)
            goto L_0x0042
        L_0x003f:
            if (r6 != r3) goto L_0x0012
            goto L_0x0035
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.activity.C0577b.m366a(com.applovin.impl.sdk.a.g$b, int, boolean):void");
    }

    /* renamed from: a */
    public void mo7968a(C0934g gVar) {
        int i;
        if (!gVar.mo8995D() || (i = this.f321b) == -1) {
            m366a(gVar.mo9064p(), this.f322c, this.f323d);
        } else {
            m365a(i);
        }
    }
}
