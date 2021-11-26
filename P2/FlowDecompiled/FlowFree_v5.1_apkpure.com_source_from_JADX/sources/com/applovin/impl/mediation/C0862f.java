package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.mediation.p022b.C0766b;
import com.applovin.impl.mediation.p022b.C0771c;
import com.applovin.impl.mediation.p023c.C0788c;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.network.C1099h;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* renamed from: com.applovin.impl.mediation.f */
public class C0862f {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1062k f1191a;

    /* renamed from: b */
    private final Map<String, C0866b> f1192b = new HashMap(4);

    /* renamed from: c */
    private final Object f1193c = new Object();

    /* renamed from: d */
    private final Map<String, C0733a> f1194d = new HashMap(4);

    /* renamed from: e */
    private final Object f1195e = new Object();

    /* renamed from: com.applovin.impl.mediation.f$a */
    private static class C0864a implements MaxAdListener {

        /* renamed from: a */
        private final C1062k f1202a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final Activity f1203b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final C0862f f1204c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final C0866b f1205d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final MaxAdFormat f1206e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public C1099h f1207f;

        private C0864a(C1099h hVar, C0866b bVar, MaxAdFormat maxAdFormat, C0862f fVar, C1062k kVar, Activity activity) {
            this.f1202a = kVar;
            this.f1203b = activity;
            this.f1204c = fVar;
            this.f1205d = bVar;
            this.f1206e = maxAdFormat;
            this.f1207f = hVar;
        }

        public void onAdClicked(MaxAd maxAd) {
        }

        public void onAdDisplayFailed(MaxAd maxAd, int i) {
        }

        public void onAdDisplayed(MaxAd maxAd) {
        }

        public void onAdHidden(MaxAd maxAd) {
        }

        public void onAdLoadFailed(final String str, int i) {
            if (!this.f1202a.mo9365a(C0964a.f1537O, this.f1206e) || this.f1205d.f1212b >= ((Integer) this.f1202a.mo9350a(C0964a.f1536N)).intValue()) {
                int unused = this.f1205d.f1212b = 0;
                this.f1205d.f1211a.set(false);
                if (this.f1205d.f1213c != null) {
                    this.f1205d.f1213c.onAdLoadFailed(str, i);
                    MaxAdListener unused2 = this.f1205d.f1213c = null;
                    return;
                }
                return;
            }
            C0866b.m1407d(this.f1205d);
            final int pow = (int) Math.pow(2.0d, (double) this.f1205d.f1212b);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C0864a aVar = C0864a.this;
                    C1099h unused = aVar.f1207f = new C1099h.C1101a(aVar.f1207f).mo9553a("retry_delay_sec", String.valueOf(pow)).mo9553a("retry_attempt", String.valueOf(C0864a.this.f1205d.f1212b)).mo9554a();
                    C0864a.this.f1204c.m1393b(str, C0864a.this.f1206e, C0864a.this.f1207f, C0864a.this.f1203b, C0864a.this);
                }
            }, TimeUnit.SECONDS.toMillis((long) pow));
        }

        public void onAdLoaded(MaxAd maxAd) {
            C0733a aVar = (C0733a) maxAd;
            int unused = this.f1205d.f1212b = 0;
            if (this.f1205d.f1213c != null) {
                aVar.mo8391f().mo8763c().mo8366a(this.f1205d.f1213c);
                this.f1205d.f1213c.onAdLoaded(aVar);
                MaxAdListener unused2 = this.f1205d.f1213c = null;
                if ((this.f1202a.mo9381b(C0964a.f1535M).contains(maxAd.getAdUnitId()) || this.f1202a.mo9365a(C0964a.f1534L, maxAd.getFormat())) && !this.f1202a.mo9332H().mo8729a() && !this.f1202a.mo9332H().mo8731b()) {
                    this.f1204c.m1393b(maxAd.getAdUnitId(), maxAd.getFormat(), this.f1207f, this.f1203b, this);
                    return;
                }
            } else {
                this.f1204c.m1389a(aVar);
            }
            this.f1205d.f1211a.set(false);
        }
    }

    /* renamed from: com.applovin.impl.mediation.f$b */
    private static class C0866b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final AtomicBoolean f1211a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f1212b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public volatile MaxAdListener f1213c;

        private C0866b() {
            this.f1211a = new AtomicBoolean();
        }

        /* renamed from: d */
        static /* synthetic */ int m1407d(C0866b bVar) {
            int i = bVar.f1212b;
            bVar.f1212b = i + 1;
            return i;
        }
    }

    public C0862f(C1062k kVar) {
        this.f1191a = kVar;
    }

    /* renamed from: a */
    private C0733a m1387a(String str) {
        C0733a aVar;
        synchronized (this.f1195e) {
            aVar = this.f1194d.get(str);
            this.f1194d.remove(str);
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1389a(C0733a aVar) {
        synchronized (this.f1195e) {
            if (this.f1194d.containsKey(aVar.getAdUnitId())) {
                C1107r.m2484i("AppLovinSdk", "Ad in cache already: " + aVar.getAdUnitId());
            }
            this.f1194d.put(aVar.getAdUnitId(), aVar);
        }
    }

    /* renamed from: b */
    private C0866b m1392b(String str) {
        C0866b bVar;
        synchronized (this.f1193c) {
            bVar = this.f1192b.get(str);
            if (bVar == null) {
                bVar = new C0866b();
                this.f1192b.put(str, bVar);
            }
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1393b(String str, MaxAdFormat maxAdFormat, C1099h hVar, Activity activity, MaxAdListener maxAdListener) {
        final String str2 = str;
        final MaxAdFormat maxAdFormat2 = maxAdFormat;
        final C1099h hVar2 = hVar;
        final Activity activity2 = activity;
        final MaxAdListener maxAdListener2 = maxAdListener;
        this.f1191a.mo9340Q().mo9266a((C0989a) new C0766b(maxAdFormat, activity, this.f1191a, new C0766b.C0770a() {
            /* renamed from: a */
            public void mo8528a(JSONArray jSONArray) {
                C0862f.this.f1191a.mo9340Q().mo9265a((C0989a) new C0771c(str2, maxAdFormat2, hVar2, jSONArray, activity2, C0862f.this.f1191a, maxAdListener2));
            }
        }), C0788c.m1108a(maxAdFormat));
    }

    /* renamed from: a */
    public void mo8737a(String str, MaxAdFormat maxAdFormat, C1099h hVar, Activity activity, MaxAdListener maxAdListener) {
        C0733a a = !this.f1191a.mo9332H().mo8731b() ? m1387a(str) : null;
        if (a != null) {
            a.mo8391f().mo8763c().mo8366a(maxAdListener);
            maxAdListener.onAdLoaded(a);
        }
        C0866b b = m1392b(str);
        if (b.f1211a.compareAndSet(false, true)) {
            if (a == null) {
                MaxAdListener unused = b.f1213c = maxAdListener;
            }
            m1393b(str, maxAdFormat, hVar, activity, new C0864a(hVar, b, maxAdFormat, this, this.f1191a, activity));
            return;
        }
        if (!(b.f1213c == null || b.f1213c == maxAdListener)) {
            C1107r.m2483h("MaxInterstitialAd", "Attempting to load ad for same ad unit id (" + str + ") while another ad load is already in progress!");
        }
        MaxAdListener unused2 = b.f1213c = maxAdListener;
    }
}
