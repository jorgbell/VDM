package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import com.applovin.impl.mediation.C0762b;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.mediation.p021a.C0735c;
import com.applovin.impl.sdk.C0942b;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxErrorCodes;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MaxFullscreenAdImpl extends C0761a implements C0942b.C0944a {

    /* renamed from: a */
    private final C0754a f809a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0942b f810b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C0762b f811c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object f812d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0735c f813e = null;

    /* renamed from: f */
    private C0760c f814f = C0760c.IDLE;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final AtomicBoolean f815g = new AtomicBoolean();
    protected final C0755b listenerWrapper;

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$a */
    public interface C0754a {
        Activity getActivity();
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$b */
    private class C0755b implements MaxAdListener, MaxRewardedAdListener {
        private C0755b() {
        }

        public void onAdClicked(MaxAd maxAd) {
            C1124k.m2632d(MaxFullscreenAdImpl.this.adListener, maxAd);
        }

        public void onAdDisplayFailed(final MaxAd maxAd, final int i) {
            MaxFullscreenAdImpl.this.m1012a(C0760c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.f810b.mo9079a();
                    MaxFullscreenAdImpl.this.m1009a();
                    MaxFullscreenAdImpl.this.sdk.mo9328D().mo9591b((C0733a) maxAd);
                    C1124k.m2612a(MaxFullscreenAdImpl.this.adListener, maxAd, i);
                }
            });
        }

        public void onAdDisplayed(MaxAd maxAd) {
            MaxFullscreenAdImpl.this.f810b.mo9079a();
            C1124k.m2626b(MaxFullscreenAdImpl.this.adListener, maxAd);
        }

        public void onAdHidden(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.f811c.mo8519a(maxAd);
            MaxFullscreenAdImpl.this.m1012a(C0760c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.m1009a();
                    MaxFullscreenAdImpl.this.sdk.mo9328D().mo9591b((C0733a) maxAd);
                    C1124k.m2630c(MaxFullscreenAdImpl.this.adListener, maxAd);
                }
            });
        }

        public void onAdLoadFailed(final String str, final int i) {
            MaxFullscreenAdImpl.this.m1016b();
            MaxFullscreenAdImpl.this.m1012a(C0760c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    C1124k.m2614a(MaxFullscreenAdImpl.this.adListener, str, i);
                }
            });
        }

        public void onAdLoaded(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.m1010a((C0735c) maxAd);
            if (MaxFullscreenAdImpl.this.f815g.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.loadRequestBuilder.mo9552a("expired_ad_ad_unit_id");
            } else {
                MaxFullscreenAdImpl.this.m1012a(C0760c.READY, (Runnable) new Runnable() {
                    public void run() {
                        C1124k.m2611a(MaxFullscreenAdImpl.this.adListener, maxAd);
                    }
                });
            }
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            C1124k.m2634f(MaxFullscreenAdImpl.this.adListener, maxAd);
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            C1124k.m2633e(MaxFullscreenAdImpl.this.adListener, maxAd);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            C1124k.m2613a(MaxFullscreenAdImpl.this.adListener, maxAd, maxReward);
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c */
    public enum C0760c {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MaxFullscreenAdImpl(String str, MaxAdFormat maxAdFormat, C0754a aVar, String str2, C1062k kVar) {
        super(str, maxAdFormat, str2, kVar);
        this.f809a = aVar;
        C0755b bVar = new C0755b();
        this.listenerWrapper = bVar;
        this.f810b = new C0942b(kVar, this);
        this.f811c = new C0762b(kVar, bVar);
        C1107r.m2481f(str2, "Created new " + str2 + " (" + this + ")");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1009a() {
        C0735c cVar;
        synchronized (this.f812d) {
            cVar = this.f813e;
            this.f813e = null;
        }
        this.sdk.mo9327C().destroyAd(cVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1010a(C0735c cVar) {
        long p = cVar.mo8412p() - (SystemClock.elapsedRealtime() - cVar.mo8404l());
        if (p > TimeUnit.SECONDS.toMillis(2)) {
            this.f813e = cVar;
            C1107r rVar = this.logger;
            String str = this.tag;
            rVar.mo9584b(str, "Handle ad loaded for regular ad: " + cVar);
            C1107r rVar2 = this.logger;
            String str2 = this.tag;
            rVar2.mo9584b(str2, "Scheduling ad expiration " + TimeUnit.MILLISECONDS.toSeconds(p) + " seconds from now for " + getAdUnitId() + "...");
            this.f810b.mo9080a(p);
            return;
        }
        this.logger.mo9584b(this.tag, "Loaded an expired ad, running expire logic...");
        onAdExpired();
    }

    /* renamed from: a */
    private void m1011a(C0735c cVar, Context context, final Runnable runnable) {
        if (!cVar.mo8424B() || C1120h.m2544a(context) || !(context instanceof Activity)) {
            runnable.run();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(cVar.mo8425C()).setMessage(cVar.mo8426D()).setPositiveButton(cVar.mo8427E(), (DialogInterface.OnClickListener) null).create();
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        create.show();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x013d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1012a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c r9, java.lang.Runnable r10) {
        /*
            r8 = this;
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = r8.f814f
            java.lang.Object r1 = r8.f812d
            monitor-enter(r1)
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.IDLE     // Catch:{ all -> 0x0168 }
            r3 = 1
            r4 = 0
            if (r0 != r2) goto L_0x0039
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.LOADING     // Catch:{ all -> 0x0168 }
            if (r9 != r0) goto L_0x0011
            goto L_0x0111
        L_0x0011:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.DESTROYED     // Catch:{ all -> 0x0168 }
            if (r9 != r0) goto L_0x0017
            goto L_0x0111
        L_0x0017:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.SHOWING     // Catch:{ all -> 0x0168 }
            if (r9 != r0) goto L_0x0020
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = "No ad is loading or loaded"
            goto L_0x0047
        L_0x0020:
            com.applovin.impl.sdk.r r0 = r8.logger     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0168 }
            r3.<init>()     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x0168 }
            r3.append(r9)     // Catch:{ all -> 0x0168 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0168 }
        L_0x0035:
            r0.mo9588e(r2, r3)     // Catch:{ all -> 0x0168 }
            goto L_0x004a
        L_0x0039:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.LOADING     // Catch:{ all -> 0x0168 }
            if (r0 != r5) goto L_0x0078
            if (r9 != r2) goto L_0x0041
            goto L_0x0111
        L_0x0041:
            if (r9 != r5) goto L_0x004d
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = "An ad is already loading"
        L_0x0047:
            com.applovin.impl.sdk.C1107r.m2484i(r0, r2)     // Catch:{ all -> 0x0168 }
        L_0x004a:
            r3 = 0
            goto L_0x0111
        L_0x004d:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.READY     // Catch:{ all -> 0x0168 }
            if (r9 != r0) goto L_0x0053
            goto L_0x0111
        L_0x0053:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.SHOWING     // Catch:{ all -> 0x0168 }
            if (r9 != r0) goto L_0x005c
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = "An ad is not ready to be shown yet"
            goto L_0x0047
        L_0x005c:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.DESTROYED     // Catch:{ all -> 0x0168 }
            if (r9 != r0) goto L_0x0062
            goto L_0x0111
        L_0x0062:
            com.applovin.impl.sdk.r r0 = r8.logger     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0168 }
            r3.<init>()     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x0168 }
            r3.append(r9)     // Catch:{ all -> 0x0168 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0168 }
            goto L_0x0035
        L_0x0078:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r6 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.READY     // Catch:{ all -> 0x0168 }
            if (r0 != r6) goto L_0x00b2
            if (r9 != r2) goto L_0x0080
            goto L_0x0111
        L_0x0080:
            if (r9 != r5) goto L_0x0087
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = "An ad is already loaded"
            goto L_0x0047
        L_0x0087:
            if (r9 != r6) goto L_0x0090
            com.applovin.impl.sdk.r r0 = r8.logger     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.String r3 = "An ad is already marked as ready"
            goto L_0x0035
        L_0x0090:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.SHOWING     // Catch:{ all -> 0x0168 }
            if (r9 != r0) goto L_0x0096
            goto L_0x0111
        L_0x0096:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.DESTROYED     // Catch:{ all -> 0x0168 }
            if (r9 != r0) goto L_0x009c
            goto L_0x0111
        L_0x009c:
            com.applovin.impl.sdk.r r0 = r8.logger     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0168 }
            r3.<init>()     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x0168 }
            r3.append(r9)     // Catch:{ all -> 0x0168 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0168 }
            goto L_0x0035
        L_0x00b2:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r7 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.SHOWING     // Catch:{ all -> 0x0168 }
            if (r0 != r7) goto L_0x00ee
            if (r9 != r2) goto L_0x00b9
            goto L_0x0111
        L_0x00b9:
            if (r9 != r5) goto L_0x00c0
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = "Can not load another ad while the ad is showing"
            goto L_0x0047
        L_0x00c0:
            if (r9 != r6) goto L_0x00ca
            com.applovin.impl.sdk.r r0 = r8.logger     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.String r3 = "An ad is already showing, ignoring"
            goto L_0x0035
        L_0x00ca:
            if (r9 != r7) goto L_0x00d2
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = "The ad is already showing, not showing another one"
            goto L_0x0047
        L_0x00d2:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.DESTROYED     // Catch:{ all -> 0x0168 }
            if (r9 != r0) goto L_0x00d7
            goto L_0x0111
        L_0x00d7:
            com.applovin.impl.sdk.r r0 = r8.logger     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0168 }
            r3.<init>()     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x0168 }
            r3.append(r9)     // Catch:{ all -> 0x0168 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0168 }
            goto L_0x0035
        L_0x00ee:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0760c.DESTROYED     // Catch:{ all -> 0x0168 }
            if (r0 != r2) goto L_0x00f8
            java.lang.String r0 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = "No operations are allowed on a destroyed instance"
            goto L_0x0047
        L_0x00f8:
            com.applovin.impl.sdk.r r0 = r8.logger     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0168 }
            r3.<init>()     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = "Unknown state: "
            r3.append(r5)     // Catch:{ all -> 0x0168 }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r8.f814f     // Catch:{ all -> 0x0168 }
            r3.append(r5)     // Catch:{ all -> 0x0168 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0168 }
            goto L_0x0035
        L_0x0111:
            if (r3 == 0) goto L_0x013d
            com.applovin.impl.sdk.r r0 = r8.logger     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0168 }
            r4.<init>()     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = "Transitioning from "
            r4.append(r5)     // Catch:{ all -> 0x0168 }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r8.f814f     // Catch:{ all -> 0x0168 }
            r4.append(r5)     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = " to "
            r4.append(r5)     // Catch:{ all -> 0x0168 }
            r4.append(r9)     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = "..."
            r4.append(r5)     // Catch:{ all -> 0x0168 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0168 }
            r0.mo9584b(r2, r4)     // Catch:{ all -> 0x0168 }
            r8.f814f = r9     // Catch:{ all -> 0x0168 }
            goto L_0x015f
        L_0x013d:
            com.applovin.impl.sdk.r r0 = r8.logger     // Catch:{ all -> 0x0168 }
            java.lang.String r2 = r8.tag     // Catch:{ all -> 0x0168 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0168 }
            r4.<init>()     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = "Not allowed transition from "
            r4.append(r5)     // Catch:{ all -> 0x0168 }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r8.f814f     // Catch:{ all -> 0x0168 }
            r4.append(r5)     // Catch:{ all -> 0x0168 }
            java.lang.String r5 = " to "
            r4.append(r5)     // Catch:{ all -> 0x0168 }
            r4.append(r9)     // Catch:{ all -> 0x0168 }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x0168 }
            r0.mo9587d(r2, r9)     // Catch:{ all -> 0x0168 }
        L_0x015f:
            monitor-exit(r1)     // Catch:{ all -> 0x0168 }
            if (r3 == 0) goto L_0x0167
            if (r10 == 0) goto L_0x0167
            r10.run()
        L_0x0167:
            return
        L_0x0168:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0168 }
            goto L_0x016c
        L_0x016b:
            throw r9
        L_0x016c:
            goto L_0x016b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.m1012a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c, java.lang.Runnable):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1016b() {
        C0735c cVar;
        if (this.f815g.compareAndSet(true, false)) {
            synchronized (this.f812d) {
                cVar = this.f813e;
                this.f813e = null;
            }
            this.sdk.mo9327C().destroyAd(cVar);
            this.loadRequestBuilder.mo9552a("expired_ad_ad_unit_id");
        }
    }

    public void destroy() {
        m1012a(C0760c.DESTROYED, (Runnable) new Runnable() {
            public void run() {
                synchronized (MaxFullscreenAdImpl.this.f812d) {
                    if (MaxFullscreenAdImpl.this.f813e != null) {
                        MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                        C1107r rVar = maxFullscreenAdImpl.logger;
                        String str = maxFullscreenAdImpl.tag;
                        rVar.mo9584b(str, "Destroying ad for '" + MaxFullscreenAdImpl.this.adUnitId + "'; current ad: " + MaxFullscreenAdImpl.this.f813e + "...");
                        MaxFullscreenAdImpl.this.sdk.mo9327C().destroyAd(MaxFullscreenAdImpl.this.f813e);
                    }
                }
            }
        });
    }

    public boolean isReady() {
        boolean z;
        synchronized (this.f812d) {
            C0735c cVar = this.f813e;
            z = cVar != null && cVar.mo8389d() && this.f814f == C0760c.READY;
        }
        return z;
    }

    public void loadAd(final Activity activity) {
        C1107r rVar = this.logger;
        String str = this.tag;
        rVar.mo9584b(str, "Loading ad for '" + this.adUnitId + "'...");
        if (isReady()) {
            C1107r rVar2 = this.logger;
            String str2 = this.tag;
            rVar2.mo9584b(str2, "An ad is already loaded for '" + this.adUnitId + "'");
            C1124k.m2611a(this.adListener, (MaxAd) this.f813e);
            return;
        }
        m1012a(C0760c.LOADING, (Runnable) new Runnable() {
            public void run() {
                Activity activity = activity;
                if (activity == null) {
                    activity = MaxFullscreenAdImpl.this.sdk.mo9378am();
                }
                Activity activity2 = activity;
                MediationServiceImpl C = MaxFullscreenAdImpl.this.sdk.mo9327C();
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                C.loadAd(maxFullscreenAdImpl.adUnitId, maxFullscreenAdImpl.adFormat, maxFullscreenAdImpl.loadRequestBuilder.mo9554a(), activity2, MaxFullscreenAdImpl.this.listenerWrapper);
            }
        });
    }

    public void onAdExpired() {
        C1107r rVar = this.logger;
        String str = this.tag;
        rVar.mo9584b(str, "Ad expired " + getAdUnitId());
        this.f815g.set(true);
        Activity activity = this.f809a.getActivity();
        if (activity == null && (activity = this.sdk.mo9370ae().mo8944a()) == null) {
            m1016b();
            this.listenerWrapper.onAdLoadFailed(this.adUnitId, MaxErrorCodes.NO_ACTIVITY);
            return;
        }
        this.loadRequestBuilder.mo9553a("expired_ad_ad_unit_id", getAdUnitId());
        this.sdk.mo9327C().loadAd(this.adUnitId, this.adFormat, this.loadRequestBuilder.mo9554a(), activity, this.listenerWrapper);
    }

    public void showAd(final String str, final Activity activity) {
        if (!isReady()) {
            String str2 = this.tag;
            C1107r.m2484i(str2, "Attempting to show ad before it is ready - please check ad readiness using " + this.tag + "#isReady()");
            C1124k.m2612a(this.adListener, (MaxAd) this.f813e, -5201);
            return;
        }
        if (activity == null) {
            activity = this.sdk.mo9378am();
        }
        if (activity == null) {
            throw new IllegalArgumentException("Attempting to show ad without a valid activity.");
        } else if (C1160r.m2760g((Context) activity) != 0) {
            if (!C1160r.m2756e((Context) activity)) {
                C1107r.m2484i(this.tag, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                C1124k.m2612a(this.adListener, (MaxAd) this.f813e, (int) MaxErrorCodes.DONT_KEEP_ACTIVITIES_ENABLED);
                return;
            }
            throw new IllegalStateException("Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
        } else if (((Boolean) this.sdk.mo9350a(C0964a.f1523A)).booleanValue() && (this.sdk.mo9369ad().mo9574a() || this.sdk.mo9369ad().mo9576b())) {
            C1107r.m2484i(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
            C1124k.m2612a(this.adListener, (MaxAd) this.f813e, -23);
        } else if (!((Boolean) this.sdk.mo9350a(C0964a.f1524B)).booleanValue() || C1120h.m2544a((Context) activity)) {
            m1011a(this.f813e, (Context) activity, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.m1012a(C0760c.SHOWING, (Runnable) new Runnable() {
                        public void run() {
                            MaxFullscreenAdImpl.this.f811c.mo8520b(MaxFullscreenAdImpl.this.f813e);
                            MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                            C1107r rVar = maxFullscreenAdImpl.logger;
                            String str = maxFullscreenAdImpl.tag;
                            rVar.mo9584b(str, "Showing ad for '" + MaxFullscreenAdImpl.this.adUnitId + "'; loaded ad: " + MaxFullscreenAdImpl.this.f813e + "...");
                            MaxFullscreenAdImpl maxFullscreenAdImpl2 = MaxFullscreenAdImpl.this;
                            maxFullscreenAdImpl2.mo8514a(maxFullscreenAdImpl2.f813e);
                            MediationServiceImpl C = MaxFullscreenAdImpl.this.sdk.mo9327C();
                            C0735c b = MaxFullscreenAdImpl.this.f813e;
                            C07513 r2 = C07513.this;
                            C.showFullscreenAd(b, str, activity, MaxFullscreenAdImpl.this.listenerWrapper);
                        }
                    });
                }
            });
        } else {
            C1107r.m2484i(this.tag, "Attempting to show ad with no internet connection");
            C1124k.m2612a(this.adListener, (MaxAd) this.f813e, -5201);
        }
    }

    public String toString() {
        return this.tag + "{adUnitId='" + this.adUnitId + '\'' + ", adListener=" + this.adListener + ", isReady=" + isReady() + '}';
    }
}
