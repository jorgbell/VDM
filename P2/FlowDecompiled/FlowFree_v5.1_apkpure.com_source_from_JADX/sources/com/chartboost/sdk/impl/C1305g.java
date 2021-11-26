package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.chartboost.sdk.C1275d;
import com.chartboost.sdk.C1277e;
import com.chartboost.sdk.C1284h;
import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.ChartboostBanner;
import com.chartboost.sdk.Events.BannerErrorMap;
import com.chartboost.sdk.Events.ChartboostError;
import com.chartboost.sdk.Libraries.C1220g;
import com.chartboost.sdk.Libraries.C1224j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C1228a;
import com.chartboost.sdk.Model.C1229b;
import com.chartboost.sdk.Model.C1230c;
import com.chartboost.sdk.Model.C1232e;
import com.chartboost.sdk.Model.C1234g;
import com.chartboost.sdk.Model.C1236h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Networking.C1240a;
import com.chartboost.sdk.Networking.C1247g;
import com.chartboost.sdk.Networking.C1248h;
import com.chartboost.sdk.Networking.C1249i;
import com.chartboost.sdk.Networking.C1252j;
import com.chartboost.sdk.Networking.requests.models.ShowParamsModel;
import com.chartboost.sdk.Tracking.C1260a;
import com.chartboost.sdk.Tracking.C1264c;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.Tracking.C1267f;
import com.chartboost.sdk.Tracking.C1268g;
import com.chartboost.sdk.Tracking.C1269h;
import com.chartboost.sdk.impl.C1286a;
import com.chartboost.sdk.impl.C1357p0;
import com.mopub.mobileads.ChartboostShared;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.g */
public class C1305g {

    /* renamed from: A */
    ScheduledFuture<?> f3088A;

    /* renamed from: B */
    private final long f3089B;

    /* renamed from: C */
    private final long f3090C;

    /* renamed from: D */
    private final String[] f3091D;

    /* renamed from: a */
    public final ScheduledExecutorService f3092a;

    /* renamed from: b */
    private final C1344n f3093b;

    /* renamed from: c */
    public final C1220g f3094c;

    /* renamed from: d */
    private final C1247g f3095d;

    /* renamed from: e */
    private final C1248h f3096e;

    /* renamed from: f */
    private final C1234g f3097f;

    /* renamed from: g */
    private final AtomicReference<C1236h> f3098g;

    /* renamed from: h */
    private final SharedPreferences f3099h;

    /* renamed from: i */
    final C1224j f3100i;

    /* renamed from: j */
    final Handler f3101j;

    /* renamed from: k */
    final C1275d f3102k;

    /* renamed from: l */
    private final C1249i f3103l;

    /* renamed from: m */
    private final C1277e f3104m;

    /* renamed from: n */
    private final C1252j f3105n;

    /* renamed from: o */
    final C1286a f3106o;

    /* renamed from: p */
    protected ChartboostBanner f3107p;

    /* renamed from: q */
    private C1268g f3108q;

    /* renamed from: r */
    private Context f3109r;

    /* renamed from: s */
    int f3110s = 0;

    /* renamed from: t */
    private int f3111t;

    /* renamed from: u */
    private boolean f3112u;

    /* renamed from: v */
    final Map<String, C1312h> f3113v;

    /* renamed from: w */
    final SortedSet<C1312h> f3114w;

    /* renamed from: x */
    final SortedSet<C1312h> f3115x;

    /* renamed from: y */
    private final Map<String, Long> f3116y;

    /* renamed from: z */
    private final Map<String, Integer> f3117z;

    /* renamed from: com.chartboost.sdk.impl.g$b */
    public class C1307b implements Runnable {

        /* renamed from: a */
        public final int f3124a;

        /* renamed from: b */
        final String f3125b;

        /* renamed from: c */
        final C1312h f3126c;

        /* renamed from: d */
        final CBError.CBImpressionError f3127d;

        public C1307b(int i, String str, C1312h hVar, CBError.CBImpressionError cBImpressionError) {
            this.f3124a = i;
            this.f3125b = str;
            this.f3126c = hVar;
            this.f3127d = cBImpressionError;
        }

