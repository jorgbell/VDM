package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C1275d;
import com.chartboost.sdk.C1279f;
import com.chartboost.sdk.C1284h;
import com.chartboost.sdk.Libraries.C1217e;
import com.chartboost.sdk.Libraries.C1220g;
import com.chartboost.sdk.Libraries.C1222i;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C1230c;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.C1313h0;
import com.mopub.common.AdType;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.i0 */
public class C1319i0 extends C1313h0 {

    /* renamed from: A */
    protected int f3175A = 0;

    /* renamed from: B */
    private boolean f3176B = false;

    /* renamed from: C */
    private boolean f3177C = false;

    /* renamed from: D */
    JSONObject f3178D;

    /* renamed from: E */
    protected boolean f3179E;

    /* renamed from: F */
    protected boolean f3180F;

    /* renamed from: G */
    protected boolean f3181G;

    /* renamed from: H */
    protected boolean f3182H;

    /* renamed from: I */
    protected boolean f3183I = false;

    /* renamed from: J */
    protected int f3184J;

    /* renamed from: K */
    protected C1222i f3185K;

    /* renamed from: L */
    protected C1222i f3186L;

    /* renamed from: M */
    protected C1222i f3187M;

    /* renamed from: N */
    protected C1222i f3188N;

    /* renamed from: O */
    protected C1222i f3189O;

    /* renamed from: P */
    protected C1222i f3190P;

    /* renamed from: Q */
    protected C1222i f3191Q;

    /* renamed from: R */
    protected C1222i f3192R;

    /* renamed from: S */
    protected boolean f3193S = false;

    /* renamed from: T */
    protected boolean f3194T = false;

    /* renamed from: U */
    protected boolean f3195U = false;

    /* renamed from: V */
    private Context f3196V;

    /* renamed from: t */
    final C1220g f3197t;

    /* renamed from: u */
    protected int f3198u = 0;

    /* renamed from: v */
    protected int f3199v;

    /* renamed from: w */
    protected String f3200w;

    /* renamed from: x */
    protected String f3201x;

    /* renamed from: y */
    private boolean f3202y = false;

    /* renamed from: z */
    protected int f3203z = 0;

    /* renamed from: com.chartboost.sdk.impl.i0$b */
    public class C1321b extends C1313h0.C1314a {

        /* renamed from: o */
        private final C1359p1 f3204o;

        /* renamed from: p */
        final C1349o0 f3205p;

        /* renamed from: q */
        C1335l0 f3206q;

        /* renamed from: r */
        private View f3207r;

        /* renamed from: s */
        final C1309g0 f3208s;

        /* renamed from: t */
        final C1329j0 f3209t;

        /* renamed from: u */
        private final C1359p1 f3210u;

        /* renamed from: com.chartboost.sdk.impl.i0$b$a */
        class C1322a extends C1359p1 {
            C1322a(Context context, C1319i0 i0Var) {
                super(context);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo10432a(MotionEvent motionEvent) {
                C1321b bVar = C1321b.this;
                if (C1319i0.this.f3004g.f2735a == 2) {
                    bVar.f3209t.mo10510a(false);
                }
                C1321b bVar2 = C1321b.this;
                if (C1319i0.this.f3198u == 1) {
                    bVar2.mo10454e(false);
                }
                C1321b.this.mo10452d(true);
            }
        }

        /* renamed from: com.chartboost.sdk.impl.i0$b$b */
        class C1323b extends C1359p1 {
            C1323b(Context context, C1319i0 i0Var) {
                super(context);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo10432a(MotionEvent motionEvent) {
                C1321b.this.mo10439c();
            }
        }

        /* renamed from: com.chartboost.sdk.impl.i0$b$c */
        class C1324c implements Runnable {
            C1324c() {
            }

            public void run() {
                Object[] objArr = new Object[1];
                objArr[0] = C1319i0.this.f3179E ? "hidden" : "shown";
                CBLogging.m2908d("InterstitialVideoViewProtocol", String.format("controls %s automatically from timer", objArr));
                C1321b bVar = C1321b.this;
                bVar.f3205p.mo10536a(!C1319i0.this.f3179E, true);
                synchronized (C1319i0.this.f3006i) {
                    C1321b bVar2 = C1321b.this;
                    C1319i0.this.f3006i.remove(bVar2.f3205p);
                }
            }
        }

