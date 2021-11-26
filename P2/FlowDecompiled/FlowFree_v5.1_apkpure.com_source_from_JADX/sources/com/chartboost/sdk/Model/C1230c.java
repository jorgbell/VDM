package com.chartboost.sdk.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C1272a;
import com.chartboost.sdk.C1275d;
import com.chartboost.sdk.C1277e;
import com.chartboost.sdk.C1279f;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.Events.ChartboostError;
import com.chartboost.sdk.Libraries.C1220g;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Networking.C1247g;
import com.chartboost.sdk.Networking.C1249i;
import com.chartboost.sdk.Networking.C1252j;
import com.chartboost.sdk.Tracking.C1260a;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.impl.C1286a;
import com.chartboost.sdk.impl.C1313h0;
import com.chartboost.sdk.impl.C1319i0;
import com.chartboost.sdk.impl.C1357p0;
import com.chartboost.sdk.impl.C1371s1;
import com.chartboost.sdk.impl.C1381v1;
import com.chartboost.sdk.impl.C1406x;
import com.mopub.mobileads.ChartboostShared;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.c */
public class C1230c {

    /* renamed from: A */
    public boolean f2731A = false;

    /* renamed from: B */
    public boolean f2732B;

    /* renamed from: C */
    public boolean f2733C = false;

    /* renamed from: D */
    public boolean f2734D = false;

    /* renamed from: a */
    public int f2735a;

    /* renamed from: b */
    public int f2736b;

    /* renamed from: c */
    public final C1286a f2737c;

    /* renamed from: d */
    public final C1220g f2738d;

    /* renamed from: e */
    public final C1247g f2739e;

    /* renamed from: f */
    public final C1234g f2740f;

    /* renamed from: g */
    public final Handler f2741g;

    /* renamed from: h */
    public final C1275d f2742h;

    /* renamed from: i */
    public final C1249i f2743i;

    /* renamed from: j */
    public final C1277e f2744j;

    /* renamed from: k */
    public final C1252j f2745k;

    /* renamed from: l */
    public final C1231d f2746l;

    /* renamed from: m */
    public final String f2747m;

    /* renamed from: n */
    private boolean f2748n;

    /* renamed from: o */
    private Boolean f2749o = null;

    /* renamed from: p */
    public final String f2750p;

    /* renamed from: q */
    public final C1228a f2751q;

    /* renamed from: r */
    public final SharedPreferences f2752r;

    /* renamed from: s */
    private Runnable f2753s;

    /* renamed from: t */
    private C1279f f2754t;

    /* renamed from: u */
    private final WeakReference<RelativeLayout> f2755u;

    /* renamed from: v */
    private final Boolean f2756v;

    /* renamed from: w */
    private final Context f2757w;

    /* renamed from: x */
    public C1357p0 f2758x;

    /* renamed from: y */
    public C1371s1 f2759y;

    /* renamed from: z */
    public boolean f2760z;

    public C1230c(Context context, C1228a aVar, C1231d dVar, C1220g gVar, C1247g gVar2, C1234g gVar3, SharedPreferences sharedPreferences, Handler handler, C1275d dVar2, C1249i iVar, C1277e eVar, C1252j jVar, C1286a aVar2, String str, String str2, RelativeLayout relativeLayout) {
        C1286a aVar3 = aVar2;
        this.f2757w = context;
        this.f2751q = aVar;
        this.f2737c = aVar3;
        this.f2738d = gVar;
        this.f2739e = gVar2;
        this.f2740f = gVar3;
        this.f2741g = handler;
        this.f2742h = dVar2;
        this.f2743i = iVar;
        this.f2744j = eVar;
        this.f2745k = jVar;
        this.f2746l = dVar;
        this.f2755u = new WeakReference<>(relativeLayout);
        this.f2756v = Boolean.valueOf(aVar3.f3035a == 3);
        this.f2736b = 0;
        this.f2760z = false;
        this.f2732B = false;
        this.f2734D = true;
        this.f2735a = 4;
        this.f2747m = str;
        this.f2750p = str2;
        this.f2748n = true;
        this.f2752r = sharedPreferences;
    }