        public void run() {
            try {
                synchronized (C1305g.this) {
                    int i = this.f3124a;
                    if (i != 0) {
                        switch (i) {
                            case 2:
                                C1305g gVar = C1305g.this;
                                gVar.f3088A = null;
                                gVar.mo10423f();
                                break;
                            case 3:
                                C1305g.this.mo10419d(this.f3125b);
                                break;
                            case 4:
                                C1305g.this.mo10424h(this.f3125b);
                                break;
                            case 5:
                                C1305g.this.mo10420e(this.f3126c);
                                break;
                            case 6:
                                C1305g.this.mo10413a(this.f3126c, this.f3127d);
                                break;
                            case 7:
                                C1305g.this.mo10425i(this.f3126c);
                                break;
                            case 8:
                                C1305g.this.mo10421e(this.f3125b);
                                break;
                        }
                    } else {
                        C1305g.this.mo10417b();
                    }
                }
            } catch (Exception e) {
                CBLogging.m2905b("AdUnitManager", e.toString());
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.g$c */
    private static class C1308c {

        /* renamed from: a */
        protected C1230c f3129a;

        /* renamed from: b */
        protected CBError.CBImpressionError f3130b;

        public C1308c(C1230c cVar, CBError.CBImpressionError cBImpressionError) {
            this.f3129a = cVar;
            this.f3130b = cBImpressionError;
        }
    }

    public C1305g(Context context, C1286a aVar, ScheduledExecutorService scheduledExecutorService, C1344n nVar, C1220g gVar, C1247g gVar2, C1248h hVar, C1234g gVar3, AtomicReference<C1236h> atomicReference, SharedPreferences sharedPreferences, C1224j jVar, Handler handler, C1275d dVar, C1249i iVar, C1277e eVar, C1252j jVar2, C1268g gVar4) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f3089B = timeUnit.toNanos(1);
        this.f3090C = timeUnit.toNanos(1);
        this.f3091D = new String[]{"ASKED_TO_CACHE", "ASKED_TO_SHOW", "REQUESTING_TO_CACHE", "REQUESTING_TO_SHOW", "DOWNLOADING_TO_CACHE", "DOWNLOADING_TO_SHOW", "READY", "ASKING_UI_TO_SHOW_AD", "DONE"};
        this.f3109r = context;
        this.f3092a = scheduledExecutorService;
        this.f3093b = nVar;
        this.f3094c = gVar;
        this.f3095d = gVar2;
        this.f3096e = hVar;
        this.f3097f = gVar3;
        this.f3098g = atomicReference;
        this.f3099h = sharedPreferences;
        this.f3100i = jVar;
        this.f3101j = handler;
        this.f3102k = dVar;
        this.f3103l = iVar;
        this.f3104m = eVar;
        this.f3105n = jVar2;
        this.f3106o = aVar;
        this.f3108q = gVar4;
        this.f3111t = 1;
        this.f3113v = new HashMap();
        this.f3115x = new TreeSet();
        this.f3114w = new TreeSet();
        this.f3116y = new HashMap();
        this.f3117z = new HashMap();
        this.f3112u = false;
    }

    /* renamed from: c */
    private void m3459c() {
        long b = this.f3100i.mo10067b();
        Iterator<Long> it = this.f3116y.values().iterator();
        while (it.hasNext()) {
            if (b - it.next().longValue() >= 0) {
                it.remove();
            }
        }
    }

    /* renamed from: d */
    private void m3462d() {
        Long l;
        boolean z = true;
        if (this.f3110s == 1) {
            long b = this.f3100i.mo10067b();
            l = null;
            for (Map.Entry next : this.f3116y.entrySet()) {
                if (this.f3113v.get((String) next.getKey()) != null) {
                    long max = Math.max(this.f3089B, ((Long) next.getValue()).longValue() - b);
                    if (l == null || max < l.longValue()) {
                        l = Long.valueOf(max);
                    }
                }
            }
        } else {
            l = null;
        }
        if (!(l == null || this.f3088A == null)) {
            if (Math.abs(l.longValue() - this.f3088A.getDelay(TimeUnit.NANOSECONDS)) > this.f3089B) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        ScheduledFuture<?> scheduledFuture = this.f3088A;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f3088A = null;
        }
        if (l != null) {
            this.f3088A = this.f3092a.schedule(new C1307b(2, (String) null, (C1312h) null, (CBError.CBImpressionError) null), l.longValue(), TimeUnit.NANOSECONDS);
        }
    }

    /* renamed from: g */
    private boolean m3467g(String str) {
        return this.f3116y.containsKey(str);
    }

    /* renamed from: h */
    private void m3468h(C1312h hVar) {
        int i = hVar.f3140c;
        long b = this.f3100i.mo10067b();
        Long l = hVar.f3145h;
        if (l != null) {
            hVar.f3148k = Integer.valueOf((int) TimeUnit.NANOSECONDS.toMillis(b - l.longValue()));
        }
        Long l2 = hVar.f3146i;
        if (l2 != null) {
            hVar.f3149l = Integer.valueOf((int) TimeUnit.NANOSECONDS.toMillis(b - l2.longValue()));
        }
        hVar.f3140c = 6;
        String str = "";
        if (hVar.f3143f) {
            C1228a aVar = hVar.f3141d;
            if (aVar != null) {
                str = aVar.f2716i;
            }
            Handler handler = this.f3101j;
            C1286a aVar2 = this.f3106o;
            aVar2.getClass();
            handler.post(new C1286a.C1287a(0, hVar.f3139b, (CBError.CBImpressionError) null, (ChartboostError) null, false, str));
        } else {
            C1266e.m3223e(new C1267f("cache_on_show_finish_success", str, this.f3106o.f3036b, hVar.f3139b));
        }
        if (i == 5) {
            m3470k(hVar);
        }
    }

    /* renamed from: j */
    private void m3469j(C1312h hVar) {
        this.f3113v.remove(hVar.f3139b);
        m3448a(hVar);
        hVar.f3140c = 8;
        hVar.f3141d = null;
    }

    /* renamed from: k */
    private void m3470k(C1312h hVar) {
        if (!this.f3096e.mo10152d()) {
            m3455b(hVar, CBError.CBImpressionError.INTERNET_UNAVAILABLE_AT_SHOW);
            return;
        }
        C1308c b = m3453b(hVar);
        m3450a(hVar, b.f3129a, b.f3130b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10417b() {
        if (this.f3110s == 0) {
            this.f3110s = 1;
            mo10423f();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10420e(C1312h hVar) {
        if (hVar.f3140c == 7) {
            if (hVar.f3146i != null && hVar.f3150m == null) {
                hVar.f3150m = Integer.valueOf((int) TimeUnit.NANOSECONDS.toMillis(this.f3100i.mo10067b() - hVar.f3146i.longValue()));
            }
            this.f3117z.remove(hVar.f3139b);
            Handler handler = this.f3101j;
            C1286a aVar = this.f3106o;
            aVar.getClass();
            handler.post(new C1286a.C1287a(5, hVar.f3139b, (CBError.CBImpressionError) null, (ChartboostError) null, true, hVar.f3141d.f2716i));
            m3465f(hVar);
            m3469j(hVar);
            mo10423f();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo10423f() {
        if (!this.f3112u) {
            try {
                this.f3112u = true;
                m3459c();
                if (this.f3110s == 1 && !m3452a(this.f3115x, 1, 3, 1)) {
                    m3452a(this.f3114w, 0, 2, 2);
                }
                m3462d();
                this.f3112u = false;
            } catch (Throwable th) {
                this.f3112u = false;
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo10425i(C1312h hVar) {
        if (hVar.f3140c == 7) {
            hVar.f3140c = 6;
            hVar.f3147j = null;
            hVar.f3146i = null;
            hVar.f3150m = null;
            C1266e.m3223e(new C1267f("show_finish_failure", CBError.CBImpressionError.USER_CANCELLATION.name(), hVar.f3141d.f2725r, hVar.f3139b));
        }
    }

    /* renamed from: a */
    private boolean m3452a(SortedSet<C1312h> sortedSet, int i, int i2, int i3) {
        Iterator it = sortedSet.iterator();
        while (it.hasNext()) {
            C1312h hVar = (C1312h) it.next();
            if (hVar.f3140c != i || hVar.f3141d != null) {
                it.remove();
            } else if (m3467g(hVar.f3139b)) {
                continue;
            } else if (!this.f3106o.mo10372b(hVar.f3139b)) {
                hVar.f3140c = 8;
                m3448a(hVar);
                this.f3113v.remove(hVar.f3139b);
                it.remove();
            } else {
                hVar.f3140c = i2;
                it.remove();
                m3449a(hVar, i3);
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    private void m3466g(C1312h hVar) {
        m3461c(hVar, CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE);
        m3469j(hVar);
        m3460c(hVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0023  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3457b(com.chartboost.sdk.Model.C1228a r5) {
        /*
            r4 = this;
            com.chartboost.sdk.Libraries.g r0 = r4.f3094c
            r1 = 0
            if (r0 == 0) goto L_0x0052
            if (r5 != 0) goto L_0x0008
            goto L_0x0052
        L_0x0008:
            java.util.Map<java.lang.String, com.chartboost.sdk.Model.b> r5 = r5.f2710c
            com.chartboost.sdk.Libraries.h r0 = r0.mo10046a()
            if (r0 == 0) goto L_0x0052
            if (r5 != 0) goto L_0x0013
            goto L_0x0052
        L_0x0013:
            java.io.File r0 = r0.f2680a
            java.util.Collection r5 = r5.values()
            java.util.Iterator r5 = r5.iterator()
        L_0x001d:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0050
            java.lang.Object r2 = r5.next()
            com.chartboost.sdk.Model.b r2 = (com.chartboost.sdk.Model.C1229b) r2
            if (r2 == 0) goto L_0x004f
            java.io.File r3 = r2.mo10077a((java.io.File) r0)
            if (r3 == 0) goto L_0x0037
            boolean r3 = r3.exists()
            if (r3 != 0) goto L_0x001d
        L_0x0037:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Asset does not exist: "
            r5.append(r0)
            java.lang.String r0 = r2.f2729b
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            java.lang.String r0 = "AdUnitManager"
            com.chartboost.sdk.Libraries.CBLogging.m2905b(r0, r5)
        L_0x004f:
            return r1
        L_0x0050:
            r5 = 1
            return r5
        L_0x0052:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C1305g.m3457b(com.chartboost.sdk.Model.a):boolean");
    }

    /* renamed from: c */
    private void m3460c(C1312h hVar) {
        C1236h hVar2 = this.f3098g.get();
        long j = hVar2.f2817k;
        int i = hVar2.f2818l;
        Integer num = this.f3117z.get(hVar.f3139b);
        if (num == null) {
            num = 0;
        }
        Integer valueOf = Integer.valueOf(Math.min(num.intValue(), i));
        this.f3117z.put(hVar.f3139b, Integer.valueOf(valueOf.intValue() + 1));
        this.f3116y.put(hVar.f3139b, Long.valueOf(this.f3100i.mo10067b() + TimeUnit.MILLISECONDS.toNanos(j << valueOf.intValue())));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10421e(String str) {
        C1312h hVar = this.f3113v.get(str);
        if (hVar != null && hVar.f3140c == 6) {
            m3469j(hVar);
            mo10423f();
        }
    }

    /* renamed from: f */
    public synchronized C1228a mo10422f(String str) {
        int i;
        C1312h hVar = this.f3113v.get(str);
        if (hVar == null || ((i = hVar.f3140c) != 6 && i != 7)) {
            return null;
        }
        return hVar.f3141d;
    }

    /* renamed from: e */
    private boolean m3464e() {
        C1268g gVar;
        if (this.f3106o.f3035a == 0 && !C1418k.f3545o && (gVar = this.f3108q) != null && gVar.mo10261c() == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private String m3458c(C1228a aVar, File file, String str) {
        C1229b bVar = aVar.f2726s;
        if (bVar == null) {
            CBLogging.m2905b("AdUnitManager", "AdUnit does not have a template body");
            return null;
        }
        File a = bVar.mo10077a(file);
        HashMap hashMap = new HashMap(aVar.f2711d);
        for (Map.Entry next : aVar.f2710c.entrySet()) {
            hashMap.put(next.getKey(), ((C1229b) next.getValue()).f2729b);
        }
        try {
            return C1356p.m3667a(a, hashMap, this.f3106o.f3036b, str);
        } catch (Exception e) {
            CBLogging.m2905b("AdUnitManager", "loadTemplateHtml: " + e.toString());
            return null;
        }
    }

    /* renamed from: f */
    private void m3465f(C1312h hVar) {
        String str = hVar.f3141d.f2713f;
        String str2 = hVar.f3139b;
        this.f3095d.mo10147a(new C1370s0(this.f3106o.f3039e, this.f3097f, new ShowParamsModel(str, str2), new C1318i(this, str2)));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m3456b(String str, C1228a aVar) {
        String str2;
        String str3;
        String str4;
        if (aVar != null) {
            String str5 = aVar.f2716i;
            String str6 = aVar.f2715h;
            str2 = aVar.f2724q;
            str4 = str5;
            str3 = str6;
        } else {
            str4 = "";
            str3 = str4;
            str2 = str3;
        }
        C1266e.m3218b(new C1269h(str, this.f3106o.f3036b, str4, str3, str2));
    }

    /* renamed from: com.chartboost.sdk.impl.g$a */
    class C1306a implements C1357p0.C1358a {

        /* renamed from: a */
        final /* synthetic */ C1312h f3118a;

        /* renamed from: b */
        final /* synthetic */ long f3119b;

        /* renamed from: c */
        final /* synthetic */ boolean f3120c;

        /* renamed from: d */
        final /* synthetic */ boolean f3121d;

        /* renamed from: e */
        final /* synthetic */ boolean f3122e;

        C1306a(C1312h hVar, long j, boolean z, boolean z2, boolean z3) {
            this.f3118a = hVar;
            this.f3119b = j;
            this.f3120c = z;
            this.f3121d = z2;
            this.f3122e = z3;
        }

        /* renamed from: a */
        public void mo10427a(C1357p0 p0Var, JSONObject jSONObject) {
            C1228a aVar;
            try {
                C1312h hVar = this.f3118a;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                hVar.f3153p = Integer.valueOf((int) timeUnit.toMillis(C1305g.this.f3100i.mo10067b() - this.f3119b));
                this.f3118a.f3154q = Integer.valueOf((int) timeUnit.toMillis(p0Var.f2853g));
                this.f3118a.f3155r = Integer.valueOf((int) timeUnit.toMillis(p0Var.f2854h));
                if (this.f3120c) {
                    aVar = new C1228a(0, jSONObject, true);
                } else if (this.f3121d) {
                    aVar = new C1410y(C1305g.this.f3106o.f3035a, jSONObject);
                } else if (this.f3122e) {
                    aVar = new C1228a(1, jSONObject, false);
                } else {
                    aVar = new C1228a(0, jSONObject, false);
                }
                C1305g.this.mo10415a(this.f3118a, aVar);
            } catch (JSONException e) {
                String str = this.f3118a.f3139b;
                C1305g.this.m3456b(str, (C1228a) null);
                if (this.f3121d) {
                    C1266e.m3223e(new C1260a("cache_bid_response_parsing_error", e.toString(), C1305g.this.f3106o.f3036b, str));
                } else {
                    C1266e.m3223e(new C1260a("cache_get_response_parsing_error", e.toString(), C1305g.this.f3106o.f3036b, str));
                }
                CBLogging.m2905b("AdUnitManager", "sendAdGetRequest.onSuccess: " + e.toString());
                C1305g.this.mo10414a(this.f3118a, new CBError(CBError.C1227b.UNEXPECTED_RESPONSE, "Response conversion failure"));
            }
        }

        /* renamed from: a */
        public void mo10426a(C1357p0 p0Var, CBError cBError) {
            C1305g.this.m3456b(this.f3118a.f3139b, (C1228a) null);
            C1266e.m3223e(new C1264c("cache_request_error", cBError.getErrorDesc(), C1305g.this.f3106o.f3036b, this.f3118a.f3139b));
            C1305g.this.mo10414a(this.f3118a, cBError);
        }
    }

    /* renamed from: a */
    public synchronized boolean mo10416a(String str, C1410y yVar) {
        int i = this.f3111t;
        this.f3111t = i + 1;
        C1312h hVar = new C1312h(i, str, 6);
        hVar.f3142e = 1;
        hVar.f3141d = yVar;
        this.f3113v.put(str, hVar);
        this.f3114w.add(hVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo10424h(String str) {
        if (m3464e()) {
            C1286a aVar = this.f3106o;
            aVar.getClass();
            this.f3101j.postDelayed(new C1286a.C1287a(4, str, CBError.CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED, (ChartboostError) null, true, ""), this.f3090C);
            return;
        }
        C1312h hVar = this.f3113v.get(str);
        if (hVar == null) {
            C1266e.m3223e(new C1267f("cache_start", "", this.f3106o.f3036b, str));
            int i = this.f3111t;
            this.f3111t = i + 1;
            hVar = new C1312h(i, str, 1);
            this.f3113v.put(str, hVar);
            this.f3115x.add(hVar);
        }
        if (!hVar.f3157t) {
            hVar.f3157t = true;
            C1266e.m3223e(new C1267f("show_start", "", this.f3106o.f3036b, str));
        }
        if (hVar.f3146i == null) {
            hVar.f3146i = Long.valueOf(this.f3100i.mo10067b());
        }
        int i2 = hVar.f3140c;
        if (i2 == 0) {
            this.f3114w.remove(hVar);
            this.f3115x.add(hVar);
            hVar.f3140c = 1;
        } else if (i2 == 2) {
            hVar.f3140c = 3;
        } else if (i2 == 4) {
            hVar.f3140c = 5;
            m3463d(hVar);
        } else if (i2 == 6) {
            m3470k(hVar);
        }
        mo10423f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void m3451a(C1312h hVar, boolean z, int i, int i2) {
        int i3 = hVar.f3140c;
        if (i3 == 4 || i3 == 5) {
            hVar.f3151n = Integer.valueOf(i);
            hVar.f3152o = Integer.valueOf(i2);
            if (z) {
                m3468h(hVar);
            } else {
                m3466g(hVar);
            }
        }
        mo10423f();
    }

    /* renamed from: a */
    private void m3449a(C1312h hVar, int i) {
        C1357p0 p0Var;
        C1312h hVar2 = hVar;
        try {
            C1236h hVar3 = this.f3098g.get();
            int i2 = this.f3106o.f3035a;
            boolean z = i2 == 2;
            boolean z2 = i2 == 3;
            boolean z3 = hVar3.f2823q && !z;
            C1306a aVar = r1;
            C1306a aVar2 = new C1306a(hVar, this.f3100i.mo10067b(), z, z2, z3);
            boolean z4 = hVar2.f3140c == 2;
            int b = this.f3108q.mo10260b(this.f3106o.f3035a);
            if (z) {
                p0Var = new C1357p0("https://live.chartboost.com", this.f3106o.f3037c, this.f3097f, i, aVar);
                p0Var.f3342m = true;
                p0Var.mo10562a(ChartboostShared.LOCATION_KEY, (Object) hVar2.f3139b);
                p0Var.mo10562a("cache", (Object) Boolean.valueOf(z4));
                p0Var.mo10562a("raw", (Object) Boolean.TRUE);
                hVar2.f3142e = 0;
            } else if (z2) {
                C1367r0 r0Var = new C1367r0(this.f3109r, new C1232e("https://da.chartboost.com", this.f3106o.f3038d, this.f3097f, i, aVar), new C1240a(this.f3106o.f3035a, Integer.valueOf(this.f3107p.getBannerHeight()), Integer.valueOf(this.f3107p.getBannerWidth()), hVar2.f3139b, b));
                hVar2.f3142e = 1;
                p0Var = r0Var;
            } else if (z3) {
                C1364q0 q0Var = new C1364q0(String.format(this.f3106o.f3038d, new Object[]{hVar3.f2829w}), this.f3097f, i, aVar);
                q0Var.mo10594a("cache_assets", this.f3094c.mo10053d(), 0);
                q0Var.mo10594a(ChartboostShared.LOCATION_KEY, hVar2.f3139b, 0);
                q0Var.mo10594a("imp_depth", Integer.valueOf(b), 0);
                q0Var.mo10594a("cache", Boolean.valueOf(z4), 0);
                q0Var.f3342m = true;
                hVar2.f3142e = 1;
                p0Var = q0Var;
            } else {
                int i3 = i;
                p0Var = new C1357p0("https://live.chartboost.com", this.f3106o.f3037c, this.f3097f, i, aVar);
                p0Var.mo10562a("local-videos", (Object) this.f3094c.mo10051c());
                p0Var.f3342m = true;
                p0Var.mo10562a(ChartboostShared.LOCATION_KEY, (Object) hVar2.f3139b);
                p0Var.mo10562a("cache", (Object) Boolean.valueOf(z4));
                hVar2.f3142e = 0;
            }
            p0Var.f2855i = 1;
            this.f3110s = 2;
            this.f3095d.mo10147a(p0Var);
        } catch (Exception e) {
            CBLogging.m2905b("AdUnitManager", "sendAdGetRequest: " + e.toString());
            mo10414a(hVar2, new CBError(CBError.C1227b.MISCELLANEOUS, "error sending ad-get request"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10419d(String str) {
        if (m3464e()) {
            C1286a aVar = this.f3106o;
            aVar.getClass();
            this.f3101j.postDelayed(new C1286a.C1287a(4, str, CBError.CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED, (ChartboostError) null, false, ""), this.f3090C);
            return;
        }
        C1312h hVar = this.f3113v.get(str);
        if (hVar != null && hVar.f3140c == 6 && !m3457b(hVar.f3141d)) {
            this.f3113v.remove(str);
            m3448a(hVar);
            hVar = null;
        }
        if (hVar == null) {
            int i = this.f3111t;
            this.f3111t = i + 1;
            hVar = new C1312h(i, str, 0);
            this.f3113v.put(str, hVar);
            this.f3114w.add(hVar);
        }
        String str2 = "";
        if (!hVar.f3156s) {
            hVar.f3156s = true;
            C1266e.m3223e(new C1267f("cache_start", str2, this.f3106o.f3036b, str));
        }
        hVar.f3143f = true;
        if (hVar.f3145h == null) {
            hVar.f3145h = Long.valueOf(this.f3100i.mo10067b());
        }
        int i2 = hVar.f3140c;
        if (i2 == 6 || i2 == 7) {
            C1228a aVar2 = hVar.f3141d;
            if (aVar2 != null) {
                str2 = aVar2.f2716i;
            }
            Handler handler = this.f3101j;
            C1286a aVar3 = this.f3106o;
            aVar3.getClass();
            handler.post(new C1286a.C1287a(0, str, (CBError.CBImpressionError) null, (ChartboostError) null, true, str2));
        }
        mo10423f();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3461c(com.chartboost.sdk.impl.C1312h r7, com.chartboost.sdk.Model.CBError.CBImpressionError r8) {
        /*
            r6 = this;
            r6.m3455b((com.chartboost.sdk.impl.C1312h) r7, (com.chartboost.sdk.Model.CBError.CBImpressionError) r8)
            com.chartboost.sdk.Model.CBError$CBImpressionError r0 = com.chartboost.sdk.Model.CBError.CBImpressionError.NO_AD_FOUND
            if (r8 != r0) goto L_0x0008
            return
        L_0x0008:
            com.chartboost.sdk.Model.a r0 = r7.f3141d
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.lang.String r2 = r0.f2713f
            goto L_0x0011
        L_0x0010:
            r2 = r1
        L_0x0011:
            int r3 = r7.f3140c
            if (r3 == 0) goto L_0x001f
            r4 = 2
            if (r3 == r4) goto L_0x001f
            r4 = 4
            if (r3 != r4) goto L_0x001c
            goto L_0x001f
        L_0x001c:
            java.lang.String r3 = "show"
            goto L_0x0021
        L_0x001f:
            java.lang.String r3 = "cache"
        L_0x0021:
            if (r0 == 0) goto L_0x0026
            int r0 = r0.f2709b
            goto L_0x002c
        L_0x0026:
            java.lang.Integer r0 = r7.f3142e
            int r0 = r0.intValue()
        L_0x002c:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            if (r0 == 0) goto L_0x003d
            int r0 = r0.intValue()
            if (r0 != 0) goto L_0x003b
            java.lang.String r1 = "native"
            goto L_0x003d
        L_0x003b:
            java.lang.String r1 = "web"
        L_0x003d:
            int r0 = r7.f3140c
            if (r0 < 0) goto L_0x0049
            java.lang.String[] r4 = r6.f3091D
            int r5 = r4.length
            if (r0 >= r5) goto L_0x0049
            r0 = r4[r0]
            goto L_0x005c
        L_0x0049:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Unknown state: "
            r0.append(r4)
            int r4 = r7.f3140c
            r0.append(r4)
            java.lang.String r0 = r0.toString()
        L_0x005c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "reportError: adTypeTraits.name: "
            r4.append(r5)
            com.chartboost.sdk.impl.a r5 = r6.f3106o
            java.lang.String r5 = r5.f3036b
            r4.append(r5)
            java.lang.String r5 = " reason: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = " format: "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = " error: "
            r4.append(r1)
            java.lang.String r1 = r8.toString()
            r4.append(r1)
            java.lang.String r1 = " adId: "
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = " appRequest.location: "
            r4.append(r1)
            java.lang.String r1 = r7.f3139b
            r4.append(r1)
            java.lang.String r1 = " stateName: "
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r1 = "AdUnitManager"
            com.chartboost.sdk.Libraries.CBLogging.m2905b(r1, r0)
            boolean r0 = r7.f3143f
            if (r0 != 0) goto L_0x00c4
            com.chartboost.sdk.Tracking.f r0 = new com.chartboost.sdk.Tracking.f
            java.lang.String r8 = r8.name()
            com.chartboost.sdk.impl.a r1 = r6.f3106o
            java.lang.String r1 = r1.f3036b
            java.lang.String r7 = r7.f3139b
            java.lang.String r2 = "cache_on_show_finish_failure"
            r0.<init>(r2, r8, r1, r7)
            com.chartboost.sdk.Tracking.C1266e.m3223e(r0)
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C1305g.m3461c(com.chartboost.sdk.impl.h, com.chartboost.sdk.Model.CBError$CBImpressionError):void");
    }

    /* renamed from: b */
    private C1308c m3453b(C1312h hVar) {
        CBError.CBImpressionError cBImpressionError;
        String str;
        C1230c cVar = null;
        try {
            C1228a aVar = hVar.f3141d;
            File file = this.f3094c.mo10046a().f2680a;
            cBImpressionError = m3443a(aVar);
            if (cBImpressionError == null) {
                cBImpressionError = m3444a(aVar, file, hVar.f3139b);
            }
            if (cBImpressionError == null) {
                str = m3454b(aVar, file, hVar.f3139b);
                cBImpressionError = m3445a(str, aVar);
            } else {
                str = null;
            }
            if (cBImpressionError == null) {
                cVar = m3446a(hVar, str);
            }
        } catch (Exception e) {
            CBLogging.m2905b("AdUnitManager", "showReady: " + e.toString());
            cBImpressionError = CBError.CBImpressionError.INTERNAL;
        }
        return new C1308c(cVar, cBImpressionError);
    }

    /* renamed from: b */
    private String m3454b(C1228a aVar, File file, String str) {
        if (aVar.f2709b == 1) {
            return m3458c(aVar, file, str);
        }
        return null;
    }

    /* renamed from: b */
    private void m3455b(C1312h hVar, CBError.CBImpressionError cBImpressionError) {
        String str;
        ChartboostError chartboostError;
        String str2 = "cache";
        String str3 = "";
        if (hVar != null) {
            String str4 = hVar.f3139b;
            int i = hVar.f3140c;
            if (!(i == 0 || i == 2 || i == 4)) {
                str2 = "show";
            }
            str = str4;
        } else {
            str = str3;
        }
        boolean equals = "show".equals(str2);
        C1228a aVar = hVar.f3141d;
        if (aVar != null) {
            str3 = aVar.f2716i;
        }
        String str5 = str3;
        C1286a aVar2 = this.f3106o;
        if (aVar2.f3035a == 3) {
            if (equals) {
                chartboostError = BannerErrorMap.mapImpressionErrorToBannerShowError(cBImpressionError);
            } else {
                chartboostError = BannerErrorMap.mapImpressionErrorToBannerCacheError(cBImpressionError);
            }
            ChartboostError chartboostError2 = chartboostError;
            int a = m3442a(chartboostError2);
            Handler handler = this.f3101j;
            C1286a aVar3 = this.f3106o;
            aVar3.getClass();
            handler.post(new C1286a.C1287a(a, str, (CBError.CBImpressionError) null, chartboostError2, equals, str5));
            return;
        }
        Handler handler2 = this.f3101j;
        aVar2.getClass();
        handler2.post(new C1286a.C1287a(4, str, cBImpressionError, (ChartboostError) null, equals, str5));
    }

    /* renamed from: d */
    private void m3463d(C1312h hVar) {
        C1228a aVar = hVar.f3141d;
        if (aVar != null) {
            int i = hVar.f3140c;
            if (i == 5 || i == 4) {
                int i2 = i == 5 ? 1 : 2;
                if (hVar.f3144g > i2) {
                    $$Lambda$g$789x1TXpOsHpD2koHpvSUlIIg0c r1 = new C1328j(hVar) {
                        public final /* synthetic */ C1312h f$1;

                        {
                            this.f$1 = r2;
                        }

                        /* renamed from: a */
                        public final void mo10363a(boolean z, int i, int i2) {
                            C1305g.this.m3451a(this.f$1, z, i, i2);
                        }
                    };
                    hVar.f3144g = i2;
                    this.f3093b.mo10519a(i2, aVar.f2710c, new AtomicInteger(), (C1328j) C1284h.m3343a().mo10361a(r1), this.f3106o.f3036b);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo10415a(C1312h hVar, C1228a aVar) {
        m3456b(hVar.f3139b, aVar);
        this.f3110s = 1;
        hVar.f3140c = hVar.f3140c == 2 ? 4 : 5;
        hVar.f3141d = aVar;
        m3463d(hVar);
        mo10423f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo10414a(C1312h hVar, CBError cBError) {
        if (this.f3110s != 0) {
            this.f3110s = 1;
            m3461c(hVar, cBError.getImpressionError());
            m3469j(hVar);
            m3460c(hVar);
            mo10423f();
        }
    }

    /* renamed from: a */
    private void m3450a(C1312h hVar, C1230c cVar, CBError.CBImpressionError cBImpressionError) {
        if (cBImpressionError == null) {
            hVar.f3140c = 7;
            C1275d dVar = this.f3102k;
            dVar.getClass();
            C1275d.C1276a aVar = new C1275d.C1276a(10);
            aVar.f2987c = cVar;
            hVar.f3147j = Long.valueOf(this.f3100i.mo10067b());
            this.f3101j.post(aVar);
            return;
        }
        m3461c(hVar, cBImpressionError);
        m3469j(hVar);
    }

    /* renamed from: a */
    private CBError.CBImpressionError m3443a(C1228a aVar) {
        if (aVar.f2709b != 0 || (!this.f3106o.f3040f && !aVar.f2724q.equals("video"))) {
            return null;
        }
        CBError.CBImpressionError a = mo10412a(aVar.f2708a);
        if (a == null) {
            return a;
        }
        CBLogging.m2905b("AdUnitManager", "Video media unavailable for the impression");
        return a;
    }

    /* renamed from: a */
    private CBError.CBImpressionError m3444a(C1228a aVar, File file, String str) {
        CBError.CBImpressionError cBImpressionError = null;
        for (C1229b next : aVar.f2710c.values()) {
            File a = next.mo10077a(file);
            if (a == null || !a.exists()) {
                CBLogging.m2905b("AdUnitManager", "Asset does not exist: " + next.f2729b);
                cBImpressionError = CBError.CBImpressionError.ASSET_MISSING;
                C1266e.m3223e(new C1260a("show_unavailable_asset_error", next.f2729b, this.f3106o.f3036b, str));
            }
        }
        return cBImpressionError;
    }

    /* renamed from: a */
    private CBError.CBImpressionError m3445a(String str, C1228a aVar) {
        if (str == null && aVar.f2709b == 1) {
            return CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW;
        }
        return null;
    }

    /* renamed from: a */
    private C1230c m3446a(C1312h hVar, String str) {
        C1312h hVar2 = hVar;
        Context context = this.f3109r;
        C1228a aVar = hVar2.f3141d;
        C1302f fVar = r6;
        C1302f fVar2 = new C1302f(this, hVar2);
        return new C1230c(context, aVar, fVar, this.f3094c, this.f3095d, this.f3097f, this.f3099h, this.f3101j, this.f3102k, this.f3103l, this.f3104m, this.f3105n, this.f3106o, hVar2.f3139b, str, this.f3107p);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10413a(C1312h hVar, CBError.CBImpressionError cBImpressionError) {
        m3461c(hVar, cBImpressionError);
        if (hVar.f3140c != 7) {
            return;
        }
        if (cBImpressionError == CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE) {
            hVar.f3140c = 6;
            hVar.f3147j = null;
            hVar.f3146i = null;
            hVar.f3150m = null;
            return;
        }
        m3460c(hVar);
        m3469j(hVar);
        mo10423f();
    }

    /* renamed from: a */
    private int m3442a(ChartboostError chartboostError) {
        if (chartboostError != null) {
            return chartboostError.actionType == 1 ? 6 : 7;
        }
        return 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CBError.CBImpressionError mo10412a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return CBError.CBImpressionError.INVALID_RESPONSE;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("assets");
        if (optJSONObject == null) {
            return CBError.CBImpressionError.INVALID_RESPONSE;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(CBUtility.m2921b(CBUtility.m2918b(this.f3109r)) ? "video-portrait" : "video-landscape");
        if (optJSONObject2 == null) {
            return CBError.CBImpressionError.VIDEO_UNAVAILABLE_FOR_CURRENT_ORIENTATION;
        }
        String optString = optJSONObject2.optString("id");
        if (optString.isEmpty()) {
            return CBError.CBImpressionError.VIDEO_ID_MISSING;
        }
        if (new File(this.f3094c.mo10046a().f2683d, optString).exists()) {
            return null;
        }
        return CBError.CBImpressionError.VIDEO_UNAVAILABLE;
    }

    /* renamed from: a */
    private void m3448a(C1312h hVar) {
        String str;
        String str2 = "";
        if (hVar != null) {
            str = hVar.f3139b;
            C1228a aVar = hVar.f3141d;
            if (aVar != null) {
                str2 = aVar.f2725r;
            }
        } else {
            str = str2;
        }
        C1266e.m3214a(str2, str);
    }
}
