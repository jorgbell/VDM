package com.applovin.impl.sdk.p035a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1015m;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1115d;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1157p;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.facebook.ads.AdSDKNotificationListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.f */
public class C0930f implements Runnable {

    /* renamed from: i */
    private static boolean f1420i;

    /* renamed from: a */
    private final C1062k f1421a;

    /* renamed from: b */
    private final MaxAdFormat f1422b;

    /* renamed from: c */
    private List<C0928d> f1423c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final List<JSONObject> f1424d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Object f1425e;

    /* renamed from: f */
    private C0928d f1426f;

    /* renamed from: g */
    private C0933b f1427g = C0933b.NONE;

    /* renamed from: h */
    private boolean f1428h;

    /* renamed from: com.applovin.impl.sdk.a.f$a */
    public static class C0932a implements AppLovinAdLoadListener {

        /* renamed from: a */
        private final C1062k f1430a;

        /* renamed from: b */
        private final C0928d f1431b;

        /* renamed from: c */
        private final AppLovinAdLoadListener f1432c;

        /* renamed from: d */
        private boolean f1433d;

        public C0932a(C0928d dVar, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
            this.f1430a = kVar;
            this.f1431b = dVar;
            this.f1432c = appLovinAdLoadListener;
        }

        /* renamed from: a */
        public void mo8990a(boolean z) {
            this.f1433d = z;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            this.f1430a.mo9366aa().mo8980a((AppLovinAdBase) (C0934g) appLovinAd, false, this.f1433d);
            this.f1432c.adReceived(appLovinAd);
        }

        public void failedToReceiveAd(int i) {
            this.f1430a.mo9366aa().mo8981a(this.f1431b, this.f1433d, i);
            this.f1432c.failedToReceiveAd(i);
        }
    }

    /* renamed from: com.applovin.impl.sdk.a.f$b */
    public enum C0933b {
        NONE(0, "none"),
        TIMER(1, "timer"),
        APP_PAUSED(2, "backgrounded"),
        IMPRESSION(3, AdSDKNotificationListener.IMPRESSION_EVENT),
        WATERFALL_RESTARTED(3, "waterfall_restarted"),
        UNKNOWN_ZONE(4, "unknown_zone"),
        SKIPPED_ZONE(5, "skipped_zone"),
        REPEATED_ZONE(6, "repeated_zone");
        

        /* renamed from: i */
        private final int f1443i;

        /* renamed from: j */
        private final String f1444j;

        private C0933b(int i, String str) {
            this.f1443i = i;
            this.f1444j = str;
        }

        /* renamed from: a */
        public int mo8991a() {
            return this.f1443i;
        }

        /* renamed from: b */
        public String mo8992b() {
            return this.f1444j;
        }
    }

    public C0930f(MaxAdFormat maxAdFormat, C1062k kVar) {
        this.f1421a = kVar;
        this.f1422b = maxAdFormat;
        this.f1424d = new ArrayList();
        this.f1425e = new Object();
    }