    /* renamed from: A */
    private void m2985A() {
        int i = this.f2737c.f3035a;
        if (i == 0) {
            m2986B();
        } else if (i == 1) {
            m2987C();
        } else if (i == 3) {
            this.f2735a = 3;
        }
    }

    /* renamed from: B */
    private void m2986B() {
        if (this.f2751q.f2724q.equals("video")) {
            this.f2735a = 1;
            this.f2748n = false;
            return;
        }
        this.f2735a = 0;
    }

    /* renamed from: C */
    private void m2987C() {
        this.f2735a = 2;
        this.f2748n = false;
        if (m2995l()) {
            this.f2754t = new C1319i0(this.f2757w, this, this.f2738d, this.f2741g, this.f2742h);
        }
    }

    /* renamed from: D */
    private void m2988D() {
        if (m2995l()) {
            int i = this.f2737c.f3035a;
            if (i == 0) {
                if (this.f2751q.f2724q.equals("video")) {
                    this.f2754t = new C1319i0(this.f2757w, this, this.f2738d, this.f2741g, this.f2742h);
                    return;
                }
                this.f2754t = new C1313h0(this.f2757w, this, this.f2741g, this.f2742h);
            } else if (i == 1) {
                this.f2754t = new C1319i0(this.f2757w, this, this.f2738d, this.f2741g, this.f2742h);
            }
        } else {
            this.f2754t = new C1381v1(this.f2757w, this, this.f2738d, this.f2739e, this.f2752r, this.f2741g, this.f2742h, this.f2744j);
        }
    }

    /* renamed from: c */
    private void m2993c() {
        C1277e d;
        if (this.f2736b == 2 && (d = this.f2742h.mo10304d()) != null) {
            d.mo10319a(this);
        }
    }

    /* renamed from: h */
    private boolean m2994h() {
        return this.f2749o.booleanValue();
    }

    /* renamed from: l */
    private boolean m2995l() {
        return this.f2751q.f2709b == 0;
    }

    /* renamed from: m */
    private boolean m2996m() {
        return this.f2749o != null;
    }

    /* renamed from: E */
    public boolean mo10078E() {
        C1279f fVar = this.f2754t;
        if (fVar != null) {
            fVar.mo10348m();
            if (this.f2754t.mo10344i() != null) {
                return true;
            }
        } else {
            CBLogging.m2905b("CBImpression", "reinitializing -- no view protocol exists!!");
        }
        CBLogging.m2907c("CBImpression", "reinitializing -- view not yet created");
        return false;
    }

    /* renamed from: F */
    public void mo10079F() {
        C1357p0 p0Var = new C1357p0("https://live.chartboost.com", "/api/video-complete", this.f2740f, 2, (C1357p0.C1358a) null);
        p0Var.mo10562a(ChartboostShared.LOCATION_KEY, (Object) this.f2747m);
        p0Var.mo10562a("reward", (Object) Integer.valueOf(this.f2751q.f2719l));
        p0Var.mo10562a("currency-name", (Object) this.f2751q.f2720m);
        p0Var.mo10562a("ad_id", (Object) mo10091d());
        p0Var.mo10562a("force_close", (Object) Boolean.FALSE);
        if (!this.f2751q.f2714g.isEmpty()) {
            p0Var.mo10562a("cgn", (Object) this.f2751q.f2714g);
        }
        C1279f k = mo10096j() != null ? mo10097k() : null;
        if (k != null) {
            float h = k.mo10343h();
            float g = k.mo10342g();
            CBLogging.m2903a(C1230c.class.getSimpleName(), String.format(Locale.US, "TotalDuration: %f PlaybackTime: %f", new Object[]{Float.valueOf(g), Float.valueOf(h)}));
            float f = g / 1000.0f;
            p0Var.mo10562a("total_time", (Object) Float.valueOf(f));
            if (h <= 0.0f) {
                p0Var.mo10562a("playback_time", (Object) Float.valueOf(f));
            } else {
                p0Var.mo10562a("playback_time", (Object) Float.valueOf(h / 1000.0f));
            }
        }
        this.f2739e.mo10147a(p0Var);
    }