        /* renamed from: com.chartboost.sdk.impl.i0$b$d */
        class C1325d implements Runnable {
            C1325d() {
            }

            public void run() {
                C1321b.this.f3209t.mo10510a(false);
            }
        }

        /* renamed from: com.chartboost.sdk.impl.i0$b$e */
        class C1326e implements Runnable {
            C1326e() {
            }

            public void run() {
                try {
                    C1319i0.this.mo10329a();
                } catch (Exception e) {
                    CBLogging.m2905b("InterstitialVideoViewProtocol", "onCloseButton Runnable.run" + e.toString());
                }
            }
        }

        /* renamed from: b */
        private void m3531b(boolean z) {
            if (z) {
                this.f3209t.mo10510a(true);
            } else {
                this.f3209t.setVisibility(0);
            }
            C1319i0.this.f2998a.postDelayed(new C1325d(), 2500);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo10352a(int i, int i2) {
            super.mo10352a(i, i2);
            m3530a(C1319i0.this.f3198u, false);
            boolean b = CBUtility.m2921b(C1319i0.this.mo10341f());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f3165i.getLayoutParams();
            C1319i0 i0Var = C1319i0.this;
            i0Var.mo10436a(layoutParams2, b ? i0Var.f3186L : i0Var.f3185K, 1.0f);
            Point b2 = C1319i0.this.mo10437b(b ? "replay-portrait" : "replay-landscape");
            int round = Math.round(((((float) layoutParams6.leftMargin) + (((float) layoutParams6.width) / 2.0f)) + ((float) b2.x)) - (((float) layoutParams2.width) / 2.0f));
            int round2 = Math.round(((((float) layoutParams6.topMargin) + (((float) layoutParams6.height) / 2.0f)) + ((float) b2.y)) - (((float) layoutParams2.height) / 2.0f));
            layoutParams2.leftMargin = Math.min(Math.max(0, round), i - layoutParams2.width);
            layoutParams2.topMargin = Math.min(Math.max(0, round2), i2 - layoutParams2.height);
            this.f3204o.bringToFront();
            if (b) {
                this.f3204o.mo10569a(C1319i0.this.f3186L);
            } else {
                this.f3204o.mo10569a(C1319i0.this.f3185K);
            }
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f3168l.getLayoutParams();
            if (!C1319i0.this.mo10447t()) {
                layoutParams3.width = layoutParams7.width;
                layoutParams3.height = layoutParams7.height;
                layoutParams3.leftMargin = layoutParams7.leftMargin;
                layoutParams3.topMargin = layoutParams7.topMargin;
                layoutParams4.width = layoutParams7.width;
                layoutParams4.height = layoutParams7.height;
                layoutParams4.leftMargin = layoutParams7.leftMargin;
                layoutParams4.topMargin = layoutParams7.topMargin;
            } else {
                RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
                C1222i iVar = b ? C1319i0.this.f3160o : C1319i0.this.f3161p;
                C1319i0.this.mo10436a(layoutParams8, iVar, 1.0f);
                layoutParams8.leftMargin = 0;
                layoutParams8.topMargin = 0;
                layoutParams8.addRule(11);
                this.f3210u.setLayoutParams(layoutParams8);
                this.f3210u.mo10569a(iVar);
            }
            layoutParams5.width = layoutParams7.width;
            layoutParams5.height = 72;
            layoutParams5.leftMargin = layoutParams7.leftMargin;
            layoutParams5.topMargin = (layoutParams7.topMargin + layoutParams7.height) - 72;
            if (C1319i0.this.f3194T) {
                this.f3207r.setLayoutParams(layoutParams);
            }
            if (C1319i0.this.f3004g.f2735a == 2) {
                this.f3206q.setLayoutParams(layoutParams3);
            }
            this.f3205p.setLayoutParams(layoutParams4);
            this.f3208s.setLayoutParams(layoutParams5);
            this.f3204o.setLayoutParams(layoutParams2);
            if (C1319i0.this.f3004g.f2735a == 2) {
                this.f3206q.mo10503a();
            }
            this.f3205p.mo10546h();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo10439c() {
            C1319i0 i0Var = C1319i0.this;
            int i = i0Var.f3198u;
            if (i != 1 || i0Var.f3004g.f2737c.f3035a != 1) {
                if (i == 1) {
                    mo10454e(false);
                    this.f3205p.mo10539c();
                    C1319i0 i0Var2 = C1319i0.this;
                    int i2 = i0Var2.f3199v;
                    if (i2 < 1) {
                        i0Var2.f3199v = i2 + 1;
                        i0Var2.f3004g.mo10106v();
                    }
                }
                C1319i0.this.f2998a.post(new C1326e());
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo10440d() {
            super.mo10440d();
            C1319i0 i0Var = C1319i0.this;
            if (i0Var.f3198u != 0 || (i0Var.f3180F && !i0Var.mo10443p())) {
                m3530a(C1319i0.this.f3198u, false);
            } else {
                mo10452d(false);
            }
        }

        /* renamed from: e */
        public void mo10453e() {
            mo10454e(true);
            this.f3205p.mo10539c();
            C1319i0 i0Var = C1319i0.this;
            int i = i0Var.f3199v + 1;
            i0Var.f3199v = i;
            if (i <= 1 && !i0Var.mo10444q()) {
                C1319i0 i0Var2 = C1319i0.this;
                if (i0Var2.f3203z >= 1) {
                    i0Var2.f3004g.mo10106v();
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public boolean mo10455f() {
            C1319i0 i0Var = C1319i0.this;
            if (i0Var.f3198u == 1 && i0Var.f3199v < 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("close-");
                sb.append(CBUtility.m2921b(C1319i0.this.mo10341f()) ? "portrait" : "landscape");
                JSONObject a = C1217e.m2936a(C1319i0.this.mo10340e(), sb.toString());
                float optDouble = a != null ? (float) a.optDouble("delay", -1.0d) : -1.0f;
                int round = optDouble >= 0.0f ? Math.round(optDouble * 1000.0f) : -1;
                C1319i0.this.f3184J = round;
                if (round < 0 || round > this.f3205p.mo10532a().mo10472d()) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public void mo10456g() {
            C1319i0.this.f3180F = false;
            mo10452d(true);
        }

        private C1321b(Context context) {
            super(context);
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            C1284h a = C1284h.m3343a();
            if (C1319i0.this.f3194T) {
                View view = new View(context);
                this.f3207r = view;
                view.setBackgroundColor(-16777216);
                this.f3207r.setVisibility(8);
                addView(this.f3207r);
            }
            if (C1319i0.this.f3004g.f2735a == 2) {
                C1335l0 l0Var = (C1335l0) a.mo10361a(new C1335l0(context, C1319i0.this));
                this.f3206q = l0Var;
                l0Var.setVisibility(8);
                addView(this.f3206q);
            }
            C1349o0 o0Var = (C1349o0) a.mo10361a(new C1349o0(context, C1319i0.this));
            this.f3205p = o0Var;
            mo10353a((View) o0Var.f3323g);
            o0Var.setVisibility(8);
            addView(o0Var);
            C1309g0 g0Var = (C1309g0) a.mo10361a(new C1309g0(context, C1319i0.this));
            this.f3208s = g0Var;
            g0Var.setVisibility(8);
            addView(g0Var);
            if (C1319i0.this.f3004g.f2735a == 2) {
                C1329j0 j0Var = (C1329j0) a.mo10361a(new C1329j0(context, C1319i0.this));
                this.f3209t = j0Var;
                j0Var.setVisibility(8);
                addView(j0Var);
            } else {
                this.f3209t = null;
            }
            C1322a aVar = new C1322a(getContext(), C1319i0.this);
            this.f3204o = aVar;
            aVar.setVisibility(8);
            addView(aVar);
            C1323b bVar = new C1323b(getContext(), C1319i0.this);
            this.f3210u = bVar;
            bVar.setVisibility(8);
            bVar.setContentDescription("CBClose");
            addView(bVar);
            JSONObject optJSONObject3 = C1319i0.this.f3178D.optJSONObject("progress");
            JSONObject optJSONObject4 = C1319i0.this.f3178D.optJSONObject("video-controls-background");
            if (optJSONObject3 != null && !optJSONObject3.isNull("background-color") && !optJSONObject3.isNull("border-color") && !optJSONObject3.isNull("progress-color") && !optJSONObject3.isNull("radius")) {
                C1319i0.this.f3193S = true;
                C1332k0 b = o0Var.mo10537b();
                b.mo10485a(C1279f.m3311a(optJSONObject3.optString("background-color")));
                b.mo10488b(C1279f.m3311a(optJSONObject3.optString("border-color")));
                b.mo10489c(C1279f.m3311a(optJSONObject3.optString("progress-color")));
                b.mo10487b((float) optJSONObject3.optDouble("radius", 0.0d));
            }
            if (optJSONObject4 != null && !optJSONObject4.isNull("color")) {
                o0Var.mo10533a(C1279f.m3311a(optJSONObject4.optString("color")));
            }
            if (C1319i0.this.f3004g.f2735a == 2 && C1319i0.this.f3181G && (optJSONObject2 = C1319i0.this.f3178D.optJSONObject("post-video-toaster")) != null) {
                g0Var.mo10430a(optJSONObject2.optString("title"), optJSONObject2.optString("tagline"));
            }
            if (C1319i0.this.f3004g.f2735a == 2 && C1319i0.this.f3180F && (optJSONObject = C1319i0.this.f3178D.optJSONObject("confirmation")) != null) {
                this.f3206q.mo10504a(optJSONObject.optString("text"), C1279f.m3311a(optJSONObject.optString("color")));
            }
            String str = "";
            if (C1319i0.this.f3004g.f2735a == 2 && C1319i0.this.f3182H) {
                JSONObject a2 = C1217e.m2936a(C1319i0.this.f3178D, "post-video-reward-toaster");
                this.f3209t.mo10509a((a2 == null || !a2.optString("position").equals("inside-top")) ? 1 : 0);
                this.f3209t.mo10461a(a2 != null ? a2.optString("text") : str);
                if (C1319i0.this.f3190P.mo10060e()) {
                    this.f3209t.mo10460a(C1319i0.this.f3192R);
                }
            }
            JSONObject e = C1319i0.this.mo10340e();
            if (e == null || e.isNull("video-click-button")) {
                o0Var.mo10541d();
            }
            o0Var.mo10540c(C1319i0.this.f3178D.optBoolean("video-progress-timer-enabled"));
            if (C1319i0.this.f3195U || C1319i0.this.f3194T) {
                this.f3169m.setVisibility(4);
            }
            String[] strArr = new String[1];
            strArr[0] = CBUtility.m2921b(C1319i0.this.mo10341f()) ? "video-portrait" : "video-landscape";
            JSONObject a3 = C1217e.m2936a(e, strArr);
            str = a3 != null ? a3.optString("id") : str;
            C1319i0.this.f3201x = str;
            if (str.isEmpty()) {
                C1319i0.this.mo10331a(CBError.CBImpressionError.VIDEO_ID_MISSING);
                return;
            }
            if (C1319i0.this.f3200w == null) {
                C1319i0.this.f3200w = C1319i0.this.f3197t.mo10047a(C1319i0.this.f3201x);
            }
            String str2 = C1319i0.this.f3200w;
            if (str2 == null) {
                C1319i0.this.mo10331a(CBError.CBImpressionError.VIDEO_UNAVAILABLE);
            } else {
                o0Var.mo10534a(str2);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo10450b(float f, float f2, float f3, float f4) {
            if (C1319i0.this.f3198u == 1) {
                mo10454e(false);
            }
            C1319i0.this.mo10335a(C1217e.m2937a(C1217e.m2935a("x", (Object) Float.valueOf(f)), C1217e.m2935a("y", (Object) Float.valueOf(f2)), C1217e.m2935a("w", (Object) Float.valueOf(f3)), C1217e.m2935a("h", (Object) Float.valueOf(f4))));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo10452d(boolean z) {
            C1319i0 i0Var = C1319i0.this;
            if (i0Var.f3198u != 1) {
                if (i0Var.f3180F) {
                    m3530a(0, z);
                    return;
                }
                m3530a(1, z);
                JSONObject a = C1217e.m2936a(C1319i0.this.f3178D, "timer");
                if (C1319i0.this.f3199v >= 1 || a == null || a.isNull("delay")) {
                    this.f3205p.mo10535a(!C1319i0.this.f3179E);
                } else {
                    Object[] objArr = new Object[1];
                    objArr[0] = C1319i0.this.f3179E ? "visible" : "hidden";
                    CBLogging.m2908d("InterstitialVideoViewProtocol", String.format("controls starting %s, setting timer", objArr));
                    this.f3205p.mo10535a(C1319i0.this.f3179E);
                    C1319i0.this.mo10330a((View) this.f3205p, (Runnable) new C1324c(), Math.round(a.optDouble("delay", 0.0d) * 1000.0d));
                }
                this.f3205p.mo10544f();
                C1319i0 i0Var2 = C1319i0.this;
                if (i0Var2.f3199v <= 1) {
                    i0Var2.f3004g.mo10107w();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo10454e(boolean z) {
            JSONObject jSONObject;
            this.f3205p.mo10545g();
            C1319i0 i0Var = C1319i0.this;
            if (i0Var.f3198u == 1 && z) {
                if (i0Var.f3199v < 1 && (jSONObject = i0Var.f3178D) != null && !jSONObject.isNull("post-video-reward-toaster")) {
                    C1319i0 i0Var2 = C1319i0.this;
                    if (i0Var2.f3182H && i0Var2.f3190P.mo10060e() && C1319i0.this.f3191Q.mo10060e()) {
                        m3531b(true);
                    }
                }
                m3530a(2, true);
                if (CBUtility.m2921b(CBUtility.m2918b(getContext()))) {
                    requestLayout();
                }
            }
        }

        /* renamed from: c */
        public C1359p1 mo10451c(boolean z) {
            return ((!C1319i0.this.mo10447t() || !z) && (C1319i0.this.mo10447t() || z)) ? this.f3166j : this.f3210u;
        }

        /* renamed from: a */
        private void m3530a(int i, boolean z) {
            C1319i0 i0Var = C1319i0.this;
            i0Var.f3198u = i;
            boolean z2 = true;
            if (i == 0) {
                i0Var.mo10334a(!i0Var.mo10447t(), (View) this.f3168l, z);
                C1319i0 i0Var2 = C1319i0.this;
                if (i0Var2.f3004g.f2735a == 2) {
                    i0Var2.mo10334a(true, (View) this.f3206q, z);
                }
                C1319i0 i0Var3 = C1319i0.this;
                if (i0Var3.f3194T) {
                    i0Var3.mo10334a(false, this.f3207r, z);
                }
                C1319i0.this.mo10334a(false, (View) this.f3205p, z);
                C1319i0.this.mo10334a(false, (View) this.f3204o, z);
                C1319i0.this.mo10334a(false, (View) this.f3208s, z);
                this.f3168l.setEnabled(false);
                this.f3204o.setEnabled(false);
                this.f3205p.setEnabled(false);
            } else if (i == 1) {
                i0Var.mo10334a(false, (View) this.f3168l, z);
                C1319i0 i0Var4 = C1319i0.this;
                if (i0Var4.f3004g.f2735a == 2) {
                    i0Var4.mo10334a(false, (View) this.f3206q, z);
                }
                C1319i0 i0Var5 = C1319i0.this;
                if (i0Var5.f3194T) {
                    i0Var5.mo10334a(true, this.f3207r, z);
                }
                C1319i0.this.mo10334a(true, (View) this.f3205p, z);
                C1319i0.this.mo10334a(false, (View) this.f3204o, z);
                C1319i0.this.mo10334a(false, (View) this.f3208s, z);
                this.f3168l.setEnabled(true);
                this.f3204o.setEnabled(false);
                this.f3205p.setEnabled(true);
            } else if (i == 2) {
                i0Var.mo10334a(true, (View) this.f3168l, z);
                C1319i0 i0Var6 = C1319i0.this;
                if (i0Var6.f3004g.f2735a == 2) {
                    i0Var6.mo10334a(false, (View) this.f3206q, z);
                }
                C1319i0 i0Var7 = C1319i0.this;
                if (i0Var7.f3194T) {
                    i0Var7.mo10334a(false, this.f3207r, z);
                }
                C1319i0.this.mo10334a(false, (View) this.f3205p, z);
                C1319i0.this.mo10334a(true, (View) this.f3204o, z);
                C1319i0.this.mo10334a(C1319i0.this.f3191Q.mo10060e() && C1319i0.this.f3190P.mo10060e() && C1319i0.this.f3181G, (View) this.f3208s, z);
                this.f3204o.setEnabled(true);
                this.f3168l.setEnabled(true);
                this.f3205p.setEnabled(false);
                if (C1319i0.this.f3183I) {
                    m3531b(false);
                }
            }
            boolean f = mo10455f();
            C1359p1 c = mo10451c(true);
            c.setEnabled(f);
            C1319i0.this.mo10334a(f, (View) c, z);
            C1359p1 c2 = mo10451c(false);
            c2.setEnabled(false);
            C1319i0.this.mo10334a(false, (View) c2, z);
            C1319i0 i0Var8 = C1319i0.this;
            if (i0Var8.f3195U || i0Var8.f3194T) {
                i0Var8.mo10334a(!i0Var8.mo10447t(), (View) this.f3169m, z);
            }
            C1319i0 i0Var9 = C1319i0.this;
            i0Var9.mo10334a(!i0Var9.mo10447t(), (View) this.f3165i, z);
            if (i == 0) {
                z2 = false;
            }
            mo10354a(z2);
        }

        /* renamed from: a */
        public void mo10351a() {
            C1319i0.this.mo10346k();
            super.mo10351a();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo10438a(float f, float f2, float f3, float f4) {
            C1319i0 i0Var = C1319i0.this;
            if ((!i0Var.f3179E || i0Var.f3198u != 1) && i0Var.f3198u != 0) {
                mo10450b(f, f2, f3, f4);
            }
        }
    }

    public C1319i0(Context context, C1230c cVar, C1220g gVar, Handler handler, C1275d dVar) {
        super(context, cVar, handler, dVar);
        this.f3196V = context;
        this.f3197t = gVar;
        this.f3198u = 0;
        this.f3185K = new C1222i(this);
        this.f3186L = new C1222i(this);
        this.f3187M = new C1222i(this);
        this.f3188N = new C1222i(this);
        this.f3189O = new C1222i(this);
        this.f3190P = new C1222i(this);
        this.f3191Q = new C1222i(this);
        this.f3192R = new C1222i(this);
        this.f3199v = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1279f.C1281b mo10328a(Context context) {
        return new C1321b(context);
    }

    /* renamed from: b */
    public boolean mo10337b(JSONObject jSONObject) {
        if (!super.mo10337b(jSONObject)) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("ux");
        this.f3178D = optJSONObject;
        if (optJSONObject == null) {
            this.f3178D = C1217e.m2937a(new C1217e.C1218a[0]);
        }
        if (this.f3002e.isNull("video-landscape") || this.f3002e.isNull("replay-landscape")) {
            this.f3008k = false;
        }
        if (!this.f3185K.mo10055a("replay-landscape") || !this.f3186L.mo10055a("replay-portrait") || !this.f3189O.mo10055a("video-click-button") || !this.f3190P.mo10055a("post-video-reward-icon") || !this.f3191Q.mo10055a("post-video-button") || !this.f3187M.mo10055a("video-confirmation-button") || !this.f3188N.mo10055a("video-confirmation-icon") || !this.f3192R.mo10055a("post-video-reward-icon")) {
            CBLogging.m2905b("InterstitialVideoViewProtocol", "Error while downloading the assets");
            mo10331a(CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE);
            return false;
        }
        this.f3179E = this.f3178D.optBoolean("video-controls-togglable");
        this.f3194T = jSONObject.optBoolean(AdType.FULLSCREEN);
        this.f3195U = jSONObject.optBoolean("preroll_popup_fullscreen");
        if (this.f3004g.f2735a == 2) {
            JSONObject optJSONObject2 = this.f3178D.optJSONObject("confirmation");
            JSONObject optJSONObject3 = this.f3178D.optJSONObject("post-video-toaster");
            if (optJSONObject3 != null && !optJSONObject3.isNull("title") && !optJSONObject3.isNull("tagline")) {
                this.f3181G = true;
            }
            if (optJSONObject2 != null && !optJSONObject2.isNull("text") && !optJSONObject2.isNull("color")) {
                this.f3180F = true;
            }
            if (!this.f3178D.isNull("post-video-reward-toaster")) {
                this.f3182H = true;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo10339d() {
        if (this.f3180F && (!this.f3187M.mo10060e() || !this.f3188N.mo10060e())) {
            this.f3180F = false;
        }
        super.mo10339d();
    }

    /* renamed from: g */
    public float mo10342g() {
        return (float) this.f3175A;
    }

    /* renamed from: h */
    public float mo10343h() {
        return (float) this.f3203z;
    }

    /* renamed from: j */
    public boolean mo10345j() {
        mo10344i().mo10439c();
        return true;
    }

    /* renamed from: k */
    public void mo10346k() {
        super.mo10346k();
        if (this.f3198u == 1 && !this.f3202y) {
            this.f3202y = true;
            mo10344i().f3205p.mo10543e();
        }
    }

    /* renamed from: l */
    public void mo10347l() {
        super.mo10347l();
        if (this.f3198u == 1 && this.f3202y) {
            mo10344i().f3205p.mo10532a().mo10463a(this.f3203z);
            mo10344i().f3205p.mo10544f();
        }
        this.f3202y = false;
    }

    /* renamed from: o */
    public C1321b mo10344i() {
        return (C1321b) super.mo10344i();
    }

    /* renamed from: p */
    public boolean mo10443p() {
        return this.f3004g.f2735a == 1;
    }

    /* renamed from: q */
    public boolean mo10444q() {
        return this.f3177C;
    }

    /* renamed from: r */
    public boolean mo10445r() {
        return this.f3198u == 1;
    }

    /* renamed from: s */
    public boolean mo10446s() {
        return this.f3176B;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo10447t() {
        /*
            r4 = this;
            int r0 = r4.f3198u
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001d
            if (r0 == r2) goto L_0x000c
            r3 = 2
            if (r0 == r3) goto L_0x002e
            goto L_0x002d
        L_0x000c:
            boolean r0 = r4.f3194T
            if (r0 != 0) goto L_0x002d
            android.content.Context r0 = r4.f3196V
            int r0 = com.chartboost.sdk.Libraries.CBUtility.m2918b((android.content.Context) r0)
            boolean r0 = com.chartboost.sdk.Libraries.CBUtility.m2921b((int) r0)
            if (r0 == 0) goto L_0x002e
            goto L_0x002d
        L_0x001d:
            boolean r0 = r4.f3195U
            if (r0 != 0) goto L_0x002d
            android.content.Context r0 = r4.f3196V
            int r0 = com.chartboost.sdk.Libraries.CBUtility.m2918b((android.content.Context) r0)
            boolean r0 = com.chartboost.sdk.Libraries.CBUtility.m2921b((int) r0)
            if (r0 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C1319i0.mo10447t():boolean");
    }

    /* renamed from: u */
    public void mo10448u() {
        if (this.f3200w != null) {
            new File(this.f3200w).delete();
        }
        this.f3177C = true;
        mo10331a(CBError.CBImpressionError.ERROR_PLAYING_VIDEO);
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public void mo10449v() {
        this.f3004g.mo10081H();
    }

    /* renamed from: a */
    public void mo10441a(boolean z) {
        this.f3176B = z;
    }

    /* renamed from: b */
    public void mo10336b() {
        super.mo10336b();
        this.f3185K = null;
        this.f3186L = null;
        this.f3189O = null;
        this.f3190P = null;
        this.f3191Q = null;
        this.f3187M = null;
        this.f3188N = null;
        this.f3192R = null;
    }
}