    /* renamed from: a */
    private static JSONObject m1563a(C0928d dVar, C1062k kVar) {
        JSONObject jSONObject = new JSONObject();
        C1123j.m2584a(jSONObject, "id", dVar.mo8972a(), kVar);
        C1123j.m2601b(jSONObject, "response_ts_s", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), kVar);
        return jSONObject;
    }

    /* renamed from: a */
    public static void m1564a(C0928d dVar, int i, C1062k kVar) {
        if (!((Boolean) kVar.mo9350a(C0965b.f1807eW)).booleanValue()) {
            if (!f1420i) {
                C1107r.m2484i("AppLovinSdk", "Unknown zone in waterfall: " + dVar.mo8972a());
                f1420i = true;
            } else {
                return;
            }
        }
        JSONObject a = m1563a(dVar, kVar);
        C1123j.m2582a(a, "error_code", i, kVar);
        m1568a(C0933b.UNKNOWN_ZONE, C0933b.NONE, C1123j.m2598b((Object) a), (MaxAdFormat) null, kVar);
    }

    /* renamed from: a */
    private void m1565a(C0928d dVar, JSONObject jSONObject) {
        C0933b bVar;
        C1123j.m2588a(jSONObject, m1563a(dVar, this.f1421a), this.f1421a);
        synchronized (this.f1425e) {
            if (m1571a(dVar)) {
                m1566a(C0933b.WATERFALL_RESTARTED);
            } else {
                if (m1574b(dVar)) {
                    m1570a(jSONObject, dVar);
                    bVar = C0933b.REPEATED_ZONE;
                } else if (m1576c(dVar)) {
                    m1570a(jSONObject, dVar);
                    bVar = C0933b.SKIPPED_ZONE;
                }
                m1567a(bVar, dVar);
            }
            m1570a(jSONObject, dVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1566a(C0933b bVar) {
        m1567a(bVar, (C0928d) null);
    }

    /* renamed from: a */
    private void m1567a(C0933b bVar, C0928d dVar) {
        if (!((Boolean) this.f1421a.mo9350a(C0965b.f1807eW)).booleanValue()) {
            if (!this.f1428h) {
                if (bVar == C0933b.SKIPPED_ZONE || bVar == C0933b.REPEATED_ZONE) {
                    C1107r.m2484i("AppLovinSdk", "Invalid zone in waterfall: " + dVar);
                    this.f1428h = true;
                }
            } else {
                return;
            }
        }
        synchronized (this.f1425e) {
            if (!this.f1424d.isEmpty()) {
                JSONArray jSONArray = new JSONArray(this.f1424d);
                this.f1424d.clear();
                C0933b bVar2 = this.f1427g;
                this.f1427g = bVar;
                m1568a(bVar, bVar2, jSONArray, this.f1422b, this.f1421a);
            }
        }
    }

    /* renamed from: a */
    private static void m1568a(C0933b bVar, C0933b bVar2, JSONArray jSONArray, MaxAdFormat maxAdFormat, C1062k kVar) {
        kVar.mo9340Q().mo9266a((C0989a) new C1015m(bVar, bVar2, jSONArray, maxAdFormat, kVar), C1020o.C1022a.BACKGROUND);
    }

    /* renamed from: a */
    private void m1570a(JSONObject jSONObject, C0928d dVar) {
        synchronized (this.f1425e) {
            this.f1424d.add(jSONObject);
            this.f1426f = dVar;
        }
    }

    /* renamed from: a */
    private boolean m1571a(C0928d dVar) {
        if (this.f1426f != null) {
            int indexOf = this.f1423c.indexOf(dVar);
            return indexOf == 0 || indexOf < this.f1423c.indexOf(this.f1426f);
        }
    }

    /* renamed from: b */
    private void m1573b() {
        long c = m1575c();
        if (c <= 0) {
            return;
        }
        if (((Boolean) this.f1421a.mo9350a(C0965b.f1804eT)).booleanValue()) {
            C1115d.m2514a(c, this.f1421a, this);
        } else {
            C1157p.m2682a(c, this.f1421a, this);
        }
    }

    /* renamed from: b */
    private boolean m1574b(C0928d dVar) {
        return this.f1426f == dVar;
    }

    /* renamed from: c */
    private long m1575c() {
        return TimeUnit.SECONDS.toMillis(((Long) this.f1421a.mo9350a(C0965b.f1803eS)).longValue());
    }

    /* renamed from: c */
    private boolean m1576c(C0928d dVar) {
        int indexOf = this.f1423c.indexOf(dVar);
        C0928d dVar2 = this.f1426f;
        return indexOf != (dVar2 != null ? this.f1423c.indexOf(dVar2) + 1 : 0);
    }

    /* renamed from: a */
    public void mo8985a() {
        if (((Boolean) this.f1421a.mo9350a(C0965b.f1805eU)).booleanValue()) {
            m1566a(C0933b.IMPRESSION);
        }
    }

    /* renamed from: a */
    public void mo8986a(AppLovinAdBase appLovinAdBase, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        C1123j.m2601b(jSONObject, "ad_id", appLovinAdBase.getAdIdNumber(), this.f1421a);
        C1123j.m2601b(jSONObject, "ad_created_ts_s", TimeUnit.MILLISECONDS.toSeconds(appLovinAdBase.getCreatedAtMillis()), this.f1421a);
        C1123j.m2587a(jSONObject, "is_preloaded", z, this.f1421a);
        C1123j.m2587a(jSONObject, "for_bidding", z2, this.f1421a);
        m1565a(appLovinAdBase.getAdZone(), jSONObject);
    }

    /* renamed from: a */
    public void mo8987a(C0928d dVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        C1123j.m2582a(jSONObject, "error_code", i, this.f1421a);
        C1123j.m2587a(jSONObject, "for_bidding", z, this.f1421a);
        m1565a(dVar, jSONObject);
    }

    /* renamed from: a */
    public void mo8988a(List<C0928d> list) {
        if (this.f1423c == null) {
            this.f1423c = list;
            m1573b();
            if (((Boolean) this.f1421a.mo9350a(C0965b.f1806eV)).booleanValue()) {
                this.f1421a.mo9375aj().registerReceiver(new AppLovinBroadcastManager.Receiver() {
                    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                        C0930f.this.m1566a(C0933b.APP_PAUSED);
                        synchronized (C0930f.this.f1425e) {
                            C0930f.this.f1424d.clear();
                        }
                    }
                }, new IntentFilter("com.applovin.application_paused"));
            }
        }
    }

    public void run() {
        m1566a(C0933b.TIMER);
        m1573b();
    }
}