    /* renamed from: G */
    public boolean mo10080G() {
        return this.f2748n;
    }

    /* renamed from: H */
    public void mo10081H() {
        this.f2746l.mo10114c(this);
    }

    /* renamed from: I */
    public boolean mo10082I() {
        return this.f2734D;
    }

    /* renamed from: a */
    public void mo10085a(CBError.CBImpressionError cBImpressionError) {
        this.f2746l.mo10112a(this, cBImpressionError);
    }

    /* renamed from: b */
    public void mo10089b(String str, JSONObject jSONObject) {
        mo10087a(str, jSONObject);
        if (this.f2737c.f3035a == 3) {
            m2992b(this.f2751q.f2716i);
        }
    }

    /* renamed from: d */
    public String mo10091d() {
        return this.f2751q.f2713f;
    }

    /* renamed from: e */
    public C1286a mo10092e() {
        return this.f2737c;
    }

    /* renamed from: f */
    public RelativeLayout mo10093f() {
        return (RelativeLayout) this.f2755u.get();
    }

    /* renamed from: g */
    public String mo10094g() {
        return this.f2747m;
    }

    /* renamed from: i */
    public Boolean mo10095i() {
        return this.f2756v;
    }

    /* renamed from: j */
    public C1279f.C1281b mo10096j() {
        C1279f fVar = this.f2754t;
        if (fVar != null) {
            return fVar.mo10344i();
        }
        return null;
    }

    /* renamed from: k */
    public C1279f mo10097k() {
        return this.f2754t;
    }

    /* renamed from: n */
    public void mo10098n() {
        C1286a aVar;
        C1272a aVar2 = C1418k.f3534d;
        if (aVar2 != null && (aVar = this.f2737c) != null) {
            int i = aVar.f3035a;
            if (i == 0) {
                aVar2.didCompleteInterstitial(this.f2747m);
            } else if (i == 1) {
                aVar2.didCompleteRewardedVideo(this.f2747m, this.f2751q.f2719l);
            }
        }
    }

    /* renamed from: o */
    public void mo10099o() {
        this.f2731A = true;
    }

    /* renamed from: p */
    public void mo10100p() {
        Runnable runnable = this.f2753s;
        if (runnable != null) {
            runnable.run();
            this.f2753s = null;
        }
        this.f2731A = false;
    }

    /* renamed from: q */
    public boolean mo10101q() {
        C1279f fVar = this.f2754t;
        if (fVar != null) {
            return fVar.mo10345j();
        }
        return false;
    }

    /* renamed from: r */
    public void mo10102r() {
        this.f2734D = true;
        this.f2742h.mo10298a(this);
        this.f2746l.mo10111a(this);
    }

    /* renamed from: s */
    public void mo10103s() {
        C1231d dVar = this.f2746l;
        if (dVar != null) {
            dVar.mo10113b(this);
        } else {
            C1266e.m3223e(new C1260a("show_null_callback_mgr_error", "", this.f2737c.f3036b, this.f2747m));
        }
    }

    /* renamed from: t */
    public void mo10104t() {
        C1279f fVar = this.f2754t;
        if (fVar != null && fVar.mo10344i() != null) {
            this.f2754t.mo10344i().setVisibility(8);
        }
    }

    /* renamed from: u */
    public void mo10105u() {
        C1279f fVar = this.f2754t;
        if (fVar != null && !this.f2733C) {
            this.f2733C = true;
            fVar.mo10346k();
        }
    }

    /* renamed from: v */
    public void mo10106v() {
        this.f2748n = true;
    }

