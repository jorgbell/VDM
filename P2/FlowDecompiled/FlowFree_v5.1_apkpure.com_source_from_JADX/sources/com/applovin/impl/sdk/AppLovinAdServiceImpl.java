package com.applovin.impl.sdk;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.C0623b;
import com.applovin.impl.sdk.network.C1094f;
import com.applovin.impl.sdk.network.C1099h;
import com.applovin.impl.sdk.p035a.C0928d;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p035a.C0940h;
import com.applovin.impl.sdk.p038d.C0973a;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1008i;
import com.applovin.impl.sdk.p039e.C1009j;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1117e;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class AppLovinAdServiceImpl implements AppLovinAdService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1062k f1333a;

    /* renamed from: b */
    private final C1107r f1334b;

    /* renamed from: c */
    private final Handler f1335c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private final Map<C0928d, C0916b> f1336d;

    /* renamed from: e */
    private final Object f1337e = new Object();

    /* renamed from: com.applovin.impl.sdk.AppLovinAdServiceImpl$a */
    private class C0915a implements AppLovinAdLoadListener {

        /* renamed from: b */
        private final C0916b f1345b;

        private C0915a(C0916b bVar) {
            this.f1345b = bVar;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            HashSet<AppLovinAdLoadListener> hashSet;
            AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
            C0928d adZone = appLovinAdBase.getAdZone();
            if (!(appLovinAd instanceof C0940h)) {
                AppLovinAdServiceImpl.this.f1333a.mo9348Y().mo9111a(appLovinAdBase);
                appLovinAd = new C0940h(adZone, AppLovinAdServiceImpl.this.f1333a);
            }
            synchronized (this.f1345b.f1346a) {
                hashSet = new HashSet<>(this.f1345b.f1348c);
                this.f1345b.f1348c.clear();
                this.f1345b.f1347b = false;
            }
            for (AppLovinAdLoadListener a : hashSet) {
                AppLovinAdServiceImpl.this.m1490a(appLovinAd, a);
            }
        }

        public void failedToReceiveAd(int i) {
            HashSet<AppLovinAdLoadListener> hashSet;
            synchronized (this.f1345b.f1346a) {
                hashSet = new HashSet<>(this.f1345b.f1348c);
                this.f1345b.f1348c.clear();
                this.f1345b.f1347b = false;
            }
            for (AppLovinAdLoadListener a : hashSet) {
                AppLovinAdServiceImpl.this.m1482a(i, a);
            }
        }
    }

    /* renamed from: com.applovin.impl.sdk.AppLovinAdServiceImpl$b */
    private static class C0916b {

        /* renamed from: a */
        final Object f1346a;

        /* renamed from: b */
        boolean f1347b;

        /* renamed from: c */
        final Collection<AppLovinAdLoadListener> f1348c;

        private C0916b() {
            this.f1346a = new Object();
            this.f1348c = new HashSet();
        }

        public String toString() {
            return "AdLoadState{, isWaitingForAd=" + this.f1347b + ", pendingAdListeners=" + this.f1348c + '}';
        }
    }

    AppLovinAdServiceImpl(C1062k kVar) {
        this.f1333a = kVar;
        this.f1334b = kVar.mo9411z();
        HashMap hashMap = new HashMap(5);
        this.f1336d = hashMap;
        hashMap.put(C0928d.m1544b(kVar), new C0916b());
        hashMap.put(C0928d.m1546c(kVar), new C0916b());
        hashMap.put(C0928d.m1547d(kVar), new C0916b());
        hashMap.put(C0928d.m1548e(kVar), new C0916b());
        hashMap.put(C0928d.m1549f(kVar), new C0916b());
    }

    /* renamed from: a */
    private C0916b m1478a(C0928d dVar) {
        C0916b bVar;
        synchronized (this.f1337e) {
            bVar = this.f1336d.get(dVar);
            if (bVar == null) {
                bVar = new C0916b();
                this.f1336d.put(dVar, bVar);
            }
        }
        return bVar;
    }

    /* renamed from: a */
    private String m1480a(String str, long j, int i, String str2, boolean z) {
        try {
            if (!C1155o.m2673b(str)) {
                return null;
            }
            if (i < 0 || i > 100) {
                i = 0;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j)).appendQueryParameter("pv", Integer.toString(i)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z)).build().toString();
        } catch (Throwable th) {
            C1107r rVar = this.f1334b;
            rVar.mo9585b("AppLovinAdService", "Unknown error parsing the video end url: " + str, th);
            return null;
        }
    }

    /* renamed from: a */
    private String m1481a(String str, long j, long j2, boolean z, int i) {
        if (!C1155o.m2673b(str)) {
            return null;
        }
        Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j)).appendQueryParameter("vs_ms", Long.toString(j2));
        if (i != C1044f.f2116a) {
            appendQueryParameter.appendQueryParameter("musw_ch", Boolean.toString(z));
            appendQueryParameter.appendQueryParameter("musw_st", Boolean.toString(C1044f.m2057a(i)));
        }
        return appendQueryParameter.build().toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1482a(final int i, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1335c.post(new Runnable() {
            public void run() {
                try {
                    appLovinAdLoadListener.failedToReceiveAd(i);
                } catch (Throwable th) {
                    C1107r.m2480c("AppLovinAdService", "Unable to notify listener about ad load failure", th);
                }
            }
        });
    }

    /* renamed from: a */
    private void m1483a(Uri uri, C0934g gVar, AppLovinAdView appLovinAdView, C0623b bVar) {
        if (appLovinAdView != null) {
            if (C1160r.m2730a(appLovinAdView.getContext(), uri, this.f1333a)) {
                C1124k.m2629c(bVar.mo8100g(), (AppLovinAd) gVar, appLovinAdView);
            }
            bVar.mo8105l();
            return;
        }
        this.f1334b.mo9588e("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
    }

    /* renamed from: a */
    private void m1486a(C0928d dVar, C1099h hVar, C0915a aVar) {
        AppLovinAdBase b = this.f1333a.mo9348Y().mo9113b(dVar);
        if (b != null) {
            C1107r rVar = this.f1334b;
            rVar.mo9584b("AppLovinAdService", "Using pre-loaded ad: " + b + " for " + dVar);
            this.f1333a.mo9366aa().mo8980a(b, true, false);
            aVar.adReceived(b);
            return;
        }
        m1489a((C0989a) new C1009j(dVar, hVar, (AppLovinAdLoadListener) aVar, this.f1333a));
    }

    /* renamed from: a */
    private void m1487a(C0928d dVar, C1099h hVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (dVar == null) {
            throw new IllegalArgumentException("No zone specified");
        } else if (appLovinAdLoadListener != null) {
            C1107r z = this.f1333a.mo9411z();
            z.mo9584b("AppLovinAdService", "Loading next ad of zone {" + dVar + "}...");
            C0916b a = m1478a(dVar);
            synchronized (a.f1346a) {
                a.f1348c.add(appLovinAdLoadListener);
                if (!a.f1347b) {
                    a.f1347b = true;
                    m1486a(dVar, hVar, new C0915a(a));
                } else {
                    this.f1334b.mo9584b("AppLovinAdService", "Already waiting on an ad load...");
                }
            }
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    /* renamed from: a */
    private void m1488a(C0973a aVar) {
        if (C1155o.m2673b(aVar.mo9151a())) {
            this.f1333a.mo9342S().mo9499a(C1094f.m2366o().mo9528c(C1160r.m2740b(aVar.mo9151a())).mo9531d(C1155o.m2673b(aVar.mo9152b()) ? C1160r.m2740b(aVar.mo9152b()) : null).mo9526b(aVar.mo9153c()).mo9523a(false).mo9530c(aVar.mo9154d()).mo9524a());
            return;
        }
        this.f1334b.mo9587d("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
    }

    /* renamed from: a */
    private void m1489a(C0989a aVar) {
        if (!this.f1333a.mo9388d()) {
            C1107r.m2483h("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.f1333a.mo9353a();
        this.f1333a.mo9340Q().mo9266a(aVar, C1020o.C1022a.MAIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1490a(final AppLovinAd appLovinAd, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1335c.post(new Runnable() {
            public void run() {
                try {
                    appLovinAdLoadListener.adReceived(appLovinAd);
                } catch (Throwable th) {
                    C1107r.m2480c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
                }
            }
        });
    }

    /* renamed from: a */
    private void m1491a(List<C0973a> list) {
        if (list != null && !list.isEmpty()) {
            for (C0973a a : list) {
                m1488a(a);
            }
        }
    }

    public AppLovinAd dequeueAd(C0928d dVar) {
        AppLovinAdBase c = this.f1333a.mo9348Y().mo9114c(dVar);
        C1107r rVar = this.f1334b;
        rVar.mo9584b("AppLovinAdService", "Dequeued ad: " + c + " for zone: " + dVar + "...");
        return c;
    }

    public String getBidToken() {
        if (C1160r.m2744b() && !this.f1333a.mo9390f()) {
            this.f1334b.mo9588e("AppLovinAdService", "AppLovinAdService#getBidToken() called from main thread! Necessary signals may not be collected in time!");
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String a = this.f1333a.mo9343T().mo9425a();
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return a;
    }

    public boolean hasPreloadedAd(AppLovinAdSize appLovinAdSize) {
        return this.f1333a.mo9348Y().mo9112a(C0928d.m1538a(appLovinAdSize, AppLovinAdType.REGULAR, this.f1333a));
    }

    public boolean hasPreloadedAdForZoneId(String str) {
        if (TextUtils.isEmpty(str)) {
            C1107r.m2484i("AppLovinAdService", "Unable to check if ad is preloaded - invalid zone id");
            return false;
        }
        return this.f1333a.mo9348Y().mo9112a(C0928d.m1540a(str, this.f1333a));
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        m1487a(C0928d.m1538a(appLovinAdSize, AppLovinAdType.REGULAR, this.f1333a), (C1099h) null, appLovinAdLoadListener);
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, C1099h hVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        C1107r rVar = this.f1334b;
        rVar.mo9584b("AppLovinAdService", "Loading next ad of zone {" + str + "} with size " + appLovinAdSize);
        m1487a(C0928d.m1539a(appLovinAdSize, AppLovinAdType.REGULAR, str, this.f1333a), hVar, appLovinAdLoadListener);
    }

    /* JADX WARNING: type inference failed for: r11v23, types: [com.applovin.impl.sdk.e.k] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadNextAdForAdToken(java.lang.String r11, com.applovin.sdk.AppLovinAdLoadListener r12) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0007
            java.lang.String r11 = r11.trim()
            goto L_0x0008
        L_0x0007:
            r11 = 0
        L_0x0008:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = -8
            java.lang.String r2 = "AppLovinAdService"
            if (r0 == 0) goto L_0x001a
            java.lang.String r11 = "Invalid ad token specified"
            com.applovin.impl.sdk.C1107r.m2484i(r2, r11)
            r10.m1482a((int) r1, (com.applovin.sdk.AppLovinAdLoadListener) r12)
            return
        L_0x001a:
            com.applovin.impl.sdk.a.c r0 = new com.applovin.impl.sdk.a.c
            com.applovin.impl.sdk.k r3 = r10.f1333a
            r0.<init>(r11, r3)
            com.applovin.impl.sdk.a.c$a r11 = r0.mo8965b()
            com.applovin.impl.sdk.a.c$a r3 = com.applovin.impl.sdk.p035a.C0926c.C0927a.REGULAR
            if (r11 != r3) goto L_0x004b
            com.applovin.impl.sdk.r r11 = r10.f1334b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Loading next ad for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r11.mo9584b(r2, r1)
            com.applovin.impl.sdk.e.k r11 = new com.applovin.impl.sdk.e.k
            com.applovin.impl.sdk.k r1 = r10.f1333a
            r11.<init>(r0, r12, r1)
        L_0x0046:
            r10.m1489a((com.applovin.impl.sdk.p039e.C0989a) r11)
            goto L_0x00fc
        L_0x004b:
            com.applovin.impl.sdk.a.c$a r11 = r0.mo8965b()
            com.applovin.impl.sdk.a.c$a r3 = com.applovin.impl.sdk.p035a.C0926c.C0927a.AD_RESPONSE_JSON
            if (r11 != r3) goto L_0x00e5
            org.json.JSONObject r5 = r0.mo8967d()
            if (r5 == 0) goto L_0x00ce
            com.applovin.impl.sdk.k r11 = r10.f1333a
            com.applovin.impl.sdk.utils.C1120h.m2557h(r5, r11)
            com.applovin.impl.sdk.k r11 = r10.f1333a
            com.applovin.impl.sdk.utils.C1120h.m2549d(r5, r11)
            com.applovin.impl.sdk.k r11 = r10.f1333a
            com.applovin.impl.sdk.utils.C1120h.m2548c(r5, r11)
            com.applovin.impl.sdk.k r11 = r10.f1333a
            com.applovin.impl.sdk.utils.C1120h.m2551e(r5, r11)
            org.json.JSONArray r11 = new org.json.JSONArray
            r11.<init>()
            com.applovin.impl.sdk.k r1 = r10.f1333a
            java.lang.String r3 = "ads"
            org.json.JSONArray r11 = com.applovin.impl.sdk.utils.C1123j.m2599b((org.json.JSONObject) r5, (java.lang.String) r3, (org.json.JSONArray) r11, (com.applovin.impl.sdk.C1062k) r1)
            int r11 = r11.length()
            if (r11 <= 0) goto L_0x00b2
            com.applovin.impl.sdk.r r11 = r10.f1334b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Rendering ad for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.mo9584b(r2, r0)
            com.applovin.impl.sdk.k r11 = r10.f1333a
            com.applovin.impl.sdk.a.d r6 = com.applovin.impl.sdk.utils.C1160r.m2705a((org.json.JSONObject) r5, (com.applovin.impl.sdk.C1062k) r11)
            com.applovin.impl.sdk.a.f$a r8 = new com.applovin.impl.sdk.a.f$a
            com.applovin.impl.sdk.k r11 = r10.f1333a
            r8.<init>(r6, r12, r11)
            r11 = 1
            r8.mo8990a(r11)
            com.applovin.impl.sdk.e.p r11 = new com.applovin.impl.sdk.e.p
            com.applovin.impl.sdk.a.b r7 = com.applovin.impl.sdk.p035a.C0925b.DECODED_AD_TOKEN_JSON
            com.applovin.impl.sdk.k r9 = r10.f1333a
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x0046
        L_0x00b2:
            com.applovin.impl.sdk.r r11 = r10.f1334b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "No ad returned from the server for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.mo9588e(r2, r0)
            r11 = 204(0xcc, float:2.86E-43)
            r12.failedToReceiveAd(r11)
            goto L_0x00fc
        L_0x00ce:
            com.applovin.impl.sdk.r r11 = r10.f1334b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unable to retrieve ad response JSON from token: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r11.mo9588e(r2, r0)
            goto L_0x00f9
        L_0x00e5:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r3 = "Invalid ad token specified: "
            r11.append(r3)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.applovin.impl.sdk.C1107r.m2484i(r2, r11)
        L_0x00f9:
            r12.failedToReceiveAd(r1)
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinAdServiceImpl.loadNextAdForAdToken(java.lang.String, com.applovin.sdk.AppLovinAdLoadListener):void");
    }

    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (!TextUtils.isEmpty(str)) {
            C1107r rVar = this.f1334b;
            rVar.mo9584b("AppLovinAdService", "Loading next ad of zone {" + str + "}");
            m1487a(C0928d.m1540a(str, this.f1333a), (C1099h) null, appLovinAdLoadListener);
            return;
        }
        throw new IllegalArgumentException("No zone id specified");
    }

    public void loadNextAdForZoneIds(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener) {
        List<String> a = C1117e.m2523a(list);
        if (a == null || a.isEmpty()) {
            C1107r.m2484i("AppLovinAdService", "No zones were provided");
            m1482a(-7, appLovinAdLoadListener);
            return;
        }
        C1107r rVar = this.f1334b;
        rVar.mo9584b("AppLovinAdService", "Loading next ad for zones: " + a);
        m1489a((C0989a) new C1008i(a, appLovinAdLoadListener, this.f1333a));
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        C1107r rVar = this.f1334b;
        rVar.mo9584b("AppLovinAdService", "Loading next incentivized ad of zone {" + str + "}");
        m1487a(C0928d.m1545b(str, this.f1333a), (C1099h) null, appLovinAdLoadListener);
    }

    public void preloadAd(AppLovinAdSize appLovinAdSize) {
    }

    public void preloadAdForZoneId(String str) {
    }

    public String toString() {
        return "AppLovinAdService{adLoadStates=" + this.f1336d + '}';
    }

    public void trackAndLaunchClick(C0934g gVar, AppLovinAdView appLovinAdView, C0623b bVar, Uri uri, PointF pointF) {
        if (gVar == null) {
            this.f1334b.mo9588e("AppLovinAdService", "Unable to track ad view click. No ad specified");
            return;
        }
        this.f1334b.mo9584b("AppLovinAdService", "Tracking click on an ad...");
        m1491a(gVar.mo9019a(pointF));
        m1483a(uri, gVar, appLovinAdView, bVar);
    }

    public void trackAndLaunchVideoClick(C0934g gVar, AppLovinAdView appLovinAdView, Uri uri, PointF pointF) {
        if (gVar == null) {
            this.f1334b.mo9588e("AppLovinAdService", "Unable to track video click. No ad specified");
            return;
        }
        this.f1334b.mo9584b("AppLovinAdService", "Tracking VIDEO click on an ad...");
        m1491a(gVar.mo9058b(pointF));
        C1160r.m2730a(appLovinAdView.getContext(), uri, this.f1333a);
    }

    public void trackAppKilled(C0934g gVar) {
        if (gVar == null) {
            this.f1334b.mo9588e("AppLovinAdService", "Unable to track app killed. No ad specified");
            return;
        }
        this.f1334b.mo9584b("AppLovinAdService", "Tracking app killed during ad...");
        List<C0973a> ar = gVar.mo9050ar();
        if (ar == null || ar.isEmpty()) {
            C1107r rVar = this.f1334b;
            rVar.mo9587d("AppLovinAdService", "Unable to track app killed during AD #" + gVar.getAdIdNumber() + ". Missing app killed tracking URL.");
            return;
        }
        for (C0973a next : ar) {
            m1488a(new C0973a(next.mo9151a(), next.mo9152b()));
        }
    }

    public void trackFullScreenAdClosed(C0934g gVar, long j, long j2, boolean z, int i) {
        C1107r rVar = this.f1334b;
        if (gVar == null) {
            rVar.mo9588e("AppLovinAdService", "Unable to track ad closed. No ad specified.");
            return;
        }
        rVar.mo9584b("AppLovinAdService", "Tracking ad closed...");
        List<C0973a> aq = gVar.mo9049aq();
        if (aq == null || aq.isEmpty()) {
            C1107r rVar2 = this.f1334b;
            rVar2.mo9587d("AppLovinAdService", "Unable to track ad closed for AD #" + gVar.getAdIdNumber() + ". Missing ad close tracking URL." + gVar.getAdIdNumber());
            return;
        }
        for (C0973a next : aq) {
            long j3 = j;
            long j4 = j2;
            boolean z2 = z;
            int i2 = i;
            String a = m1481a(next.mo9151a(), j3, j4, z2, i2);
            String a2 = m1481a(next.mo9152b(), j3, j4, z2, i2);
            if (C1155o.m2673b(a)) {
                m1488a(new C0973a(a, a2));
            } else {
                C1107r rVar3 = this.f1334b;
                rVar3.mo9588e("AppLovinAdService", "Failed to parse url: " + next.mo9151a());
            }
        }
    }

    public void trackImpression(C0934g gVar) {
        if (gVar == null) {
            this.f1334b.mo9588e("AppLovinAdService", "Unable to track impression click. No ad specified");
            return;
        }
        this.f1334b.mo9584b("AppLovinAdService", "Tracking impression on ad...");
        m1491a(gVar.mo7822as());
        this.f1333a.mo9366aa().mo8982a(gVar);
    }

    public void trackVideoEnd(C0934g gVar, long j, int i, boolean z) {
        C1107r rVar = this.f1334b;
        if (gVar == null) {
            rVar.mo9588e("AppLovinAdService", "Unable to track video end. No ad specified");
            return;
        }
        rVar.mo9584b("AppLovinAdService", "Tracking video end on ad...");
        List<C0973a> ap = gVar.mo9048ap();
        if (ap == null || ap.isEmpty()) {
            C1107r rVar2 = this.f1334b;
            rVar2.mo9587d("AppLovinAdService", "Unable to submit persistent postback for AD #" + gVar.getAdIdNumber() + ". Missing video end tracking URL.");
            return;
        }
        String l = Long.toString(System.currentTimeMillis());
        for (C0973a next : ap) {
            if (C1155o.m2673b(next.mo9151a())) {
                long j2 = j;
                int i2 = i;
                String str = l;
                boolean z2 = z;
                String a = m1480a(next.mo9151a(), j2, i2, str, z2);
                String a2 = m1480a(next.mo9152b(), j2, i2, str, z2);
                if (a != null) {
                    m1488a(new C0973a(a, a2));
                } else {
                    C1107r rVar3 = this.f1334b;
                    rVar3.mo9588e("AppLovinAdService", "Failed to parse url: " + next.mo9151a());
                }
            } else {
                this.f1334b.mo9587d("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
            }
        }
    }
}