    /* renamed from: w */
    public void mo10107w() {
    }

    /* renamed from: x */
    public void mo10108x() {
        this.f2732B = false;
        C1279f fVar = this.f2754t;
        if (fVar != null && this.f2733C) {
            this.f2733C = false;
            fVar.mo10347l();
        }
    }

    /* renamed from: y */
    public void mo10109y() {
        this.f2732B = false;
    }

    /* renamed from: z */
    public boolean mo10110z() {
        this.f2736b = 0;
        m2985A();
        m2988D();
        return this.f2754t.mo10337b(this.f2751q.f2708a);
    }

    /* renamed from: a */
    public void mo10084a() {
        C1371s1 s1Var = this.f2759y;
        if (s1Var != null) {
            s1Var.mo10601a();
            try {
                C1279f fVar = this.f2754t;
                if (!(fVar == null || fVar.mo10344i() == null || this.f2754t.mo10344i().getParent() == null)) {
                    this.f2759y.removeView(this.f2754t.mo10344i());
                }
            } catch (Exception e) {
                CBLogging.m2904a("CBImpression", "Exception raised while cleaning up views", e);
            }
            this.f2759y = null;
        }
        C1279f fVar2 = this.f2754t;
        if (fVar2 != null) {
            fVar2.mo10338c();
        }
        CBLogging.m2907c("CBImpression", "Destroying the view");
    }

    /* renamed from: b */
    private void m2992b(String str) {
        C1414j b = C1414j.m3867b();
        if (b != null) {
            b.f3509l.mo10292b(this.f2737c.f3036b, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo10090b(org.json.JSONObject r7) {
        /*
            r6 = this;
            int r0 = r6.f2736b
            r1 = 0
            r2 = 2
            if (r0 != r2) goto L_0x0049
            boolean r0 = r6.f2731A
            if (r0 == 0) goto L_0x000b
            goto L_0x0049
        L_0x000b:
            com.chartboost.sdk.Model.a r0 = r6.f2751q
            java.lang.String r2 = r0.f2718k
            java.lang.String r0 = r0.f2717j
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x003b
            com.chartboost.sdk.Networking.i r3 = r6.f2743i     // Catch:{ Exception -> 0x002d }
            android.content.Context r4 = r6.f2757w     // Catch:{ Exception -> 0x002d }
            boolean r3 = r3.mo10155a((android.content.Context) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x002d }
            if (r3 == 0) goto L_0x0028
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0026 }
            r6.f2749o = r2     // Catch:{ Exception -> 0x0026 }
            goto L_0x003a
        L_0x0026:
            r2 = move-exception
            goto L_0x0031
        L_0x0028:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x002d }
            r6.f2749o = r0     // Catch:{ Exception -> 0x002d }
            goto L_0x003b
        L_0x002d:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
        L_0x0031:
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "CBImpression onClick"
            com.chartboost.sdk.Libraries.CBLogging.m2905b(r3, r2)
        L_0x003a:
            r2 = r0
        L_0x003b:
            boolean r0 = r6.f2732B
            if (r0 == 0) goto L_0x0040
            return r1
        L_0x0040:
            r0 = 1
            r6.f2732B = r0
            r6.f2734D = r1
            r6.mo10087a((java.lang.String) r2, (org.json.JSONObject) r7)
            return r0
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Model.C1230c.mo10090b(org.json.JSONObject):boolean");
    }

    /* renamed from: a */
    public CBError.CBImpressionError mo10083a(RelativeLayout relativeLayout) {
        try {
            if (this.f2754t != null) {
                if (mo10095i().booleanValue()) {
                    return this.f2754t.mo10327a(relativeLayout);
                }
                return this.f2754t.mo10349n();
            }
        } catch (Exception e) {
            CBLogging.m2905b("CBImpression", "tryCreatingView: " + e.toString());
        }
        return CBError.CBImpressionError.ERROR_CREATING_VIEW;
    }

    /* renamed from: a */
    public void mo10086a(Runnable runnable) {
        this.f2753s = runnable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10087a(String str, JSONObject jSONObject) {
        Handler handler = this.f2741g;
        C1286a aVar = this.f2737c;
        aVar.getClass();
        handler.post(new C1286a.C1287a(1, this.f2747m, (CBError.CBImpressionError) null, (ChartboostError) null, true, this.f2751q.f2716i));
        if (mo10080G()) {
            m2993c();
        }
        if (m2991a(str)) {
            this.f2758x = m2990a(jSONObject);
            this.f2743i.mo10153a(this.f2757w, this, str, (C1357p0) null);
            return;
        }
        C1266e.m3223e(new C1260a("click_invalid_url_error", str, this.f2737c.f3036b, this.f2747m));
        this.f2743i.mo10154a(this, false, str, CBError.CBClickError.URI_INVALID, (C1357p0) null);
    }

    /* renamed from: b */
    public void mo10088b() {
        mo10084a();
        if (this.f2760z) {
            C1279f fVar = this.f2754t;
            if (fVar != null) {
                fVar.mo10336b();
            }
            this.f2754t = null;
            CBLogging.m2907c("CBImpression", "Destroying the view and view data");
        }
    }

    /* renamed from: a */
    private boolean m2991a(String str) {
        return !C1406x.m3823b().mo10696a((CharSequence) str);
    }

    /* renamed from: a */
    private C1357p0 m2990a(JSONObject jSONObject) {
        return m2989a(new C1357p0("https://live.chartboost.com", "/api/click", this.f2740f, 2, (C1357p0.C1358a) null), jSONObject);
    }

    /* renamed from: a */
    private C1357p0 m2989a(C1357p0 p0Var, JSONObject jSONObject) {
        if (!this.f2751q.f2713f.isEmpty()) {
            p0Var.mo10562a("ad_id", (Object) this.f2751q.f2713f);
        }
        if (!this.f2751q.f2721n.isEmpty()) {
            p0Var.mo10562a("to", (Object) this.f2751q.f2721n);
        }
        if (!this.f2751q.f2714g.isEmpty()) {
            p0Var.mo10562a("cgn", (Object) this.f2751q.f2714g);
        }
        if (!this.f2751q.f2715h.isEmpty()) {
            p0Var.mo10562a("creative", (Object) this.f2751q.f2715h);
        }
        int i = this.f2735a;
        if (i == 1 || i == 2) {
            C1279f fVar = null;
            if (this.f2751q.f2709b == 0 && mo10096j() != null) {
                fVar = mo10097k();
            } else if (this.f2751q.f2709b == 1 && mo10096j() != null) {
                fVar = mo10097k();
            }
            if (fVar != null) {
                float h = fVar.mo10343h();
                float g = fVar.mo10342g();
                CBLogging.m2903a(C1230c.class.getSimpleName(), String.format(Locale.US, "TotalDuration: %f PlaybackTime: %f", new Object[]{Float.valueOf(g), Float.valueOf(h)}));
                float f = g / 1000.0f;
                p0Var.mo10562a("total_time", (Object) Float.valueOf(f));
                if (h <= 0.0f) {
                    p0Var.mo10562a("playback_time", (Object) Float.valueOf(f));
                } else {
                    p0Var.mo10562a("playback_time", (Object) Float.valueOf(h / 1000.0f));
                }
            }
        } else if (i == 3) {
            p0Var.mo10562a("creative", (Object) "");
        }
        if (jSONObject != null) {
            p0Var.mo10562a("click_coordinates", (Object) jSONObject);
        }
        p0Var.mo10562a(ChartboostShared.LOCATION_KEY, (Object) this.f2747m);
        if (m2996m()) {
            p0Var.mo10562a("retarget_reinstall", (Object) Boolean.valueOf(m2994h()));
        }
        return p0Var;
    }
}
